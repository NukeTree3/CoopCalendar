package com.ourcalendar.view;

import com.ourcalendar.view.commands.CommandAbstract;
import com.ourcalendar.view.commands.CommandOutputTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<CommandAbstract> commandsList;

    public MainMenu(ConsoleUI consoleUI){
//        commandsList = new ArrayList<>();
//        commandsList.add(new CommandOutputTable());
//        commandsList.add();
//        commandsList.add();
//        commandsList.add();
//        commandsList.add();
//        commandsList.add();
//        commandsList.add();
    }

    public String outputMenuInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<commandsList.size(); i++){
            stringBuilder.append((i+1) + " - ");
            stringBuilder.append(commandsList.get(i).getDiscription() + "\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int i) throws IOException, ClassNotFoundException {
        CommandAbstract command = commandsList.get(i-1);
        command.execute();
    }

    public int getSize(){
        return commandsList.size();
    }
}
