package com.integrationninjas.springbootexample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Environment environment;

    @Autowired
    public TestController(Environment environment) {
        this.environment = environment;
    }

	@GetMapping
	public Object hello() {
		Map<String, String> object = new HashMap<>();
		object.put("name", environment.getProperty("example.api.name", "Integration Ninjas"));
		object.put("email", environment.getProperty("example.api.email", "integrationninjas@gmail.com"));
		return object;
	}

}
