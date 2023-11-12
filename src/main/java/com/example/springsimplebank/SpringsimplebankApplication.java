package com.example.springsimplebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringsimplebankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsimplebankApplication.class, args);
	}

}
