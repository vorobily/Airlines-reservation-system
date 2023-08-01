package com.example.airlinesreservation.service;

import com.example.airlinesreservation.entity.Flight;
import com.example.airlinesreservation.exception.FlightException;

import java.time.LocalDate;
import java.util.Collection;

public interface FlightService {

    int addFlight(Flight flight) throws FlightException;

    Collection<Flight> fetchAll();

    Flight fetchFlight(String source, String destination, LocalDate scheduleDate)
            throws FlightException;

    int updateFlight(Flight flight) throws FlightException;

    void removeFlight(int flightNumber);

    Flight fetchById(int fid);
}