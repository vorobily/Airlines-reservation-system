package com.example.airlinesreservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airlinesreservation.entity.Passenger;

/**
 * @author Chetan
 * 
 */
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
