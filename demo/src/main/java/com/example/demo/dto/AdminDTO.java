package com.example.demo.dto;

import com.example.demo.entities.Admin;

public class AdminDTO {


    private Long id;
    
    private String email;

    private String phoneNumber;

    public AdminDTO(){

    }
    public AdminDTO(Long id, String email, String phoneNumber){

        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public AdminDTO(Admin adm){

        this.id = adm.getId();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
