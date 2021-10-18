package com.moviebooking.repositories;

import java.util.List;

import com.moviebooking.entities.Movie;

public interface IMovieRepository {
    public List<Movie> getAllMovies();
    public Movie getMovieById(String id);
    public void saveMovie(Movie movie);
    
}