package com.example.ciclo3.Reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ciclo3.Reto3.model.Client;
import com.example.ciclo3.Reto3.repository.crud.CrudRepositoryClient;

@Repository
public class RepositoryClient {

    @Autowired
    private CrudRepositoryClient crudRepositoryClient;
    
    
    public List<Client> getAll(){
        return (List<Client>) crudRepositoryClient.findAll();
    }
    public Optional<Client> getClient(int id){
        return crudRepositoryClient.findById(id);
    }
    
    public Client save(Client client){
        return crudRepositoryClient.save(client);
    }
    
    public void delete(Client client){
        crudRepositoryClient.delete(client);
    }
}
