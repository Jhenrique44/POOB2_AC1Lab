package com.example.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
// import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.example.demo.dto.InsertEventDTO;


@Entity
@Table(name="TB_EVENT")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Event implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idAdmin;
    private String name;
    private String descp;    
    private String email;
    private Long amountFreeTickets;
    private Long amountPayTickets;
    private Double priceTicket;
    private LocalDate std;
    private LocalDate endate;
    // private LocalTime startTime;
    // private LocalTime endTime;
    //LocalDate dateToday;
    // LocalTime hourNow;

    @ManyToOne // N events have one admin 
    @JoinColumn(name = "ADMIN_USER_ID")
    private Admin admin;


    @ManyToMany
    @JoinTable(
        name = "TB_EVENT_PLACE",
        joinColumns = @JoinColumn(name = "EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PLACE_ID")
    )
    private List<Place> places = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST) //One event have N tickets 
    @JoinColumn(name = "EVENT_ADMIN_ID")
    private List<Ticket> tickets = new ArrayList<>();

    
    public Event(){
        
    }

    public Event(InsertEventDTO insertDTO) {
        this.idAdmin = insertDTO.getIdAdmin();
        this.name = insertDTO.getName();
        this.descp = insertDTO.getDescp();
        this.email = insertDTO.getEmail();
        this.std = insertDTO.getStd();
        this.endate = insertDTO.getEndate();
        this.amountFreeTickets = insertDTO.getAmountFreeTickets();
        this.amountPayTickets = insertDTO.getAmountPayTickets();
        this.priceTicket = insertDTO.getPriceTicket();


    }

    
    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = admin.getId(); //
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

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
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
        // if(stD.isAfter(dateToday))
        this.std = std;
    }

    public LocalDate getEndate() {
        return endate;
    }

    public void setEndate(LocalDate endate) {
        // if(endate.isAfter(stD))
        this.endate = endate;
    }

    // public LocalTime getStartTime() {
    //     return startTime;
    // }

    // public void setStartTime(LocalTime startTime) {
    //     if(startTime.isAfter(hourNow)) 
    //         this.startTime = startTime;
    // }

    // public LocalTime getEndTime() {
    //     return endTime;
    // }

    // public void setEndTime(LocalTime endTime) {
    //     if(endTime.isAfter(startTime))
    //         this.endTime = endTime;
    // }

    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }

    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }

    public Long getAmountPayTickets() {
        return amountPayTickets;
    }

    public void setAmountPayTickets(Long amountPayTickets) {
        this.amountPayTickets = amountPayTickets;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }
    
    public Admin getAdmin() {
        return admin;
    }


    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    // public List<Place> getPlaces() {
    //     return places;
    // }

    // public void addPlace(Place place) {
    //     this.places.add(place);
    // }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
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

    // public Event(Long id, String name, String descp, String email, Long amountFreeTickets,
    //         Long amountPayTickets, Double priceTicket, LocalDate std, LocalDate endate) {
    //     this.id = id;
    //     this.name = name;
    //     this.descp = descp;
    //     this.email = email;
    //     this.amountFreeTickets = amountFreeTickets;
    //     this.amountPayTickets = amountPayTickets;
    //     this.priceTicket = priceTicket;
    //     this.std = std;
    //     this.endate = endate;
    // }
    // public void addTicket(Inte)

    
    
    


    



}
