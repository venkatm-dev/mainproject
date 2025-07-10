package com.example.mainproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.subproject.dto.UserDTO;
import com.example.subproject.service.GreetingService;

@RestController
@RequestMapping("/api")
public class GreetingController {
	
	@Autowired
	  private GreetingService greetingService;
	
	@GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return greetingService.greet(name);
    }
	
	@PostMapping("/submit")
	public String submit(@RequestBody UserDTO userDTO) {
	    return "Name: " + userDTO.getName();
	}
	

}
