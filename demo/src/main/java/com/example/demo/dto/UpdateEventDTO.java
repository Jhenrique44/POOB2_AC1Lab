package com.example.demo.dto;

import java.time.LocalDate;

public class UpdateEventDTO {
    
    private String name;
    private String email;

    private LocalDate std;
    private LocalDate endDate;

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
    
    
       
}
