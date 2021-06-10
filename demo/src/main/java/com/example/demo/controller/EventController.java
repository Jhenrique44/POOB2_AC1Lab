package com.example.demo.controller;

import java.net.URI;
// import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.InsertEventDTO;
import com.example.demo.dto.InsertTicketDTO;
import com.example.demo.dto.TicketDTO;
import com.example.demo.dto.UpdateEventDTO;
import com.example.demo.entities.Event;
import com.example.demo.entities.Ticket;
import com.example.demo.service.EventService;
import com.example.demo.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    private EventService service;

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(

        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
        @RequestParam(value = "name",         defaultValue = "") String name,
        @RequestParam(value = "descp",        defaultValue = "") String descp,
        // @RequestParam(value = "std",          defaultValue = "") LocalDate std,
        @RequestParam(value = "email",        defaultValue = "") String email
        

    ) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page<EventDTO> list = service.getEvents(pageRequest, name.trim(), descp.trim(), email.trim());
        return ResponseEntity.ok(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id){
        
        EventDTO dto = service.getEventById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EventDTO> insert(@RequestBody InsertEventDTO insertDTO){

        EventDTO dto = service.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody UpdateEventDTO updateDTO){
        EventDTO dto = service.update(id, updateDTO);
        return ResponseEntity.ok().body(dto);
        
    }

    //Events/id/tickets
    // @GetMapping("/{id}/tickets")
    // public ResponseEntity<Ticket> getTicketByEvent(@PathVariable Long id){

    //     Ticket ticket = ticketService.getTicketByEvent(id);   
    //     return ResponseEntity.ok(ticket);

    // }
    @GetMapping("/{id}/tickets")
    public List<Ticket> getTicketEventById(@PathVariable Long id){
        
        Event event = service.getTicketEventById(id);
        return event.getTickets();

    }

    //events/{id}/places/{id}
    // @PostMapping("/events/{id}/places/{idp}")
    // public ResponseEntity<Void> insertEP(@PathVariable id, @pa )

    //events/{id}/places/{id}
    // @DeleteMapping("/events/{id}/places/{id}")

    //

    @PostMapping("/{id}/tickets")
    public ResponseEntity<TicketDTO> insertTicket(@PathVariable Long idEvent, @RequestBody InsertTicketDTO insertDTO){
    
        TicketDTO dto = service.insertTicket(insertDTO, idEvent);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);


    }

    // @DeleteMapping("{id}/tickets")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long idEvent){

        service.deleteTicket(idEvent);
        return ResponseEntity.noContent().build();

    }

}
