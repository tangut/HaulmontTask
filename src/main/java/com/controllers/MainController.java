package com.controllers;

import com.entities.Client;
import com.repos.ClientRepos;
import com.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class MainController {

    @Autowired
    ClientRepos clientRepo;

    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public String greetings(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Model model){
        Iterable<Client> clients = clientRepo.findAll();
        model.addAttribute("clients", clients);
        return "main";
    }

    @PostMapping("/main")
    public String addClient(@RequestParam String name, @RequestParam String phoneNumber, @RequestParam String email,
                            @RequestParam String passportNumber, Map<String, Object> model){
        Client client = new Client(name, phoneNumber, email, passportNumber);
        clientService.addClient(client);
        return "redirect:/main";
    }
}
