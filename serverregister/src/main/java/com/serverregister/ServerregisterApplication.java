package com.serverregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerregisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerregisterApplication.class, args);
	}

}
