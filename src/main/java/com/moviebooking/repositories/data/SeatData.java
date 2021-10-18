package com.moviebooking.repositories.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.moviebooking.entities.Cinema;
import com.moviebooking.entities.Screen;
import com.moviebooking.entities.Seat;
import com.moviebooking.repositories.ICinemaRepository;


public class SeatData implements IData{

    private final ICinemaRepository iCinemaRepository;

    public SeatData(ICinemaRepository iCinemaRepository){
        this.iCinemaRepository = iCinemaRepository;
    }

    @Override
    public void load(String dataPath, String delimiter) {
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(dataPath));
            String line = reader.readLine();
            while(line != null){
                List<String> tokens = Arrays.asList(line.split(delimiter));
                addSeat(tokens.get(0), tokens.get(1), Integer.parseInt(tokens.get(2)), Integer.parseInt(tokens.get(3)));
                line = reader.readLine();
            }
            
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();        
        }

    }
    public void addSeat(String cinemaId, String screenId, int numOfRows, int numOfCols){
        Cinema cinema = iCinemaRepository.getCinemaById(cinemaId);
        Screen screen = cinema.getScreenById(screenId);
        for(int i=1; i <= numOfRows; i++){
            for(int j = 1; j <= numOfCols; j++){
                screen.addSeat(new Seat(i+"#"+j, i, j));
            }
        }
        cinema.addScreen(screen);
        iCinemaRepository.updateCinema(cinema);
    }
}