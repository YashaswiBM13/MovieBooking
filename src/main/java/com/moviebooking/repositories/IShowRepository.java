package com.moviebooking.repositories;

import java.util.List;

import com.moviebooking.entities.Show;

public interface IShowRepository {
    public List<Show> getAllShowsForMovieName(String movieName);
    public Show getShowById(String id);
    public void saveShow(Show show);
    
    
}