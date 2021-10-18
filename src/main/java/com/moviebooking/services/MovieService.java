package com.moviebooking.services;

import java.util.List;

import com.moviebooking.entities.Movie;
import com.moviebooking.repositories.IMovieRepository;

public class MovieService implements IMovieService {

    private final IMovieRepository iMovieRepository;

    public MovieService(IMovieRepository iMovieRepository){
        this.iMovieRepository = iMovieRepository;
    }
    @Override
    public List<Movie> getAllMovies() {
        return iMovieRepository.getAllMovies();
    }
    
}