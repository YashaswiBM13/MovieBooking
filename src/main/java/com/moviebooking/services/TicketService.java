package com.moviebooking.services;

import java.util.List;

import com.moviebooking.entities.Customer;
import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.ShowSeat;
import com.moviebooking.entities.Ticket;
import com.moviebooking.exceptions.NoSuchTicketFoundException;
import com.moviebooking.exceptions.SeatNotAvailableException;
import com.moviebooking.repositories.ICustomerRepository;
import com.moviebooking.repositories.IShowRepository;
import com.moviebooking.repositories.IShowSeatRepository;
import com.moviebooking.repositories.ITicketRepository;

public class TicketService implements ITicketService {

    private final ITicketRepository iTicketRepository;
    private final ICustomerRepository iCustomerRepository;
    private final IShowSeatRepository iShowSeatRepository;
    private final IShowRepository iShowRepository;


    public TicketService(ICustomerRepository iCustomerRepository, IShowSeatRepository iShowSeatRepository, IShowRepository iShowRepository, ITicketRepository iTicketRepository) {
        this.iCustomerRepository = iCustomerRepository;
        this.iShowSeatRepository = iShowSeatRepository;
        this.iShowRepository = iShowRepository;
        this.iTicketRepository = iTicketRepository;
    }


    @Override
    public Ticket bookTicket(String customerId, String showId, List<Seat> seatList) throws SeatNotAvailableException {
        Customer customer = iCustomerRepository.getCustomerById(customerId);
        Show show = iShowRepository.getShowById(showId);
        for(Seat seat: seatList){
            ShowSeat showSeat = iShowSeatRepository.getShowSeat(showId, seat.getId());
            if(showSeat.isLocked())
                throw new SeatNotAvailableException();
            else
                showSeat.lock();
                iShowSeatRepository.updateShowSeat(showSeat);

        }

        return iTicketRepository.saveTicket(customer, show, seatList);
           
    }

    @Override
    public void cancelTicket(Integer ticketId) throws NoSuchTicketFoundException {
        Ticket ticket = iTicketRepository.getTicketById(ticketId);
        if(ticket == null)
            throw new NoSuchTicketFoundException();
        else{
            List<Seat> seatList = ticket.getSeatList();
            for(Seat seat: seatList){
                ShowSeat showSeat = iShowSeatRepository.getShowSeat(ticket.getShowId()
                        , seat.getId());
                showSeat.unlock();
                iShowSeatRepository.updateShowSeat(showSeat);
            }
            iTicketRepository.removeTicket(ticketId);
        }

    }
    
}