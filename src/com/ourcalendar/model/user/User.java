import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private static ServerSocket serverSocket;
    private static BufferedReader readerClient;
    private static Socket socket1;
    private static OutputStreamWriter writer;
    private static Socket socket2;
    private static ArrayList<String> connectsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        connectsList.add("127.0.0.1:8001");
        connectsList.add("127.0.0.1:8002");

        Thread serverThread = new Thread(() -> {
            try {
                server();
            } catch (IOException e) {

            }
        });

        Thread clientThread = new Thread(() -> {
            try {
                messaging();
                //TimeUnit.SECONDS.sleep(10);
                //client(sendMessage());
                stop();
            } catch (IOException e) {
                //throw new RuntimeException(e);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
            }

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

    public static void server() throws IOException {
        System.out.println("01?");
        serverSocket = new ServerSocket(8000);
        System.out.println("02?");
        while (true){
            System.out.println("03?");
            socket1 = serverSocket.accept();
            System.out.println("04?");
            readerClient = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            System.out.println("06?");


            String auntifaction = readerClient.readLine();
            System.out.println("07?");
            System.out.println(auntifaction);
            System.out.println("08?");
            readerClient.close();
            socket1.close();
        }


    }

    public static void client(String message) throws IOException, InterruptedException {
        System.out.println("1?");
        for (String con: connectsList){
            String[] strings = con.split(":");
            socket2 = new Socket(strings[0], Integer.parseInt(strings[1]));
            System.out.println("2?");
            writer = new OutputStreamWriter(socket2.getOutputStream());
            System.out.println("3?");

            System.out.println("4?");
            writer.write("от "+8000+" к "+8001 + " сообщение:"+message);
            writer.flush();
            writer.close();
        }
    }

    public static void stop() throws IOException {
        System.out.println("12345");
        //socket2.close();
    }

    public static void stopServer() throws InterruptedException, IOException {
        serverSocket.close();
    }

    public static String sendMessage(){
        System.out.println("Введите сообщение: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }

    public static void messaging() throws IOException, InterruptedException {
        while (true){
            String s = sendMessage();
            System.out.println(s);
            switch (s){
                case ("/stop"):stop(); stopServer();break;
                case ("/add"):addUser();break;
                default: client(s);
            }
        }

    }

    public static void addUser(){
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адресс");
        String adres = scanner.nextLine();
        System.out.println("Введите порт");
        String port = scanner.nextLine();
        builder.append(adres);
        builder.append(":");
        builder.append(port);
        connectsList.add(builder.toString());
    }
}