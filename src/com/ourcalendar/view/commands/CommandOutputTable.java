package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class CommandOutputTable extends CommandAbstract{

    public CommandOutputTable(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Вывод календаря";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.outputTable();
    }
}
