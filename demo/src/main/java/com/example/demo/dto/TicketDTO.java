package com.example.demo.dto;

import java.time.Instant;

import com.example.demo.entities.Ticket;
import com.example.demo.entities.TicketType;

public class TicketDTO {
    
    private Long id;
    
    private TicketType type;

    private Instant date;

    private Double price;

    private Long idAttend;

    public TicketDTO(){

    }

    public TicketDTO(Long id, Long idAttend, TicketType type, Instant date, Double price) {
        this.id = id;
        this.idAttend = idAttend;
        this.type = type;
        this.date = date;
        this.price = price;
    }
    
    public TicketDTO(Ticket ticket) {
        
        this.id = ticket.getId();
        // this.idAttend = ticket.getIdAttend();
        this.type = ticket.getType();
        this.date = ticket.getDate();
        this.price = ticket.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getIdAttend() {
        return idAttend;
    }

    public void setIdAttend(Long idAttend) {
        this.idAttend = idAttend;
    }



}
