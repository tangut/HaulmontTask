package com.repos;

import com.entities.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface BankRepos extends CrudRepository<Bank, UUID> {
    Optional<Bank> findById(UUID Id);
    Bank findByBankUUID(String  bankUUID);
}

