package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

// import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.InsertAdminDTO;

@Entity
@Table(name = "TB_ADMIN")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Admin extends User{    


    private String phoneNumber;

    @OneToMany(mappedBy = "admin") //One admin have N events
    private List<Event> events = new ArrayList<>();;

    public Admin(){

        
    }

    public Admin(InsertAdminDTO insertDTO) {

        this.setId(insertDTO.getId());
        // this.getId();
        this.setName(insertDTO.getName());
        this.setEmail(insertDTO.getEmail());
        this.phoneNumber = insertDTO.getPhoneNumber();

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Admin(Long id, String name, String email, String phoneNumber) {
        super(id, name, email);
        this.phoneNumber = phoneNumber;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

 
    
    
}
