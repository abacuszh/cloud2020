package org.aiguigu.customlbrules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class CustomRule {
	
	@Bean
	public IRule CustomZoneAvoidanceRule() {
		return new com.netflix.loadbalancer.RandomRule();
	}

}
