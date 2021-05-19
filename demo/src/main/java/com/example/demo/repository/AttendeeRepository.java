package com.example.demo.repository;

import com.example.demo.entities.Attend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attend, Long>{
    

    // @Query("SELECT a FROM Attend a " + 
    //         "WHERE " + 
    //         "( LOWER(a.name)        LIKE LOWER(CONCAT('%', :name, '%')))"
    //         // "(a.balance             LIKE (CONCAT('%', :balance , '%')))"
    // )
    // public Page<Attend> find(Pageable pageRequest);
}
