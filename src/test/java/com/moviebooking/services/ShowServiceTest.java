package com.moviebooking.services;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import com.moviebooking.dto.ShowResponse;
import com.moviebooking.entities.Cinema;
import com.moviebooking.entities.Movie;
import com.moviebooking.entities.Screen;
import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.ShowSeat;
import com.moviebooking.repositories.ShowRepository;
import com.moviebooking.repositories.ShowSeatRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Show Service Test")
@ExtendWith(MockitoExtension.class)
public class ShowServiceTest {

    @Mock
    ShowRepository showRepositoryMock;

    @Mock
    ShowSeatRepository showSeatRepositoryMock;

    @InjectMocks
    ShowService showService;

    @Test
    @DisplayName("getAllShowSeats_Should Return List Of ShowSeats For Given ShowId")
    public void getAllShowSeats_ShouldReturnListOfShowSeatsFor_GivenShowId() throws ParseException{
        // Arrange

        List<ShowSeat> expectedShowSeatList = new ArrayList<>();
        expectedShowSeatList.add(new ShowSeat("SS1"
                    ,new Seat("1#1",1,1)
                    ,new Show("Show1"
                                , new SimpleDateFormat("dd/MM/yyyy").parse("06/10/2021 11:00") 
                                , new SimpleDateFormat("dd/MM/yyyy").parse("06/10/2021 13:00")
                                , new Screen("Screen1", "ScreenA")
                                , new Cinema("C1", "Cinema1")
                                , new Movie("M1", "ZNMD", 120))));

        expectedShowSeatList.add(new ShowSeat("SS2"
                    ,new Seat("4#5",4,5)
                    ,new Show("Show1"
                                , new SimpleDateFormat("dd/MM/yyyy").parse("07/10/2021 13:00")
                                , new SimpleDateFormat("dd/MM/yyyy").parse("07/10/2021 14:30")
                                , new Screen("Screen5", "ScreenE")
                                , new Cinema("C5", "Cinema5")
                                , new Movie("M5", "Dear Zindagi", 90))));


        when(showSeatRepositoryMock.getShowSeatsByShowId("Show1"))
                    .thenReturn(expectedShowSeatList);
        // Act
        List<ShowSeat> actualShowseatList = showService.getAllShowSeats("Show1");

        Assertions.assertEquals(expectedShowSeatList, actualShowseatList);
        verify(showSeatRepositoryMock).getShowSeatsByShowId("Show1");

    }

    @Test
    @DisplayName("getAllShowsByMovieTitle method Should Return ShowResponse List Given Movie Title")
    public void getAllShowsByMovieTitle_GivenMovieTitle_ShouldReturnShowResponseList() throws ParseException {
        //Arrange

        List<Show> showList = new ArrayList<>(
                List.of(
                        new Show("1",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                                new Screen("1","ScreenA"),
                                new Cinema("1","CinemaA"),
                                new Movie("1","MovieA",120)),
                        new Show("3",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 12:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 15:00"),
                                new Screen("4","ScreenA"),
                                new Cinema("2","CinemaB"),
                                new Movie("1","MovieA",120))
                        )
        );

        List<ShowResponse> actualShowResponseList = new ArrayList<>(
                List.of(
                       new ShowResponse(
                               "1",
                               "MovieA",
                               "CinemaA",
                               "ScreenA",
                               new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                               new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"))
                        ,
                        new ShowResponse(
                                "3",
                                "MovieA",
                                "CinemaB",
                                "ScreenA",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 12:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 15:00")
                        )
                )
        );

        when(showRepositoryMock.getAllShowsForMovieName("MovieA")).thenReturn(showList);

        //Act
        List<ShowResponse> expectedShowList = showService.getAllShowsByMovieTitle("MovieA");

        //Assert
        Assertions.assertEquals(expectedShowList,actualShowResponseList);

        verify(showRepositoryMock).getAllShowsForMovieName("MovieA");
    }

    @Test
    @DisplayName("getAllShowsByMovieTitle method Should Return Empty ShowResponse List If No Movies Found For Given Movie Title")
    public void getAllShowsByMovieTitle_GivenMovieTitle_ShouldReturnEmptyShowResponseListIfNoMoviesFound() throws ParseException {
        //Arrange
        List<Show> showList = new ArrayList<>();

        List<ShowResponse> actualShowResponseList = new ArrayList<>();

        when(showRepositoryMock.getAllShowsForMovieName("MovieA")).thenReturn(showList);

        //Act
        List<ShowResponse> expectedShowList = showService.getAllShowsByMovieTitle("MovieA");

        //Assert
        Assertions.assertEquals(expectedShowList,actualShowResponseList);

        verify(showRepositoryMock).getAllShowsForMovieName("MovieA");
    }


    
}