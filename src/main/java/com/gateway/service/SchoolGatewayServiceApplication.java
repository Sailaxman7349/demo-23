package com.gateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SchoolGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolGatewayServiceApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("school-jpa",p -> p.path("/school/course/**").uri("lb://school-jpa"))
				.route("school-service",p -> p.path("/school/student/**").uri("lb://school-service")).build();
	}

}
