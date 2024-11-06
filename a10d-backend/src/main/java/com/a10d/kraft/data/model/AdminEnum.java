package com.a10d.kraft.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AdminEnum {

	SUPER_ADMIN("super admin"),
	CONTACT_ADMIN("contact admin");
	
	@Getter
	private String role;
	
	@Override
	public String toString() {
		return this.role;
	}
	
	
}
