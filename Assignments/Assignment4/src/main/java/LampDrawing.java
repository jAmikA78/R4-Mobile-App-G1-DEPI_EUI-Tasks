import java.awt.*;
import javax.swing.JFrame;

public class LampDrawing extends JFrame {

    public LampDrawing() {
        setTitle("Lamp Drawing");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setStroke(new BasicStroke(2));

        g2.setColor(new Color(255, 255, 150));
        g2.fillOval(220, 120, 160, 60);
        g2.setColor(Color.BLACK);
        g2.drawOval(220, 120, 160, 60);

        g2.setColor(new Color(255, 255, 150));
        g2.fillOval(270, 190, 70, 130);   
        g2.fillOval(215, 215, 45, 90);   
        g2.fillOval(350, 215, 45, 90);    

        g2.setColor(Color.BLACK);
        g2.drawOval(270, 190, 70, 130);
        g2.drawOval(215, 215, 45, 90);
        g2.drawOval(350, 215, 45, 90);

        g2.drawLine(220, 150, 180, 330);  
        g2.drawLine(380, 150, 420, 330);  

        g2.drawArc(180, 320, 240, 25, 180, 180);

        g2.drawLine(300, 345, 270, 470);
        g2.drawLine(300, 345, 330, 470);

        g2.drawRect(230, 470, 140, 25); 
    }

    public static void main(String[] args) {
        LampDrawing lamp = new LampDrawing();
    }
}
