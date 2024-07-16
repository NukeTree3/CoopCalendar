package com.ourcalendar.model.client;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    ArrayList<String> connections = new ArrayList();

    public Client() throws IOException {
        for (String con: connections){
            Socket socket = new Socket(con,8000);

        }
    }

    public void addConnections(){

    }

    public void connection(){

    }


}
