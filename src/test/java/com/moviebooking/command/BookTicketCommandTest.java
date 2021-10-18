package com.moviebooking.command;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Ticket;
import com.moviebooking.exceptions.SeatNotAvailableException;
import com.moviebooking.services.TicketService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Book Ticket Command Test")
@ExtendWith(MockitoExtension.class)
public class BookTicketCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Mock
    TicketService ticketService;

    @Mock
    Ticket ticket;

    @InjectMocks
    BookTicketCommand bookTicketCommand;

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("executeBookTicketCommand_shouldReturnBookedTicket")
    public void executeBookTicketCommand_shouldReturnBookedTicket() throws SeatNotAvailableException{
        // Arrange
        String customerId = "Customer1";
        String showId = "show1";
        Seat seat1_2 = new Seat("1#2",1,2);
        Seat seat1_3 = new Seat("1#3",1,3);
        List<Seat> seatList = new ArrayList<>(List.of(seat1_2,seat1_3));

        
        when(ticketService.bookTicket(customerId, showId, seatList)).thenReturn(ticket);
        when(ticket.getId()).thenReturn(1);

        String expectedoutput = "Ticket ID - 1";
      

        // Act
        bookTicketCommand.execute(new ArrayList<>(List.of("BOOK-TICKET"
                                                    , customerId
                                                    , showId
                                                    , seat1_2.getId()
                                                    , seat1_3.getId())));

        // Assert
        Assertions.assertEquals(expectedoutput, outputStream.toString().trim());

        verify(ticketService).bookTicket(customerId, showId, seatList);
        
        
    }
    @Test
    @DisplayName("execute method Should Print Error Message to Console")
    public void execute_ShouldPrintErrorMessage() throws SeatNotAvailableException {
        //Arrange
        String customerId = "1";
        String showId = "1";
        Seat seat1_2 = new Seat("1#2",1,2);
        Seat seat1_3 = new Seat("1#3",1,3);
        List<Seat> seatList = new ArrayList<>(List.of(seat1_2,seat1_3));

        when(ticketService.bookTicket(customerId,showId,seatList)).thenThrow(new SeatNotAvailableException());

        String expectedOutput = "Some Seats are already Booked! Please try booking available seats!";

        //Act
        bookTicketCommand.execute(new ArrayList<>(List.of("BOOK-TICKET",customerId,showId,seat1_2.getId(),seat1_3.getId())));

        //Assert
        Assertions.assertEquals(expectedOutput,outputStream.toString().trim());

        verify(ticketService).bookTicket(customerId,showId,seatList);

    }


    @AfterEach
    public void tearDown(){
        System.setOut(standardOut);
    }
}