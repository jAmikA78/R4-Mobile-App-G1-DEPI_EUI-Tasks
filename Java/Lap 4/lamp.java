import java.awt.*;
import javax.swing.JFrame;

public class lamp extends JFrame {

    public lamp() {
        setTitle("Lamp");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.YELLOW);
        g.fillOval(100, 75, 200, 50);
        g.fillOval(85, 175, 40, 60);
        g.fillOval(265, 175, 40, 60);
        g.fillOval(155, 150, 80, 120);

        g.setColor(Color.BLACK);
        g.drawOval(100, 75, 200, 50);
        g.drawOval(85, 175, 40, 60);
        g.drawOval(265, 175, 40, 60);
        g.drawOval(155, 150, 80, 120);

        g.drawLine(100, 100, 50, 300);
        g.drawLine(300, 100, 350, 300);

        g.drawLine(185, 325, 160, 420);
        g.drawLine(225, 325, 250, 420);

        g.drawRect(100, 420, 200, 20);

        g.drawArc(50, 275, 300, 50, 180, 180);
    }

    public static void main(String[] args) {
        new lamp();
    }
}
