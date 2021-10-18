package com.moviebooking.command;


import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.moviebooking.exceptions.NoSuchTicketFoundException;
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

@DisplayName("CancelTicketCommandTest")
@ExtendWith(MockitoExtension.class)
public class CancelTicketCommandTest {
    private final PrintStream standardOutput = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @InjectMocks
    CancelTicketCommand cancelTicketCommand;

    @Mock
    TicketService ticketService;

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("execute_shouldShowSuccessMessage")
    public void execute_shouldShowSuccessMessage() throws NoSuchTicketFoundException{
        Integer ticketId = 1;

        cancelTicketCommand.execute(new ArrayList<>(List.of("CANCEL-TICKET",String.valueOf(ticketId))));

        String expectedMessage = "Cancellation Successful!";

        Assertions.assertEquals(expectedMessage, outputStream.toString().trim());

        verify(ticketService).cancelTicket(ticketId);
    }

    @Test
    @DisplayName("execute_shouldThrowNoSuchTicketFoundException")
    public void execute_shouldThrowNoSuchTicketFoundException() throws NoSuchTicketFoundException{
        // Arrange
        Integer ticketId = 1;
        doThrow(new NoSuchTicketFoundException()).when(ticketService).cancelTicket(ticketId);
        String expectedString = "No Such Ticket Found!";
        // Act
        cancelTicketCommand.execute(new ArrayList<>(List.of("CANCEL-TICKET",String.valueOf(ticketId))));
        // Assert
        Assertions.assertEquals(expectedString, outputStream.toString().trim());
        verify(ticketService).cancelTicket(ticketId);

    }

    @AfterEach
    public void tearDown(){
        System.setOut(standardOutput);
    }
    
}