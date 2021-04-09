package com.controllers;

import com.entities.Credit;
import com.repos.CreditRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/creditEdit")
public class CreditEditorController {
    @Autowired
    CreditRepos creditRepo;

    @GetMapping("{creditUUID}")
    public String getInfo(@PathVariable String creditUUID, Model model){
        Credit credit = creditRepo.findByCreditUUID(creditUUID);
        model.addAttribute("credits", Collections.singletonList(credit));
        return "creditEdit";
    }

    @PostMapping("{creditUUID}")
    public String editCredit(@PathVariable String creditUUID, @RequestParam String name, @RequestParam String limit, @RequestParam String percent){
        Credit credit = creditRepo.findByCreditUUID(creditUUID);
        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(limit) && !StringUtils.isEmpty(percent)){
            credit.setCreditName(name);
            credit.setLimit(Long.valueOf(limit));
            credit.setLimit(Integer.valueOf(percent));
            creditRepo.save(credit);
        }
        return "redirect:/creditList";
    }
}
