Java Chat Application

Description.

This project implements a simple console chat server and client in Java that allows users to connect to the server and exchange messages.

Functionality.

The server accepts connections from multiple clients.

Clients can send messages that are broadcasted to all chat participants.

Each client receives all messages that come into the chat.

The server automatically removes disconnected clients from the list.

Project structure

src.
│ ├── ClientHandler.java # Client handler on the server
│ ├── ChatServer.java # Server side of the chat
│ ├── ChatClient.java # Client side of the chat
│ ├── Main.java # Additional file for tests

Requirements.

Java 8 or later

IntelliJ IDEA or any other development environment

Instructions for use

Starting the server

Open a terminal or command prompt.

Change to the folder with the ChatServer.java file.

Run the command:

javac ChatServer.java
java ChatServer

The server will start working on port 12345.

Launch the client

Open a new terminal or command prompt.

Change to the folder with the ChatClient.java file.

Run the command:

javac ChatClient.java
java ChatClient

Enter messages and send them to the chat.

How to launch a project in IntelliJ IDEA

Open the project in IntelliJ IDEA.

Run the ChatServer.

Launch ChatClient (you can do this several times to create multiple clients).

Enter messages in the client - they will appear in all active clients and on the server.

License.

This project is distributed under the MIT license. You can use it for your own purposes, modify it, and distribute it.
