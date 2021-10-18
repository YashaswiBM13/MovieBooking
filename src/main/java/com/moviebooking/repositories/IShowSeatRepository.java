package com.moviebooking.repositories;

import java.util.List;

import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.ShowSeat;

public interface IShowSeatRepository {
    public List<ShowSeat> getShowSeatsByShowId(String id);
    public ShowSeat getShowSeat(String showId, String seatId);
    public void addShowSeats(Show show, List<Seat> seats);
    public void updateShowSeat(ShowSeat showseat);
}