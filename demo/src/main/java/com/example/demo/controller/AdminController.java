package com.example.demo.controller;

import java.net.URI;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.InsertAdminDTO;
import com.example.demo.service.AdminService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/admins")
public class AdminController {
    
    @Autowired 
    private AdminService service;

    @PostMapping
    public ResponseEntity<AdminDTO> insert(@RequestBody InsertAdminDTO insertDTO){

        AdminDTO dto = service.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        
        return ResponseEntity.noContent().build();

    }
}
