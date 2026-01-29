/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Shape{
    private Point startPoint;
    private Point endPoint;
    
    public Line(Point start, Point end, Color color, boolean isDotted) {
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
        g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
    @Override
    public boolean contains(Point p) {
        Line2D line = new Line2D.Float(startPoint, endPoint);
        return line.ptSegDist(p) <= 3;
    }
}
