import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {

    int count = 0;

    JButton incrementButton;
    JButton decrementButton;

    JPanel panel;

    public ButtonFrame() {
        setTitle("Button");
        setSize(200 , 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("Count: " + count, 75 , 75);
            }
        };

        panel.setLayout(new FlowLayout());

        incrementButton = new JButton("++");
        decrementButton = new JButton("--");


        incrementButton.addActionListener(e -> {
            count++;
            panel.repaint();
        });

        decrementButton.addActionListener(e -> {
            count--;
            panel.repaint();
        });

        panel.add(incrementButton);
        panel.add(decrementButton);

        add(panel);
    }

}
