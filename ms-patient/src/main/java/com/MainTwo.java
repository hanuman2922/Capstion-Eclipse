package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MainTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainTwo.class,args);
	}
	//create a bean (Write outside the main method)
			@Bean	
			@LoadBalanced
			RestTemplate restTemplate() {
				return new RestTemplate();
			}

}
