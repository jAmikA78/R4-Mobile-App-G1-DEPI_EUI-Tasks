/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.helloframe;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Amir Fahmy 7
 */
class Hello extends JLabel {

    private int x;

    public Hello(int frameWidth) {
        setText("Hello Java");
        setFont(new Font("Arial", Font.BOLD, 30));

        x = frameWidth;
        setBounds(x, 200, 300, 40);

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x -= 2;

                if (x + getWidth() < 0) {
                    x = frameWidth;
                }

                setLocation(x, 10);
            }
        });

        timer.start();
    }
}

public class HelloFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Hello(frame.getWidth()));
        frame.setVisible(true);

    }
}
