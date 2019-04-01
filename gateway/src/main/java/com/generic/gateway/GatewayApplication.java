package com.generic.gateway;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.generic.gateway.filter.AccessTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableZuulProxy
//@Configuration
//@EnableApolloConfig
@SpringBootApplication(scanBasePackages ="com.generic")
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	public AccessTokenFilter accessFilter() {
		return new AccessTokenFilter();
	}
}
