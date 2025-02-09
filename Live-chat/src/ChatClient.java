import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Підключено до чату. Введіть свої повідомлення:");

            // Потік для отримання повідомлень від сервера
            Thread receiveMessages = new Thread(() -> {
                try {
                    String message;
                    while ((message = input.readLine()) != null) {
                        System.out.println("Отримано: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveMessages.start();

            // Читання повідомлень з консолі і надсилання на сервер
            while (true) {
                String userMessage = scanner.nextLine();
                output.println(userMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
