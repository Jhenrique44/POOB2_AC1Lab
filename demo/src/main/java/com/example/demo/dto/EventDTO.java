package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entities.Event;

import org.springframework.format.annotation.DateTimeFormat;

public class EventDTO {
    
    private Long id;
    
    private String name;
    private String address;
    private String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;

    public EventDTO(){
    
    }

    public EventDTO(Long id, String name, String address, LocalDate startDate, String description) {
        setId(id);
        setName(name);
        setAddress(address);
        setStartDate(startDate);
        setDescription(description);


    }


    public EventDTO(Event event) {

        setId(event.getId());
        setName(event.getName());
        setAddress(event.getAddress());
        setStartDate(event.getStartDate());
        setDescription(event.getDescription()); 
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
}   
