package com.farmacia.farmacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EntityScan(basePackages = "com.farmacia.farmacia.Models")
@SpringBootApplication
public class FarmaciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmaciaApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
