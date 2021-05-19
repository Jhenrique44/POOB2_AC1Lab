package com.example.demo.dto;

import com.example.demo.entities.User;

public class InsertAttendDTO extends User{
 
    private Double balance;

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public InsertAttendDTO(Double balance) {
        this.balance = balance;
    }

    public InsertAttendDTO(Long id, String name, String email, Double balance) {
        super(id, name, email);
        this.balance = balance;
    }

    

    
}
