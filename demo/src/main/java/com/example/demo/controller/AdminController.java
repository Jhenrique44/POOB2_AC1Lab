package com.example.demo.controller;

import java.net.URI;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<Page<AdminDTO>> getAdmins(


    ){


    }


    @PostMapping
    public ResponseEntity<AdminDTO> insert(@RequestBody InsertAdminDTO insertDTO){

        AdminDTO dtp = service.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<AdminDTO> update(@PathVariable Long id, @RequestBody UpdateAdminDTO updateDTO){
        AdminDTO dto = service.update(id, updateDTO);
        return ResponseEntity.ok().body(dto);

    }
}
