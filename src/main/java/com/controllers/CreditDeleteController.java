package com.controllers;

import com.entities.Credit;
import com.repos.CreditRepos;
import com.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/creditDelete")
public class CreditDeleteController {
    @Autowired
    CreditRepos creditRepo;

    @Autowired
    CreditService creditService;

    @GetMapping("{creditUUID}")
    public String getInfo(@PathVariable String creditUUID, Model model){
        Credit credit = creditRepo.findByCreditUUID(creditUUID);
        model.addAttribute("credits", Collections.singletonList(credit));
        return "creditDelete";
    }

    @PostMapping("{creditUUID}")
    public String deleteClient(@PathVariable String creditUUID){
        Credit credit = creditRepo.findByCreditUUID(creditUUID);
        creditService.removeCredit(credit);
        return "redirect:/creditList";
    }
}
