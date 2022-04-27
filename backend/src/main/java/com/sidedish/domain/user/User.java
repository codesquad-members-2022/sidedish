package com.sidedish.domain.user;

public class User {
	private Long id;
	private String address;
	private String name;

	public User(Long id, String address, String name) {
		this.id = id;
		this.address = address;
		this.name = name;
	}
}
