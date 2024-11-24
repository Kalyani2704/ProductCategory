package com.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductCategoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductCategoryApplication.class, args);
		System.out.println("Hello i am spring boot application");
	}
}
