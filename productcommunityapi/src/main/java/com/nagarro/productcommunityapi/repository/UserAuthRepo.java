package com.nagarro.productcommunityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.productcommunityapi.entity.UserAuth;
public interface UserAuthRepo extends JpaRepository<UserAuth, String> {
			
		public UserAuth getByEmail(String email);
		
		@Query("select count(email) from UserAuth where role='user'")
		public int getRegisterUser();
}
