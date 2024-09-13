package com.rating.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException () {
		super("Rating not found on this Server ! !");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
