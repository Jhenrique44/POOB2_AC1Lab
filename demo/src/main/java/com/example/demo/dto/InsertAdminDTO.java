package com.example.demo.dto;

import com.example.demo.entities.User;

public class InsertAdminDTO extends User{
    
    // private String name;

    // private String email;

    private String phoneNumber;

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // public InsertAdminDTO() {
    // }

    // public InsertAdminDTO(Long id, String name, String email) {
    //     super(id, name, email);
    // }

    public InsertAdminDTO(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public InsertAdminDTO(Long id, String name, String email, String phoneNumber) {
        super(id, name, email);
        this.phoneNumber = phoneNumber;
    }

    

}
