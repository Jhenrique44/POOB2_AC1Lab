package com.example.demo.controller;

import java.net.URI;

import com.example.demo.dto.AttendeeDTO;
import com.example.demo.dto.InsertAttendeeDTO;
import com.example.demo.service.AttendeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {
    

    @Autowired
    private AttendeeService service;

    @GetMapping
    public ResponseEntity<Page<AttendeeDTO>> getAttendees(
        
        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
        @RequestParam(value = "name",         defaultValue = "") String name,
        @RequestParam(value = "balance",      defaultValue = "") Double balance


    
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page<AttendeeDTO> list = service.getAttendees(pageRequest, name.trim(), balance);
        
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<AttendeeDTO> getAttendeeById(@PathVariable Long id){

        AttendeeDTO dto = service.getAttendeeById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AttendeeDTO> insert(@RequestBody InsertAttendeeDTO insertDTO){

        AttendeeDTO dto = service.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

}
