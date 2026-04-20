 package com.mycompany.datetime;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime extends JFrame {

    private final JLabel label;
    private final DateTimeFormatter fmt =
            DateTimeFormatter.ofPattern("EEE MMM dd  HH:mm:ss  yyyy");

    public DateTime() {
        setTitle("Date & Time");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        add(label);

        // update every 1 second
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        updateTime(); // first time
    }

    private void updateTime() {
        label.setText(LocalDateTime.now().format(fmt));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DateTime().setVisible(true));
    }
}

