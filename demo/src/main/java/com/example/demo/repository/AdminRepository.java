package com.example.demo.repository;

import com.example.demo.entities.Admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

    // @Query("SELECT a FROM Admin a " +
    //         "WHERE " + 
    //         "(LOWER (a.name)        LIKE LOWER(CONCAT('%', :name , '%')))"        
    
    // )
    // public Page <Admin> find(Pageable pageRequest, String name);
    
}
