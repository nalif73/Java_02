package ru.geekbrains.lesson_06.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Server() {
        try {
            serverSocket = new ServerSocket(8989);
            System.out.println("Server is running on and waiting for a connection...");
            Socket client = serverSocket.accept();
            System.out.println("Client accepted: " + client);
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    try {
                        System.out.println("Please input message...");
                        out.writeUTF(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Transmission closed.");
                        break;
                    }
                }
            })
                    .start();
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("Message from client: " + in.readUTF());
                    } catch (IOException e) {
                        System.out.println("Connection closed.");
                        break;
                    }
                }
            })
                    .start();
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }
}
