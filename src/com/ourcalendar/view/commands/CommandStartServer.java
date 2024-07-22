package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class CommandStartServer extends CommandAbstract{
    public CommandStartServer(ConsoleUI consoleUI){
        super(consoleUI);
        description = "запуск сервера";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, InterruptedException {
        consoleUI.startServer();
    }
}