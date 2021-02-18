package ru.geekbrains.lesson_06.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public Client() {
        try {
            socket = new Socket("127.0.0.1", 8989);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

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
                        System.out.println("Message from server: " + in.readUTF());
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
