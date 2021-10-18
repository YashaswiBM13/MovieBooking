package com.moviebooking.repositories.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.moviebooking.entities.Movie;
import com.moviebooking.repositories.IMovieRepository;

public class MovieData  implements IData{

    private final IMovieRepository iMovieRepository;

    public MovieData(IMovieRepository iMovieRepository){
        this.iMovieRepository = iMovieRepository;
    }

    @Override
    public void load(String dataPath, String delimiter) {
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(dataPath));
            String line="";
            while((line = reader.readLine()) != null){
                List<String> tokens = Arrays.asList(line.split(delimiter));
                addMovie(tokens.get(0), tokens.get(1), Integer.parseInt(tokens.get(2)));
            }
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        

    }
    public void addMovie(String id, String title, int durationInMins){
        iMovieRepository.saveMovie(new Movie(id, title, durationInMins));
    }
    
}