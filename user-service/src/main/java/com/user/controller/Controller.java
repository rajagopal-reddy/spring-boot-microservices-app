package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class Controller {
	@Autowired
	private UserService service;
	
//	private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User u=service.save(user);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(u);
	}
	
//	int retryCount=1;
	
	@GetMapping("/{id}")
//	@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
//	@RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String id){
//		logger.info("Get Single User Handler : UserController");
//		logger.info("Retry count: {}",retryCount);
//		retryCount++;
		User u=service.get(id);
		return ResponseEntity
				.ok(u);
	}
	
	
//	public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
////		logger.info("Fallback is because service is Down : ",ex.getMessage());
//		
//		User user = User.builder()
//				.email("dummy@gmail.com")
//				.name("Dummy")
//				.address("000/0,Dummy,Dummy City")
//				.userid("62521")
//				.build();	
//		return new ResponseEntity<>(user,HttpStatus.OK);
//	}
	
	
	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> allUser=service.getAll();
		return ResponseEntity.ok(allUser); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id,@RequestBody User user){
		User u=service.updete(id,user);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(u);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id) {
		service.delete(id); 
	}
	
	

}


























