package com.projectsujan.moviereview.enums;

public enum UserRole {
	
	ADMIN("ROLE_ADMIN"), EDITOR("ROLE_EDITOR"), USER("ROLE_USER");
	String value;


	UserRole(String value) {
		this.value = value;
	}
	

	static UserRole getByValue(String userType) {
		for (UserRole ug : UserRole.values()) {
			if (ug.value.equals(userType)) {
				return ug;
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
