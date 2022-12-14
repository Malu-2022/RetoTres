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
    
    public Bike update(Bike bike){
        if(bike.getId()!=null){
            Optional<Bike>g= repositoryBike.getBike(bike.getId());
            if(!g.isEmpty()){
                if(bike.getDescription()!=null){                    
                    g.get().setDescription(bike.getDescription());
                }
                if(bike.getName()!=null){
                    g.get().setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    g.get().setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    g.get().setYear(bike.getYear());
                }
                if(bike.getCategory()!=null){
                    g.get().setCategory(bike.getCategory());
                }
                
                
                return repositoryBike.save(g.get());
            }
        }
        return bike;
    }

    public boolean deleteBike(int id){
        Boolean d= getBike(id).map(bike -> {
                                                repositoryBike.delete(bike);
                                                return true;
                                            }
                                      ).orElse(false);
        return d;
    }

}
