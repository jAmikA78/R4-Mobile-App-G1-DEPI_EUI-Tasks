/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.drawlamp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Amir Fahmy 7
 */
class Lamp extends JPanel {

    public void paint(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        g.drawRect(100, 350, 200, 15);
        g.drawLine(200, 280, 180, 350);
        g.drawLine(200, 280, 220, 350);

        int[] xPoints = {120, 280, 320, 80};
        int[] yPoints = {110, 110, 280, 280};
        g.setColor(Color.WHITE);
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 4);

        g.setColor(new Color(253, 253, 170));
        g.fillOval(120, 95, 160, 35);
        g.setColor(Color.BLACK);
        g.drawOval(120, 95, 160, 35);

        g.setColor(new Color(235, 235, 150));

        g.fillOval(110, 170, 40, 50);
        g.setColor(Color.BLACK);
        g.drawOval(110, 170, 40, 50);

        g.setColor(new Color(235, 235, 150));
        g.fillOval(175, 150, 60, 90);
        g.setColor(Color.BLACK);
        g.drawOval(175, 150, 60, 90);

        g.setColor(new Color(235, 235, 150));
        g.fillOval(255, 170, 40, 50);
        g.setColor(Color.BLACK);
        g.drawOval(255, 170, 40, 50);

        g.drawArc(80, 265, 240, 30, 180, 180);
        g.setColor(Color.WHITE);
        g.fillArc(80, 265, 240, 30, 180, 180);
    }
}

public class DrawLamp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Lamp");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Lamp());
        frame.setVisible(true);
    }
}
