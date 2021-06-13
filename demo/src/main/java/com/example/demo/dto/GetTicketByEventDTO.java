package com.example.demo.dto;


public class GetTicketByEventDTO {
    
    private Long totalAmountFree;

    private Long totalAmountPayd;

    private Long totalSelledFree;

    private Long totalSelledPayd;

    public GetTicketByEventDTO(){

    }
    
    public Long getTotalAmountFree() {
        return totalAmountFree;
    }

    public void setTotalAmountFree(Long totalAmountFree) {
        this.totalAmountFree = totalAmountFree;
    }

    public Long getTotalAmountPayd() {
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

    
}
