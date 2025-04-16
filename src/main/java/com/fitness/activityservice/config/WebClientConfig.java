package com.fitness.activityservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Slf4j
public class WebClientConfig {

     @Bean
     @LoadBalanced
     public WebClient.Builder webClientBuilder() {
         log.info("Creating WebClient.Builder bean");

         return WebClient.builder();
     }

     @Bean
     public WebClient userServiceWebClient(WebClient.Builder webClientBuilder) {
         log.info("Creating WebClient bean for User Service");

         return webClientBuilder
                 .baseUrl("http://FITNESS-USER-SERVICE")
                 .build();
     }
}
