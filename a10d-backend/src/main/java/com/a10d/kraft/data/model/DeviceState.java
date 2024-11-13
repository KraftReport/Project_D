package com.a10d.kraft.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DeviceState {

	PENDING("pending"),
	APPROVED("approved"),
	INACTIVE("inactive");
	
	@Getter
	private String state;
	
	@Override
	public String toString() {
		return this.state;
	}
}
