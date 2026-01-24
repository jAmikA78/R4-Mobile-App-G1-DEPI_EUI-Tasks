/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.buttoncount;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Count extends JPanel {

    private int counter = 0;
    private JLabel label;
    private JButton increment;
    private JButton decrement;

    public Count() {
        setLayout(null);

        label = new JLabel("Counter Value is: " + counter);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBounds(100, 150, 400, 50);
        add(label);

        increment = new JButton("++");
        increment.setBounds(70, 20, 60, 50);
        increment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter++;
                label.setText("Counter Value: " + counter);
            }
        });
        add(increment);

        decrement = new JButton("--");
        decrement.setBounds(350, 20, 60, 50);
        decrement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter--;
                label.setText("Counter Value: " + counter);
            }
        }
     );
        add(decrement);
    }
}

public class ButtonCount {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Counter Example");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new Count());

        frame.setVisible(true);
    }
}
