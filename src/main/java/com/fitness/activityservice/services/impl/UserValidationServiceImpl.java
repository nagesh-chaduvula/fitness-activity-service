package com.fitness.activityservice.services.impl;

import com.fitness.activityservice.services.UserValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationServiceImpl implements UserValidationService {

    private final WebClient userServiceWebClient;

    @Override
    public Boolean validateUserId(String userId) {
        log.info("***** Validating user ID: {}", userId);
        try {
            return userServiceWebClient.get()
                    .uri("/api/v1/user/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

        } catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("User Not Found with ID: " + userId);
            } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new RuntimeException("Invalid Request: " + e.getResponseBodyAsString());
            }
        }

        return false;
    }
}
