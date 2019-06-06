package com.mugen.doughservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DoughServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoughServiceApplication.class, args);
	}

}
