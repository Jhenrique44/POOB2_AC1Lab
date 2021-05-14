package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.InsertPlaceDTO;
import com.example.demo.dto.PlaceDTO;
import com.example.demo.dto.UpdatePlaceDTO;
import com.example.demo.entities.Place;
import com.example.demo.repository.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceService {
    
    @Autowired
    private PlaceRepository repo;

    public Page<PlaceDTO> getPlaces(PageRequest pageRequest, String name, String address){
        Page<Place> list = repo.find(pageRequest, name, address);
        return list.map( c -> new PlaceDTO(c));
    }

    public PlaceDTO getPlaceById(Long id){

        Optional<Place> op = repo.findById(id);
        Place place = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Place not found"));

        return new PlaceDTO(place);

    }

    public PlaceDTO insert(InsertPlaceDTO insert){

        Place entity = new Place(insert);
        entity =  repo.save(entity);

        return new PlaceDTO(entity);

    }

    public void delete(Long id) {

        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not Found");
        }

    }
    
    public PlaceDTO update(Long id, UpdatePlaceDTO updateDTO){

        try {
            
            Place entity = repo.getOne(id);
            entity.setAddress(updateDTO.getAddress());

            entity = repo.save(entity);

            return new PlaceDTO(entity);

        } catch (EntityNotFoundException ex) {
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not Found");
        }

    }







    public List<PlaceDTO> toDTOList(List<Place> list){

        List<PlaceDTO> listDTO = new ArrayList<>();
        
        for(Place c : list){

            PlaceDTO dto = new PlaceDTO(c.getId(), c.getName(), c.getAddress());
            listDTO.add(dto);
        }
        return listDTO;
        
    }
}
