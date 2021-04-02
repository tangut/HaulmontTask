package com.services;

import com.entities.Bank;
import com.repos.BankRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    BankRepos bankRepo;

    public boolean addBank(Bank bank){
        Bank present = bankRepo.findByBankUUID(bank.getBankUUID());
        if (present != null){
            return false;
        }
        else{
            bankRepo.save(bank);
            return true;
        }
    }

    public boolean removeBank(Bank bank){
        Bank present = bankRepo.findByBankUUID(bank.getBankUUID());
        if (present != null){
            bankRepo.delete(present);
            return true;
        }
        else{
            return false;
        }
    }
}
