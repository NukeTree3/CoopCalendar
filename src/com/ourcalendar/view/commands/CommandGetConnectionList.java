package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class CommandGetConnectionList  extends CommandAbstract{
    public CommandGetConnectionList(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Вывод всех контактов";
    }

    @Override
    public void execute(){
        consoleUI.getConnects();
    }
}
