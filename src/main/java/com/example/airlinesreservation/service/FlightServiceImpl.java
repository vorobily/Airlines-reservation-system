package com.example.airlinesreservation.service;

import com.example.airlinesreservation.entity.Flight;
import com.example.airlinesreservation.exception.FlightException;
import com.example.airlinesreservation.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Repository
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository frepo;

    @Transactional
    public int addFlight(Flight flight) throws FlightException {
        // TODO Auto-generated method stub
        List<Flight> flights = (List) fetchAll();
        Flight flight_temp = null;
        for (Flight f : flights) {
            if (f.getSource().equals(flight.getSource()) && f.getDestination().equals(flight.getDestination())
                    && f.getTravelDate().equals(flight.getTravelDate()) && f.getArrivalTime().equals(flight.getArrivalTime())
                    && f.getDepartureTime().equals(flight.getDepartureTime())) {
                flight_temp = f;
            }
        }
        if (flight_temp == null) {
            frepo.save(flight);
            return flight.getFlightNumber();
        } else {
            throw new FlightException("Flight already exists with flight number " + flight_temp.getFlightNumber());
        }
    }

    @Override
    public Collection<Flight> fetchAll() {
        List<Flight> flights = frepo.findAll();
        return flights;
    }

    @Override
    public Flight fetchFlight(String source, String destination, LocalDate scheduleDate) throws FlightException {
        // TODO Auto-generated method stub
        System.out.println(source + " " + destination + " " + scheduleDate);
        List<Flight> flights = (List) fetchAll();
        Flight flight = null;
        for (Flight f : flights) {
            if ((f.getSource().equals(source) && f.getDestination().equals(destination)) && f.getTravelDate().equals(scheduleDate)) {
                flight = f;
            }
        }

        if (flight != null) {
            return flight;
        } else {
            throw new FlightException("Flight not found with provided details");
        }

    }

    @Transactional
    public int updateFlight(Flight flight) throws FlightException {

        List<Flight> flights = (List) fetchAll();
        Flight flight1 = null;
        for (Flight f : flights) {
            if (f.getFlightNumber() == flight.getFlightNumber()) {
                flight1 = f;
            }
        }

        if (flight1 != null) {
            flight1.setFlightNumber(flight.getFlightNumber());
            flight1.setArrivalTime(flight.getArrivalTime());
            flight1.setAvailableSeats(flight.getAvailableSeats());
            flight1.setDepartureTime(flight.getDepartureTime());
            flight1.setDestination(flight.getDestination());
            flight1.setSource(flight.getSource());
            flight1.setPrice(flight.getPrice());
            flight1.setTravelDate(flight.getTravelDate());
            frepo.save(flight1);
            return flight.getFlightNumber();
        } else {
            throw new FlightException("Flight not found with id " + flight.getFlightNumber());
        }


    }

    @Transactional
    @Override
    public void removeFlight(int flightNumber) {
        // TODO Auto-generated method stub
        frepo.deleteById(flightNumber);
        System.out.println("Deleted flight");
    }

    @Override
    public Flight fetchById(int fid) {
        Flight flight = frepo.findById(fid).get();
        return flight;
    }

}