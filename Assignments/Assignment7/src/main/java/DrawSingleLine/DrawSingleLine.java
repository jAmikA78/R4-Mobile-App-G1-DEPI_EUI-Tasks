package DrawSingleLine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawSingleLine extends JFrame {

    public DrawSingleLine() {
        setTitle("Draw Single Line");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new DrawPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new DrawSingleLine();
    }
}






class DrawPanel extends JPanel {

    private int startX, startY, endX, endY;
    private boolean isDrawing = false;
    private boolean hasLine = false;

    public DrawPanel() {
        LineMouse line = new LineMouse();
        addMouseListener(line);
        addMouseMotionListener(line);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (hasLine || isDrawing) {
            g.setColor(Color.BLACK);
            g.drawLine(startX, startY, endX, endY);
        }
    }

    private class LineMouse extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
            endX = startX;
            endY = startY;
            isDrawing = true;
            hasLine = false;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            isDrawing = false;
            hasLine = true;  
            repaint();
        }
    }
}
