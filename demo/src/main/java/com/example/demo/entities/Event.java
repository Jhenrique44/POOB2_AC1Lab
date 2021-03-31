package com.example.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.InsertEventDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="TB_EVENT")
public class Event implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String desc;
    private String address;
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy") //formatando a data
    private LocalDate stD;
    private LocalDate endDate;

    @DateTimeFormat(pattern = "HH:mm:ss.SSS") //formatando o horario
    private LocalTime startTime;
    private LocalTime endTime;

    LocalDate dateToday;
    LocalTime hourNow;
    
    public Event(){
        
    }

    public Event(InsertEventDTO insertDTO) {
        this.name = insertDTO.getName();
        this.address = insertDTO.getAddress();
        this.desc = insertDTO.getDesc();
        this.email = insertDTO.getEmail();
        this.stD = insertDTO.getStD();
        this.endDate = insertDTO.getEndDate();
        this.startTime = insertDTO.getStartTime();
        this.endTime = insertDTO.getEndTime();

    }
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

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
        if(startTime.isAfter(hourNow)) 
            this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        if(endTime.isAfter(startTime))
            this.endTime = endTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    


    
    


    



}
