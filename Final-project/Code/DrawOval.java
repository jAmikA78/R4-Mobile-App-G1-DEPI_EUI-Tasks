
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawOval implements ShapesInterface {
  private Color color;
  private boolean bold;
  private boolean dotted;
  private int x1, y1, x2, y2;

  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public void setBold(boolean bold) {
    this.bold = bold;
  }

  @Override
  public void setDotted(boolean dotted) {
    this.dotted = dotted;
  }

  @Override
  public void setCoordinates(int x1, int y1, int x2, int y2) {
    this.x1 = Math.min(x1, x2);
    this.y1 = Math.min(y1, y2);
    this.x2 = Math.max(x1, x2);
    this.y2 = Math.max(y1, y2);
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(color);
    if (bold) {
      g2d.setStroke(new BasicStroke(3));
    } else {
      g2d.setStroke(new BasicStroke(1));
    }
    if (dotted) {
      float[] dash = {5f, 5f};
      g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, dash, 0f));
    }
    g2d.drawOval(x1, y1, x2 - x1, y2 - y1);

  }

}
