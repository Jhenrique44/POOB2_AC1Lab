package com.example.demo.service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.InsertAdminDTO;
import com.example.demo.entities.Admin;
import com.example.demo.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    @Autowired 
    private AdminRepository repo;




    public Page<AdminDTO> getAdmins(PageRequest pageRequest, String name){

        Page<Admin> list = repo.find(pageRequest, name);
        return list.map( c -> new AdminDTO(c));
    }



    public AdminDTO insert(InsertAdminDTO insert){

        Admin entity = new Admin(insert);
        entity = repo.save(entity);

        return new AdminDTO(entity);
    }


    

}
