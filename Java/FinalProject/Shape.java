/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Serializable{
    protected Color color;
    protected boolean isDotted;
    
    public Shape(Color color, boolean isDotted) {
        this.color = color;
        this.isDotted = isDotted;
    }
    public abstract void draw(Graphics2D g2d);
    public abstract boolean contains(Point p);
}
