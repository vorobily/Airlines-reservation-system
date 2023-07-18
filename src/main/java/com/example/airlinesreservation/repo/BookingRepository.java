package com.example.airlinesreservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airlinesreservation.entity.Booking;

/**
 * 
 * @author Chetan
 *
 */
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
