package com.controllers;

import com.entities.Client;
import com.repos.ClientRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/clientEdit")
public class ClientEditorController {
    @Autowired
    ClientRepos clientRepo;

    @GetMapping("{clientUUID}")
    public String getInfo(@PathVariable String clientUUID, Model model){
        Client client =clientRepo.findByClientUUID(clientUUID);
        model.addAttribute("clients", Collections.singletonList(client));
        return "clientEdit";
    }

    @PostMapping("{clientUUID}")
    public String editClient(@PathVariable String clientUUID, @RequestParam String name, @RequestParam String phoneNumber,
                             @RequestParam String email, @RequestParam String passportNumber){
        Client client = clientRepo.findByClientUUID(clientUUID);
        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(phoneNumber) && !StringUtils.isEmpty(email)
                & !StringUtils.isEmpty(passportNumber)){
            client.setName(name);
            client.setEmail(email);
            client.setPassportNumber(passportNumber);
            client.setPhoneNumber(phoneNumber);
        }
        clientRepo.save(client);
        return "redirect:/main";
    }

}
