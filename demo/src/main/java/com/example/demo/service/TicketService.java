package com.example.demo.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.TicketDTO;
import com.example.demo.entities.Attend;
import com.example.demo.entities.Event;
import com.example.demo.entities.Ticket;
import com.example.demo.repository.AttendeeRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TicketService {
    
    

    @Autowired 
    private TicketRepository repo;

    @Autowired 
    private AttendeeRepository attendRepo;

    @Autowired 
    private EventRepository eventRepo;

    // public TicketDTO getTicketByEvent(Long id){

    //     Optional<Event> op = eventRepo.findById(id);
    //     Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not Found"));

    //     return new TicketDTO(event);

    // }
    // public TicketDTO insert(InsertTicketDTO insert){

	// public List<TicketDTO> toDTOList(List<Ticket> list) {
		
    //     List<TicketDTO> listDTO = new ArrayList<>();

    //     for(Ticket c : list){

    //         TicketDTO dto = new TicketDTO(c.getId(), c.getType(), c.getPrice(), c.getDate());

    //         listDTO.add(dto);
    //     }
        
    //     return listDTO;
	// }

    //     Ticket ticket = new Ticket();


    //     Event e = eventRepo.findById(insert.getIdEvent()).get();
    //     Attend a = attendRepo.findById(insert.getIdAttend()).get();

    //     ticket.set
    //     ticket.setDate(Instant.now());
    //     ticket.setPrice(e.getPriceTicket());
    //     ticket.setType(ticket.);

    // }

    // public void deleteTicket(Long idEvent){

    //     try {
            
    //         Event e = eventRepo.findById(idEvent).get();

    //         repo.deleteAll(e.getTickets());


    //     } catch (EmptyResultDataAccessException e) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
    //     }

    // }

}
