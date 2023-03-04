package com.pbtms.occurrenceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.pbtms.core.model"})
@EnableJpaRepositories({"com.pbtms.core.repository"})
public class OccurrenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OccurrenceServiceApplication.class, args);
	}

}
