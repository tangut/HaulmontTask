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
        if (!StringUtils.isEmpty(nameClient) && !StringUtils.isEmpty(nameCredit) && !StringUtils.isEmpty(summCredit)){
            CreditOffer creditOffer = creditOfferRepo.findByOfferUUID(offerUUID);
            Client client = clientRepo.findByName(nameClient);
            Credit credit = creditRepo.findByCreditName(nameCredit);
            if (client == null || credit == null){
                return "redirect:/error";
            }
            StringBuffer strb = new StringBuffer();
            for (int i = 0; i < summCredit.length(); i++){
                if (summCredit.charAt(i) != 160){
                    strb.append(summCredit.charAt(i));
                }
            }
            Long valueOfSumm = Long.valueOf(strb.toString());
            creditOffer.setCredit(credit);
            creditOffer.setClient(client);
            creditOffer.setSummCredit(valueOfSumm);
            creditOfferRepo.save(creditOffer);
        }
        return "redirect:/creditOffersList";
    }
}
