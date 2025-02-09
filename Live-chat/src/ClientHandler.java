import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Отримано повідомлення: " + message);
                ChatServer.broadcast(message); // Розсилка повідомлення іншим клієнтам
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ChatServer.removeClient(this);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        output.println(message);
    }
}
