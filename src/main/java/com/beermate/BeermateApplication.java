package com.beermate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BeermateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeermateApplication.class, args);
	}
}

@RestController
class HomeRestController {
	
	@RequestMapping("/home")
	public String home() {
		return "Hello World! From Spring Boot!";
	}
}