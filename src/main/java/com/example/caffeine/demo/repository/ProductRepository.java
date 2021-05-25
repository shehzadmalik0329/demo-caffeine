package com.example.caffeine.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.caffeine.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
