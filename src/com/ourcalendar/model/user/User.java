package com.ourcalendar.model.user;

import com.ourcalendar.model.user.accepteddata.AcceptedData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class User extends Thread{

    private int myPort;
    private ServerSocket serverSocket;
    private BufferedReader readerClient;
    private Socket socket1;
    private OutputStreamWriter writer;
    private Socket socket2;
    private boolean work = false;
    AcceptedData acceptedData;

    public User(int port, AcceptedData acceptedData){
        this.myPort = port;
        this.acceptedData = acceptedData;
    }

    @Override
    public void run() {
        try {
            work = true;
            server();

        } catch (IOException _) {

        }
    }

    public void server() throws IOException {
        serverSocket = new ServerSocket(myPort);
        while (true){
            socket1 = serverSocket.accept();
            readerClient = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            String data = readerClient.readLine();
            acceptedData.setData(data);
            readerClient.close();
            socket1.close();
        }


    }

    public void client(String message,ArrayList<String> connectsList) throws IOException, InterruptedException {
        for (String con: connectsList){
            String[] strings = con.split(":");
            socket2 = new Socket(strings[1], Integer.parseInt(strings[2]));
            writer = new OutputStreamWriter(socket2.getOutputStream());
            writer.write(message);
            writer.flush();
            writer.close();
        }
    }


    public void stopServer() throws IOException {
        if (work){
            serverSocket.close();
        }
    }
}