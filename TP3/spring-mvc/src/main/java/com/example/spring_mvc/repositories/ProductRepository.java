package com.example.spring_mvc.repositories;
import com.example.spring_mvc.entities.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
     Page<Product> findByNameContainsIgnoreCase(String keyword, Pageable pageable);
}
