package com.example.backenduser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BackenduserApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackenduserApplication.class, args);
	}

}
