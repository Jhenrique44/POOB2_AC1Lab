package com.example.demo.service;

import java.time.LocalDate;
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

    //Pegando todos os eventos cadatrados na lista, agora paginada, passando filtros
    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String address, LocalDate startDate, String description){

        Page<Event> list = repo.find(pageRequest, name, address, startDate, description);  
        
        return list.map(c -> new EventDTO(c));

    }
    public Page<EventDTO> getEventsByDate(PageRequest pageRequest, LocalDate startDate){

        Page<Event> list = repo.findByDate(pageRequest, startDate);
        
        return list.map(c ->  new EventDTO(c));

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

    public EventDTO update(Long id, UpdateEventDTO updateDTO){

        try {
            Event event = repo.getOne(id);
            event.setAddress(updateDTO.getAddress());
            event.setEmail(updateDTO.getEmail());

            event.setStartDate(updateDTO.getStartDate());
            event.setEndDate(updateDTO.getEndDate());
            event.setStartTime(updateDTO.getStartTime());
            event.setEndTime(updateDTO.getEndTime());

            event =  repo.save(event);

            return new EventDTO(event);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        // } catch (){
        //     throw new ResponseStatusException(HttpStatus.)
        // }
        }
    }
}


    // private List<EventDTO> toDTOList(List<Event> list){

    //     List<EventDTO> listDTO = new ArrayList<>();

    //     for(Event c : list){
            
    //         listDTO.add(new EventDTO(c.getId(), c.getName(), c.getAddress(), c.getEmail()));
            
    //     }

    //     return listDTO;

    // }

