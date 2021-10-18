package com.moviebooking.services;

import java.util.List;

import com.moviebooking.dto.ShowResponse;
import com.moviebooking.entities.ShowSeat;

public interface IShowService {
    public List<ShowResponse> getAllShowsByMovieTitle(String title);
    public List<ShowSeat> getAllShowSeats(String showId);
    
}