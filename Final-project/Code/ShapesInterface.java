import java.awt.Color;
import java.awt.Graphics;


public interface  ShapesInterface {
  void setColor(Color color);  
  void setBold(boolean bold);
  void setDotted(boolean dotted);
  void paintComponent(Graphics g);

  void setCoordinates(int x1, int y1, int x2, int y2);

}