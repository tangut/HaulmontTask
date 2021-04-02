
package com.repos;

import com.entities.Credit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CreditRepos extends CrudRepository<Credit, UUID> {
    Optional<Credit> findById(UUID Id);
    Credit findByCreditUUID(String creditUUID);
}

