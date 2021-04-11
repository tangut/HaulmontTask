package com.services;

import com.entities.CreditOffer;
import com.repos.ClientRepos;
import com.repos.CreditOfferRepos;
import com.repos.CreditRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditOfferService {


    @Autowired
    CreditOfferRepos creditOfferRepo;

    public boolean addCreditOffer(CreditOffer creditOffer){
        CreditOffer present = creditOfferRepo.findByOfferUUID(creditOffer.getOfferUUID());
        if (present == null){
            creditOfferRepo.save(creditOffer);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeCreditOffer(CreditOffer creditOffer){
        CreditOffer present = creditOfferRepo.findByOfferUUID(creditOffer.getOfferUUID());
        if (present != null){
            creditOfferRepo.delete(creditOffer);
            return true;
        }
        else{
            return false;
        }
    }
}
