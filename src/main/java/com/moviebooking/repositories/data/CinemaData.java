package com.moviebooking.repositories.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.moviebooking.entities.Cinema;
import com.moviebooking.repositories.ICinemaRepository;

public class CinemaData implements IData{

    private final ICinemaRepository iCinemaRepository;

    public CinemaData(ICinemaRepository iCinemaRepository){
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
                addCinema(tokens.get(0),tokens.get(1));
                line = reader.readLine();

            }
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public void addCinema(String cinemaId, String cinemaName){
        iCinemaRepository.saveCinema(new Cinema(cinemaId, cinemaName));
    }
    
}