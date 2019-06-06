package com.mugen.pizzaservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PizzaServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaServiceDiscoveryApplication.class, args);
	}

}
