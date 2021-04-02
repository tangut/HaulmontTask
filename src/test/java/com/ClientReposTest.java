package com;

import com.entities.Client;
import com.repos.ClientRepos;
import com.services.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientReposTest {
    @Autowired
    ClientRepos clientRepo;
    @Autowired
    ClientService clientService;

    @Test
    public void ClientSaveAndDelete(){
        Client client = new Client("Aaron", "8888432423", "tan@gmail.com", "134567");
        clientService.addClient(client);
        Client clientFromRepo = clientRepo.findByClientUUID(client.getClientUUID());
        Assert.assertEquals(client, clientFromRepo);
        boolean flagDelete = clientService.removeClient(client);
        Client client1 = clientRepo.findByClientUUID(client.getClientUUID());
        Assert.assertEquals(true, flagDelete);
        Assert.assertEquals(client1, null);
    }
}
