package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import com.example.demo.dto.AttendDTO;
import com.example.demo.dto.InsertAttendDTO;
import com.example.demo.dto.UpdateAttendDTO;
import com.example.demo.entities.Attend;
import com.example.demo.repository.AttendeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttendService {
    
    @Autowired
    private AttendeeRepository repo;

    public Page<AttendDTO> getAttendees(PageRequest pageRequest){
        
        Page<Attend> list = repo.findAll(pageRequest);
        
        return list.map( c -> new AttendDTO(c) );
    }

    public AttendDTO getAttendeeById(Long id){
        Optional<Attend> op = repo.findById(id);
        Attend attendee = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendee not Found"));

        return new AttendDTO(attendee);
    }

    public AttendDTO insert(InsertAttendDTO insert) {
        
        Attend entity = new Attend(insert);
        entity = repo.save(entity);

        return new AttendDTO(entity);

    }
    public AttendDTO update(Long id, UpdateAttendDTO updateDTO){


        try {
            Attend entity = repo.getOne(id);

            entity.setEmail(updateDTO.getEmail());
            
            entity = repo.save(entity);

            return new AttendDTO(entity);
        } catch (EntityExistsException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attende not Found");
        }
    }


    public List<AttendDTO> toDTOList(List<Attend> list){
        
        List<AttendDTO> listDTO = new ArrayList<>();

        for(Attend a: list){
            AttendDTO dto = new AttendDTO(a.getId(), a.getName(), a.getEmail(), a.getBalance());
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
