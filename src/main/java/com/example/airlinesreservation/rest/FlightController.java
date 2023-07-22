package com.example.airlinesreservation.rest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

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
		Collection<Flight> flights = fservice.fetchAll();

		model.addAttribute("flights", flights);

		System.out.println("Number of flights fetched: " + flights.size());

		return "index.html"; // Return the view name "index.html"
	}

	@PostMapping(value = "/add")
	public String addFlight(@RequestBody Flight flight, HttpSession session) {
		try {
			int id=fservice.addFlight(flight);
			return "Flight added with flight number "+id;

		} catch (FlightException e) {
			e.printStackTrace();
			return ""+e.getMessage();
		}

	}

	@PostMapping(value="/remove/{fid}")
	public String removeFlight(@PathVariable int fid, HttpSession session) {

		fservice.removeFlight(fid);
		return "redirect:/";
	}

	@PutMapping(value="/update")
	public String updateFlight(@RequestBody Flight flight, HttpSession session) {
		try {

			int id=fservice.updateFlight(flight);
			return "Flight updated with id "+id;

		} catch (FlightException e) {

			e.printStackTrace();
			return ""+e.getMessage();
		}
	}

}