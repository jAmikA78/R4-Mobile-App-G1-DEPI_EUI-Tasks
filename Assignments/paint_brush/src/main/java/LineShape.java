import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class LineShape extends DrawShape {

    private int x1, y1, x2, y2;

    public LineShape(int x1, int y1, int x2, int y2, Color color, Stroke Stroke) {
        super(color, Stroke);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(stroke);
        g.drawLine(x1, y1, x2, y2);
    }
}
