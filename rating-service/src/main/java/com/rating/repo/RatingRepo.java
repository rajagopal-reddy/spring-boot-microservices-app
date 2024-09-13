package com.rating.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.model.Rating;
import java.util.List;


@Repository
public interface RatingRepo extends JpaRepository<Rating, String> {

	List<Rating> findByUserId(String userid);

	List<Rating> findByHotelId(String hotelId);


}
