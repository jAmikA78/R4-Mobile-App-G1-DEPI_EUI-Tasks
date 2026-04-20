package com.mycompany.drawsingleline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawSingleLine extends JFrame {

    public DrawSingleLine() {
        setTitle("Draw Line");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new DrawPanel());
    }

    static class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

        private int x1, y1, x2, y2;
        private boolean hasLine = false;

        public DrawPanel() {
            setBackground(Color.WHITE);
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (hasLine) {
                g.setColor(Color.BLUE);
                g.drawLine(x1, y1, x2, y2);
            }
        }

         
        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
            x2 = x1;
            y2 = y1;
            hasLine = true;
            repaint();
        }

         
        @Override
        public void mouseDragged(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }

         
        @Override
        public void mouseReleased(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }

         
        @Override public void mouseMoved(MouseEvent e) {}
        @Override public void mouseClicked(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawSingleLine().setVisible(true));
    }
}
