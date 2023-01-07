package com.example.simpleservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class SimpleservletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleservletApplication.class, args);
	}

}
