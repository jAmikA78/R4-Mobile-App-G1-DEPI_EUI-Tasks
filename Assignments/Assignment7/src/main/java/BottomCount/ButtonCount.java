package BottomCount;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCount extends JFrame {
    private int counter = 0; 
    private JLabel counterLabel; 

    public ButtonCount() {
        setTitle("Counter App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton incrementButton = new JButton("++");
        JButton decrementButton = new JButton("--");

        buttonPanel.add(incrementButton);
        buttonPanel.add(decrementButton);
        add(buttonPanel, BorderLayout.NORTH);

        counterLabel = new JLabel("Counter's value is: " + counter, SwingConstants.CENTER);
        add(counterLabel, BorderLayout.CENTER);

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                updateCounterLabel();
            }
        });
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;
                updateCounterLabel();
            }
        });
        setVisible(true);
    }

    private void updateCounterLabel() {
        counterLabel.setText("Counter's value is: " + counter);
    }

    public static void main(String[] args) {
        new ButtonCount();
    }
}
