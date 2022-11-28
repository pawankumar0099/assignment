package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class for ORM
 **/
@Entity
public class TShirt {
	@Id
	private String id;
	private String name;
	private String color;
	private String gender;
	private String size;
	private float price;
	private float rating;
	private String availablity;

	public TShirt() {
	};

	/**
	 * @param id
	 * @param name
	 * @param color
	 * @param gender
	 * @param size
	 * @param price
	 * @param rating
	 * @param availablity
	 */
	public TShirt(String id, String name, String color, String gender, String size, float price, float rating,
			String availablity) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availablity = availablity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getAblty() {
		return availablity;
	}

	public void setAblty(String ablty) {
		this.availablity = ablty;
	}

	@Override
	public String toString() {
		return "TShirt [id=" + id + ", name=" + name + ", color=" + color + ", gender=" + gender + ", size=" + size
				+ ", price=" + price + ", rating=" + rating + ", availablity=" + availablity + "]";
	}

}
