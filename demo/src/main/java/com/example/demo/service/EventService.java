package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.InsertEventDTO;
import com.example.demo.entities.Event;
import com.example.demo.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {
    
    @Autowired 
    private EventRepository repo;

    //Pegando todos os eventos cadatrados na lista 
    public List<EventDTO> getEvents(){

        List<Event> list = repo.findAll(); //usando recurso jpa para pegar todos os eventos. 
        
        return toDTOList(list);

    }
    public EventDTO getEventById(Long id){

        Optional<Event> op = repo.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Event not found"));

        return new EventDTO(event); 
    }

    public EventDTO insert(InsertEventDTO insertDTO){
        Event entity = new Event(insertDTO);
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
    private List<EventDTO> toDTOList(List<Event> list){

        List<EventDTO> listDTO = new ArrayList<>();

        for(Event c : list){
            
            listDTO.add(new EventDTO(c.getId(), c.getName(), c.getAddress(), c.getEmail()));
            
        }

        return listDTO;

    }

}
