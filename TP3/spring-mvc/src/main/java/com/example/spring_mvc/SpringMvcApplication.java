package com.example.spring_mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.spring_mvc.entities.Product;
import com.example.spring_mvc.repositories.ProductRepository;

//@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	// Données de test
    @Bean
    CommandLineRunner initData(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
            repo.save(new Product(null, "Ordinateur Dell", 12500.0, 10));
            repo.save(new Product(null, "Imprimante HP", 3200.0, 5));
            repo.save(new Product(null, "Clavier Mécanique", 450.0, 30));
            repo.save(new Product(null, "Souris Logitech", 180.0, 50));
            repo.save(new Product(null, "Ecran Samsung 24\"", 4200.0, 15));
            repo.save(new Product(null, "Webcam HD", 650.0, 20));
            repo.save(new Product(null, "Casque Audio", 890.0, 12));
            repo.save(new Product(null, "Disque SSD 1To", 1200.0, 25));
        }
        };
    }

}
