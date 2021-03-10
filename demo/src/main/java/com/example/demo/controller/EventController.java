package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.EventDTO;
import com.example.demo.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    

    @Autowired 
    private EventService service; 

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvents(){
        List <EventDTO> list = service.getEvents();
        return ResponseEntity.ok().body(list);
        
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventByCodigo(@PathVariable Long id){

        EventDTO dto = service.getEventByCodigo(id);

        return ResponseEntity.ok().body(dto);


    }
}
