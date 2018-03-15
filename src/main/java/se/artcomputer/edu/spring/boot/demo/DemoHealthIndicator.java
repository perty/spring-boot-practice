package se.artcomputer.edu.spring.boot.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DemoHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.status("Such a bad ass status").build();
    }
}
