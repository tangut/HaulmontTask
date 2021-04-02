package com.repos;

import com.entities.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ScheduleRepos extends CrudRepository<Schedule, UUID> {
    Optional<Schedule> findById(UUID Id);
    Schedule findByScheduleUUID(String scheduleUUID);
}

