package com.example.ciclo3.Reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ciclo3.Reto3.model.Bike;
import com.example.ciclo3.Reto3.repository.crud.CrudRepositoryBike;

@Repository
public class RepositoryBike {
    
    @Autowired
    private CrudRepositoryBike crudRepositoryBike;


    public List<Bike> getAll(){
        return (List<Bike>) crudRepositoryBike.findAll();
    }
    public Optional<Bike> getBike(int id){
        return crudRepositoryBike.findById(id);
    }
    
    public Bike save(Bike bike){
        return crudRepositoryBike.save(bike);
    }

}
