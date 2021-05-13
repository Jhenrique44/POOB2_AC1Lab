package com.example.demo.controller;

import com.example.demo.dto.PlaceDTO;
import com.example.demo.service.PlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {



    @Autowired
    private PlaceService service;

    @GetMapping
    public ResponseEntity<Page<PlaceDTO>> getPlaces(
        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
        @RequestParam(value = "name",         defaultValue = "") String name,
        @RequestParam(value = "address",      defaultValue = "") String address
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page<PlaceDTO> list = service.getPlaces(pageRequest, name.trim(), address.trim());
        
        return ResponseEntity.ok(list);
    } 

}
