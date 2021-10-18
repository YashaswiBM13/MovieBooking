package com.moviebooking.services;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.moviebooking.entities.Cinema;
import com.moviebooking.entities.Customer;
import com.moviebooking.entities.Movie;
import com.moviebooking.entities.Screen;
import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.ShowSeat;
import com.moviebooking.entities.Ticket;
import com.moviebooking.exceptions.NoSuchTicketFoundException;
import com.moviebooking.exceptions.SeatNotAvailableException;
import com.moviebooking.repositories.CustomerRepository;
import com.moviebooking.repositories.ShowRepository;
import com.moviebooking.repositories.ShowSeatRepository;
import com.moviebooking.repositories.TicketRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Ticket Service Test")
@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {
    private Customer customer;
    private Show show;
    private ShowSeat showSeat1_1_2;
    private ShowSeat showSeat1_1_3;
    private Seat seat1_2;
    private Seat seat1_3;

    @InjectMocks
    TicketService ticketService;

    @Mock
    TicketRepository ticketRepository;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    ShowSeatRepository showSeatRepository;
    @Mock
    ShowRepository showRepository;

    @BeforeEach
    void setup() throws ParseException {
        customer = new Customer("1", "CustomerA", "customerA@gmail.com");
        show = new Show("1", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"), new Screen("1", "ScreenA"),
                new Cinema("1", "CinemaA"), new Movie("1", "MovieA", 120));
        showSeat1_1_2 = new ShowSeat("1#1#2", new Seat("1#2", 1, 2), show);
        showSeat1_1_3 = new ShowSeat("1#1#3", new Seat("1#3", 1, 3), show);
        seat1_2 = new Seat("1#2", 1, 2);
        seat1_3 = new Seat("1#3", 1, 3);

    }

    @Test
    @DisplayName("bookTicket_Should Return Ticket_Given The Details")
    public void bookTicket_ShouldReturnTicket_GivenTheDetails() throws SeatNotAvailableException {
        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );

        Ticket expectedTicket = new Ticket(1,customer,show,seatList);

        when(customerRepository.getCustomerById("1")).thenReturn(customer);
        when(showRepository.getShowById("1")).thenReturn(show);
        when(showSeatRepository.getShowSeat(anyString(),anyString())).thenReturn(showSeat1_1_2,showSeat1_1_3,showSeat1_1_2,showSeat1_1_3);
        when(ticketRepository.saveTicket(customer,show,seatList)).thenReturn(new Ticket(1,customer,show,seatList));

        //Act
        Ticket actualTicket = ticketService.bookTicket("1","1",seatList);

        //Assert
        Assertions.assertEquals(expectedTicket,actualTicket);

    }
    @Test
    @DisplayName("bookTicket method should Throw Exception If Seat is Already Booked")
    public void bookTicket_ShouldThrowExceptionIfSeatAlreadyBooked() throws SeatNotAvailableException {
        //Arrange
        showSeat1_1_2.lock();

        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );

        when(customerRepository.getCustomerById("1")).thenReturn(customer);
        when(showRepository.getShowById("1")).thenReturn(show);
        when(showSeatRepository.getShowSeat(anyString(),anyString())).thenReturn(showSeat1_1_2,showSeat1_1_3,showSeat1_1_2,showSeat1_1_3);

        //Act and Assert
        Assertions.assertThrows(SeatNotAvailableException.class,()-> ticketService.bookTicket("1", "1", seatList));

    }
    @Test
    @DisplayName("cancelTicket method should Cancel Ticket Given Ticket Id")
    public void cancelTicket_GivenTicketId_ShouldCancelTicket() throws NoSuchTicketFoundException {
        //Arrange
        showSeat1_1_2.lock();
        showSeat1_1_3.lock();

        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );

        Ticket ticket = new Ticket(1,customer,show,seatList);

        when(ticketRepository.getTicketById(1)).thenReturn(ticket);
        when(showSeatRepository.getShowSeat("1","1#2")).thenReturn(showSeat1_1_2);
        when(showSeatRepository.getShowSeat("1","1#3")).thenReturn(showSeat1_1_3);

        //Act
        ticketService.cancelTicket(1);

        //Assert
        showSeat1_1_2.unlock();
        verify(showSeatRepository).updateShowSeat(showSeat1_1_2);
        showSeat1_1_3.unlock();
        verify(showSeatRepository).updateShowSeat(showSeat1_1_3);
        verify(ticketRepository).removeTicket(1);

    }

    @Test
    @DisplayName("cancelTicket method should Throw Exception If No Ticket Found Given Ticket Id")
    public void cancelTicket_GivenTicketId_ShouldShouldThrowExceptionIfNoTicketFound() throws NoSuchTicketFoundException {
        //Arrange
        when(ticketRepository.getTicketById(1)).thenReturn(null);

        //Act and Assert
        Assertions.assertThrows(NoSuchTicketFoundException.class,()->ticketService.cancelTicket(1));

        verify(ticketRepository).getTicketById(1);

    }



    
}