package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.InsertAdminDTO;
import com.example.demo.dto.UpdateAdminDTO;
import com.example.demo.entities.Admin;
import com.example.demo.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {


    @Autowired 
    private AdminRepository repo;


    public Page<AdminDTO> getAdmins(PageRequest pageRequest){

        Page<Admin> list = repo.findAll(pageRequest);
        return list.map( c -> new AdminDTO(c));
    }



    public AdminDTO insert(InsertAdminDTO insert){

        Admin entity = new Admin(insert);
        entity = repo.save(entity);

        return new AdminDTO(entity);
    }



    public AdminDTO getAdminById(Long id) {
        
        Optional<Admin> op = repo.findById(id);
        Admin admin = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin Not Found"));

        return new AdminDTO(admin);

    }

    public void delete(Long id) {

        try {
            repo.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Admin not Found");
        }
	}

    public AdminDTO udpdate(Long id, UpdateAdminDTO updateDTO){

        try {
            Admin entity = repo.getOne(id);
            // entity.setName(updateDTO.getName());
            entity.setEmail(updateDTO.getEmail());
            entity.setPhoneNumber(updateDTO.getPhoneNumber());

            entity = repo.save(entity);

            return new AdminDTO(entity);
        } catch (EntityExistsException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }


    }
    
    public List<AdminDTO> toDTOList(List<Admin> list){

        List<AdminDTO> listDTO = new ArrayList<>();

        for(Admin a: list){
            AdminDTO dto = new AdminDTO(a.getId(), a.getName(), a.getEmail(), a.getPhoneNumber());
            listDTO.add(dto);
        }

        return listDTO;

        
    }

}
