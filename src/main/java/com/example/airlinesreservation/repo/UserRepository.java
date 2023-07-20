package com.example.airlinesreservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airlinesreservation.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String username,String pasword);
	
}
