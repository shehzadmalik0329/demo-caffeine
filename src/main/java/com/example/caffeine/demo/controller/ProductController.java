package com.example.caffeine.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caffeine.demo.model.Product;
import com.example.caffeine.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable Integer id){
		return productService.findProductById(id);
	}
	
	@GetMapping
	public List<Product> findAllProducts(){
		return productService.findAllProducts();
	}
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product){
		return productService.saveProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProductById(@PathVariable Integer id){
		return productService.deleteProductById(id);
	}

}
