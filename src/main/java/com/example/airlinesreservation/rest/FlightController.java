package com.example.airlinesreservation.rest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import com.example.airlinesreservation.exception.UserException;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



import com.example.airlinesreservation.entity.Flight;
import com.example.airlinesreservation.entity.User;
import com.example.airlinesreservation.exception.FlightException;
import com.example.airlinesreservation.service.FlightService;



@CrossOrigin()
@Controller
public class FlightController {

	@Autowired
	FlightService fservice;

	@GetMapping("/")
	public String displayFlights(Model model) {
		List<Flight> flights = new ArrayList<>(fservice.fetchAll());

		// Sort the flights by flightNumber using a comparator
		flights.sort(Comparator.comparingInt(Flight::getFlightNumber));

		model.addAttribute("flights", flights);

		System.out.println("Number of flights fetched: " + flights.size());

		return "index.html"; // Return the view name "index.html"
	}

	@GetMapping("/add")
	public String showAddPage(Model model) {
		model.addAttribute("flightForm", new Flight());
		return "add.html";
	}
	@PostMapping(value = "/add")
	public String addFlight(@ModelAttribute("flightForm") Flight flight) {
		try {
			int id=fservice.addFlight(flight);
			System.out.println("Flight added successfully with flight id: " + id);
			return "redirect:/";
		} catch (FlightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error occurred: " + e.getMessage();
		}
	}

	@PostMapping(value="/remove/{fid}")
	public String removeFlight(@PathVariable int fid, HttpSession session) {

		fservice.removeFlight(fid);
		return "redirect:/";
	}
	@GetMapping("/update/{flightId}")
	public String showUpdateFlightPage(@PathVariable int flightId, Model model) {
		Flight flight = fservice.fetchById(flightId);
		model.addAttribute("flight", flight);
		return "update.html";
	}


	@PostMapping(value = "/update/{flightId}")
	public String updateFlight(@ModelAttribute("flight") Flight flight) {
		try {
			int id = fservice.updateFlight(flight);
			return "redirect:/";
		} catch (FlightException e) {
			e.printStackTrace();
			return "" + e.getMessage();
		}
	}


}