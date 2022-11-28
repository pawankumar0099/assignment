package com.nagarro.productcommunityapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.productcommunityapi.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {

	@Query("Select sum(rating),count(id) FROM Review WHERE product.id =?1 and verified=1")
	public String getRatingSumAndReviewCountByProductId(Long id);

	@Query("from Review where product.id=?1 and verified=1")
	public List<Review> getVerifiedReviewByProductId(Long id);

	@Query("from Review where verified=0")
	public List<Review> getNewReview();
	
	@Query("select count(id) from Review")
	public int getTotalReview();

	@Transactional
	@Modifying
	@Query("update Review set verified=true where id=?1")
	public void approveReview(Long id);

	@Transactional
	@Modifying
	@Query("update Review set verified=2 where id=?1")
	public void rejectReview(Long id);
	


}
