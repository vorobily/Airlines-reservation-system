package com.example.airlinesreservation.service;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airlinesreservation.login.Login;
import com.example.airlinesreservation.entity.User;
import com.example.airlinesreservation.exception.UserException;
import com.example.airlinesreservation.repo.UserRepository;

/**
 * @author dhananjay
 * 
 * UserServiceImpl will perform operations:
 * Like creating User, fetching the user by user id and validate user .
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;
	
	@Override
	public int createUser(User user) throws UserException {
		List<User> users=(List)fetchAllUsers();
		User user_temp=null;
		for(User u:users)
		{
			if(u.getUsername().equals(user.getUsername()) && (u.getEmail().equals(user.getEmail())) )
				user_temp=u;
		}
		
		if(user_temp==null) {
			userrepo.save(user);
			return user.getUserId();
		}else {
			throw new UserException("User already exist with userId " + user_temp.getUserId());
		}
	}

	@Override
	public User fetchUserById(int user_id) throws UserException {
		
		List<User> users=(List)fetchAllUsers();
		User user=null;
		for(User u:users) {
			if(u.getUserId()==user_id) {
				user=u;
			}
		}
		if(user!=null) {
			return userrepo.findById(user_id).get();
		}else {
			throw new UserException("User not found with id"+user_id);
		}
		
		
	}

	// this method authenticates user based on Login bean
	@Override
	public User validate(Login login) {
		// TODO Auto-generated method stub
		Encoder encoder=Base64.getEncoder();
		String encrypt=encoder.encodeToString(login.getPassword().getBytes());
		User user=userrepo.findByUsernameAndPassword(login.getUsername(), encrypt);
		return user;
	}
	
	@Override
	public Collection<User> fetchAllUsers() {
		List<User> users=userrepo.findAll();
		return users;
	}

}
