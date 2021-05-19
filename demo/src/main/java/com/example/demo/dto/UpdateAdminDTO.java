package com.example.demo.dto;

import com.example.demo.entities.User;

public class UpdateAdminDTO extends User {

    private String email;
    private String phoneNumber;
    

    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    
}
