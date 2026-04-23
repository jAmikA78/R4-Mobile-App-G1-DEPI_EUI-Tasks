import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

class MyFrame extends JFrame {

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2 = (Graphics2D) g;
    g = g2;
    g2.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(Color.white);
    g.setFont(new Font("Arial", Font.BOLD, 60));

    g.setColor(Color.yellow);
    g.fillOval(100, 75, 200, 50);
    g.fillOval(85, 175, 40, 60);
    g.fillOval(265, 175, 40, 60);
    g.fillOval(155, 150, 80, 120);

    g.setColor(Color.black);
    g.drawLine(100, 100, 50, 300);
    g.drawLine(300, 100, 350, 300);
    g.drawLine(185, 325, 160, 420);
    g.drawLine(225, 325, 250, 420);

    g.drawRect(100, 420, 200, 20);

    g2.drawOval(100, 75, 200, 50);
    g2.drawOval(85, 175, 40, 60);
    g2.drawOval(265, 175, 40, 60);
    g2.drawOval(155, 150, 80, 120);

    g2.drawArc(50, 275, 300, 50, 180, 180);
  }
  public MyFrame() {
    this.setTitle("this a lamp");
    this.setSize(400, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
}