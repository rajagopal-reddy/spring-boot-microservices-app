package com.hotel.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hotel.model.User;

@FeignClient(name = "User",url = "http://localhost:2034")
public interface UserService {
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") String id);
  
}
