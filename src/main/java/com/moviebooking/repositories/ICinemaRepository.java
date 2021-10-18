package com.moviebooking.repositories;

import com.moviebooking.entities.Cinema;

public interface ICinemaRepository {
    public Cinema getCinemaById(String id);
    public void saveCinema(Cinema cinema);
    public void updateCinema(Cinema cinema);
    
    
}