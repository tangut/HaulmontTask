package com.controllers;

import com.entities.Credit;
import com.repos.CreditRepos;
import com.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreditController {
    @Autowired
    CreditRepos creditRepo;

    @Autowired
    CreditService creditService;

    @GetMapping("/creditList")
    public String creditList(Model model){
        Iterable<Credit> credits = creditRepo.findAll();
        model.addAttribute("credits", credits);
        return "creditList";
    }

    @PostMapping("/creditList")
    public String addCredit(Model model, @RequestParam String name, @RequestParam String limit, @RequestParam String percent){
        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(limit) && !StringUtils.isEmpty(percent)){
            Credit credit = new Credit(Long.valueOf(limit), Integer.valueOf(percent), name);
            creditService.addCredit(credit);
        }
        return "redirect:/creditList";
    }
}
