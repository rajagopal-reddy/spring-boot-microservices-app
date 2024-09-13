package com.hotel.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotel.model.Hotel;
import com.hotel.model.Rating;
import com.hotel.model.User;
import com.hotel.repo.HotelRepo;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.external.service.UserService;

@Service
public class HotelServiceImp implements HotelService {

	@Autowired
	private HotelRepo repo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(HotelServiceImp.class);
	
	@Override
	public Hotel save(Hotel hotel) {
//		String randomUserId=UUID.randomUUID().toString();
//		hotel.setId(randomUserId);
		return repo.save(hotel);
	}

	@Override
	public Hotel get(String id) {
		
		Hotel hotel =  repo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Hotel with given id is ot found on thid server ! ! "+ id));
		
	    Rating[] ratingsOfUser = restTemplate.getForObject("http://Rating/rating/hotels/"+ hotel.getId(), Rating[].class);
	    logger.info("{}", ratingsOfUser);

	    List<Rating> ratings = Arrays.asList(ratingsOfUser);

	    List<Rating> ratingList = ratings.stream()
	            .map(rating -> {
	                User user = userService.getUser(rating.getUserId());
	                rating.setUser(user);
	                return rating;
	            }).collect(Collectors.toList());

	    hotel.setRatings(ratingList);
		return hotel;
		}

	@Override
	public List<Hotel> getAll() {
		return repo.findAll();
	}

	@Override
	public Hotel updete(String id, Hotel hotel) {
		 Hotel h = repo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found on this server !!"));
	        h.setName(hotel.getName());
	        h.setLocation(hotel.getLocation());
	        h.setAbout(hotel.getAbout());
	        return repo.save(h);
	}

	@Override
	public void delete(String id) {
		repo.deleteById(id);
	}

}
