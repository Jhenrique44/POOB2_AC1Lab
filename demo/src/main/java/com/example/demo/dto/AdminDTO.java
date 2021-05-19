package com.example.demo.dto;

import com.example.demo.entities.Admin;
import com.example.demo.entities.User;

public class AdminDTO extends User{

    private Long id; 

    private String name;
    private String email;
    private String phoneNumber;

    public AdminDTO(){

    }
    public AdminDTO(Admin adm){

        this.id = adm.getId();
        this.name = adm.getName();
        this.email = adm.getEmail();
        this.phoneNumber = adm.getPhoneNumber();

    }

    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdminDTO(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public AdminDTO(Long id, String name, String email, String phoneNumber) {
        super(id, name, email);
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
