package com.tw.dojosp.model;

public class User {

	private final String name;
	private final int id;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String name() {
		return this.name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}
}
