package com.example.demo.service;

import java.time.Instant;

import com.example.demo.entities.Event;
import com.example.demo.entities.Ticket;
import com.example.demo.repository.AttendeeRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    
    

    @Autowired 
    private TicketRepository repo;

    @Autowired 
    private AttendeeRepository attendRepo;

    @Autowired 
    private EventRepository eventRepo;

    // public void TicketEmb(){

    //     Ticket ticket = new Ticket();


    //     Event e = eventRepo.findById(ticket.

    //     ticket.setDate(Instant.now());
    //     ticket.setPrice(e.getPriceTicket());
    //     ticket.setType(ticket.);

    // }

}
