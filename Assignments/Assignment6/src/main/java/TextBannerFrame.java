import javax.swing.*;
import java.awt.*;

public class TextBannerFrame extends JFrame implements Runnable {

    private final Thread t;
    private final int width = 600;
    private final String text = "Hello, World!"; 
    private final int speed = 7;
    private final int[] charPositions; 

    public TextBannerFrame() {
        setTitle("Letter by letter movement");
        setSize(width, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        charPositions = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            charPositions[i] = i * 35; 
        }
        t = new Thread(this);
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.setColor(Color.blue);

        for (int i = 0; i < text.length(); i++) {
            int x = charPositions[i];
            if (x < -30) {
                charPositions[i] = width;
                x = charPositions[i];
            }
            g.drawString(String.valueOf(text.charAt(i)), x, 100);
        }
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < charPositions.length; i++) {
                charPositions[i] -= speed;
            }
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
     TextBannerFrame frame = new TextBannerFrame();
    }
}
