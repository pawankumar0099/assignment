package com.nagarro.productcommunityapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.productcommunityapi.entity.UserAuth;
import com.nagarro.productcommunityapi.repository.UserAuthRepo;

@Component
public class UserAuthService {

	@Autowired
	UserAuthRepo userAuthRepo;
	
	public boolean isUserExist(String email) {
			
			UserAuth user= userAuthRepo.getByEmail(email);
			if(user==null)
				return false;
			return true;
	}
}
