package com.example.airlinesreservation.repo;

import com.example.airlinesreservation.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}