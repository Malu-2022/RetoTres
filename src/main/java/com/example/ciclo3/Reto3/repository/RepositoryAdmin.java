package com.example.ciclo3.Reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ciclo3.Reto3.model.Admin;
import com.example.ciclo3.Reto3.repository.crud.CrudRepositoryAdmin;

@Repository
public class RepositoryAdmin {
    
    @Autowired
    private CrudRepositoryAdmin crudRepositoryAdmin;

    public List<Admin> getAll(){
        return (List<Admin>) crudRepositoryAdmin.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return crudRepositoryAdmin.findById(id);
    }
    
    public Admin save(Admin admin){
        return crudRepositoryAdmin.save(admin);
    }

}