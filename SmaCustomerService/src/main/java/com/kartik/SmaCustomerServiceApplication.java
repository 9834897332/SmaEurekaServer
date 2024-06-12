package com.kartik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
 
@SpringBootApplication
@EnableDiscoveryClient
public class SmaCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmaCustomerServiceApplication.class, args);
	}

}
