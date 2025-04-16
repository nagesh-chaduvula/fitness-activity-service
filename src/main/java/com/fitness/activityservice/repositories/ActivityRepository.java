package com.fitness.activityservice.repositories;

import com.fitness.activityservice.entities.ActivityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<ActivityEntity, String> {
    List<ActivityEntity> findByUserId(String userId);
}
