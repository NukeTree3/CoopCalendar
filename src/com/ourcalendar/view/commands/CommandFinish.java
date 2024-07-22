package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class CommandFinish extends CommandAbstract{
    public CommandFinish(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Закончить сессию";
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        consoleUI.finish();
    }
}
