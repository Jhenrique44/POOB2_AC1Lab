package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antlr.debug.Event;

@Repository
public interface EventResposity extends JpaRepository<Event, Long>{
    
}
