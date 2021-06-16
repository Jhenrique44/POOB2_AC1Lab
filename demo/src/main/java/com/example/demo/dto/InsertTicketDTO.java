package com.example.demo.dto;

import java.time.Instant;

import com.example.demo.entities.TicketType;

public class InsertTicketDTO {
    
    private Long idAttend;
    private TicketType type;
    // private Instant date;
    // private double balance;
    
    public Long getIdAttend() {
        return idAttend;
    }

    public void setIdAttend(Long idAttend) {
        this.idAttend = idAttend;
    }
    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    // public Instant getDate() {
    //     return date;
    // }

    // public void setDate(Instant date) {
    //     this.date = date;
    // }

    // public double getBalance() {
    //     return balance;
    // }

    // public void setBalance(double balance) {
    //     this.balance = balance;
    // }
}
