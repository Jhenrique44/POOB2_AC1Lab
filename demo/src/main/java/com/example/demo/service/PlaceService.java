package com.example.demo.service;

import com.example.demo.dto.PlaceDTO;
import com.example.demo.entities.Place;
import com.example.demo.repository.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    
    @Autowired
    private PlaceRepository repo;

    public Page<PlaceDTO> getPlaces(PageRequest pageRequest, String name, String address){
        Page<Place> list = repo.find(pageRequest, name, address);
        return list.map( c -> new PlaceDTO(c));
    }
    
}
