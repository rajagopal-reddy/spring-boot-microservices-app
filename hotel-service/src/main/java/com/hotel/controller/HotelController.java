package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Hotel;
import com.hotel.service.HotelServiceImp;

@RestController
@RequestMapping("hotel")
public class HotelController {
	@Autowired
	private HotelServiceImp service;
	
	@PostMapping
	public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel){
		Hotel h=service.save(hotel);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(h);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id){
		Hotel h=service.get(id);
		return ResponseEntity
				.ok(h);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel() {
		List<Hotel> allUser=service.getAll();
		return ResponseEntity.ok(allUser); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable String id,@RequestBody Hotel hotel){
		Hotel h=service.updete(id,hotel);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(h);
	}
	
	@DeleteMapping("/{id}")
	public void deleteHotel(@PathVariable String id) {
		service.delete(id); 
	}

}
