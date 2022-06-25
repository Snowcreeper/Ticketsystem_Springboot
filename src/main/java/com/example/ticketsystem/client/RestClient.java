package com.example.ticketsystem.client;

import com.example.ticketsystem.domain.Ticket;
import com.example.ticketsystem.utils.HasLogger;
import org.springframework.web.client.RestTemplate;

public class RestClient implements HasLogger {
    public static void main(String[] args) {
        new RestClient().start();
    }
    public void start() {
        final String uri = "http://localhost:8080/api/tickets/1";
        RestTemplate restTemplate = new RestTemplate();
        Ticket result = restTemplate.getForObject(uri, Ticket.class);
        getLogger().info(result.toString());
    }
}
