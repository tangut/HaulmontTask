package com.repos;

import com.entities.ScheduleOfPayment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ScheduleRepos extends CrudRepository<ScheduleOfPayment, UUID> {
    Optional<ScheduleOfPayment> findById(UUID Id);
    ScheduleOfPayment findByScheduleUUID(String scheduleUUID);
}

