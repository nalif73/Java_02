package ru.geekbrains.lesson_07.server;

import ru.geekbrains.lesson_07.server.auth.AuthenticationService;
import ru.geekbrains.lesson_07.server.auth.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * 1. Multiclient
 * 2. Login to chat (auth)
 * 3. Execute constraints (Unique name, already existing client, etc.)
 * 4. IN\OUT messages + broadcast
 */
public class Server {
    private final ServerSocket serverSocket;
    private final AuthenticationService authenticationService;
    private final Set<ClientHandler> handlers;

    public Server() {
        authenticationService = new AuthenticationService();
        handlers = new HashSet<>();
        try {
            serverSocket = new ServerSocket(8989);
            init();
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    private void init() throws IOException {
        while (true) {
            System.out.println("Server is waiting for a connection...");
            Socket client = serverSocket.accept();
            System.out.println("Client accepted: " + client);
            new ClientHandler(this, client);
        }
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public boolean isNicknameFree(String nickname) {
        for (ClientHandler handler : handlers) {
            if (handler.getName().equals(nickname)) {
                return false;
            }
        }
        return true;
    }

    public void broadcast(String message) {
        String[] s = message.split("\\s");
        if (s[1].equals("/w") && s.length>3) {    // проверка >3, что есть и само сообщение
            boolean flag = false;
            for (ClientHandler handler : handlers) {
                if (handler.getName().equals(s[2])) {
                    handler.sendMessage(message.replace(" /w " + s[2], ""));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (ClientHandler handler : handlers)
                    if (handler.getName().equals(s[0].substring(0,s[0].length()-1))) {
                        handler.sendMessage("No this nickname in chat");
                        break;
                    }
            }
        } else {
            for (ClientHandler handler : handlers)
                handler.sendMessage(message);

        }
    }

    public void subscribe(ClientHandler handler) {
        handlers.add(handler);
    }

    public void unsubscribe(ClientHandler handler) {
        handlers.remove(handler);
    }
}
