package com.example.ticketsystem.web.rest;

import com.example.ticketsystem.domain.Ticket;
import com.example.ticketsystem.repository.TicketRepository;
import com.example.ticketsystem.web.exception.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tickets")
public class TicketRestController {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketRestController(TicketRepository ticketRepository){this.ticketRepository = ticketRepository;}
    @GetMapping({"/",""})
    public List<Ticket> getTicketsAll() {return ticketRepository.findAll();}
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(()
                -> new TicketNotFoundException("Get not successful: ticket with id=" + id
                + "not found"));
    }
    @GetMapping("/deadline")
    public List<Ticket> getTicketsSortedByDeadline() {return ticketRepository.sortByDeadline();}
    @GetMapping("/priority")
    public List<Ticket> getTicketsSortedByPriority() {return ticketRepository.sortByPriority();}
}
