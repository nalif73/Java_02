package ru.geekbrains.lesson_04;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EnterKeyListener extends Listener implements KeyListener {

    public EnterKeyListener(JTextField messageField, JTextArea chatArea) {
        super(messageField, chatArea);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (!messageIsEmpty()) {
                sendMessage();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
