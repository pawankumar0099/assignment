package com.nagarro.productcommunityapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productcommunityapi.entity.Product;
import com.nagarro.productcommunityapi.repository.ProductRepo;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductRepo productRepo;
		
	@GetMapping("/product/{data}")
	public List<Product> getProducts(@PathVariable(name = "data") String data){
		String a[];
		a=data.split(" ");
		if(a.length==1)
		return productRepo.search(data);
		
		return productRepo.search(a[0],a[1]);
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable(name="id") Long id) {
		return productRepo.getById(id);
	}
	
	@PostMapping("/product")
	public void addProduct(@RequestBody Product product)
	{
		productRepo.save(product);
	}
	
	@GetMapping("totalproducts")
	public int getTotalProducts() {
		return productRepo.getTotalProducts();
	}
}
