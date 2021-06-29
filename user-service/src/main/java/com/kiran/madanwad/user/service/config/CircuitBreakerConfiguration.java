package com.kiran.madanwad.user.service.config;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerConfiguration {

    @Bean(name = "departmentcb")
    public CircuitBreaker departmentCircuitBreaker(CircuitBreakerFactory circuitBreakerFactory) {
        return circuitBreakerFactory.create("departmentcb");
    }

}
