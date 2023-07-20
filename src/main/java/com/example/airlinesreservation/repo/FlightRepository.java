package com.example.airlinesreservation.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.airlinesreservation.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

}