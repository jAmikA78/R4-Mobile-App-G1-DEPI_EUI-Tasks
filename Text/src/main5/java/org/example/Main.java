package org.example;

import javax.swing.JFrame;
import java.awt.*;


public class Main extends JFrame{
    int x=500;
    String text = "Hello instructor Hello java";
    public Main(){
        setSize(600,300);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Thread(() -> {
            while (true) {
                x -= 5;
                if (x < -100) {
                    x = getWidth();
                }
                repaint();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
        }).start();
    }


@Override
public void paint(Graphics g){
    super.paint(g);
    g.drawString(text,x,150);
}

public static void main(String[] args)
{  new Main();}
}


