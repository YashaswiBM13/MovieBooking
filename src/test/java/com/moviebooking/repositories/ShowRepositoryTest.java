package com.moviebooking.repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moviebooking.entities.Cinema;
import com.moviebooking.entities.Movie;
import com.moviebooking.entities.Screen;
import com.moviebooking.entities.Show;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ShowRepositoryTest")
public class ShowRepositoryTest {
    private ShowRepository showRepository;

    @BeforeEach
    public void setUp() throws ParseException{
        Map<String,Show> showMap = new HashMap<>();
        
        showMap.put("S1", new Show("S1"
                , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/10/2021 14:00")
                , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/10/2021 16:00")
                , new Screen("Scrn1", "Screen1")
                , new Cinema("C1", "Cinema1")
                , new Movie("M1", "Dear Zindagi", 120)));

        showMap.put("S2", new Show("S2"
                , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("02/10/2021 15:00")
                , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("02/10/2021 17:30")
                , new Screen("Scrn2", "Screen2")
                , new Cinema("C2", "Cinema2")
                , new Movie("M1", "Dear Zindagi", 120)));

        showMap.put("S3", new Show("S3"
                , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/10/2021 11:00")
                , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/10/2021 12:30")
                , new Screen("Scrn2", "Screen2")
                , new Cinema("C1", "Cinema1")
                , new Movie("M3", "ZNMD", 90)));

        showRepository = new ShowRepository(showMap);

    }

    @Test
    @DisplayName("getAllShowsForMovieName_shouldReturnListOfShows")
    public void getAllShowsForMovieName_shouldReturnListOfShows() throws ParseException{
        // Arrange
        List<Show> expectedShowList = new ArrayList<>();
        expectedShowList.add(new Show("S1"
            , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/10/2021 14:00")
            , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/10/2021 16:00")
            , new Screen("Scrn1", "Screen1")
            , new Cinema("C1", "Cinema1")
            , new Movie("M1", "Dear Zindagi", 120)));

        expectedShowList.add(new Show("S2"
            , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("02/10/2021 15:00")
            , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("02/10/2021 17:30")
            , new Screen("Scrn2", "Screen2")
            , new Cinema("C2", "Cinema2")
            , new Movie("M1", "Dear Zindagi", 120)));

        // Act
        List<Show> actualShowList = showRepository.getAllShowsForMovieName("Dear Zindagi");

        // Assert
        Assertions.assertTrue(expectedShowList.size() == actualShowList.size()
            && expectedShowList.containsAll(actualShowList) 
            && actualShowList.containsAll(expectedShowList));
        

    }

    @Test
    @DisplayName("getAllShowsForMovieName_shouldReturnEmptyList")
    public void getAllShowsForMovieName_shouldReturnEmptyList() throws ParseException{
        

        // Act
        List<Show> actualShowList = showRepository.getAllShowsForMovieName("Dear");

        // Assert
        Assertions.assertEquals(new ArrayList<>(), actualShowList);
        

    }
    @Test
    @DisplayName("getShowById method Should Return Show Given Show Id")
    public void getShowById_GivenShowId_ShouldReturnShow() throws ParseException {
        //Arrange
        Show expectedShow = new Show("S3"
        , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/10/2021 11:00")
        , new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/10/2021 12:30")
        , new Screen("Scrn2", "Screen2")
        , new Cinema("C1", "Cinema1")
        , new Movie("M3", "ZNMD", 90));
        //Act
        Show actualShow = showRepository.getShowById("S3");
        //Assert
        Assertions.assertEquals(expectedShow,actualShow);
    }

    @Test
    @DisplayName("getShowById  method Should Return null Given Show Id If Show not found")
    public void getShowById_GivenShowId_ShouldReturnNull(){
        //Arrange
        String showId = "4";
        //Act
        Show actualShow = showRepository.getShowById(showId);
        //Assert
        Assertions.assertNull(actualShow);
    }

    @Test
    @DisplayName("saveShow method Should Save Show")
    public void saveShow_ShouldSaveShow() throws ParseException {
        //Arrange
        Show expectedShow = new Show("4",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("5","ScreenA"),
                new Cinema("2","CinemaB"),
                new Movie("1","MovieA",120));
        //Act
      showRepository.saveShow(expectedShow);

        //Assert
        Assertions.assertEquals(expectedShow, showRepository.getShowById("4"));
    }

}