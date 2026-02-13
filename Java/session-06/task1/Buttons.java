import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JFrame {
    private int count = 0;
    private JLabel countlabel;
    
    public Buttons() {
        setTitle("Button Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
        setLayout(new BorderLayout());

        countlabel = new JLabel("Counter: " + count, SwingConstants.CENTER);
        add(countlabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton incrementButton = new JButton("++");
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                updateCount();
            }
        });

        JButton decrementButton = new JButton("--");
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                updateCount();
            }
        });

        buttonPanel.add(incrementButton);
        buttonPanel.add(decrementButton);

        add(buttonPanel, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
    }
    
    private void updateCount() {
        countlabel.setText("Counter: " + count);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Buttons frame = new Buttons();
                frame.setVisible(true);
            }
        });
    }
}