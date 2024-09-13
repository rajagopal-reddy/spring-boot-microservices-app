package com.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.model.Rating;

@SpringBootTest
class UserApplicationTests {

	
	@Test
	void contextLoads() {
	}

//	@Autowired
//	private RatingService ratingService;
//	
//	@Test
//	void createRating() {
//		Rating rating = Rating.builder()
//				.ratingId("502")
//				.rating(10)
//				.userId("")
//				.hotelId("")
//				.feedback("This is created using feing client")
//				.build();
//		
//		Rating saveRating = ratingService.createRating(rating);
//		
//		System.out.println("new Rating created ! !");
//	}
}
