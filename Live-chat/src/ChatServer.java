import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345; // Порт сервера
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущено на порту " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новий клієнт підключився.");

                ClientHandler handler = new ClientHandler(clientSocket);
                clientHandlers.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для надсилання повідомлення всім клієнтам
    public static synchronized void broadcast(String message) {
        for (ClientHandler client : clientHandlers) {
            client.sendMessage(message);
        }
    }

    // Метод для видалення клієнта з списку
    public static synchronized void removeClient(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
    }
}
