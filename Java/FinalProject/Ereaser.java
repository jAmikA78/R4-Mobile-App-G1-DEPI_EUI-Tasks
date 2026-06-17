/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;

public class Ereaser {
    private int eraserSize;
    
    public Ereaser() {
        this.eraserSize = 10;
    }
    public void drawEraser(Graphics2D g2d, Point point) {
        if (point != null) {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(point.x - eraserSize/2, point.y - eraserSize/2, eraserSize, eraserSize);
            
            g2d.setColor(Color.GRAY);
            g2d.drawRect(point.x - eraserSize/2, point.y - eraserSize/2, eraserSize, eraserSize);
        }
    }
    public boolean eraseAtPoint(Point p, java.util.List<Shape> shapes) {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i).contains(p)) {
                shapes.remove(i);
                return true;
            }
        }
        return false;
    }
}
