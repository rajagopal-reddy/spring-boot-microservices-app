package com.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.exception.ResourceNotFoundException;
import com.rating.model.Rating;
import com.rating.repo.RatingRepo;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	private RatingRepo repo;
	
	@Override
	public Rating createRating(Rating rating) {
//		String randomUserId=UUID.randomUUID().toString();
//		hotel.setId(randomUserId);
		return repo.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return repo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return repo.findByHotelId(hotelId);
	}
	
	@Override
	public List<Rating> getRatings() {
		return repo.findAll();
	}

	@Override
	public Rating updateRating(String id, Rating rating) {
		Rating h = repo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Rating not found on this server !!"));
	        h.setUserId(rating.getUserId());
	        h.setHotelId(rating.getHotelId());
	        h.setRating(rating.getRating());
	        h.setFeedback(rating.getFeedback());
	        return repo.save(h);
	}

	@Override
	public void deleteRating(String id) {
		repo.deleteById(id);
	}

	

	

}
