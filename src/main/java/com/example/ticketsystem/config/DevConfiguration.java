package com.example.ticketsystem.config;

import com.example.ticketsystem.domain.*;
import com.example.ticketsystem.repository.*;
import com.example.ticketsystem.utils.HasLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Defines a Bean for the dev-Profile
 */
@Configuration
@Profile("dev")
@Transactional
// @ConditionalOnClass(name = {"org.h2.Driver"})
public class DevConfiguration implements HasLogger {
    @Autowired
    @Qualifier("ticket1")
    Ticket ticket1;
    @Autowired
    @Qualifier("ticket2")
    Ticket ticket2;
    @Autowired
    @Qualifier("ticket3")
    Ticket ticket3;
    @Autowired
    TicketRepository ticketRepository;
    public DevConfiguration() {
        getLogger().info("Dev Configuration Class");

    }
    @PostConstruct
    public void createData() {
        createPersonData();
    }
    private void createPersonData() {
        ticketRepository.save(ticket1);
        ticketRepository.save(ticket2);
        ticketRepository.save(ticket3);
        getLogger().debug("created Data saved to DB");
    }
}
