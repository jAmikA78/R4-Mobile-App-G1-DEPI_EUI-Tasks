import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class lineDraw extends JFrame {

    public lineDraw() {
        setTitle("Draw Single Line");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new DrawPanel());
        setVisible(true);
    }

    private static class DrawPanel extends JPanel {

        private int x1, y1, x2, y2;
        private boolean dragging = false;

        public DrawPanel() {

            MouseAdapter mouseHandler = new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    x1 = e.getX();
                    y1 = e.getY();
                    x2 = x1;
                    y2 = y1;
                    dragging = true;
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if (dragging) {
                        x2 = e.getX();
                        y2 = e.getY();
                        repaint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    dragging = false;
                }
            };

            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) {
        new lineDraw();
    }
}
