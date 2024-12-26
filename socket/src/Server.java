import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(65432)) {
            System.out.println("Server listening on port 65432...");

            // Accept a connection from the client.java
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client.java");

            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive data from the client.java
            String clientMessage = in.readLine();
            System.out.println("Received from client.java: " + clientMessage);

            // Send a response to the client.java
            String response = "Hello, client.java!";
            out.println(response);

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

