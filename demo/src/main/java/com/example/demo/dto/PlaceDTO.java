package com.example.demo.dto;

import com.example.demo.entities.Place;

public class PlaceDTO {

    private Long id;

    private String name;

    private String address;
    
    public PlaceDTO(){

    }
    public PlaceDTO(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public PlaceDTO(Place place){

        this.id = place.getId();
        this.name = place.getName();
        this.address = place.getAddress();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        PlaceDTO other = (PlaceDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
