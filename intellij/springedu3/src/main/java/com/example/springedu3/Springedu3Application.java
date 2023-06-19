package com.example.springedu3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.springedu3.repository"})
@EntityScan(basePackages = {"com.example.springedu3.entity"})
public class Springedu3Application {
	public static void main(String[] args) {
		SpringApplication.run(Springedu3Application.class, args);
	}
}
