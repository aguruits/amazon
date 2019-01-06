package com.amazon.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AmaznonRegistrationServer {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "registration-server");
		
		SpringApplication.run(AmaznonRegistrationServer.class, args);
	}
}
