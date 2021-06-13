package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

// import org.springframework.format.annotation.DateTimeFormat;

public class InsertEventDTO {
    
    private Long idAdmin;
    private Long idPlace;
    private String name;
    private String descp;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate std;
   
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private Long amountFreeTickets;
    private Long amountPayTickets;
    private Double priceTicket;

    // @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    private LocalTime startTime;
    
    // @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    private LocalTime endTime;
    
    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate dateToday = LocalDate.now();

    // @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    LocalTime timeNow = LocalTime.now();
    
    
    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    
    public Long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Long idPlace) {
        this.idPlace = idPlace;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
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
        if(endDate.isAfter(std))
            this.endDate = endDate;
    }

    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }

    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }

    public Long getAmountPayTickets() {
        return amountPayTickets;
    }

    public void setAmountPayTickets(Long amountPayTickets) {
        this.amountPayTickets = amountPayTickets;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }

    

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        // if(startTime.isAfter(timeNow))
            this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        // if(endTime.isAfter(startTime))    
            this.endTime = endTime;
    }

    
}
