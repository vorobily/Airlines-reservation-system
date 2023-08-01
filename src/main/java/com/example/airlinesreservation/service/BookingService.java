package com.example.airlinesreservation.service;

import com.example.airlinesreservation.entity.Booking;

public interface BookingService {

    int addBooking(Booking booking);

    Booking getBookingById(int bid);

    void updateBooking(Booking bookPay);

}
