package com.example.airlinesreservation.repo;

import com.example.airlinesreservation.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
