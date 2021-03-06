package com.example.demo.dto;

import com.example.demo.entities.Attend;
import com.example.demo.entities.User;

public class AttendDTO extends User{
    
    private Long id;

    private String name;
    private String email;
    private Double balance;

    public AttendDTO(){

    }
    
    public AttendDTO(Attend attendee){

        this.id = attendee.getId();
        this.name = attendee.getName();
        this.email = attendee.getEmail();
        this.balance = attendee.getBalance();
    }
    

    public AttendDTO(Double balance) {
        
        this.balance = balance;
    }

    public AttendDTO(Long id, String name, String email, Double balance) {
        super(id, name, email);
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }


    
}
