package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame {

    JButton btnIncrement;
    JButton btnDecrement;
    int counter = 0;

    public Main() {

        btnIncrement = new JButton("++");
        btnDecrement = new JButton("--");

        btnIncrement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                repaint();
            }
        });

        btnDecrement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;
                repaint();
            }
        });

        add(btnIncrement);
        add(btnDecrement);

        setLayout(new FlowLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Counter = " + counter, 120, 120);
    }
    public static void main(String[] args) {
        new Main();
    }
}
