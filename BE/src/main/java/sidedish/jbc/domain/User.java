package sidedish.jbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class User {

	@Id
	private Integer id;

	private String address;
	private String name;
	private int point;

	@PersistenceConstructor
	public User(Integer id, String address, String name, int point) {
		this.id = id;
		this.address = address;
		this.name = name;
		this.point = point;
	}

	public Integer getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public int getPoint() {
		return point;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", address='" + address + '\'' +
			", name='" + name + '\'' +
			", point=" + point +
			'}';
	}
}
