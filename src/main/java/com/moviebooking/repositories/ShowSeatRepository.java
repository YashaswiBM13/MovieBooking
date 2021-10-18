package com.moviebooking.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.ShowSeat;

public class ShowSeatRepository implements IShowSeatRepository {

    private final Map<String, ShowSeat> showSeatMap;
    
    public ShowSeatRepository(){
        showSeatMap = new HashMap<>();
    }
    public ShowSeatRepository(Map<String, ShowSeat> showSeatMap){
        this.showSeatMap = showSeatMap;
    }

    @Override
    public List<ShowSeat> getShowSeatsByShowId(String id) {
        return showSeatMap.values()
                .stream()
                .filter(showSeat ->{
                    String showId = showSeat.getId().split("#")[0];
                    return showId.equalsIgnoreCase(id);
                })
                .collect(Collectors.toList());
    }

    @Override
    public ShowSeat getShowSeat(String showId, String seatId) {
        String id = showId+"#"+seatId;
        return showSeatMap.get(id);
    }

    @Override
    public void addShowSeats(Show show, List<Seat> seats) {
        seats.stream()
            .forEach(seat -> {
                String id = show.getId() + "#" + seat.getId();
                showSeatMap.put(id, new ShowSeat(id, seat, show));
            });

    }

    @Override
    public void updateShowSeat(ShowSeat showseat) {
        showSeatMap.put(showseat.getId(), showseat);
    }
    
    
}