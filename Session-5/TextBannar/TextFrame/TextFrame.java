
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;

public class TextFrame extends JFrame implements Runnable {

  Thread tamerHosny;
  int pos = 0,width=600;
  String text = "Hello,World;";


  @Override
  public void paint(Graphics g) {
    super.paint(g);

    g.setColor(Color.white);
    g.drawString( 0, 0);

    g.setFont(new Font("Arial", Font.BOLD, 24));
    g.setColor(Color.RED);
    for (int i = 0; i < text.length(); i++) {
      g.drawString(String.valueOf(text.charAt(i)), ((pos + (i * 30)) % width), 100);
    }

  }

  public TextFrame() {
    this.setTitle("Title");
    this.setSize(width  , 150);
    tamerHosny = new Thread(this);
    tamerHosny.start();
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void run() {
    while (true) {
      pos++;
      if (pos == 450) {
        pos = 0;
      }
      repaint();
      try {
        tamerHosny.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
