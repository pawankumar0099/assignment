package com.nagarro.productcommunityapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@CrossOrigin("*")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "identity")
	@GenericGenerator(name = "identity",strategy = "native")
	private long id;
	
	private String reviewBy;
	
	private float rating;
	
	private String heading;
	
	@ManyToOne
	private Product product;
	
	private String review;
	
	@Column(name = "verified", columnDefinition = "bit default 0")
	private Boolean verified;
	
	public Review() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReviewBy() {
		return reviewBy;
	}

	public void setReviewBy(String reviewBy) {
		this.reviewBy = reviewBy;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewBy=" + reviewBy + ", rating=" + rating + ", heading=" + heading
				+ ", product=" + product + ", review=" + review + ", verified=" + verified + "]";
	}
	
}
