package com.example.airlinesreservation.rest;

import java.time.LocalDate;

import com.example.airlinesreservation.entity.Booking;
import com.example.airlinesreservation.entity.Flight;
import com.example.airlinesreservation.exception.FlightException;
import com.example.airlinesreservation.service.BookingService;
import com.example.airlinesreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookservice;

	@Autowired
	private FlightService flightservice;

	@GetMapping("/booking")
	public String showBookingPage(Model model, @RequestParam(required = false) int flightId,
								  @RequestParam String source,
								  @RequestParam String destination,
								  @RequestParam String date) {

		Flight flight = flightservice.fetchById(flightId);

		// Create a Booking object with pre-filled flight information
		Booking booking = new Booking();
		booking.setFlight(flight);
		// Set other default values for the booking if needed

		// Add the booking object to the model
		model.addAttribute("booking", booking);

		return "booking"; // Assuming your booking.html is in the "templates" directory
	}

	@PostMapping("/booking")
	public String addBooking(@ModelAttribute("booking") Booking booking,
							 @RequestParam int flightId,
							 String source,
							 String destination,
							 String date, Model model) throws FlightException {

		Flight flight = flightservice.fetchById(flightId);
		if (flight.getAvailableSeats() <= 0) {
			model.addAttribute("message", "Seats are not available");
			return "Seats are not available";
		} else if (booking.getNumberOfSeatsToBook() > flight.getAvailableSeats()) {
			model.addAttribute("message", "Only " + flight.getAvailableSeats() + " seats are available");
			return "Only "+flight.getAvailableSeats()+" are Available";
		} else {
			flight.setAvailableSeats(flight.getAvailableSeats() - booking.getNumberOfSeatsToBook());
			flightservice.updateFlight(flight);
			booking.setFlight(flight);
			booking.setBookingDate(LocalDate.now());
			int bid = bookservice.addBooking(booking);
			model.addAttribute("bookingId", bid);
			return "redirect:/";
		}
	}
}
