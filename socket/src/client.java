import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 65432)) {
            System.out.println("Connected to server");

            // Get input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send data to the server
            String message = "Hello, server!";
            out.println(message);

            // Receive response from the server
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

