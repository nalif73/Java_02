package ru.geekbrains.lesson_04;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ChatFrame extends JFrame {
    public ChatFrame() {

        setTitle("Чат v 0.1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setBounds(0, 0, 600, 300);
        setLayout(new BorderLayout());
        setDefaultLookAndFeelDecorated(true);

        JPanel top = new JPanel();
        top.setBackground(Color.WHITE);
        top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        top.setLayout(new BorderLayout());
        add(top, BorderLayout.CENTER);

        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        top.add(scrollPane, BorderLayout.CENTER);


        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        bottom.setLayout(new BorderLayout());
        add(bottom, BorderLayout.SOUTH);

        JTextField messageField = new JTextField();
        messageField.setEditable(true);
        messageField.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        bottom.add(messageField, BorderLayout.CENTER);

        JButton sendButton = new JButton("Отправить");
        bottom.add(sendButton, BorderLayout.EAST);
        SendButtonListener sendButtonListener = new SendButtonListener(messageField, chatArea);
        sendButton.addActionListener(sendButtonListener);

        EnterKeyListener enterKeyListener = new EnterKeyListener(messageField, chatArea);
        messageField.addKeyListener(enterKeyListener);

        setVisible(true);
        messageField.requestFocusInWindow();

    }
}
