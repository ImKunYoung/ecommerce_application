package com.example.msuserservice.outer.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4JConfiguration {
    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(4) // 4% 이상 실패하면 circuit breaker가 열린다. (default: 50%)
                .waitDurationInOpenState(Duration.ofSeconds(5)) // 5초 동안 circuit breaker가 열려있다가 닫힌다. (default: 60초)
                .slidingWindowSize(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED.ordinal()) // sliding window size (default: 100)
                .slidingWindowSize(2) // 2개의 요청을 보고 failure rate를 계산한다. (default: 100)
                .build();

        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(3)) // 3초 이상 응답이 없으면 timeout
                .build();

        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .timeLimiterConfig(timeLimiterConfig)
                .circuitBreakerConfig(circuitBreakerConfig)
                .build());
        /*TODO: -p117*/
    }
}
