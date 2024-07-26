package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;


public class CommandOutputTable extends CommandAbstract{

    public CommandOutputTable(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Вывод календаря";
    }

    @Override
    public void execute() {
        consoleUI.outputTable();
    }
}