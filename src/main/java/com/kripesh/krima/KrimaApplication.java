package com.kripesh.krima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class KrimaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(KrimaApplication.class);
		springApplication.run(args);
	}

	protected SpringApplicationBuilder config(SpringApplicationBuilder builder){
		return builder.sources(KrimaApplication.class);
	}
}
