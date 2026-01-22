import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {

    private ArrayList<DrawShape> shapes = new ArrayList<>();
    private int startX, startY;
    private Color currentColor = Color.BLACK;
    private DrawMode currentMode = DrawMode.LINE;
    private PencilShape currentPencil;
    private final Color backgroundColor = Color.WHITE;
    private Stroke solidStroke = new BasicStroke(2);
    private Stroke dottedStroke = new BasicStroke(3,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,new float[]{3, 7},0);
    private Stroke currentStroke = solidStroke;

    public DrawingPanel() {
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (DrawShape s : shapes) {
            s.draw(g2);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();

        if (currentMode == DrawMode.PENCIL || currentMode == DrawMode.ERASER) {
            Color c = (currentMode == DrawMode.ERASER) ? backgroundColor : currentColor;
            currentPencil = new PencilShape(c, currentStroke);
            currentPencil.addPoint(e.getPoint());
            shapes.add(currentPencil);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (currentPencil != null) {
            currentPencil.addPoint(e.getPoint());
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int endX = e.getX();
        int endY = e.getY();

        switch (currentMode) {
            case LINE ->shapes.add(new LineShape(startX, startY, endX, endY, currentColor, currentStroke));
            case RECTANGLE -> shapes.add(new RectangleShape(startX, startY, endX, endY, currentColor, currentStroke));
            case OVAL -> shapes.add(new OvalShape(startX, startY, endX, endY, currentColor, currentStroke));
        }

        currentPencil = null;
        repaint();
    }

    public void setMode(DrawMode mode) {
        this.currentMode = mode;
    }

    public void setColor(Color color) {
        this.currentColor = color;
    }

    public void setSolid() {
        currentStroke = solidStroke;
    }

    public void setDotted() {
        currentStroke = dottedStroke;
    }

    public void clearAll() {
        shapes.clear();
        repaint();
    }

    public void undo() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
            repaint();
        }
    }
    
    
    
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}


}
