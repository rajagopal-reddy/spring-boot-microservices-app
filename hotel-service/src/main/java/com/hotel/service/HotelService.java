package com.hotel.service;

import java.util.List;

import com.hotel.model.Hotel;

public interface HotelService {

	public Hotel save(Hotel hotel);
	
	public Hotel get(String id);
	
	public List<Hotel> getAll();
	
	public Hotel updete(String id,Hotel user);
	
	public void delete(String id);
	
}
