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
    private String desc;
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate stD;
    
    private LocalDate endDate;

    public EventDTO(){
    
    }

    public EventDTO(Long id, String name, String address, String desc, String email, LocalDate stD, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.desc = desc;
        this.email = email;
        this.stD = stD;
        this.endDate = endDate;


    }


    public EventDTO(Event event) {

        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.desc = event.getDesc();
        this.email = event.getEmail();
        this.stD = event.getStD();
        this.endDate = event.getEndDate();
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

    
    public LocalDate getStD() {
         return stD;
    }

    public void setStD(LocalDate stD) {
        
        if(stD.isAfter(LocalDate.now()))
            this.stD = stD;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        
        try {
            if(endDate.isAfter(stD))
                this.endDate = endDate;
        } catch (DataAccessException e) {
            System.out.println("invalid Date");
        }
    }

    
    
}   
