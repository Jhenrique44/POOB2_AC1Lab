package com.example.demo.dto;

import com.example.demo.entities.TicketType;

public class GetTicketByEventDTO {
    
    private Long idTicket;

    private String nameAttend;

    private TicketType type;
    
    private Long totalAmountFree;

    private Long totalAmountPayd;

    private Long totalSelledFree;

    private Long totalSelledPayd;

    public GetTicketByEventDTO(){

    }
    

    public GetTicketByEventDTO(Long totalAmountFree, Long totalAmountPayd, Long totalSelledFree, Long totalSelledPayd) {
        this.totalAmountFree = totalAmountFree;
        this.totalAmountPayd = totalAmountPayd;
        this.totalSelledFree = totalSelledFree;
        this.totalSelledPayd = totalSelledPayd;
    }


    public Long getTotalAmountFree() {
        if(getTotalAmountFree() == null){
            return 0L;
        }
        return totalAmountFree;
    }

    public void setTotalAmountFree(Long totalAmountFree) {
        this.totalAmountFree = totalAmountFree;
    }

    public Long getTotalAmountPayd() {
        if(getTotalAmountPayd() == null){
          return 0L;  
        }
        return totalAmountPayd;
        
    }

    public void setTotalAmountPayd(Long totalAmountPayd) {
        this.totalAmountPayd = totalAmountPayd;
    }

    public Long getTotalSelledFree() {
        if(totalSelledFree == null){
            return 0L;
        }
        return totalSelledFree;
    }

    public void setTotalSelledFree(Long totalSelledFree) {
        this.totalSelledFree = totalSelledFree;
    }

    public Long getTotalSelledPayd() {
        if(totalSelledPayd == null){
            return 0L;
        }
        return totalSelledPayd;
    }

    public void setTotalSelledPayd(Long totalSelledPayd) {
        this.totalSelledPayd = totalSelledPayd;
    }


    public Long getIdTicket() {
        return idTicket;
    }


    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }


    public String getNameAttend() {
        return nameAttend;
    }


    public void setNameAttend(String nameAttend) {
        this.nameAttend = nameAttend;
    }


    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }
    
    
}
