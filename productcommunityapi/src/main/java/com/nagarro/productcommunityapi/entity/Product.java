package com.nagarro.productcommunityapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@CrossOrigin("*")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "identity")
	@GenericGenerator(name = "identity",strategy = "native")
	private long id;
	
	@Column(unique = true)
	private String code;
	
	private String name;
	
	private String brand;
	
	private String imageURL;
	
	private float price;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Review> review;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", imageURL=" + imageURL
				+ ", price=" + price + "]";
	}
	
	
	
	

}
