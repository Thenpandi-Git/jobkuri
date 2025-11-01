package com.jobkuri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.jobkuri.Entity")
@EnableJpaRepositories(basePackages = "com.jobkuri.Repository")
public class JobkuriApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobkuriApplication.class, args);
	}

}