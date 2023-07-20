package com.example.airlinesreservation.service;

import java.util.List;

import com.example.airlinesreservation.entity.Booking;

public interface BookingService {
	
	int addBooking(Booking booking);
	
	Booking getBookingById(int bid);
	
	void updateBooking(Booking bookPay);
	
}
