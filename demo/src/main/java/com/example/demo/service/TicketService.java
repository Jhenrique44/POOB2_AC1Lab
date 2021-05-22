package com.example.demo.service;

import java.time.Instant;

import com.example.demo.entities.Attend;
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

    // public TicketDTO insert(InsertTicketDTO insert){

    //     Ticket ticket = new Ticket();


    //     Event e = eventRepo.findById(insert.getIdEvent()).get();
    //     Attend a = attendRepo.findById(insert.getIdAttend()).get();

    //     ticket.set
    //     ticket.setDate(Instant.now());
    //     ticket.setPrice(e.getPriceTicket());
    //     ticket.setType(ticket.);

    // }

}
