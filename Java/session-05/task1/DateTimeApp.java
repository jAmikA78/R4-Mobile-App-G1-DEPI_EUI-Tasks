/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mohammedtaysser
 */
import java.awt.*;
import javax.swing.JFrame;
import java.util.Date;

public class DateTimeApp extends JFrame{
    
    Thread tH;
    Date d;
    
    public DateTimeApp() {
        
        this.setTitle("Date Time App");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        d = new Date();
        g.setColor(Color.black);
        g.drawString(d.toString(), 100, 100);
    }

 public static void main(String[] args) {
        new DateTimeApp();
    }
 }
