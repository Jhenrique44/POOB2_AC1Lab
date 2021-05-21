package com.example.demo.service;

import java.time.LocalDate;
// import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.InsertEventDTO;
import com.example.demo.dto.UpdateEventDTO;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Event;
import com.example.demo.entities.Place;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repo;
    
    @Autowired 
    private AdminRepository adminRepository;

    @Autowired 
    private PlaceRepository placeRepository;

    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String descp,
    LocalDate std, String email){
        Page<Event> list = repo.find(pageRequest, name, descp, std, email);
        return list.map( c -> new EventDTO(c) );
    }

    public EventDTO getEventById(Long id){
        Optional<Event> op = repo.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        
        return new EventDTO(event);

    }
    public EventDTO insert(InsertEventDTO insert){

        if (insert.getStd().compareTo(insert.getEndate()) > 0) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"End date must be after the Start date");
        } else {

            Event entity = new Event(insert);
            try {
                
                Admin a = adminRepository.findById(insert.getIdAdmin()).get();
                entity.setAdmin(a);

                // entity = repo.save(entity);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Admin not found");
            }    
            try {

                Place p = placeRepository.findById(insert.getIdPlace()).get();
                entity.addPlace(p);

                entity = repo.save(entity);
                return new EventDTO(entity);

            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Place not found");
            }
        }
        
    }

    public void delete(Long id){
        
        try {

            repo.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        
        }

    }

    public EventDTO update(Long id, UpdateEventDTO updateDTO){

        if (updateDTO.getStd().compareTo(updateDTO.getEndDate()) > 0) {

            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "End date must be after the Start date");

        } else {
            try {

                Event entity = repo.getOne(id);
                entity.setName(updateDTO.getName());
                entity.setEmail(updateDTO.getEmail());
                entity.setStd(updateDTO.getStd());
                entity.setEndate(updateDTO.getEndDate());
    
                entity = repo.save(entity);
    
                return new EventDTO(entity);
            } catch (EntityNotFoundException ex) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Event Not Found");
            } 
        }
        
    }
    public List<EventDTO> toDTOList(List<Event> list) {

        List<EventDTO> listDTO = new ArrayList<>();
            
        for (Event c : list){
            EventDTO dto = new EventDTO(c.getId(), c.getName(), c.getDescp(), c.getEmail(), c.getStd(), c.getEndate(),
                                 c.getStartTime(),c.getEndTime());
            listDTO.add(dto);
        }
        return listDTO;

    }
}
