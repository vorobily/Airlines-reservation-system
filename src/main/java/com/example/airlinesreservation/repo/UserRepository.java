package com.example.airlinesreservation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airlinesreservation.entity.Ticket;
import com.example.airlinesreservation.entity.User;

/**
 * 
 * @author Chetan
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	//Finds the User from database with matching username and password
	User findByUsernameAndPassword(String username,String pasword);
	
}
