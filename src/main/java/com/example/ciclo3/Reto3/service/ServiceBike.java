package com.example.ciclo3.Reto3.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ciclo3.Reto3.model.Bike;
import com.example.ciclo3.Reto3.repository.RepositoryBike;

@Service
public class ServiceBike {
    
    @Autowired
    private RepositoryBike repositoryBike;

    
    public List<Bike> getAll() {
        return repositoryBike.getAll();
    }

    public Optional<Bike> getBike(int id) {
        return repositoryBike.getBike(id);
    }

    public Bike save(Bike bike) {
        if (bike.getId() == null) {
            return repositoryBike.save(bike);
        } else {
            Optional<Bike> bike1 = repositoryBike.getBike(bike.getId());
            if (bike1.isEmpty()) {
                return repositoryBike.save(bike);
            } else {
                return bike;
            }
        }
    }

}