package com.projectsujan.moviereview.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7075983357663950479L;
	String resourceName;
	String fieldName;
	Long fielValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Long fielValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fielValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fielValue = fielValue;
	}

}
