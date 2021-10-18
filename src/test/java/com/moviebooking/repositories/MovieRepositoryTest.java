package com.moviebooking.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moviebooking.entities.Movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MovieRepositoryTest")
public class MovieRepositoryTest {
    private MovieRepository movieRepository;

    @BeforeEach
    public void setUp(){
        // Map<String, Movie> movieMap = new HashMap<>();
        // movieMap.put("M1",new Movie("M1","K3G",180));
        // movieMap.put("M2",new Movie("M2","Dear Zindagi",130));
        // movieMap.put("M3",new Movie("M3","Little Things",250));

        // movieRepository = new MovieRepository(movieMap);
        Map<String, Movie> movieMap = new HashMap<>();
        movieMap.put("1",new Movie("1","MovieA",90));
        movieMap.put("2",new Movie("2","MovieB",120));
        movieMap.put("3",new Movie("3","MovieC",180));

        movieRepository = new MovieRepository(movieMap);


    }


    @Test
    @DisplayName("getAllMovies_ShouldRetrnAllMovies")
    public void getAllMovies_ShouldRetrnAllMovies(){
        // Arrange
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("1","MovieA",90));
        movieList.add(new Movie("2","MovieB",120));
        movieList.add(new Movie("3","MovieC",180));

        // Act
        List<Movie> actualMovieList = movieRepository.getAllMovies();

        Assertions.assertTrue(movieList.size() == actualMovieList.size() 
                            && movieList.containsAll(actualMovieList) 
                            && actualMovieList.containsAll(movieList));

        


    }

    @Test
    @DisplayName("getMovieByTitle_ShouldReturnMovie")
    public void getMovieByTitle_ShouldReturnMovie(){
        Movie expectedMovie = new Movie("3","MovieC",180);
        Movie actaulMovie = movieRepository.getMovieById("3");

        Assertions.assertEquals(expectedMovie, actaulMovie);

    }

    @Test
    @DisplayName("getMovieByTitle_ShouldReturnNull")
    public void getMovieByTitle_ShouldReturnNull(){
        Movie actaulMovie = movieRepository.getMovieById("4");

        Assertions.assertNull(actaulMovie);

    }

    @Test
    @DisplayName("saveMovie_shouldSaveMovie")
    public void saveMovie_shouldSaveMovie(){
        Movie savedMovie = new Movie("4","MovieD",210);
        movieRepository.saveMovie(savedMovie);

        assertEquals(savedMovie,movieRepository.getMovieById("4"));
    }
}