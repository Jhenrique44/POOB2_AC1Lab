package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InsertEventDTO {
    
    private String name;
    private String desc;
    private String address;
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
   
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @JsonFormat(pattern = "HH:mm:ss.SSS")
    private LocalTime startTime;
    
    @JsonFormat(pattern = "HH:mm:ss.SSS")
    private LocalTime endTime;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dateToday = LocalDate.now();

    @JsonFormat(pattern = "HH:mm:ss.SSS")
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if(startDate.isAfter(dateToday))
            this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if(endDate.isAfter(startDate))
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
