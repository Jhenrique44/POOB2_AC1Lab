package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.demo.entities.Event;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.dao.DataAccessException;


public class EventDTO {
    
    private Long id;
    // private Long idAdmin;
    
    private String name;
    private String descp;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate std;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    public EventDTO(){
    
    }

    public EventDTO(Long id, String name, String descp, String email, LocalDate std, LocalDate endDate, LocalTime startTime,
    LocalTime endTime) {

        // this.idAdmin = idAdmin;
        this.id = id;
        this.name = name;
        this.descp = descp;
        this.email = email;
        this.std = std;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;

    }
    

    public EventDTO(Event event) {
    
        // this.idAdmin = event.getIdAdmin();
        this.id = event.getId();
        this.name = event.getName();
        this.descp = event.getDescp();
        this.email = event.getEmail();
        this.std = event.getStd();
        this.endDate = event.getEndDate();
        this.startTime = event.getStartTime();
        this.endTime = event.getEndTime();


    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public Long getIdAdmin() {
    //     return idAdmin;
    // }

    // public void setIdAdmin(Long idAdmin) {
    //     this.idAdmin = idAdmin;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        
        try {
            if(endDate.isAfter(std))
                this.endDate = endDate;
        } catch (DataAccessException e) {
            System.out.println("invalid Date ");
        }
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    
    
}   
