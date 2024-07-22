package com.ourcalendar.view;

import com.ourcalendar.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<CommandAbstract> commandsList;

    public MainMenu(ConsoleUI consoleUI){
        commandsList = new ArrayList<>();
        commandsList.add(new CommandOutputTable(consoleUI));
        commandsList.add(new CommandAddUsers(consoleUI));
        commandsList.add(new CommandAddComment(consoleUI));
        commandsList.add(new CommandGetConnectionList(consoleUI));
        commandsList.add(new CommandClientUser(consoleUI));
        commandsList.add(new CommandStopServer(consoleUI));
        commandsList.add(new CommandStartServer(consoleUI));
        commandsList.add(new CommandDeleteContact(consoleUI));
        commandsList.add(new CommandFinish(consoleUI));
    }

    public String outputMenuInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<commandsList.size(); i++){
            stringBuilder.append((i+1) + " - ");
            stringBuilder.append(commandsList.get(i).getDiscription() + "\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int i) throws IOException, ClassNotFoundException, InterruptedException {
        CommandAbstract command = commandsList.get(i-1);
        command.execute();
    }

    public int getSize(){
        return commandsList.size();
    }
}
