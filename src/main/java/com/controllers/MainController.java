package com.controllers;

import com.entities.Client;
import com.repos.ClientRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    ClientRepos clientRepo;

    @GetMapping("/")
    public String main(Model model){
        Iterable<Client> clients = clientRepo.findAll();
        model.addAttribute("clients", clients);
        return "main";
    }
}
