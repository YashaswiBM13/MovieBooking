package com.moviebooking.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ShowSeatTest")
public class ShowSeatTest {
    private Show show;
    private Seat seat;

    @BeforeEach
    public void setUp() throws ParseException{
        show = new Show("Show1", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("28/09/2021 15:00"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("28/09/2021 17:00"),
                new Screen("S1", "ScreenA"),
                new Cinema("C1", "Inox"),
                new Movie("M1", "K3G", 120));

        seat = new Seat("1#1",1,1);
    }

    @Test
    @DisplayName("lock_shouldLockTheSeat")
    public void lock_shouldLockTheSeat(){
        // Arrange
        ShowSeat showSeat = new ShowSeat("SS1", seat, show);

        // Act
        showSeat.lock();
        // ShowSeatStatus status = showSeat.getShowSeatStatus();

        // Assertions
        // Assertions.assertEquals(ShowSeatStatus.RESERVED,status);
        // OR
        Assertions.assertTrue(showSeat.isLocked());

    }

    @Test
    @DisplayName("unlock_shouldunlockSeat")
    public void unlock_shouldunlockSeat(){
        // Arrange
        ShowSeat showSeat = new ShowSeat("SS2", seat, show);

        // Act
        showSeat.lock();
        showSeat.unlock();
        // ShowSeatStatus status = showSeat.getShowSeatStatus();

        // Assertions
        // Assertions.assertEquals(ShowSeatStatus.UNRESERVED, status);
        // OR
        Assertions.assertFalse(showSeat.isLocked());
    }
}