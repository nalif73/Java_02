package ru.geekbrains.lesson_08.client.network;

public interface ClientNetwork {
    void send(String message);
    String receive();
}
