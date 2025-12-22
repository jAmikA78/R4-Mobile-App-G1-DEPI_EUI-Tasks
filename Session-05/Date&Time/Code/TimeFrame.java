
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.JFrame;

public class TimeFrame extends JFrame implements Runnable {

  Thread tahaHussin;

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    g.setColor(Color.white);
    g.drawString("لما بشيل السطر ده الدنيا بتبوظ", 0, 0);

    g.setFont(new Font("Arial", Font.BOLD, 24));

    Date date = new Date();
    g.setColor(Color.black);

    g.drawString(date.toString(), 50, 100);

  }

  public TimeFrame() {
    this.setTitle("يا عمو الساعة كام ؟");
    this.setSize(450, 150);
    tahaHussin =new Thread(this);
    tahaHussin.start();
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  @Override
  public void run() {
    while (true) {
      repaint();
      try {
        tahaHussin.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
