package com.example.ciclo3.Reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ciclo3.Reto3.model.Client;
import com.example.ciclo3.Reto3.repository.RepositoryClient;

@Service
public class ServiceClient {
    
    @Autowired
    private RepositoryClient repositoryClient;

    
    public List<Client> getAll() {
        return repositoryClient.getAll();
    }

    public Optional<Client> getClient(int id) {
        return repositoryClient.getClient(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return repositoryClient.save(client);
        } else {
            Optional<Client> client1 = repositoryClient.getClient(client.getIdClient());
            if (client1.isEmpty()) {
                return repositoryClient.save(client);
            } else {
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= repositoryClient.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                repositoryClient.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

  
    public boolean deleteClient(int clientId) {
        boolean flag=false;
        Optional<Client> c = repositoryClient.getClient(clientId);
        if(c.isPresent()){
            repositoryClient.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
