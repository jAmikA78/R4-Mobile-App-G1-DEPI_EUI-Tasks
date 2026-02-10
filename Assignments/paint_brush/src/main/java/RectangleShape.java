import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class RectangleShape extends DrawShape {

    private int x, y, width, height;

    public RectangleShape(int x1, int y1, int x2, int y2, Color color, Stroke stroke) {
        super(color, stroke);

        this.x = Math.min(x1, x2);
        this.y = Math.min(y1, y2);
        this.width = Math.abs(x1 - x2);
        this.height = Math.abs(y1 - y2);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(stroke);
        g.drawRect(x, y, width, height);
    }
}
