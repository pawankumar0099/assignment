package com.nagarro.dao;

public interface UserAuthenticationDao {

	boolean ValidateUser(String username, String password);

	boolean isUserExist(String username);

	void updatePassword(String Username, String username);

}
