/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.paint;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


 class PaintBrush extends JFrame {

    DrawPanel panel;

    public PaintBrush() {
        panel = new DrawPanel();

        JPanel top = new JPanel();

        JButton undoBtn = new JButton("Undo");
        undoBtn.addActionListener(e -> panel.undo());

        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> panel.clear());

        top.add(new JLabel("Functions:"));
        top.add(clearBtn);
        top.add(undoBtn);

        JRadioButton rbLine = new JRadioButton("Line");
        JRadioButton rbRect = new JRadioButton("Rect");
        JRadioButton rbOval = new JRadioButton("Oval");
        JRadioButton rbPencil = new JRadioButton("Pencil");
        JRadioButton rbEraser = new JRadioButton("Eraser");

        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(rbLine); shapeGroup.add(rbRect); shapeGroup.add(rbOval);
        shapeGroup.add(rbPencil); shapeGroup.add(rbEraser);

        rbLine.setSelected(true);
        panel.currentShape = "Line";

        ActionListener shapeListener = e -> panel.currentShape = ((JRadioButton)e.getSource()).getText();
        rbLine.addActionListener(shapeListener);
        rbRect.addActionListener(shapeListener);
        rbOval.addActionListener(shapeListener);
        rbPencil.addActionListener(shapeListener);
        rbEraser.addActionListener(shapeListener);

        JPanel shapePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        shapePanel.add(rbLine); shapePanel.add(rbRect); shapePanel.add(rbOval);
        shapePanel.add(rbPencil); shapePanel.add(rbEraser);

        top.add(new JLabel("Paint Mode:"));
        top.add(shapePanel);

        JCheckBox solidBox = new JCheckBox("Solid", true);
        JCheckBox dottedBox = new JCheckBox("Dotted");

        solidBox.addActionListener(e -> panel.solidEnabled = solidBox.isSelected());
        dottedBox.addActionListener(e -> panel.dottedEnabled = dottedBox.isSelected());

        top.add(solidBox); top.add(dottedBox);

        JButton blackBtn = new JButton("Black"); blackBtn.setBackground(Color.BLACK); blackBtn.setForeground(Color.WHITE);
        JButton redBtn = new JButton("Red"); redBtn.setBackground(Color.RED);
        JButton greenBtn = new JButton("Green"); greenBtn.setBackground(Color.GREEN);
        JButton blueBtn = new JButton("Blue"); blueBtn.setBackground(Color.BLUE);

        blackBtn.addActionListener(e -> panel.currentColor = Color.BLACK);
        redBtn.addActionListener(e -> panel.currentColor = Color.RED);
        greenBtn.addActionListener(e -> panel.currentColor = Color.GREEN);
        blueBtn.addActionListener(e -> panel.currentColor = Color.BLUE);

        top.add(new JLabel("Colors:"));
        top.add(blackBtn); top.add(redBtn); top.add(greenBtn); top.add(blueBtn);

        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setTitle("Paint Brush");
        setSize(2000,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
   

    class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

        ArrayList<MyShape> shapes = new ArrayList<>();
        int x1, y1, x2, y2;
        String currentShape = "Line";
        Color currentColor = Color.BLACK;
        ArrayList<Point> penPoints;

        boolean solidEnabled = true;
        boolean dottedEnabled = false;

        DrawPanel() {
            setBackground(Color.WHITE);
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (MyShape s : shapes) s.draw(g, solidEnabled, dottedEnabled);
        }

        public void mousePressed(MouseEvent e) {
            x1 = e.getX(); y1 = e.getY();
            if (currentShape.equals("Pencil")) {
                penPoints = new ArrayList<>();
                penPoints.add(new Point(x1, y1));
            }
        }

        public void mouseDragged(MouseEvent e) {
            x2 = e.getX(); y2 = e.getY();
            if (currentShape.equals("Pencil")) {
                penPoints.add(new Point(x2, y2));
                repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {
            x2 = e.getX(); y2 = e.getY();
            MyShape s = null;

            switch(currentShape){
                case "Line": s = new LineShape(x1,y1,x2,y2,currentColor); break;
                case "Rect": s = new RectShape(x1,y1,x2,y2,currentColor); break;
                case "Oval": s = new OvalShape(x1,y1,x2,y2,currentColor); break;
                case "Pencil": if(penPoints.size()>1) s = new PenShape(penPoints,currentColor); break;
                case "Eraser": s = new EraserShape(x1,y1,x2,y2); break;
            }

            if(s != null) shapes.add(s);
            repaint();
        }

        void undo(){ if(!shapes.isEmpty()) shapes.remove(shapes.size()-1); repaint(); }
        void clear(){ shapes.clear(); repaint(); }

        public void mouseClicked(MouseEvent e) {} 
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {} 
        public void mouseMoved(MouseEvent e) {}
    }

    abstract class MyShape {
        abstract void draw(Graphics g, boolean solidEnabled, boolean dottedEnabled);
    }

    class LineShape extends MyShape {
        int x1,y1,x2,y2; Color c;
        LineShape(int a,int b,int c1,int d,Color c){ x1=a;y1=b;x2=c1;y2=d; this.c=c; }
        void draw(Graphics g, boolean solidEnabled, boolean dottedEnabled){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(c);
            if(dottedEnabled && !solidEnabled) g2.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,new float[]{5,5},0));
            else g2.setStroke(new BasicStroke(2));
            g2.drawLine(x1,y1,x2,y2);
        }
    }

    class RectShape extends MyShape {
        int x1,y1,x2,y2; Color c;
        RectShape(int a,int b,int c1,int d,Color c){x1=a;y1=b;x2=c1;y2=d; this.c=c;}
        void draw(Graphics g, boolean solidEnabled, boolean dottedEnabled){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(c);
            if(dottedEnabled && !solidEnabled) g2.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,new float[]{5,5},0));
            else g2.setStroke(new BasicStroke(2));
            g2.drawRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
        }
    }

    class OvalShape extends MyShape {
        int x1,y1,x2,y2; Color c;
        OvalShape(int a,int b,int c1,int d,Color c){x1=a;y1=b;x2=c1;y2=d; this.c=c;}
        void draw(Graphics g, boolean solidEnabled, boolean dottedEnabled){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(c);
            if(dottedEnabled && !solidEnabled) g2.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,new float[]{5,5},0));
            else g2.setStroke(new BasicStroke(2));
            g2.drawOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
        }
    }

    class PenShape extends MyShape {
        ArrayList<Point> pts; Color c;
        PenShape(ArrayList<Point> p, Color c){ pts=p; this.c=c; }
        void draw(Graphics g, boolean solidEnabled, boolean dottedEnabled){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(c);
            if(dottedEnabled && !solidEnabled) g2.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,0,new float[]{3,3},0));
            else g2.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
            for(int i=0;i<pts.size()-1;i++)
                g2.drawLine(pts.get(i).x, pts.get(i).y, pts.get(i+1).x, pts.get(i+1).y);
        }
    }

    class EraserShape extends MyShape {
        int x1,y1,x2,y2;
        EraserShape(int a,int b,int c,int d){x1=a;y1=b;x2=c;y2=d;}
        void draw(Graphics g, boolean solidEnabled, boolean dottedEnabled){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(10,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
            g2.drawLine(x1,y1,x2,y2);
        }
    }
    class Paint{
 public static void main(String[] args) {
        new PaintBrush();
    }
  }