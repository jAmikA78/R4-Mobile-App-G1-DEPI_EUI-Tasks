import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public abstract class Shapes {
    
    protected int x=0 ;
    protected int y=0 ;
    protected int x2=0 ;
    protected int y2=0 ;
    protected Color color;
    protected String Mode= "";

    public  void setX(int X){if(X>=0){x=X;}}
    public  void setY(int Y){if(y>=0){y=Y;}}
    public  void setX2(int X){if(X>=0){x2=X;}}
    public  void setY2(int Y){if(Y>=0){y2=Y;}}

    public  int getX(){return x;}
    public  int getY(){return y;}
    public  int getX2(){return x2;}
    public  int getY2(){return y2;}
    
    public abstract void paint(Graphics g);


}

class  line extends Shapes{

    public line(Color c,String m){
        color = c;
        Mode = m;
    }
    
    @Override
    public void paint(Graphics g){
          
      if(Mode.equals("dotted")){
          Graphics2D g2 = (Graphics2D) g;
          g2.setColor(color);
          BasicStroke dot = new BasicStroke(0.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f,new float[]{10.0f,5.0f},5.0f);
          g2.setStroke(dot);
          g2.drawLine(x,y,x2,y2);
          g2.setStroke(new BasicStroke(0));
        }else{
          g.setColor(color);
          g.drawLine(x,y,x2,y2);
        }
    }
    
}

class  rectangle extends Shapes{

    public rectangle(Color c,String m){
        color = c;
        Mode=m;
    }
    
    @Override
    public void paint(Graphics g){
    
      int X = Math.min(x, x2);
      int Y = Math.min(y, y2);
      int width =Math.abs(x2-x) ;
      int hight =Math.abs(y2-y) ;
    
      if(Mode.equals("dotted")){
          Graphics2D g2 = (Graphics2D) g;
          g2.setColor(color);
          BasicStroke dot = new BasicStroke(0.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f,new float[]{10.0f,5.0f},5.0f);
          g2.setStroke(dot);
          g2.drawRect(X, Y, width, hight);
          g2.setStroke(new BasicStroke(0));
      }else{
        g.setColor(color);
        g.drawRect(X, Y, width, hight);
      }
    }
}

class  oval extends Shapes{

    public oval(Color c,String m){
        color = c;
        Mode=m;
    }
    
    @Override
    public void paint(Graphics g){
        
        int X = Math.min(x, x2);
        int Y = Math.min(y, y2);
        int width =Math.abs(x2-x);
        int hight =Math.abs(y2-y);        

      if(Mode.equals("dotted")){
          Graphics2D g2 = (Graphics2D) g;
          g2.setColor(color);
          BasicStroke dot = new BasicStroke(0.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f,new float[]{10.0f,5.0f},5.0f);
          g2.setStroke(dot);
          g2.drawOval(X, Y, width, hight);
          g2.setStroke(new BasicStroke(0));
      }else{        
        g.setColor(color);
        g.drawOval(X, Y, width, hight);
      }
    }
}

class pencil extends Shapes{

    public pencil(Color c,String m){
        color = c;
        Mode=m;
    }
    
    ArrayList<Integer> xs = new ArrayList<>();
    ArrayList<Integer> ys = new ArrayList<>();
    
    @Override
    public void setX(int X){
        if(X >= 0){
            xs.add(X);
        }
    }
    @Override
    public void setY(int Y){
        if(Y>=0){
            ys.add(Y);
        }
    }
    @Override
    public void setX2(int X){
        if(X >= 0){
            xs.add(X);
        }
    }
    @Override
    public void setY2(int Y){
        if(Y>=0){
            ys.add(Y);
        }
    }
    @Override
    public void paint(Graphics g){

        int[] X = new int[xs.size()];
        int[] Y = new int[ys.size()];
        int t = xs.size();

        for(int i=0; i < xs.size(); i++){
            X[i]=xs.get(i);
        }
        for(int i=0; i < ys.size(); i++){
            Y[i]=ys.get(i);
        }
        
       if(Mode.equals("dotted")){
          Graphics2D g2 = (Graphics2D) g;
          g2.setColor(color);
          BasicStroke dot = new BasicStroke(0.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f,new float[]{10.0f,5.0f},5.0f);
          g2.setStroke(dot);
          g2.drawPolyline(X, Y, t);
          g2.setStroke(new BasicStroke(0));
      }else{        
        g.setColor(color);
        g.drawPolyline(X, Y, t);
      }       
  }
}
class erase extends pencil{
    
  public erase(Color c,String m){
    super(c,m);
  }
  
  @Override
  public void paint(Graphics g) {

    int[] X = new int[xs.size()];
    int[] Y = new int[ys.size()];
    int t = xs.size();

    for(int i=0; i < xs.size(); i++){
        X[i]=xs.get(i);
    }
    for(int i=0; i < ys.size(); i++){
        Y[i]=ys.get(i);
    }
    
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(10));
    g2.drawPolyline(X, Y, t);
    g2.setStroke(new BasicStroke(0));
  
  } 
}
