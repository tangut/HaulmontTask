package com.repos;

import com.entities.CreditOffer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CreditOfferRepos extends CrudRepository<CreditOffer, UUID> {
    CreditOffer findByOfferUUID(String offerUUID);
}
