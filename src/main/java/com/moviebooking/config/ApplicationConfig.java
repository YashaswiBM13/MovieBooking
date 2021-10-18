package com.moviebooking.config;

import com.moviebooking.command.BookTicketCommand;
import com.moviebooking.command.CancelTicketCommand;
import com.moviebooking.command.CommandInvoker;
import com.moviebooking.command.DisplayMovieCommand;
import com.moviebooking.command.DisplayShowCommand;
import com.moviebooking.command.DisplayShowSeatCommand;
import com.moviebooking.command.ICommand;
import com.moviebooking.repositories.CinemaRepository;
import com.moviebooking.repositories.CustomerRepository;
import com.moviebooking.repositories.ICinemaRepository;
import com.moviebooking.repositories.ICustomerRepository;
import com.moviebooking.repositories.IMovieRepository;
import com.moviebooking.repositories.IShowRepository;
import com.moviebooking.repositories.IShowSeatRepository;
import com.moviebooking.repositories.ITicketRepository;
import com.moviebooking.repositories.MovieRepository;
import com.moviebooking.repositories.ShowRepository;
import com.moviebooking.repositories.ShowSeatRepository;
import com.moviebooking.repositories.TicketRepository;
import com.moviebooking.repositories.data.CinemaData;
import com.moviebooking.repositories.data.CustomerData;
import com.moviebooking.repositories.data.DataLoader;
import com.moviebooking.repositories.data.MovieData;
import com.moviebooking.repositories.data.ScreenData;
import com.moviebooking.repositories.data.SeatData;
import com.moviebooking.repositories.data.ShowData;
import com.moviebooking.services.IMovieService;
import com.moviebooking.services.IShowService;
import com.moviebooking.services.ITicketService;
import com.moviebooking.services.MovieService;
import com.moviebooking.services.ShowService;
import com.moviebooking.services.TicketService;

public class ApplicationConfig {
    private final ICinemaRepository iCinemaRepository = new CinemaRepository();
    private final ICustomerRepository iCustomerRepository = new CustomerRepository();
    private final IMovieRepository iMovieRepository = new MovieRepository();
    private final IShowRepository iShowRepository = new ShowRepository();
    private final IShowSeatRepository iShowSeatRepository = new ShowSeatRepository();
    private final ITicketRepository iTicketRepository = new TicketRepository();

    private final IMovieService iMovieService = new MovieService(iMovieRepository);
    private final IShowService iShowService  =new ShowService(iShowRepository, iShowSeatRepository);
    private final ITicketService iTicketService = new TicketService(iCustomerRepository, iShowSeatRepository, iShowRepository, iTicketRepository);

    private final ICommand bookTicketCommand = new BookTicketCommand(iTicketService);
    private final ICommand cancelTicketCommand = new CancelTicketCommand(iTicketService);
    private final ICommand displayMovieCommand = new DisplayMovieCommand(iMovieService);
    private final ICommand displayShowCommand = new DisplayShowCommand(iShowService);
    private final ICommand displayShowSeatCommand = new DisplayShowSeatCommand(iShowService);

    private final CommandInvoker commandInvoker = new CommandInvoker();
    private final DataLoader dataLoader = new DataLoader();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("DISPLAY-MOVIES", displayMovieCommand);
        commandInvoker.register("DISPLAY-SHOWS", displayShowCommand);
        commandInvoker.register("DISPLAY-SEATS", displayShowSeatCommand);
        commandInvoker.register("BOOK-TICKET", bookTicketCommand);
        commandInvoker.register("CANCEL-TICKET", cancelTicketCommand);
        return commandInvoker;
    }
    public DataLoader getDataLoader(){
        dataLoader.register("CINEMA-DATA", new CinemaData(iCinemaRepository));
        dataLoader.register("SCREEN-DATA", new ScreenData(iCinemaRepository));
        dataLoader.register("SEAT-DATA", new SeatData(iCinemaRepository));
        dataLoader.register("CUSTOMER-DATA", new CustomerData(iCustomerRepository));
        dataLoader.register("MOVIE-DATA", new MovieData(iMovieRepository));
        dataLoader.register("SHOW-DATA", new ShowData(iShowRepository, iCinemaRepository, iMovieRepository, iShowSeatRepository));
        return dataLoader;

    }


    
}