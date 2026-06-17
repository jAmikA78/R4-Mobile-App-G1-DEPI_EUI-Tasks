import javax.swing.*;
import java.awt.*;

public class TextBanner extends JFrame implements Runnable {
    private JLabel label;
    private int xPosition = 0;
    private volatile boolean running = true;
    private Thread animationThread;
    
    public TextBanner() {
        setTitle("Text Banner");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        label = new JLabel("Hello Java");
        label.setForeground(Color.black);
 
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);

        animationThread = new Thread(this);
        animationThread.start();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                running = false;
                animationThread.interrupt();
            }
        });
    }
    
    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            xPosition +=2;

            if (xPosition == getWidth()) {
                xPosition = -200; 
            }

            SwingUtilities.invokeLater(() -> {
                label.setLocation(xPosition, 50);
            });

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextBanner frame = new TextBanner();
            frame.setVisible(true);
        });
    }
}