package org.example;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Main extends JFrame implements MouseListener,MouseMotionListener {

    int x1,y1;
    int x2,y2;
    public Main() {
        setSize(600,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        addMouseMotionListener(this);

    }
     @Override
     public void paint(Graphics g){
        super.paint(g);
        g.drawLine(x1,y1,x2,y2);
    }  @Override
public void mousePressed(MouseEvent e){
        x1=e.getX();
        y1= e.getY();
    } @Override
    public void mouseDragged(MouseEvent e){
        x2=e.getX();
        y2= e.getY();
        repaint();}
    public void mouseReleased(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}


    public static void main(String[] args) { new
    Main();}}
