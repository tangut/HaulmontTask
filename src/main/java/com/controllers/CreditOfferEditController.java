package com.controllers;

import com.entities.CreditOffer;
import com.repos.ClientRepos;
import com.repos.CreditOfferRepos;
import com.repos.CreditRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/creditOfferEdit")
public class CreditOfferEditController {
    @Autowired
    CreditOfferRepos creditOfferRepo;

    @Autowired
    CreditRepos creditRepo;

    @Autowired
    ClientRepos clientRepo;

    @GetMapping("{offerUUID}")
    public String getInfo(@PathVariable String offerUUID, Model model){
        CreditOffer creditOffer = creditOfferRepo.findByOfferUUID(offerUUID);
        model.addAttribute("creditOffers", Collections.singletonList(creditOffer));
        return "creditOfferEdit";
    }

    @PostMapping("{offerUUID}")
    public String editCreditOffer(@PathVariable String offerUUID, @RequestParam String nameClient,
                                  @RequestParam String nameCredit, @RequestParam String summCredit){

        return "redirect:/creditOffersList";
    }
}
