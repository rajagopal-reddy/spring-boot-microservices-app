package com.rating.service;

import java.util.List;

import com.rating.model.Rating;

public interface RatingService {

	public Rating createRating(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);

	Rating updateRating(String id, Rating rating);

	void deleteRating(String id);

	
}
