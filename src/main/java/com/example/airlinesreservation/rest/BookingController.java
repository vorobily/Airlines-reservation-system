package com.example.airlinesreservation.rest;

import java.time.LocalDate;
import java.util.List;

import com.example.airlinesreservation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import com.example.airlinesreservation.entity.Booking;
import com.example.airlinesreservation.entity.Flight;
import com.example.airlinesreservation.exception.FlightException;
import com.example.airlinesreservation.service.BookingService;
import com.example.airlinesreservation.service.FlightService;



@CrossOrigin()
@Controller
public class BookingController {

	@Autowired
	private BookingService bookservice;
	
	@Autowired
	private FlightService flightservice;

	@PostMapping("/booking")
	public ResponseEntity<?> addBooking(@RequestBody Booking booking,
										@RequestParam int flightId,
										@RequestParam String source,
										@RequestParam String destination,
										@RequestParam String date) throws FlightException {

		Flight flight = flightservice.fetchById(flightId);
		if (flight.getAvailableSeats() <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seats are not available");
		} else if (booking.getNumberOfSeatsToBook() > flight.getAvailableSeats()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only " + flight.getAvailableSeats() + " seats are available");
		} else {
			flight.setAvailableSeats(flight.getAvailableSeats() - booking.getNumberOfSeatsToBook());
			flightservice.updateFlight(flight);
			booking.setFlight(flight);
			booking.setBookingDate(LocalDate.now());
			int bid = bookservice.addBooking(booking);
			return ResponseEntity.ok(bid);
		}
	}
}
