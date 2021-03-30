package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entities.Event;

import org.springframework.format.annotation.DateTimeFormat;

public class EventDTO {
    
    private Long id;
    
    private String name;
    private String address;
    private String desc;
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;

    public EventDTO(){
    
    }

    public EventDTO(Long id, String name, String address, String desc, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.desc = desc;
        this.email = email;


    }


    public EventDTO(Event event) {

        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.desc = event.getDesc();
        this.email = event.getEmail(); 
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

    
    // public LocalDate getStartDate() {
    //     return startDate;
    // }

    // public void setStartDate(LocalDate startDate) {
        
        
    //     this.startDate = startDate;
    // }

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


    
}   
