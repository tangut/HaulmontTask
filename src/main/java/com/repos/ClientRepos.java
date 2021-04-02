package com.repos;

import com.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClientRepos extends CrudRepository<Client, UUID> {
    Client findByClientUUID(String clientUUID);
    Client findByName(String name);
}

