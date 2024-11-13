package com.a10d.kraft.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum LocationType {

	OFFICE("office"),
	CLIENT("client"),
	HOME("home"),
	OTHER("other");
	
	@Getter
	private String type;
	
	@Override
	public String toString() {
		return this.type;
	}
}
