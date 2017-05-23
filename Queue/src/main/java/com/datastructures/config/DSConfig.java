package com.datastructures.config;

import java.util.Stack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Leela
 * Configuration class for all the spring beans.
 *
 */
@Configuration
public class DSConfig {

	@Bean
	public Stack<Integer> stack() {
		return new Stack<>();
	}
}
