package com.example.caffeine.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.caffeine.demo.model.Product;
import com.example.caffeine.demo.repository.ProductRepository;
@Service
@CacheConfig(cacheNames= {"Product"})
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Cacheable(key="#id")
	public Product findProductById(Integer id){
		System.out.println("Getting data from DB");
		return productRepository.findById(id).get();
	}

	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
//	@CachePut(key="#prodcut.id")
	public Product saveProduct(Product product){
		productRepository.save(product);
		return product;
	}
	@CacheEvict(key="#id")
	public String deleteProductById(Integer id){
		System.out.println("Remove Product data from cache");
		productRepository.deleteById(id);
		return "Product Deleted!!!";
	}

}
