package com.moviebooking.entities;

import org.junit.jupiter.api.*;

@DisplayName("CinemaTest")
public class CinemaTest {

    @Test
    @DisplayName("getScreenByName_givenScreenName_shouldReturnScreen")
    public void getScreenByName_givenScreenName_shouldReturnScreen(){
        // Arrange
        Cinema cinema = new Cinema("1", "CinemaA");

        cinema.addScreen(new Screen("S1","ScreenA"));
        cinema.addScreen(new Screen("S2", "ScreenB"));
        cinema.addScreen(new Screen("S3", "ScreenC"));

        
        Screen expectedScreen = new Screen("S2","ScreenB");

        // Act
        Screen screen = cinema.getScreenByName("ScreenB");

        // Assert
        Assertions.assertEquals(expectedScreen, screen, "Fetching Screen by Screen Name from Cinema");


    }

    @Test
    @DisplayName("getScreenByName_GivenScreenNotPresentInCinema_shouldReturnNull")
    public void getScreenByName_GivenScreenNotPresentInCinema_shouldReturnNull() {
        // Arrange
        Cinema cinema = new Cinema("1","CinemaB");
        cinema.addScreen(new Screen("S1","ScreenA"));
        cinema.addScreen(new Screen("S2","ScreenB"));
        cinema.addScreen(new Screen("S3","ScreenC"));

        // Act
        Screen actualScreen = cinema.getScreenByName("ScreenD");

        // Assert
        Assertions.assertNull(actualScreen,"Checking for null value");
    }
    
}