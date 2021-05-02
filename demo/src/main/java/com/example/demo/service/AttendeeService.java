package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import com.example.demo.dto.AttendeeDTO;
import com.example.demo.dto.InsertAttendeeDTO;
import com.example.demo.dto.UpdateAttendeeDTO;
import com.example.demo.entities.Attendee;
import com.example.demo.repository.AttendeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttendeeService {
    
    @Autowired
    private AttendeeRepository repo;

    public Page<AttendeeDTO> getAttendees(PageRequest pageRequest, String name){
        
        Page<Attendee> list = repo.find(pageRequest, name);
        
        return list.map( c -> new AttendeeDTO(c) );
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
    public AttendeeDTO update(Long id, UpdateAttendeeDTO updateDTO){


        try {
            Attendee entity = repo.getOne(id);

            entity.setEmail(updateDTO.getEmail());
            
            entity = repo.save(entity);

            return new AttendeeDTO(entity);
        } catch (EntityExistsException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attende not Found");
        }
    }


    public List<AttendeeDTO> toDTOList(List<Attendee> list){
        
        List<AttendeeDTO> listDTO = new ArrayList<>();

        for(Attendee a: list){
            AttendeeDTO dto = new AttendeeDTO(a.getId(), a.getName(), a.getEmail(), a.getBalance());
            listDTO.add(dto);
        }
        return listDTO;
    }

    public void delete(Long id) {

        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }

    }
}
