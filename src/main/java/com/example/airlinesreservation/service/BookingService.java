package com.example.airlinesreservation.service;

import java.util.List;

import com.example.airlinesreservation.entity.Booking;
import com.example.airlinesreservation.entity.Passenger;
import com.example.airlinesreservation.entity.Ticket;

public interface BookingService {
	
	int addBooking(Booking booking);
	
	int addPassenger(Passenger passenger, int bookingId);
	
	Ticket generateTicket(Ticket ticket, int userId, int bookingId);
	
	List<Ticket> getTicket(int uid);
	
	Booking getBookingById(int bid);
	
	void updateBooking(Booking bookPay);
	
}
