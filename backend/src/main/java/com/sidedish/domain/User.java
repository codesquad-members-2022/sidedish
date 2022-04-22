package com.sidedish.domain;

public class User {
	private Long id;
	private String address;
	private String name;

	public User(Long id, String address, String name) {
		this.id = id;
		this.address = address;
		this.name = name;
	}

	public class Builder {
		private Long id;
		private String address;
		private String name;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public User build() {
			return new User(id, address, name);
		}
	}
}
