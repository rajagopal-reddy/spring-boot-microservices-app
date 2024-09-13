package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {

	public User save(User user);
	
	public List<User> getAll();
	
	public User get(String id);
	
	public void delete(String id);
	
	public User updete(String id,User user);
	
}
