package com.generic.theme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.generic")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages ="com.generic")
public class ThemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThemeApplication.class, args);
	}

}
