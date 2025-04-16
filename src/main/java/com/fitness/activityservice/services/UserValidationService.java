package com.fitness.activityservice.services;

public interface UserValidationService {

    /**
     * Validates if a user exists by their ID.
     *
     * @param userId the ID of the user to validate
     * @return true if the user exists, false otherwise
     */
    Boolean validateUserId(String userId);

}
