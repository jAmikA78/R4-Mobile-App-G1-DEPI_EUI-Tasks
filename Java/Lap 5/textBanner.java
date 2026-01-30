import java.awt.Graphics;
import javax.swing.JFrame;

public class textBanner extends JFrame implements Runnable {
    String text = " Welcome to Java Graphics ";
    int x = 300;
    Thread th;
    public textBanner() {
        setTitle("textBanner");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        while (true) {
            x -= 5;          // move text
            if (x < -200) {
                x = getWidth();
            }
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(text, x, 100);
    }
    public static void main(String[] args) {
        new textBanner();
    }
}
