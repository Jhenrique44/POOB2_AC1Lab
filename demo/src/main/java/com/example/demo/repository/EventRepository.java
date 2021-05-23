package com.example.demo.repository;

import java.time.LocalDate;

// import java.time.LocalDate;

import com.example.demo.entities.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long>{

    @Query("SELECT c FROM Event c " + 
            "WHERE " + 
            " LOWER(c.name)        LIKE LOWER(CONCAT('%', :name    , '%'))    AND  " + 
            " LOWER(c.descp)        LIKE LOWER(CONCAT('%', :descp  , '%' ))   AND  " +
            // " c.std                    >                    :std                AND  " +
            " LOWER(c.email)       LIKE LOWER(CONCAT('%', :email   , '%'))"
        )
    public Page <Event> find(Pageable pageRequest, String name, String descp, String email);

}
 