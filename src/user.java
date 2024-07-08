import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class user {
    private InetAddress ip;
    private int hostname;

    public void Initializations() throws UnknownHostException {
        this.ip = InetAddress.getLocalHost();
        this.hostname = Integer.parseInt(ip.getHostName());
//        System.out.println(ip);
//        System.out.println(hostname);
    }

    public void ConnectionTo() throws IOException {
        ServerSocket serverSocket = new ServerSocket(hostname);

        Socket client = serverSocket.accept();

        //OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
        BufferedReader readerClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

        writer.println("message");

        writer.close();
        readerClient.close();
        serverSocket.close();
        client.close();

        //String message = readerClient.readLine();


        //BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //PrintWriter out = new PrintWriter(client.getOutputStream(), true);
    }
    public void ConnectionIn() throws IOException {
        Socket socket = new Socket(ip,hostname);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);

        writer.println("meeeessege");
        String response = reader.readLine();

        reader.close();
        writer.close();
        socket.close();
    }

}