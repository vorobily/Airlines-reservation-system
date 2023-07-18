package com.example.airlinesreservation.service;

import java.util.Collection;

import com.example.airlinesreservation.login.Login;
import com.example.airlinesreservation.entity.User;
import com.example.airlinesreservation.exception.UserException;

public interface UserService {
	
	 int createUser(User user) throws UserException;
	
	 User fetchUserById(int user_id) throws UserException;
	 
	 User validate(Login login);
	
	 public Collection<User> fetchAllUsers();
	
}
