package com.moviebooking.repositories;

import java.util.List;

import com.moviebooking.entities.Customer;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.Ticket;
import com.moviebooking.entities.Seat;

public interface ITicketRepository {
    public Ticket getTicketById(Integer id);
    public Ticket saveTicket(Customer customer, Show show, List<Seat> seatList);
    public void removeTicket(Integer id);
    
}