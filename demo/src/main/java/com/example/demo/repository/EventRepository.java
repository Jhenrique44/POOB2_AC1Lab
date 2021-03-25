package com.example.demo.repository;

import java.time.LocalDate;

import com.example.demo.entities.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long>{
    
    @Query("SELECT c FROM c"+ 
        "WHERE" + 
        "LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))" + 
        "LOWER(c.address) LIKE LOWER(CONCAT('%', :address, '%' ))" + 
        "LOWER(c.startDate) LIKE LOWER(CONCAT('%', :startDate, '%'))"+
        "LOWER(C.description) LIKE LOWER(CONCAT('%', :description, '%'))"
    )
    public Page<Event> find(Pageable ageRequest, String name, String address, LocalDate startDate, String description);

}
