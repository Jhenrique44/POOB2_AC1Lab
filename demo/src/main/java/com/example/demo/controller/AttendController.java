package com.example.demo.controller;

import java.net.URI;

import com.example.demo.dto.AttendDTO;
import com.example.demo.dto.InsertAttendDTO;
import com.example.demo.dto.UpdateAttendDTO;
import com.example.demo.service.AttendService;

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
@RequestMapping("/attendees")
public class AttendController {
    

    @Autowired
    private AttendService service;

    @GetMapping
    public ResponseEntity<Page<AttendDTO>> getAttendees(
        
        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy
        // @RequestParam(value = "balance",      defaultValue = "") Double balance


    
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page<AttendDTO> list = service.getAttendees(pageRequest);
        
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<AttendDTO> getAttendeeById(@PathVariable Long id){

        AttendDTO dto = service.getAttendeeById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AttendDTO> insert(@RequestBody InsertAttendDTO insertDTO){

        AttendDTO dto = service.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<AttendDTO> update(@PathVariable Long id, @RequestBody UpdateAttendDTO updateDTO){

        AttendDTO dto = service.update(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.noContent().build();


    }
}
