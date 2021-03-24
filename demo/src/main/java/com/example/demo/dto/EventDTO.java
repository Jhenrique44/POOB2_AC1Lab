package com.example.demo.dto;

import com.example.demo.entities.Event;

public class EventDTO {
    
    private Long id;
    
    private String name;
    private String address;
    private String email;

    public EventDTO(){
    
    }

    public EventDTO(Long id, String name, String address, String email) {
        setId(id);
        setName(name);
        setAddress(address);
        setEmail(email);
        
    }


    public EventDTO(Event event) {

        setId(event.getId());
        setName(event.getName());
        setAddress(event.getAddress());
        setEmail(event.getEmail());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    
}   
