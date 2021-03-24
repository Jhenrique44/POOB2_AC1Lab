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

    //Pegando todos os eventos cadatrados na lista 
    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String address){

        Page<Event> list = repo.find(pageRequest, name, address); //usando recurso jpa para pegar todos os eventos. 
        
        return list.map(c -> new EventDTO(c));

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
            event =  repo.save(event);

            return new EventDTO(event);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }


    }

    // public EventDTO updata(Long id, UpdataDTO updataDTO){

    //     try {
    //         Event event =  repo.getOne(id);
    //         event.setStartDate(updataDTO.getStartDate());
    //         event.setEndDate(updataDTO.getEndDate());
    //         event.setStartTime(updataDTO.getStartTime());
    //         event.setEndTime(updataDTO.getEndTime());
    //         event = repo.save(event);
            
    //         return new EventDTO(event);

    //     } catch (EntityNotFoundException e) {
            
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
    //     }catch(EmptyResultDataAccessException e){
            
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data invalida");
    //     }

    // }

    private List<EventDTO> toDTOList(List<Event> list){

        List<EventDTO> listDTO = new ArrayList<>();

        for(Event c : list){
            
            listDTO.add(new EventDTO(c.getId(), c.getName(), c.getAddress(), c.getEmail()));
            
        }

        return listDTO;

    }

}
