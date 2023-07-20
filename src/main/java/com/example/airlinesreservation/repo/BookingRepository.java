package com.example.airlinesreservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airlinesreservation.entity.Booking;


public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
