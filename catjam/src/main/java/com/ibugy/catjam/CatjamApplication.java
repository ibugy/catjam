package com.ibugy.catjam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CatjamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatjamApplication.class, args);
	}
}
