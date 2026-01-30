import java.awt.Graphics;
import java.util.Date;
import javax.swing.JFrame;

public class dateTime extends JFrame implements Runnable {
    Thread th;
    public dateTime() {
        setTitle("Date & Time");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        while (true) {
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
        Date d = new Date();
        g.drawString(d.toString(), 50, 100);
    }
    public static void main(String[] args) {
        new dateTime();
    }
}
