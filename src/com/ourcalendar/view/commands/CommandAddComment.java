package com.ourcalendar.view.commands;

import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class CommandAddComment extends CommandAbstract{
    public CommandAddComment(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добваление записи";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.addComment();
    }
}
