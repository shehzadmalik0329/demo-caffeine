package com.example.caffeine.demo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;

@Configuration
public class CaffeineConfiguration {
//	initialCapacity
//	maximumSize
//	maximumWeight
//	expireAfterAccess
//	expireAfterWrite
//	refreshAfterWrite
//	weakKeys
//	weakValues
//	softValues
//	recordStats
	@Bean
	public CacheManager cacheManager(){
		String specAsString = "initialCapacity=100,maximumSize=500,expireAfterAccess=5m,recordStats";
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setAllowNullValues(false);
		cacheManager.setCacheSpecification(specAsString);
//		cacheManger.setCaffeineSpec(caffeineSpec());
//		cacheManager.setCaffeine(caffeineCacheBuilder());
		return cacheManager;
	}
	
	CaffeineSpec caffeineSpec(){
		return CaffeineSpec.parse("initialCapacity=100,maximumSize=500,expireAfterAccess=5m,recordStats");
	}
	
	Caffeine<Object, Object> caffeineCacheBuilder(){
		return Caffeine.newBuilder()
				.initialCapacity(100)
				.maximumSize(150)
				.expireAfterAccess(5, TimeUnit.MINUTES)
				.weakKeys()
				.removalListener((key, value, cause) -> 
				System.out.format("removal listener called with key [%s], cause [%s], evicted [%S] \n",
						key, cause.toString(), cause.wasEvicted()))
				.recordStats();
	}

}
