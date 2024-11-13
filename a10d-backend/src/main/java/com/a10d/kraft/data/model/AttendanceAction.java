package com.a10d.kraft.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AttendanceAction {
	
	CHECK_IN("check in"),CHECK_OUT("check out");
	
	@Getter
	private String action;
	
	@Override
	public String toString() {
		return this.action;
	}

}
