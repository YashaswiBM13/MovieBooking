package com.moviebooking.repositories;

import java.util.HashMap;
import java.util.Map;

import com.moviebooking.entities.Cinema;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cinema Repository Test")
public class CinemaRepositoryTest {
    
    private CinemaRepository cinemaRepository;

    @BeforeEach
    public void setUp(){
        Map<String, Cinema> cinemaMap = new HashMap<>();
        cinemaMap.put("C1", new Cinema("C1","Cinema1"));
        cinemaMap.put("C2", new Cinema("C2","Cinema2"));
        cinemaMap.put("C3", new Cinema("C3","Cinema3"));

        cinemaRepository = new CinemaRepository(cinemaMap);
    }

    @Test
    @DisplayName("Get Cinema by Id- Should return Cinema")
    public void getCinemaById_GivenId_ShouldreturnCinema(){
        // Arrange
        Cinema expectedCinema = new Cinema("C2","Cinema2");

        // Act
        Cinema actualCinema = cinemaRepository.getCinemaById("C2");

        // Assert
        Assertions.assertEquals(expectedCinema, actualCinema);
    }

    @Test
    @DisplayName("Get Cinema by Id- Should return Null")
    public void getCinemaById_GivenId_ShouldReturnNull(){
        // Act

        Cinema actaulCinema = cinemaRepository.getCinemaById("C4");

        // Assert
        Assertions.assertNull(actaulCinema);
    }

    @Test
    @DisplayName("saveCinema_shouldSaveCinema")
    public void saveCinema_shouldSaveCinema(){
        // Arrange
        Cinema newCinema = new Cinema("C6","Cinema6");

        // Act

        cinemaRepository.saveCinema(newCinema);

        // Assert
        Assertions.assertEquals(newCinema, cinemaRepository.getCinemaById("C6"));
    }

    @Test
    @DisplayName("updateCinema_shouldUpdateCinema")
    public void updateCinema_shouldUpdateCinema(){
        // Arrange
        Cinema cinema = new Cinema("C8","Cinema8");

        // Act
        cinemaRepository.updateCinema(cinema);

        // Assert
        Assertions.assertEquals(cinema, cinemaRepository.getCinemaById("C8"));
    }
}