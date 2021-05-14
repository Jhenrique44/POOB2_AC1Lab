package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.example.demo.dto.InsertAttendDTO;

@Entity
@Table(name = "TB_ATTEND")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Attend extends User {

    private Double balance;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ATTEND_USER_ID")
    private List<Ticket> tickets = new ArrayList<>();

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTickets(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Attend(InsertAttendDTO insert){
        // this.name = insert.getName();
        // this.email = insert.getEmail();
        this.balance = insert.getBalance();
    }

    public Attend(Long id, String name, String email, Double balance) {
        super(id, name, email);
        this.balance = balance;
    }


}
