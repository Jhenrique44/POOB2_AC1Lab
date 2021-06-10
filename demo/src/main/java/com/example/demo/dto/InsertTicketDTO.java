package com.example.demo.dto;

import java.time.Instant;

import com.example.demo.entities.TicketType;

public class InsertTicketDTO {
    
    private Long idAttend;

    // private Long idEvent;

    private TicketType type;

    private Instant date;
    
    private Double price;

    public Long getIdAttend() {
        return idAttend;
    }

    public void setIdAttend(Long idAttend) {
        this.idAttend = idAttend;
    }

    // public Long getIdEvent() {
    //     return idEvent;
    // }

    // public void setIdEvent(Long idEvent) {
    //     this.idEvent = idEvent;
    // }

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



    
}
