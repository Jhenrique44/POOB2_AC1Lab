package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.EventDTO;
import com.example.demo.entities.Event;
import com.example.demo.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired 
    private EventRepository repo;

    //Pegando todos os eventos cadatrados na lista 
    public List<EventDTO> getEvents(){

        List<Event> list = repo.findAll(); //usando recurso jpa para pegar todos os eventos. 
        
        return toDTOList(list);

    }

    private List<EventDTO> toDTOList(List<Event> list){

        List<EventDTO> listDTO = new ArrayList<>();

        for(Event c : list){
            
            listDTO.add(new EventDTO(c.getId(), c.getName(), c.getAddress(), c.getEmail()));
            
        }

        return listDTO;

    }

}
