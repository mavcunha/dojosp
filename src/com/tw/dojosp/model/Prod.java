package com.tw.dojosp.model;

public class Prod {
	
	private final int id;
	private final String desc;
	private final int price;

	public Prod(int id, String desc, int price) {
		this.id = id;
		this.desc = desc;
		this.price = price;
	}
	
	public int id() {
		return this.id;
	}
	
	public String desc() {
		return this.desc;
	}
	
	public int price() {
		return this.price;
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
		Prod other = (Prod) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
