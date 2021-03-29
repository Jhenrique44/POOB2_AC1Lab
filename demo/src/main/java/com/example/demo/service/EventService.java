package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.InsertEventDTO;
import com.example.demo.dto.UpdateEventDTO;
import com.example.demo.entities.Event;
import com.example.demo.repository.EventRepository;

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

    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String address){
        
        Page<Event> list = repo.find(pageRequest, name, address);
        return list.map( e -> new EventDTO(e) );
    }

    public EventDTO getEventById(Long id){
        Optional<Event> op = repo.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        
        return new EventDTO(event);

    }
    public EventDTO insert(InsertEventDTO insert){

        Event entity = new Event(insert);
        entity = repo.save(entity);
        return new EventDTO(entity);
    }

    public void delete(Long id){
        
        try {
            repo.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }

    }

    public EventDTO update(Long id, UpdateEventDTO updateDTO){

        try {
            Event entity = repo.getOne(id);
            entity.setAddress(updateDTO.getAddress());
            entity.setEmail(updateDTO.getEmail());
            entity.setStartDate(updateDTO.getStartDate());
            entity.setEndDate(updateDTO.getEndDate());
            entity.setStartTime(updateDTO.getStartTime());
            entity.setEndTime(updateDTO.getEndTime());

            entity = repo.save(entity);

            return new EventDTO(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Event Not Found");
        }        
    }
    public List<EventDTO> toDTOList(List<Event> list) {

        List<EventDTO> listDTO = new ArrayList<>();
            
        for (Event e: list){
            EventDTO dto = new EventDTO(e.getId(), e.getName(), e.getAddress(), e.getDescription());
            listDTO.add(dto);
        }
        return listDTO;

    }

    
}
