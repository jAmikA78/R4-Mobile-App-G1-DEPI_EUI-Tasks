/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import java.util.ArrayList;

public class PenDraw extends Shape{
    private ArrayList<Point> points;
    
    public PenDraw(Color color, boolean isDotted) {
        super(color, isDotted);
        this.points = new ArrayList<>();
    }
    public void addPoint(Point point) {
        points.add(point);
    }
    @Override
    public void draw(Graphics2D g2d) {
        if (points.size() < 2) return;
        
        g2d.setColor(color);
        if (isDotted) {
            float[] dashPattern = {3, 3};
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, 
                BasicStroke.JOIN_ROUND, 1.0f, dashPattern, 0));
        } else {
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        }
        
        Point prevPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            g2d.drawLine(prevPoint.x, prevPoint.y, currentPoint.x, currentPoint.y);
            prevPoint = currentPoint;
        }
    }
    @Override
    public boolean contains(Point p) {
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            
            double distance = pointToLineDistance(p, p1, p2);
            if (distance <= 3) {
                return true;
            }
        }
        return false;
    }
    
    private double pointToLineDistance(Point p, Point a, Point b) {
        double A = p.x - a.x;
        double B = p.y - a.y;
        double C = b.x - a.x;
        double D = b.y - a.y;

        double dot = A * C + B * D;
        double len_sq = C * C + D * D;
        double param = (len_sq != 0) ? dot / len_sq : -1;

        double xx, yy;

        if (param < 0) {
            xx = a.x;
            yy = a.y;
        } else if (param > 1) {
            xx = b.x;
            yy = b.y;
        } else {
            xx = a.x + param * C;
            yy = a.y + param * D;
        }

        double dx = p.x - xx;
        double dy = p.y - yy;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
