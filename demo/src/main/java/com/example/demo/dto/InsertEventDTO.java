package com.example.demo.dto;

import java.time.LocalDate;
// import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class InsertEventDTO {
    
    private String name;
    private String address;
    private String descp;
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate std;
   
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endate;

    // @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    // private LocalTime startTime;
    
    // @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    // private LocalTime endTime;
    
    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    // LocalDate dateToday = LocalDate.now();

    // @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    // LocalTime timeNow = LocalTime.now();
    
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

    public LocalDate getStd() {
        return std;
    }

    public void setStd(LocalDate std) {

        this.std = std;
    }

    public LocalDate getEndate() {
        return endate;
    }

    public void setEndate(LocalDate endate) {
        if(endate.isAfter(std))
            this.endate = endate;
    }

    // public LocalTime getStartTime() {
    //     return startTime;
    // }

    // public void setStartTime(LocalTime startTime) {
    //     if(startTime.isAfter(timeNow))
    //         this.startTime = startTime;
    // }
    // public LocalTime getEndTime() {
    //     return endTime;
    // }
    // public void setEndTime(LocalTime endTime) {
    //     if(endTime.isAfter(startTime))    
    //         this.endTime = endTime;
    // }

    
}
