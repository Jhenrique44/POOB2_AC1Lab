package com.example.demo.repository;

import com.example.demo.entities.Attendee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long>{
    

    @Query("SELECT a FROM Attendee a " + 
            "WHERE " + 
            "( LOWER(a.name)        LIKE LOWER(CONCAT('%', :name, '%')))"
            // "(a.balance             LIKE (CONCAT('%', :balance , '%')))"
    )
    public Page<Attendee> find(Pageable pageRequest, String name);
}
