package com.example.airlinesreservation.entity;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingId;

	@Column(name = "seats")
	private int numberOfSeatsToBook;

	private LocalDate bookingDate;

	@OneToOne
	@JoinColumn(name = "flight_number")
	private Flight flight;


	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getNumberOfSeatsToBook() {
		return numberOfSeatsToBook;
	}

	public void setNumberOfSeatsToBook(int numberOfSeatsToBook) {
		this.numberOfSeatsToBook = numberOfSeatsToBook;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
}