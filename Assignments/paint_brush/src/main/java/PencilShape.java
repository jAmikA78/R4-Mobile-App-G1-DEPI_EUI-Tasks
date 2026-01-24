import java.awt.*;
import java.util.ArrayList;

public class PencilShape extends DrawShape {

    private ArrayList<Point> points;

    public PencilShape(Color color, Stroke stroke) {
        super(color, stroke);
        points = new ArrayList<>();
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON ); 
        g.setColor(color);
        g.setStroke(stroke);

        for (int i = 0; i < points.size()- 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}
