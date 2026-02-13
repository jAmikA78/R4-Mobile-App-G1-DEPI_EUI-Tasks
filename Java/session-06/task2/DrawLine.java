/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
public class DrawLine extends JFrame{

    int start1, start2, end1, end2;
    boolean drawing = false;
    
    public DrawLine() {
        setTitle("Draw Line");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(start1, start2, end1, end2);
            }
        };
        
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                start1 = end1 = e.getX();
                start2 = end2 = e.getY();
                drawing = true;
            }
            public void mouseReleased(MouseEvent e) {
                drawing = false;
            }
        });
        
        panel.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (drawing) {
                    end1 = e.getX();
                    end2 = e.getY();
                    panel.repaint();
                }
            }
        });
        
        add(panel);
    }
    
    public static void main(String[] args) {
        new DrawLine().setVisible(true);
    }
}
