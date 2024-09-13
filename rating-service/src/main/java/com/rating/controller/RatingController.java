package com.rating.controller;

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

import com.rating.model.Rating;
import com.rating.service.RatingService;


@RestController
@RequestMapping("rating")
public class RatingController{

	@Autowired
	private RatingService service;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating u=service.createRating(rating);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(u);
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getRatings() {
		
		return ResponseEntity.ok(service.getRatings()) ;
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		
		return ResponseEntity.ok(service.getRatingByUserId(userId));
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		
		return ResponseEntity.ok(service.getRatingByHotelId(hotelId));
	}

	@PutMapping("/{ratingId}")
	public ResponseEntity<Rating> updateRating(@PathVariable String ratingId,@RequestBody Rating rating) {
		
		return ResponseEntity.ok(service.updateRating(ratingId, rating));
	}

	@DeleteMapping("/{ratingId}")
	public void deleteRating(@PathVariable String ratingId) {
		service.deleteRating(ratingId);
		
	}
	
	


}
