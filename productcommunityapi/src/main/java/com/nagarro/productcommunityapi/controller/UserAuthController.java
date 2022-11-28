package com.nagarro.productcommunityapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productcommunityapi.entity.UserAuth;
import com.nagarro.productcommunityapi.model.Login;
import com.nagarro.productcommunityapi.model.Token;
import com.nagarro.productcommunityapi.repository.UserAuthRepo;
import com.nagarro.productcommunityapi.service.UserAuthService;

@RestController
@CrossOrigin("*")
public class UserAuthController {
		
	@Autowired 
	UserAuthRepo userAuthRepo;
	
	@Autowired
	UserAuthService userAuthService;
	
	@PostMapping("/user")
	public void addUser(@RequestBody UserAuth userAuth) throws Exception
	{
		if(userAuthService.isUserExist(userAuth.getEmail()))
		{
			throw new Exception("user already exist");
		}
		else
		userAuthRepo.save(userAuth);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login)
	{
		UserAuth userAuth=userAuthRepo.getByEmail(login.getEmail());
		
		if(userAuth!=null && userAuth.getPassword().equals(login.getPassword()))
		{
			return ResponseEntity.ok(new Token("qwertyuiopasdfghjkzxcvbnm",userAuth.getFirstName(),userAuth.getRole()));
		}
		
		return null;
	}
	
	@GetMapping("/registerusers")
	public int getRegisterUser() {
		return userAuthRepo.getRegisterUser();
	}
	
}
