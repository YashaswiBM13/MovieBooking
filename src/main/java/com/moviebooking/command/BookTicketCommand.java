package com.moviebooking.command;

import java.util.ArrayList;
import java.util.List;

import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Ticket;
import com.moviebooking.exceptions.SeatNotAvailableException;
import com.moviebooking.services.ITicketService;

public class BookTicketCommand implements ICommand{
    private final ITicketService iTicketService;

    public BookTicketCommand(ITicketService iTicketService){
        this.iTicketService = iTicketService;
    }

	@Override
	public void execute(List<String> tokens) {
        String customerId = tokens.get(1);
        String showId  =tokens.get(2);
        List<Seat> seatList = new ArrayList<>();
        for(int i = 3; i < tokens.size(); i++){
            String[] lanes = tokens.get(i).split("#");
            Seat seat = new Seat(tokens.get(i), Integer.parseInt(lanes[0]), Integer.parseInt(lanes[1]));
            seatList.add(seat);
        }
        try{
            Ticket bookedTicket = iTicketService.bookTicket(customerId, showId, seatList);
            System.out.println("Ticket ID - "+bookedTicket.getId());
            System.out.println();
        }
        catch(SeatNotAvailableException e){
            System.out.println(e);
        }
		
	}

    
    
}