package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public abstract class CommandAbstract {
    String description;
    ConsoleUI consoleUI;

    public CommandAbstract(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }

    public String getDiscription(){
        return description;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;
}
