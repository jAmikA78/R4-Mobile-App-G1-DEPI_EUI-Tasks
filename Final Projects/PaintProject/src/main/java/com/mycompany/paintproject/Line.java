
package com.mycompany.paintproject;
import java.awt.*;
public class Line extends GraphicShape{
  
    private int startX, startY, endX, endY;

    public Line(int x1, int y1, int x2, int y2, Color c) {
        super(c, false); 
        this.startX = x1; this.startY = y1; this.endX = x2; this.endY = y2;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(strokeColor);
        g.drawLine(startX, startY, endX, endY);
    }
}

