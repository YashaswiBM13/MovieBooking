/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.moviebooking;

import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("App Test")
public class AppTest {
    private final PrintStream standardOutput = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Integration Test")
    public void runTest(){
        // String resourcesPath = "src/test/resources";
        List<String> arguements = new ArrayList<>(List.of("INPUT-FILE=./temp/input.txt","CINEMA-DATA=./temp/cinema.csv","SCREEN-DATA=./temp/screen.csv","SEAT-DATA=./temp/seat.csv","CUSTOMER-DATA=./temp/customer.csv","MOVIE-DATA=./temp/movie.csv","SHOW-DATA=./temp/show.csv"));
        String expectedOutput = "Movie ID - 1\n" +
                "Title - MovieA\n" +
                "Duration - 120\n" +
                "\n" +
                "Movie ID - 2\n" +
                "Title - MovieB\n" +
                "Duration - 120\n" +
                "\n" +
                "Movie ID - 3\n" +
                "Title - MovieC\n" +
                "Duration - 120\n" +
                "\n" +
                "Show ID - 1\n" +
                "Title - MovieA\n" +
                "Start - 14/10/2020 10:30\n" +
                "End - 14/10/2020 13:00\n" +
                "Cinema - CinemaA\n" +
                "Screen - SCREENA\n" +
                "\n" +
                "Show ID - 4\n" +
                "Title - MovieA\n" +
                "Start - 14/10/2020 10:30\n" +
                "End - 14/10/2020 13:00\n" +
                "Cinema - CinemaB\n" +
                "Screen - SCREENA\n" +
                "\n" +
                "Show ID - 7\n" +
                "Title - MovieA\n" +
                "Start - 14/10/2020 10:30\n" +
                "End - 14/10/2020 13:00\n" +
                "Cinema - CinemaC\n" +
                "Screen - SCREENA\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "Ticket ID - 1\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 2\n" +
                "Status - RESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 1\n" +
                "Status - RESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 3\n" +
                "Status - RESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "Cancellation Successful!\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 4\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 5\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 6\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 4\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 6\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 5\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED";

        App.run(arguements);

        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {

        System.setOut(standardOutput);

    }

}
