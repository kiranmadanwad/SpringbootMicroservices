package com.kiran.madanwad.user.service.config;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class CircuitBreakerConfiguration {

//    CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom().failureRateThreshold(50)
//            .waitDurationInOpenState(Duration.ofMillis(1000)).slidingWindowSize(2).build();
//    TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build();

    @Bean(name = "departmentcb")
    public CircuitBreaker departmentCircuitBreaker(CircuitBreakerFactory circuitBreakerFactory) {
        return circuitBreakerFactory.create("departmentcb");
    }

//    @Bean(name = "departmentCBCustomConfiguration")
//    public Customizer<Resilience4JCircuitBreakerFactory> departmentCBCustomConfiguration() {
//
//        // the circuitBreakerConfig and timeLimiterConfig objects
//
//        return factory -> factory.configure(builder -> builder.circuitBreakerConfig(circuitBreakerConfig)
//                .timeLimiterConfig(timeLimiterConfig).build(), "departmentcb");
//    }
}
