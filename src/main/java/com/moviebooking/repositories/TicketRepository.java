package com.moviebooking.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moviebooking.entities.Customer;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.Ticket;
import com.moviebooking.entities.Seat;


public class TicketRepository implements ITicketRepository {

    private static Integer counter = 0;
    private final Map<Integer,Ticket> ticketMap;

    public TicketRepository(){
        ticketMap = new HashMap<>();
    }
    public TicketRepository(Map<Integer,Ticket> ticketMap){
        this.ticketMap = ticketMap;
    }

    @Override
    public Ticket getTicketById(Integer id) {
        return ticketMap.get(id);
    }

    @Override
    public Ticket saveTicket(Customer customer, Show show, List<Seat> seatList) {
        // TODO Auto-generated method stub
        counter++;
        Ticket ticket = new Ticket(counter, customer, show, seatList);
        ticketMap.put(counter, ticket);
        return ticket;
    }

    @Override
    public void removeTicket(Integer id) {
        ticketMap.remove(id);

    }
    
}