package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class CommandDeleteContact extends CommandAbstract{
    public CommandDeleteContact(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Удаление контакта";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.deleteContact();
    }
}
