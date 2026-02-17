
package com.mycompany.paintproject;

import java.awt.*;
public class BoxArea extends GraphicShape  {
    
    private int xCoord, yCoord, boxWidth, boxHeight;

    public BoxArea(int x, int y, int w, int h, Color c, boolean solid) {
        super(c, solid);
        this.xCoord = x; this.yCoord = y; 
        this.boxWidth = w; this.boxHeight = h;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(strokeColor);
        if (isSolid) {
            g.fillRect(xCoord, yCoord, boxWidth, boxHeight);
        } else {
            g.drawRect(xCoord, yCoord, boxWidth, boxHeight);
        }
    }
}

