package com.controllers;

import com.entities.Client;
import com.entities.Credit;
import com.entities.CreditOffer;
import com.repos.ClientRepos;
import com.repos.CreditOfferRepos;
import com.repos.CreditRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreditOfferListController {
    @Autowired
    CreditOfferRepos creditOfferRepo;


    @Autowired
    ClientRepos clientRepo;

    @Autowired
    CreditRepos creditRepo;

    @GetMapping("/creditOffersList")
    public String getList(Model model){
        Iterable<CreditOffer> creditOffers = creditOfferRepo.findAll();
        model.addAttribute("creditOffers", creditOffers);
        return "creditOffersList";
    }

    @PostMapping("/creditOffersList")
    public String addCreditOffer(@RequestParam String nameClient, @RequestParam String nameCredit,
                                 @RequestParam String sumCredit){
        if (!StringUtils.isEmpty(nameClient) && !StringUtils.isEmpty(nameCredit) && !StringUtils.isEmpty(sumCredit)){
            Client client = clientRepo.findByName(nameClient);
            Credit credit = creditRepo.findByCreditName(nameCredit);
            CreditOffer creditOffer = new CreditOffer(client, credit, Long.valueOf(sumCredit));
            creditOfferRepo.save(creditOffer);
        }
        return "redirect:/creditOffersList";
    }
}
