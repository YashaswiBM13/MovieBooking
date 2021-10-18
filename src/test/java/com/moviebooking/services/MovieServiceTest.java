package com.moviebooking.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.moviebooking.entities.Movie;

import com.moviebooking.repositories.MovieRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Movie Service Test")
@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    MovieRepository movieRepositoryMock;

    @InjectMocks
    MovieService movieService;

    @Test
    @DisplayName("getAllMovies Should Return List Of Movies")
    public void getAllMovies_ShouldReturnListOfMovies(){
        // arrange
        List<Movie> expectedMovieList = new ArrayList<>();
        expectedMovieList.add(new Movie("M1", "Dear Zindagi", 120));
        expectedMovieList.add(new Movie("M2","Dil Dhadakne Do", 150));
        expectedMovieList.add(new Movie("M3", "ZNMD", 135));

        when(movieRepositoryMock.getAllMovies()).thenReturn(expectedMovieList);

        // Act
        List<Movie> actaulMovieList = movieService.getAllMovies();

        // Assert
        Assertions.assertEquals(expectedMovieList,actaulMovieList);
        Mockito.verify(movieRepositoryMock).getAllMovies();
    }

    @Test
    @DisplayName("getAllMovies_Should Return Empty List If No Movies")
    public void getAllMovies_ShouldReturnEmptyListIfNoMovies(){

        Mockito.when(movieRepositoryMock.getAllMovies()).thenReturn(null);

        List<Movie> actaulMovieList = movieService.getAllMovies();

        Assertions.assertNull(actaulMovieList);
        Mockito.verify(movieRepositoryMock).getAllMovies();
    }
    
}