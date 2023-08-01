package com.example.airlinesreservation.rest;

import com.example.airlinesreservation.entity.Booking;
import com.example.airlinesreservation.entity.Flight;
import com.example.airlinesreservation.exception.FlightException;
import com.example.airlinesreservation.service.BookingService;
import com.example.airlinesreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;


@Controller
public class BookingController {

    @Autowired
    private BookingService bookservice;

    @Autowired
    private FlightService flightservice;

    @GetMapping("/booking/{flightId}")
    public String showBookingPage(Model model, @PathVariable int flightId) {

        Flight flight = flightservice.fetchById(flightId);

        Booking booking = new Booking();
        booking.setFlight(flight);

        model.addAttribute("booking", booking);

        return "booking";
    }

    @PostMapping("/booking/{flightId}")
    public String addBooking(@ModelAttribute("booking") Booking booking, @PathVariable int flightId, Model model) throws FlightException {

        Flight flight = flightservice.fetchById(flightId);

        if (flight.getAvailableSeats() <= 0) {
            model.addAttribute("message", "Seats are not available");
            return "Seats are not available";
        } else if (booking.getNumberOfSeatsToBook() > flight.getAvailableSeats()) {
            model.addAttribute("message", "Only " + flight.getAvailableSeats() + " seats are available");
            return "Only " + flight.getAvailableSeats() + " are Available";
        } else {
            booking.setFlight(flight);
            booking.setBookingDate(LocalDate.now());
            int bid = bookservice.addBooking(booking);
            model.addAttribute("bookingId", bid);
            flight.setAvailableSeats(flight.getAvailableSeats() - booking.getNumberOfSeatsToBook());
            flightservice.updateFlight(flight);
            return "redirect:/";
        }
    }
}
