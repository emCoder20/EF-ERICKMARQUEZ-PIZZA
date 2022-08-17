package com.idat.EFERICKMARQUEZPIZZA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EfErickmarquezPizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfErickmarquezPizzaApplication.class, args);
	}

}
