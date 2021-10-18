package com.moviebooking.services;

import java.util.List;

import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Ticket;
import com.moviebooking.exceptions.NoSuchTicketFoundException;
import com.moviebooking.exceptions.SeatNotAvailableException;

public interface ITicketService {
    public Ticket bookTicket(String customerId, String showId, List<Seat> seatList) throws SeatNotAvailableException;
    public void cancelTicket(Integer ticketId) throws NoSuchTicketFoundException;
    
}