package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class CommandAddUsers extends CommandAbstract{
    public CommandAddUsers(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добваление нового контакта";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.addUser();
    }
}
