package com.example.centralizedconfigurationclient;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigDataEnvironmentPostProcessor;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		MapPropertySource propertySource = new MapPropertySource("springCloudServicesConfigImport",
				Collections.singletonMap("spring.config.import", "optional:configserver:http://localhost:8881/"));
		environment.getPropertySources().addFirst(propertySource);
	}

	@Override
	public int getOrder() {
		return ConfigDataEnvironmentPostProcessor.ORDER - 1;
	}
}
