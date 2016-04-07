package com.beermate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeermateApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BeermateApplication.class);
		app.setWebEnvironment(true);
	    app.run(args);
	}
}