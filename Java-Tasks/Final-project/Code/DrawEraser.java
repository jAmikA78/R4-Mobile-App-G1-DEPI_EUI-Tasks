
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class DrawEraser implements ShapesInterface {
  private Color color;
  private boolean bold;
  private boolean dotted;
  private final ArrayList<Integer> xPoints = new ArrayList<>();
  private final ArrayList<Integer> yPoints = new ArrayList<>();

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
    xPoints.add(x2);
    yPoints.add(y2);
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
    for (int i = 1; i < xPoints.size(); i++) {
        g2d.drawLine(xPoints.get(i - 1), yPoints.get(i - 1), xPoints.get(i), yPoints.get(i));
    }

  }

}
