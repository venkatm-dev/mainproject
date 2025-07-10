package com.example.mainproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
	    "com.example.mainproject",   // your main project
	    "com.example.subproject"     // the package where GreetingService is defined
	})
public class MainprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainprojectApplication.class, args);
	}

}
