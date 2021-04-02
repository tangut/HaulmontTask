package com.services;

import com.entities.Client;
import com.repos.ClientRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepos clientRepo;

    public boolean addClient(Client client){
        Client present = clientRepo.findByClientUUID(client.getClientUUID());
        if (present != null) {
            return false;
        } else {
            clientRepo.save(client);
            return true;
        }
    }

    public boolean removeClient(Client client){
        Client present = clientRepo.findByClientUUID(client.getClientUUID());
        if (present != null){
            clientRepo.delete(present);
            return true;
        }
        else{
            return false;
        }
    }
}

