package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class CommandClientUser extends CommandAbstract{
    public CommandClientUser(ConsoleUI consoleUI){
        super(consoleUI);
        description = "отправка изменений";
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        consoleUI.sendMyComments();
    }
}
