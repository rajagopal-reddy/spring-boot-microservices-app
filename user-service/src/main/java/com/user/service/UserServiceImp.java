package com.user.service;

import java.util.List;
import com.user.exception.ResourceNotFoundException;
import com.user.model.User;
import com.user.reop.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImp  implements UserService {

	@Autowired
	private Repo repo;

//	@Autowired
//	private RestTemplate restTemplate;
//	
//	@Autowired
//	private HotelService hotelService;
	
//	private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
	
	@Override
	public User save(User user) {
		//String randomUserId=UUID.randomUUID().toString();
		//user.setId(randomUserId);
		return repo.save(user);
	}

	@Override
	public List<User> getAll() {
		return repo.findAll();
	}

	
	@Override
	public User get(String userId) {
	    User user = repo.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User with the given id is not found on this server: " + userId));

//	    Rating[] ratingsOfUser = restTemplate.getForObject("http://Rating/rating/users/" + user.getUserid(), Rating[].class);
//	    logger.info("{}", ratingsOfUser);
//
//	    List<Rating> ratings = Arrays.asList(ratingsOfUser);
//
//	    List<Rating> ratingList = ratings.stream()
//	            .map(rating -> {
////	                ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://Hotel/hotel/" + rating.getHotelId(), Hotel.class);
//	                Hotel hotel = hotelService.getHotel(rating.getHotelId());
////	                logger.info("Response entity code: {}", forEntity.getStatusCode());
//	                rating.setHotel(hotel);
//	                return rating;
//	            }).collect(Collectors.toList());
//
//	    user.setRatings(ratingList);

	    return user;
	}



	@Override
	public void delete(String id) {
		repo.deleteById(id);
	}

	@Override
	public User updete(String id,User user) {
		 User h = repo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found on this server !!"));
	        h.setName(user.getName());
	        h.setEmail(user.getEmail()); 
	        h.setAddress(user.getAddress()); 
	        return repo.save(h);
	}


	

}
