package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entities.Event;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;


public class EventDTO {
    
    private Long id;
    
    private String name;
    private String address;
    private String descp;
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate std;
    
    private LocalDate endate;

    public EventDTO(){
    
    }

    public EventDTO(Long id, String name, String address, String descp, String email, LocalDate std, LocalDate endate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.descp = descp;
        this.email = email;
        this.std = std;
        this.endate = endate;


    }


    public EventDTO(Event event) {

        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.descp = event.getDescp();
        this.email = event.getEmail();
        this.std = event.getStd();
        this.endate = event.getEndate();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    public LocalDate getStd() {
         return std;
    }

    public void setStd(LocalDate std) {
        
        if(std.isAfter(LocalDate.now()))
            this.std = std;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEndate() {
        return endate;
    }

    public void setEndDate(LocalDate endate) {
        
        try {
            if(endate.isAfter(std))
                this.endate = endate;
        } catch (DataAccessException e) {
            System.out.println("invalid Date ");
        }
    }

    
    
}   
