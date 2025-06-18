package com.tercertiempo.sistemarugby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.tercertiempo.sistemarugby.modelo.entidades")

public class SistemarugbyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemarugbyApplication.class, args);
	}

}
