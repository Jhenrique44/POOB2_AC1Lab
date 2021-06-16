package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDate;
// import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.GetTicketByEventDTO;
import com.example.demo.dto.InsertEventDTO;
import com.example.demo.dto.InsertPlaceDTO;
import com.example.demo.dto.InsertTicketDTO;
import com.example.demo.dto.PlaceDTO;
import com.example.demo.dto.TicketDTO;
import com.example.demo.dto.UpdateEventDTO;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Attend;
import com.example.demo.entities.Event;
import com.example.demo.entities.Place;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.TicketType;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.AttendeeRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.repository.TicketRepository;

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

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private AttendeeRepository attendeeRepository;

    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String descp, String email){
        Page<Event> list = repo.find(pageRequest, name, descp, email);
        return list.map( c -> new EventDTO(c) );
    }

    public EventDTO getEventById(Long id){
        Optional<Event> op = repo.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        
        return new EventDTO(event);

    }
    public EventDTO insert(InsertEventDTO insert){

        if (insert.getStd().isAfter(insert.getEndDate())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"End date must be after the Start date");
        } else {

            Event entity = new Event(insert);
            try {
                
                Admin a = adminRepository.findById(insert.getIdAdmin()).get();
                entity.setAdmin(a);
                // entity = repo.save(entity);
            } catch (NoSuchElementException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Admin not found");
            }    
            try {

                entity = repo.save(entity);
                return new EventDTO(entity);

            } catch (NoSuchElementException e) {
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

        if (updateDTO.getEndDate().isBefore(updateDTO.getStd())) {

            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "End date must be after the Start date");

        } else {
            try {

                Event entity = repo.getOne(id);
                entity.setName(updateDTO.getName());
                entity.setEmail(updateDTO.getEmail());
                entity.setStd(updateDTO.getStd());
                entity.setEndDate(updateDTO.getEndDate());
                entity.setStartTime(updateDTO.getStartTime());
                entity.setEndTime(updateDTO.getEndTime());
                entity.setAmountFreeTickets(updateDTO.getAmountFreeTickets());
                entity.setAmountPayTickets(updateDTO.getAmountPayTickets());
    
                entity = repo.save(entity);
    
                return new EventDTO(entity);
            } catch (EntityNotFoundException ex) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Event Not Found");
            } 
        }
        
    }

    //Requisição  GET /{idEvent}/tickets 
    public List<GetTicketByEventDTO> getTicketEventById(Long id){
        Optional<Event> op = repo.findById(id);
        Event event = op.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        // GetTicketByEventDTO dto = new GetTicketByEventDTO(); 
        
        List<GetTicketByEventDTO> listdto = new ArrayList<>();
        List<Attend> listAttend = new ArrayList<>();
        List<Ticket> listTickets = event.getTickets();
        listAttend = attendeeRepository.findAll();
        try {
            for (Attend attend : listAttend){
            
                for (Ticket tickets : attend.getTickets()){
                    if (listTickets.contains(tickets)) {
                        GetTicketByEventDTO dto = new GetTicketByEventDTO();    
                        dto.setNameAttend(attend.getName());
                        if(tickets.getType().equals(TicketType.FREE)){
                            dto.setTotalSelledFree(dto.getTotalSelledFree()+1);
                        }else{
                            dto.setTotalSelledPayd(dto.getTotalSelledPayd()+1);
                        }
                        dto.setTotalAmountFree(dto.getTotalAmountFree() + event.getAmountFreeTickets());
                        dto.setTotalAmountPayd(dto.getTotalAmountPayd() + event.getAmountPayTickets());
                        dto.setType(tickets.getType());
                        listdto.add(dto);
                    } else {
                            
                    }
                }
            }
    
        } catch (Exception e) {
            System.out.println("Error parça");
        }
        return listdto;
        
        // for (Ticket tickets : event.getTickets()) {
        //     if (tickets.getType().equals(TicketType.FREE)) {
        //         dto.setTotalSelledFree(dto.getTotalSelledFree()+1);
        //     } else {
        //         dto.setTotalSelledPayd(dto.getTotalSelledPayd()+1);
        //     }
        // }
        // dto.setTotalAmountFree(event.getAmountFreeTickets());
        // dto.setTotalAmountPayd(event.getAmountPayTickets());
        // dto.setTotalAmountFree(dto.getTotalSelledFree() + event.getAmountFreeTickets());
        // dto.setTotalAmountPayd(dto.getTotalAmountPayd() + event.getAmountPayTickets());

        // return dto;

    }
    //Requisição POST /{idevent}/tickets
    public TicketDTO insertTicket(InsertTicketDTO insertTicketDTO, Long idEvent){

        Ticket entity = new Ticket(insertTicketDTO);
        try {
                
            Event e = repo.findById(idEvent).get();
            Optional<Attend> op = attendeeRepository.findById(insertTicketDTO.getIdAttend());
            Attend attend = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Attend not found"));
            
            // if(insertTicketDTO.getType() == TicketType.FREE){
            //     e.setAmountFreeTickets(e.getAmountFreeTickets()-1);
            //     entity.setPrice(0.0);
            // }else{
            //     e.setAmountPayTickets(e.getAmountPayTickets()-1);
            //     entity.setPrice(e.getPriceTicket());
            // }
            // // || insertTicketDTO.getType().equals(TicketType.FREE)
            // if(attend.getBalance() > e.getPriceTicket()){
            //     if(insertTicketDTO.getType().equals(TicketType.FREE)){
            //         attend.addTickets(entity);
            //         entity.setDate(Instant.now());
            //         e.addTicket(entity);
            //         entity = ticketRepository.save(entity);

            //         return new TicketDTO(entity);
            //     }else{
            //         attend.addTickets(entity);
            //         entity.setDate(Instant.now());
            //         e.addTicket(entity);
            //         entity = ticketRepository.save(entity);
                    
            //         return new TicketDTO(entity);
            //     }
            //     // return new TicketDTO(entity);
            // }else{
            //     throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Saldo Insuficiente");
            // }
            if (insertTicketDTO.getType().equals(TicketType.PAID)) {
                
                if (attend.getBalance() > e.getPriceTicket()) {
                    
                    entity.setPrice(e.getPriceTicket());
                    entity.setDate(Instant.now());
                    attend.setBalance(attend.getBalance() - entity.getPrice());
                    attend.addTickets(entity);
                    e.addTicket(entity);
                    
                    if(e.getAmountPayTickets() != 0){
                        e.setAmountPayTickets((e.getAmountPayTickets()) - 1);
                    }else{
                        throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Invalid Ticket (Sold out)");
                    }

                    entity = ticketRepository.save(entity);
                    return new TicketDTO(entity);

                } else {
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Insuficient Balance for Buy");
                }

            } else {

                entity.setPrice(0.0);
                attend.addTickets(entity);
                entity.setDate(Instant.now());
                e.addTicket(entity);

               if(e.getAmountFreeTickets() != 0){
                    e.setAmountFreeTickets((e.getAmountFreeTickets()) - 1);
                }else{
                   throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Invalid Ticket (Sold out)");
                }    
                
                entity = ticketRepository.save(entity);
                return new TicketDTO(entity);
            }

        } catch (NoSuchElementException r) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "idEvent not Found");
        }

    }

    // DELETE /{idEvent}/tickets
    public void deleteTicket(Long idEvent, InsertTicketDTO deleteDTO){

        // Ticket entity = new Ticket(deleteDTO);
        Optional<Attend> op = attendeeRepository.findById(deleteDTO.getIdAttend());
        Attend attend = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Attend not found"));
            
        try {
        Event e = repo.findById(idEvent).get();
            

            // for (Ticket tickets : attend.getTickets()) {
                
            //     attend.removeTicket(tickets);
            //     ticketRepository.deleteById(tickets.getId());
            // }
            
            for (Ticket tickets : attend.getTickets()) {
                if(deleteDTO.getType().equals(TicketType.FREE)){

                    if(attend.getTickets().isEmpty() == false){ 
                    // || tickets.getId().equals(null)){
                        
                        if(tickets.getType().equals(TicketType.FREE)){
                            e.setAmountFreeTickets(e.getAmountFreeTickets()+1);
                            attend.removeTicket(tickets);
                            ticketRepository.deleteById(tickets.getId());    
                        }else{
                            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"don't have any FREE tickets to devolve");
                        }
                        
                    }
                    else{
                        throw new ResponseStatusException(HttpStatus.FORBIDDEN,"don't have tickets anymore");
                    }
                }else{
                         
                    e.setAmountPayTickets(e.getAmountPayTickets()+1);
                    attend.setBalance(attend.getBalance() + e.getPriceTicket());
                    attend.removeTicket(tickets);
                    ticketRepository.deleteById(tickets.getId());
                         
                } 
            }
            // for (Ticket tickets : attend.getTickets()) {
                
            //     for (Ticket ticketsE : e.getTickets()) {
                    
            //         if(deleteDTO.getType().equals(TicketType.FREE)){

            //             if((tickets.getType().equals(TicketType.FREE) && ticketsE.getType().equals(TicketType.FREE))){

            //                 attend.removeTicket(tickets);
            //                 ticketRepository.deleteById(tickets.getId());
            //                 ticketRepository.deleteById(ticketsE.getId());
            //             }else{
            //                 throw new ResponseStatusException(HttpStatus.FORBIDDEN,"don't have any FREE tickets to sell back");
            //             }

            //         }else{

            //         }



            //     }
            // }

            
        } catch (NoSuchElementException r) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }

    }


    
    public List<EventDTO> toDTOList(List<Event> list) {

        List<EventDTO> listDTO = new ArrayList<>();
            
        for (Event c : list){
            EventDTO dto = new EventDTO(c.getId(), c.getName(), c.getDescp(), c.getEmail(), c.getStd(), c.getEndDate(),
                                 c.getStartTime(),c.getEndTime());
            listDTO.add(dto);
        }
        return listDTO;

    }

    public void insertPlaceEvent(Long idEvent, Long idPlace) {
        // public LocalDate today;
        try {
            Event e = repo.findById(idEvent).get();
            
            if(e.getEndDate().isBefore(LocalDate.now()))
                throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Event date already finished");
            else{

                try {
                    Place p = placeRepository.findById(idPlace).get();

                    p.addEvent(e);
                    // e.addPlace(p);

                    // repo.save(e);
                    placeRepository.save(p);
                    
                } catch (NoSuchElementException r) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Place not found");            
                }
            }
        } catch (NoSuchElementException r) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Event not found");
        }

    }

    public void deletePlaceEvent(Long idEvent, Long idPlace){

        try {
            Event e = repo.findById(idEvent).get();
            
            if(e.getEndDate().isBefore(LocalDate.now()))
                throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Event date already finished");
            else{

                try {
                    Place p = placeRepository.findById(idPlace).get();
                    
                    // placeRepository.deleteAll(e.getPlaces());
                    // placeRepository.deleteInBatch(e.getPlaces());
                    // p.getEvents().clear();
                    p.removeEvent(e);

                    placeRepository.save(p);

                    // repo.deleteAll(p.getEvents());
                    
                } catch (NoSuchElementException r) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Place not found");            
                }
            }
        } catch (NoSuchElementException r) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Event not found");
        }

    } 
}
