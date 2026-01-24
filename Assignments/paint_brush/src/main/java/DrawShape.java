import java.awt.*;

public abstract class DrawShape {

    protected Color color;
    protected Stroke stroke;

    public DrawShape(Color color, Stroke stroke) {
        this.color = color;
        this.stroke = stroke;
    }

    public abstract void draw(Graphics2D g);
}
