package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UpdateEventDTO {
    
    private String name;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate std;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long amountFreeTickets;
    private Long amountPaytickets;

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
    public LocalDate getStd() {
        return std;
    }
    public void setStd(LocalDate std) {
        this.std = std;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }
    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }
    public Long getAmountPaytickets() {
        return amountPaytickets;
    }
    public void setAmountPaytickets(Long amountPaytickets) {
        this.amountPaytickets = amountPaytickets;
    }
        
    
       
}
