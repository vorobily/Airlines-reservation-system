package com.example.airlinesreservation.service;

import com.example.airlinesreservation.entity.Booking;
import com.example.airlinesreservation.repo.BookingRepository;
import com.example.airlinesreservation.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private UserRepository urepo;

    @Autowired
    private BookingRepository brepo;


    @Override
    public int addBooking(Booking booking) {
        brepo.save(booking);
        return booking.getBookingId();
    }


    @Override
    public void updateBooking(Booking bookPay) {
        brepo.save(bookPay);
    }

    @Override
    public Booking getBookingById(int bid) {

        return brepo.findById(bid).get();
    }

}