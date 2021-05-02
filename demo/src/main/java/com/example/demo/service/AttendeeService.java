package com.example.demo.service;

import java.util.Optional;

import com.example.demo.dto.AttendeeDTO;
import com.example.demo.dto.InsertAttendeeDTO;
import com.example.demo.entities.Attendee;
import com.example.demo.repository.AttendeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttendeeService {
    
    @Autowired
    private AttendeeRepository repo;

    public Page<AttendeeDTO> getAttendees(PageRequest pageRequest, String name, Double balance){
        Page<Attendee> list = repo.find(pageRequest, name, balance);
        
        return list.map( a -> new AttendeeDTO(a) );


    }

    public AttendeeDTO getAttendeeById(Long id){
        Optional<Attendee> op = repo.findById(id);
        Attendee attendee = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendee not Found"));

        return new AttendeeDTO(attendee);
    }

    public AttendeeDTO insert(InsertAttendeeDTO insert) {
        
        Attendee entity = new Attendee(insert);
        entity = repo.save(entity);

        return new AttendeeDTO(entity);

    }
}
