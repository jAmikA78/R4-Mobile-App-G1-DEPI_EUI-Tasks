import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class PaintGUI extends JFrame {

    static ArrayList<ShapesInterface> shapes = new ArrayList<>();
    static ShapesInterface shape;
    static String shapetype = "line";
    static boolean bold = false;
    static boolean dotted = false;
    static Color color = Color.BLACK;

    JLabel actionsLabel = new JLabel("Actions:");
    JButton clearBtn = new JButton("Clear");
    JButton undoBtn = new JButton("Undo");

    JLabel drawLabel = new JLabel("Draw:");
    JButton lineBtn = new JButton("Line");
    JButton ovalBtn = new JButton("Oval");
    JButton rectBtn = new JButton("Rectangle");
    JButton dottedBtn = new JButton("Dotted");
    JButton boldBtn = new JButton("Bold");
    JButton pencilBtn = new JButton("Pencil");
    JButton eraserBtn = new JButton("Eraser");

    JLabel colorLabel = new JLabel("Colors:");
    JButton blackBtn = new JButton("Black");
    JButton redBtn = new JButton("Red");
    JButton greenBtn = new JButton("Green");
    JButton blueBtn = new JButton("Blue");

    public PaintGUI() {
        super("شخبط شخابيط لغبط لغابيط مسك الالوان ورسم ع الحيط");

        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        topPanel.setBackground(new Color(245, 245, 245));
        add(topPanel, BorderLayout.NORTH);

        JPanel canvas = new JPanel();
        add(canvas, BorderLayout.CENTER);

        topPanel.add(actionsLabel);
        topPanel.add(clearBtn);
        clearBtn.addActionListener(e -> {
            clearCanvas();
        });
        topPanel.add(undoBtn);
        undoBtn.addActionListener(e -> {
            undoLastAction();
        });

        topPanel.add(drawLabel);
        topPanel.add(lineBtn);
        lineBtn.addActionListener(e -> {
            shapetype = "line";
        });
        topPanel.add(ovalBtn);
        ovalBtn.addActionListener(e -> {
            shapetype = "oval";
        });
        topPanel.add(rectBtn);
        rectBtn.addActionListener(e -> {
            shapetype = "rect";
        });
        topPanel.add(pencilBtn);
        pencilBtn.addActionListener(e -> {
            shapetype = "pencil";
        });
        topPanel.add(eraserBtn);
        eraserBtn.addActionListener(e -> {
            shapetype = "eraser";
        });
        topPanel.add(dottedBtn);
        dottedBtn.addActionListener(e -> {
            dotted = !dotted;
            if (dotted)
                bold = false;
        });
        topPanel.add(boldBtn);
        boldBtn.addActionListener(e -> {
            bold = !bold;
            if (bold)
                dotted = false; // it causing an logical error if both are true
        });

        topPanel.add(colorLabel);
        topPanel.add(blackBtn);
        blackBtn.addActionListener(e -> {
            color = Color.BLACK;
        });
        topPanel.add(redBtn);
        redBtn.addActionListener(e -> {
            color = Color.RED;
        });
        topPanel.add(greenBtn);
        greenBtn.addActionListener(e -> {
            color = new Color(0, 140, 0);
        });
        topPanel.add(blueBtn);
        blueBtn.addActionListener(e -> {
            color = Color.BLUE;
        });

        makeColorButton(blackBtn, Color.BLACK);
        makeColorButton(redBtn, Color.RED);
        makeColorButton(greenBtn, new Color(0, 140, 0));
        makeColorButton(blueBtn, Color.BLUE);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);

        add(new DrawPanel());
    }

    private static class DrawPanel extends JPanel {
        private int x1, y1, x2, y2;
        private boolean dragging = false;

        public DrawPanel() {
            MouseAdapter mouseHandler = new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    x1 = e.getX();
                    y1 = e.getY();
                    x2 = x1;
                    y2 = y1;
                    dragging = true;
                    switch (shapetype) {
                        case "line" -> {
                            shape = new DrawLine();
                            shape.setCoordinates(x1, y1, x2, y2);
                            shape.setColor(color);
                            shape.setBold(bold);
                            shape.setDotted(dotted);
                        }
                        case "oval" -> {
                            shape = new DrawOval();
                            shape.setCoordinates(x1, y1, x2, y2);
                            shape.setColor(color);
                            shape.setBold(bold);
                            shape.setDotted(dotted);
                        }
                        case "rect" -> {
                            shape = new DrawRect();
                            shape.setCoordinates(x1, y1, x2, y2);
                            shape.setColor(color);
                            shape.setBold(bold);
                            shape.setDotted(dotted);
                        }
                        case "pencil" -> {
                            shape = new DrawPencil();
                            shape.setCoordinates(x1, y1, x2, y2);
                            shape.setColor(color);
                            shape.setBold(bold);
                            shape.setDotted(dotted);
                        }
                        case "eraser" -> {
                            shape = new DrawPencil();
                            shape.setCoordinates(x1, y1, x2, y2);
                            shape.setColor(new Color(245, 245, 245));
                            shape.setBold(bold);

                        }
                        default -> {
                        }
                    }
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if (dragging) {
                        x2 = e.getX();
                        y2 = e.getY();
                        shape.setCoordinates(x1, y1, x2, y2);
                        repaint();
                        shape.paintComponent(getGraphics());
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    dragging = false;
                    shape.setCoordinates(x1, y1, x2, y2);

                    saveShape();
                    repaint();
                }
            };

            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (ShapesInterface s : shapes) {
                s.paintComponent(g);
            }
            if (dragging && shape != null) {
                shape.paintComponent(g);
            }
        }
    }

    private void makeColorButton(JButton btn, Color c) {
        btn.setBackground(c);
        btn.setOpaque(true);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)));
        btn.setFocusPainted(false);
    }

    private void clearCanvas() {
        shapes.clear();
        repaint();
    }

    private void undoLastAction() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
            repaint();
        }
    }

    private static void saveShape() {

        shapes.add(shape);
    }
}