package ru.geekbrains.lesson_04;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonListener extends Listener implements ActionListener {


    public SendButtonListener(JTextField messageField, JTextArea chatArea) {
        super(messageField, chatArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!messageIsEmpty()) {
            sendMessage();
        }
    setMessageFieldFocus();
    }
}
