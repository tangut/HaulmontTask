package com.controllers;

import com.entities.CreditOffer;
import com.repos.CreditOfferRepos;
import com.services.CreditOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/creditOfferDelete")
public class CreditOfferDeleteController {

    @Autowired
    CreditOfferRepos creditOfferRepo;

    @Autowired
    CreditOfferService creditOfferService;

    @GetMapping("{offerUUID}")
    public String getInfo(Model model, @PathVariable String offerUUID){
        CreditOffer creditOffer = creditOfferRepo.findByOfferUUID(offerUUID);
        model.addAttribute("creditOffers", Collections.singletonList(creditOffer));
        return "creditOfferDelete";
    }

    @PostMapping("{offerUUID}")
    public String removeOffer(@PathVariable String offerUUID){
        CreditOffer creditOffer = creditOfferRepo.findByOfferUUID(offerUUID);
        creditOfferService.removeCreditOffer(creditOffer);
        return "redirect:/creditOffersList";
    }

}
