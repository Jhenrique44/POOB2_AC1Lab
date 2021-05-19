package com.example.demo.dto;

import com.example.demo.entities.User;

public class UpdateAttendDTO extends User {
    
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public UpdateAttendDTO(String email){
    //     this.email = email;
    // }

    // public UpdateAttendDTO(Long id, String name, String email) {
    //     super(id, name, email);
    //     this.email = email;
    // }
    
    

    
}
