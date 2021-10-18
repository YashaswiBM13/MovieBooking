package com.moviebooking.command;

import java.util.List;

public interface ICommand {
    void execute(List<String> tokens);

}