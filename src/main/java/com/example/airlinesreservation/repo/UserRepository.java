package com.example.airlinesreservation.repo;

import com.example.airlinesreservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String pasword);

}
