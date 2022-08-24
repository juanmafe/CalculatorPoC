package com.sanitas.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

/**
 * The Class AppConfiguration.
 */
@Configuration
public class AppConfiguration {


	/**
	 * Tracer.
	 *
	 * @return the tracer impl
	 */
	@Bean
	public TracerImpl tracer() {
		return new TracerImpl();
	}
}
