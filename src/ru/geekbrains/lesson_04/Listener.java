package ru.geekbrains.lesson_04;

import javax.swing.*;

public class Listener {
    private final JTextField messageField;
    private final JTextArea chatArea;

    public Listener(JTextField messageField, JTextArea chatArea) {
        this.messageField = messageField;
        this.chatArea = chatArea;
    }

    public void sendMessage() {
        StringBuilder sb = new StringBuilder(chatArea.getText());
        sb.append(messageField.getText()).append("\n");
        chatArea.setText(sb.toString());
        messageField.setText("");
    }

    public boolean messageIsEmpty() {
        if (messageField.getText().trim().isEmpty())
            return true;
        return false;
    }
    public void setMessageFieldFocus() {
        messageField.requestFocus();
    }
}
