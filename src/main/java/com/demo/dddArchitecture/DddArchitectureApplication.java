package com.demo.dddArchitecture;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
@EnableFeignClients
public class DddArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddArchitectureApplication.class, args);
		log.info("CustomerApplication Started........");
	}



}
