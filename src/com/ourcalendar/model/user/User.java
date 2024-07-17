package com.ourcalendar.model.user;

import com.ourcalendar.model.AcceptedData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private int myPort;
    private ServerSocket serverSocket;
    private BufferedReader readerClient;
    private Socket socket1;
    private OutputStreamWriter writer;
    private Socket socket2;
    private ArrayList<String> connectsList = new ArrayList<>();

    public User(int port){
        this.myPort = port;
    }

    public void start() throws IOException {

        Thread serverThread = new Thread(() -> {
            try {
                server();
            } catch (IOException e) {

            }
        });

        Thread clientThread = new Thread(() -> {
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
        });


        System.out.println("запуск сервераной части сервера");
        serverThread.start();
        System.out.println("запуск клменской части сервера");
        clientThread.start();


        //stop();
    }

    public void server() throws IOException {
        System.out.println("01?");
        serverSocket = new ServerSocket(myPort);
        System.out.println("02?");
        while (true){
            System.out.println("03?");
            socket1 = serverSocket.accept();
            System.out.println("04?");
            readerClient = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            System.out.println("06?");


            String data = readerClient.readLine();
            AcceptedData acceptedData = new AcceptedData();
            acceptedData.setData(data);
            System.out.println("07?");
            System.out.println(data);
            System.out.println("08?");
            readerClient.close();
            socket1.close();
        }


    }

    public void client(String message) throws IOException, InterruptedException {
        System.out.println("1?");
        for (String con: connectsList){
            String[] strings = con.split(":");
            socket2 = new Socket(strings[0], Integer.parseInt(strings[1]));
            System.out.println("2?");
            writer = new OutputStreamWriter(socket2.getOutputStream());
            System.out.println("3?");

            System.out.println("4?");
            writer.write("от "+ myPort +" к "+8001 + " сообщение:"+message);
            writer.flush();
            writer.close();
        }
        //stopServer();
    }


    public void stopServer() throws InterruptedException, IOException {
        serverSocket.close();
    }

    public void addUser(String adres, int port){
        String builder = adres + ":" + port;
        connectsList.add(builder);
    }

    public ArrayList<String> getConnectionList(){
        return connectsList;
    }
}