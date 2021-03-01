package ru.geekbrains.lesson_08;

import ru.geekbrains.lesson_08.client.ClientChatAdapter;

public class ClientOne {
    public static void main(String[] args) {
        new ClientChatAdapter("localhost", 8989);
    }
}
