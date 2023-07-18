package com.example.airlinesreservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airlinesreservation.entity.Ticket;
import com.example.airlinesreservation.entity.User;
import java.util.List;

/**
 * 
 * @author Chetan
 *
 */
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	//Finds the list of tickets by user 
	List<Ticket> findByUser(User user);
}
