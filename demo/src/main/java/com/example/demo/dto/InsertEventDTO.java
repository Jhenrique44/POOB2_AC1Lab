package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class InsertEventDTO {
    
    private String name;
    private String desc;
    private String address;
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate stD;
   
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    private LocalTime startTime;
    
    @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    private LocalTime endTime;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate dateToday = LocalDate.now();

    @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    LocalTime timeNow = LocalTime.now();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
     
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public LocalDate getStD() {
        return stD;
    }

    public void setStD(LocalDate stD) {
        if(stD.isAfter(dateToday))
            this.stD = stD;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if(endDate.isAfter(stD))
            this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        if(startTime.isAfter(timeNow))
            this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        if(endTime.isAfter(startTime))    
            this.endTime = endTime;
    }

    
}
