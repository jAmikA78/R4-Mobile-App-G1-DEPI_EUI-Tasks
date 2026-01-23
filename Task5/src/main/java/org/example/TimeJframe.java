package org.example;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.JFrame;
public class TimeJframe extends JFrame {
    Date date;
    MyThread thread;
    public TimeJframe() {
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thread = new MyThread();
        thread.start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        date = new Date();
        g.drawString(date.toString(), 100, 100);
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    repaint();
                } catch (InterruptedException e) {
                }
            }
        }
    }
public static void main(String[] args) {
    new TimeJframe();
}
}

