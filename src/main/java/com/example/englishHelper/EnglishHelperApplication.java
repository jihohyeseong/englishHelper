package com.example.englishHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EnglishHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishHelperApplication.class, args);
	}

}
