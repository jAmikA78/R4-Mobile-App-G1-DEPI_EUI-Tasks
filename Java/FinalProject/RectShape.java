/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectShape extends Shape{
    private Point startPoint;
    private Point endPoint;
    
    public RectShape(Point start, Point end, Color color, boolean isDotted) {
        super(color, isDotted);
        this.startPoint = start;
        this.endPoint = end;
    }
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        if (isDotted) {
            float[] dashPattern = {5, 5};
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, 
                BasicStroke.JOIN_ROUND, 1.0f, dashPattern, 0));
        } else {
            g2d.setStroke(new BasicStroke(2));
        }
        
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        
        g2d.drawRect(x, y, width, height);
    }
    @Override
    public boolean contains(Point p) {
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        
        Rectangle2D rect = new Rectangle2D.Float(x - 3, y - 3, 
            width + 6, height + 6);
        Rectangle2D innerRect = new Rectangle2D.Float(x + 2, y + 2, 
            width - 4, height - 4);
        
        return rect.contains(p) && !innerRect.contains(p);
    }
}
