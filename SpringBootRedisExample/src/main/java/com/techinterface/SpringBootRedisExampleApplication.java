package com.techinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootRedisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisExampleApplication.class, args);
	}

}
