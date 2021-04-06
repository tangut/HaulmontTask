package com.controllers;

import com.entities.Client;
import com.repos.ClientRepos;
import com.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/clientDelete")
public class ClientDeleteController {
    @Autowired
    ClientRepos clientRepo;

    @Autowired
    ClientService clientService;

    @GetMapping("{clientUUID}")
    public String getInfo(@PathVariable String clientUUID, Model model){
        Client client = clientRepo.findByClientUUID(clientUUID);
        model.addAttribute("clients", Collections.singletonList(client));
        return "clientDelete";
    }

    @PostMapping("{clientUUID}")
    public String deleteClient(@PathVariable String clientUUID){
        Client client = clientRepo.findByClientUUID(clientUUID);
        clientService.removeClient(client);
        return "redirect:/main";
    }
}
