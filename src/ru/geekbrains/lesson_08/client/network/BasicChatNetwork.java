package ru.geekbrains.lesson_08.client.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class BasicChatNetwork implements ClientNetwork {
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;

    public BasicChatNetwork(String host, int port) {
        try {
            socket = new Socket(host, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException("SWW during establishing", e);
        }
    }

    @Override
    public void send(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException("SWW during send", e);
        }
    }

    @Override
    public String receive() {
        try {
            return in.readUTF();
        } catch (IOException e) {
            throw new RuntimeException("SWW during receive", e);
        }
    }
}
