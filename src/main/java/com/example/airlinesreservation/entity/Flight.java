package com.example.airlinesreservation.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightNumber;
	private String source;
	private String destination;
	@Column(name = "travel_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate travelDate;
	@Column(name = "arrival_time")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime arrivalTime;
	@Column(name = "departure_time")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime departureTime;
	private double price;
	private int availableSeats;


	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


}
