package com.livevox.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PBHealthIndicator implements HealthIndicator {
	private final String message_key = "Phone Book Application";

	@Override
	public Health health() {
		if (!isPBRunning()) {
			return Health.down().withDetail(message_key, " is  undergoing Maintenance. Please try after sometime !!").build();
		}
		return Health.up().withDetail(message_key, " is healthy").build();
	}

	private Boolean isPBRunning() {
		Boolean areAllComponentsRunning = true;
	 
		return areAllComponentsRunning;
	}
}
