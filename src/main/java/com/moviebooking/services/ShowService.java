package com.moviebooking.services;

import java.util.ArrayList;
import java.util.List;

import com.moviebooking.dto.ShowResponse;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.ShowSeat;
import com.moviebooking.repositories.IShowRepository;
import com.moviebooking.repositories.IShowSeatRepository;

public class ShowService implements IShowService {

    private final IShowRepository iShowRepository;
    private final IShowSeatRepository iShowSeatRepository;

    public ShowService(IShowRepository iShowRepository, IShowSeatRepository iShowSeatRepository){
        this.iShowRepository = iShowRepository;
        this.iShowSeatRepository = iShowSeatRepository;
    }

    @Override
    public List<ShowResponse> getAllShowsByMovieTitle(String title) {
        List<ShowResponse> showResponsesList = new ArrayList<>();
        List<Show> showList = iShowRepository.getAllShowsForMovieName(title);
        for(Show s: showList){
            showResponsesList.add(new ShowResponse(s.getId()
            , s.getMovieTitle()
            , s.getCinemaName()
            , s.getScreenName()
            , s.getStart()
            , s.getEnd()));
        }
        return showResponsesList;


    }

    @Override
    public List<ShowSeat> getAllShowSeats(String showId) {
        return iShowSeatRepository.getShowSeatsByShowId(showId);
    }
    
}