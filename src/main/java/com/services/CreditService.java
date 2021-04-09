
package com.services;

import com.entities.Credit;
import com.repos.CreditRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreditService {
    @Autowired
    CreditRepos creditRepo;


    public boolean addCredit(Credit credit){
        Credit present = creditRepo.findByCreditUUID(credit.getCreditUUID());
        if (present != null) {
            return false;
        } else {
            creditRepo.save(credit);
            return true;
        }
    }

    public boolean removeCredit(Credit credit){
        Credit present = creditRepo.findByCreditUUID(credit.getCreditUUID());
        if (present != null){
            creditRepo.delete(present);
            return true;
        }
        else{
            return false;
        }
    }

}

