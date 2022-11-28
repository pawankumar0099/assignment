package com.nagarro.productcommunityapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productcommunityapi.entity.Review;
import com.nagarro.productcommunityapi.model.Rating;
import com.nagarro.productcommunityapi.repository.ReviewRepo;

@RestController
@CrossOrigin("*")
public class ReviewController {

	@Autowired
	ReviewRepo reviewRepo;
	@PostMapping("/review")
	public void addReview(@RequestBody Review review) {
		System.out.println(review);
		reviewRepo.save(review);
	}
	
	@GetMapping("productreview/{id}")
	public List<Review> getVerifiedReviewByProductId(@PathVariable(name = "id") Long id){
		return reviewRepo.getVerifiedReviewByProductId(id);
	}
	
	
	@GetMapping("/review/{id}")
	public Rating getRatingSumAndReviewCountByProductId(@PathVariable(name = "id") Long id){
		
		String t=reviewRepo.getRatingSumAndReviewCountByProductId(id);
		String temp[]=t.split(",");
		
		Rating rating=new Rating(temp[0],temp[1]);
		
		return rating;
	}
	
	@PutMapping("/approve/{id}")
	public void approve(@PathVariable(name="id") Long id)
	{
		reviewRepo.approveReview(id);
	}
	
	@PutMapping("/reject/{id}")
	public void rejectReview(@PathVariable(name="id") Long id) {
		reviewRepo.rejectReview(id);
	}
	
	@GetMapping("newreview")
	public List<Review> newReview(){
		
		return reviewRepo.getNewReview();
	}
	
	@GetMapping("/totalreview")
	public int getTotalReview() {
		return reviewRepo.getTotalReview();
	}
}


