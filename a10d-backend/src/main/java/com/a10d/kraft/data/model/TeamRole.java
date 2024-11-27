package com.a10d.kraft.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TeamRole {

	MANAGER("manager"),
	LEADRE("leader"),
	MEMBER("member");
	
	@Getter
	private String role;
	
	@Override
	public String toString() {
		return role;
	}
}
