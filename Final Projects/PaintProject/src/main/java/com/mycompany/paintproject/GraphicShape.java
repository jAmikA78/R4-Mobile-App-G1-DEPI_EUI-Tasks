
package com.mycompany.paintproject;


import java.awt.*;

public abstract class GraphicShape {
    protected Color strokeColor; 
    protected boolean isSolid;   

    public GraphicShape(Color color, boolean solid) {
        this.strokeColor = color;
        this.isSolid = solid;
    }

    
    public abstract void render(Graphics g);
}