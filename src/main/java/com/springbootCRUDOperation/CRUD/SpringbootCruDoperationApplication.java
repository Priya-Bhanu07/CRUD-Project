package com.springbootCRUDOperation.CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.springbootCRUDOperation.CRUD.model") // Make sure the correct package is included here

public class SpringbootCruDoperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCruDoperationApplication.class, args);
	}

}
