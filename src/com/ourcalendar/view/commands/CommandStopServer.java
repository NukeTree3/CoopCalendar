package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class CommandStopServer extends CommandAbstract{
    public CommandStopServer(ConsoleUI consoleUI){
        super(consoleUI);
        description = "остановка сервера";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, InterruptedException {
        consoleUI.stopServer();
    }
}
