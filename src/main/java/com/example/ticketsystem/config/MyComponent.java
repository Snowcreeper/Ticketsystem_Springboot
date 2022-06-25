package com.example.ticketsystem.config;

import com.example.ticketsystem.domain.Ticket;
import com.example.ticketsystem.utils.HasLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyComponent implements HasLogger {
    @Bean(name = "ticket1")
    public Ticket getTicket1(){
        Ticket ticket = new Ticket();
        ticket.setTitle("HILFE");
        ticket.setDescription("TASTATUR SCHREIBT NURNOCH GROSS");
        ticket.setPriority("3");
        ticket.setCreatedAt("25.06.2022");
        ticket.setDeadlineAt("26.06.2022");
        ticket.setAuthor("Michel Platter");
        return ticket;
    }
    @Bean(name = "ticket2")
    public Ticket getTicket2(){
        Ticket ticket = new Ticket();
        ticket.setTitle("Login Outlook");
        ticket.setDescription("Kann mich seit heute morgen nicht mehr im Outlook einloggen, kommt kein Fehler");
        ticket.setPriority("2");
        ticket.setCreatedAt("20.06.2022");
        ticket.setDeadlineAt("22.06.2022");
        ticket.setAuthor("Fabian Strassenmeyer");
        return ticket;
    }
    @Bean(name = "ticket3")
    public Ticket getTicket3(){
        Ticket ticket = new Ticket();
        ticket.setTitle("Druckerprobleme");
        ticket.setDescription("Drucker im Stock 2 Raum 4 druckt nicht mehr, Display zeigt Fehler 403 an");
        ticket.setPriority("1");
        ticket.setCreatedAt("10.06.2022");
        ticket.setDeadlineAt("12.06.2022");
        ticket.setAuthor("Matthias Bachmann");
        return ticket;
    }
}
