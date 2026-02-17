
package com.mycompany.paintproject;
import java.awt.*;
public class OvalArea extends GraphicShape {
    

    private int xPos, yPos, radiusW, radiusH;

    public OvalArea(int x, int y, int w, int h, Color c, boolean solid) {
        super(c, solid);
        this.xPos = x; this.yPos = y; 
        this.radiusW = w; this.radiusH = h;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(strokeColor);
        if (isSolid) {
            g.fillOval(xPos, yPos, radiusW, radiusH);
        } else {
            g.drawOval(xPos, yPos, radiusW, radiusH);
        }
    }
}

