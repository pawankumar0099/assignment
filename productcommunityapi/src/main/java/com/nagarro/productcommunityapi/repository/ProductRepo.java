package com.nagarro.productcommunityapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.productcommunityapi.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	@Query("FROM Product WHERE brand like %?1% or name like %?1% or code like %?1%")
	  List<Product> search(String s);
	
	@Query("FROM Product WHERE brand like %?1% and name like %?2% or name like %?1% and brand like %?2%")
	  List<Product> search(String s,String t);

	Product getById(Long id);
	
	@Query("select count(id) from Product")
	public int getTotalProducts();
	
}
