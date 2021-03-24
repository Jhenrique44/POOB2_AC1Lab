package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateEventDTO {
    
    private String address;
    private String email;
    
    private LocalDate beginDate;
    private LocalDate endDate;
    private LocalTime beginTime;
    private LocalTime endTime;


    
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
    public LocalDate getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public LocalTime getBeginTime() {
        return beginTime;
    }
    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    
       
}
