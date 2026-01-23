
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class Shape {
    protected Color color;
    protected int x1, y1;
    protected int x2, y2;
    protected boolean isDotted;
    protected int thickness;
    public Shape(Color color, int x1, int y1, int x2, int y2, boolean isDotted) {
        this(color, x1, y1, x2, y2, isDotted, 1);
    }
    public Shape(Color color, int x1, int y1, int x2, int y2, boolean isDotted, int thickness) {
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.isDotted = isDotted;
        this.thickness = thickness;
    }
    
    public abstract void draw(Graphics g);
}

class Line extends Shape{
    public Line(Color color, int x1, int y1, int x2, int y2, boolean isDotted) {
        super(color, x1, y1, x2, y2, isDotted);
    }
    public Line(Color color, int x1, int y1, int x2, int y2, boolean isDotted,int thickness){
        super(color, x1, y1, x2, y2, isDotted, thickness);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g.setColor(color);
        g2.setStroke(new BasicStroke(thickness));
        g.drawLine(x1, y1, x2, y2);
    }
}

class Rectangle extends Shape{
    public Rectangle(Color color, int x1, int y1, int x2, int y2, boolean isDotted) {
        super(color, x1, y1, x2, y2, isDotted);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int w  = Math.abs(x2 - x1);
        int h = Math.abs(y2 - y1);        
        
        if(isDotted){
            g.drawRect(x, y, w, h);
            
        }else{
            g.fillRect(x, y, w, h);
        }
    }
}

class Oval extends Shape{
    public Oval(Color color, int x1, int y1, int x2, int y2, boolean isDotted) {
        super(color, x1, y1, x2, y2, isDotted);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int w  = Math.abs(x2 - x1);
        int h = Math.abs(y2 - y1);
        
        if(isDotted){
            g.drawOval(x, y, w, h);
        }else{
            g.fillOval(x, y, w, h);
        }
    }
}

class Pencil extends Shape {

    private ArrayList<Line> lines;
    private int x2, y2;

    public Pencil(Color color, int x1, int y1) {
        super(color, x1, y1, x1, y1, true);
        lines = new ArrayList<>();
        x2 = x1;
        y2 = y1;
    }
    public Pencil(Color color, int x1, int y1,int thickness){
        super(color, x1, y1, x1, y1, true, thickness);
        lines = new ArrayList<>();
        x2 = x1;
        y2 = y1;

    }

    public void addPoint(int x, int y) {
        lines.add(new Line(color, x2, y2, x, y, true,thickness));
        x2 = x;
        y2 = y;
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i<lines.size(); i++) {
            lines.get(i).draw(g);
        }
    }
}

class Eraser extends Shape{
    public Eraser(Color color, int x1, int y1, int x2, int y2, boolean isDotted) {
        super(color, x1, y1, x2, y2, isDotted);
    }

    @Override
    public void draw(Graphics g) {    }
}