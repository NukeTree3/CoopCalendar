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

        } catch (IOException e) {
            System.out.println("пуппупупу");
        }

        //Thread clientThread = new Thread(() -> {
//            try {
//                //messaging();
//                //TimeUnit.SECONDS.sleep(10);
//                //client(sendMessage());
//                stop();
//            } catch (IOException e) {
//                //throw new RuntimeException(e);
//            } catch (InterruptedException e) {
//                //throw new RuntimeException(e);
//            }

//            try {
//                client();
//                stop();
//                TimeUnit.SECONDS.sleep(3);
//                client();
//                stop();
//                TimeUnit.SECONDS.sleep(3);
//            } catch (IOException | InterruptedException e) {
//
//            }
        //});

//
//        serverThread.start();
//        clientThread.start();

    }

    public void server() throws IOException {
        //System.out.println("01?");
        serverSocket = new ServerSocket(myPort);
        //System.out.println("02?");
        while (true){
            //System.out.println("03?");
            socket1 = serverSocket.accept();
            //System.out.println("04?");
            readerClient = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            //System.out.println("06?");


            String data = readerClient.readLine();
            //System.out.println(data);
            acceptedData.setData(data);
            //System.out.println("07?");
            //System.out.println(data);
            //System.out.println("08?");
            readerClient.close();
            socket1.close();
        }


    }

    public void client(String message,ArrayList<String> connectsList) throws IOException, InterruptedException {
        //System.out.println("1?");
        for (String con: connectsList){
            String[] strings = con.split(":");
            //System.out.println(strings[0]+ "  " + strings[1] + "  "+ strings[2]);
            socket2 = new Socket(strings[1], Integer.parseInt(strings[2]));
            //System.out.println("2?");
            writer = new OutputStreamWriter(socket2.getOutputStream());
            //System.out.println("3?");

            //System.out.println("4?");
            writer.write(message);
            writer.flush();
            writer.close();
        }
        //stopServer();
    }


    public void stopServer() throws IOException {
        if (work){
            serverSocket.close();
        }
    }
}