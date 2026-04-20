
package com.mycompany.paintbrush;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

 
public class PaintBrush extends JFrame {

    private final JLabel statusLabel = new JLabel("Ready");
    private final DrawPanel drawPanel = new DrawPanel();

    public PaintBrush() {
        setTitle("Paint Brush");
        setSize(980, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

         
        JPanel top = new JPanel(new GridLayout(3, 1));
 
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        JButton clearBtn = new JButton("Clear");
        JButton undoBtn  = new JButton("Undo");
        JButton saveBtn  = new JButton("Save");
        JButton loadBtn  = new JButton("Load");

        row1.add(new JLabel("Functions:"));
        row1.add(clearBtn);
        row1.add(undoBtn);
        row1.add(saveBtn);
        row1.add(loadBtn);

         
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        row2.add(new JLabel("Paint Mode:"));

        JRadioButton lineRB   = new JRadioButton("Line", true);
        JRadioButton rectRB   = new JRadioButton("Rectangle");
        JRadioButton ovalRB   = new JRadioButton("Oval");
        JRadioButton pencilRB = new JRadioButton("Pencil");
        JRadioButton eraserRB = new JRadioButton("Eraser");

        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(lineRB);
        modeGroup.add(rectRB);
        modeGroup.add(ovalRB);
        modeGroup.add(pencilRB);
        modeGroup.add(eraserRB);

        row2.add(lineRB);
        row2.add(rectRB);
        row2.add(ovalRB);
        row2.add(pencilRB);
        row2.add(eraserRB);

        JCheckBox fillCB = new JCheckBox("Fill");
        row2.add(Box.createHorizontalStrut(10));
        row2.add(fillCB);

        row2.add(Box.createHorizontalStrut(15));
        row2.add(new JLabel("Style:"));

        JRadioButton solidRB  = new JRadioButton("Solid", true);
        JRadioButton dottedRB = new JRadioButton("Dotted");
        ButtonGroup styleGroup = new ButtonGroup();
        styleGroup.add(solidRB);
        styleGroup.add(dottedRB);

        row2.add(solidRB);
        row2.add(dottedRB);

         
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        row3.add(new JLabel("Colors:"));

        JButton blackBtn = makeColorButton(Color.BLACK);
        JButton redBtn   = makeColorButton(Color.RED);
        JButton greenBtn = makeColorButton(new Color(0, 150, 0));
        JButton blueBtn  = makeColorButton(Color.BLUE);

         
        row3.add(blackBtn); row3.add(new JLabel("Black"));
        row3.add(redBtn);   row3.add(new JLabel("Red"));
        row3.add(greenBtn); row3.add(new JLabel("Green"));
        row3.add(blueBtn);  row3.add(new JLabel("Blue"));

        top.add(row1);
        top.add(row2);
        top.add(row3);

         
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusLabel.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        statusPanel.add(statusLabel, BorderLayout.CENTER);

         
        add(top, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

         
        clearBtn.addActionListener(e -> { drawPanel.clearAll(); refreshStatus(null); });
        undoBtn.addActionListener(e -> { drawPanel.undo(); refreshStatus(null); });

        saveBtn.addActionListener(e -> { drawPanel.saveToFile(this); refreshStatus(null); });
        loadBtn.addActionListener(e -> { drawPanel.loadFromFile(this); refreshStatus(null); });

        lineRB.addActionListener(e -> { drawPanel.setMode(DrawMode.LINE); refreshStatus(null); });
        rectRB.addActionListener(e -> { drawPanel.setMode(DrawMode.RECT); refreshStatus(null); });
        ovalRB.addActionListener(e -> { drawPanel.setMode(DrawMode.OVAL); refreshStatus(null); });
        pencilRB.addActionListener(e -> { drawPanel.setMode(DrawMode.PENCIL); refreshStatus(null); });
        eraserRB.addActionListener(e -> { drawPanel.setMode(DrawMode.ERASER); refreshStatus(null); });

        fillCB.addActionListener(e -> { drawPanel.setFill(fillCB.isSelected()); refreshStatus(null); });

        solidRB.addActionListener(e -> { drawPanel.setDotted(false); refreshStatus(null); });
        dottedRB.addActionListener(e -> { drawPanel.setDotted(true); refreshStatus(null); });

        blackBtn.addActionListener(e -> { drawPanel.setCurrentColor(Color.BLACK, "Black"); refreshStatus(null); });
        redBtn.addActionListener(e -> { drawPanel.setCurrentColor(Color.RED, "Red"); refreshStatus(null); });
        greenBtn.addActionListener(e -> { drawPanel.setCurrentColor(new Color(0, 150, 0), "Green"); refreshStatus(null); });
        blueBtn.addActionListener(e -> { drawPanel.setCurrentColor(Color.BLUE, "Blue"); refreshStatus(null); });

         
        drawPanel.setStatusCallback(this::refreshStatus);

        refreshStatus(null);
    }

    private JButton makeColorButton(Color c) {
        JButton b = new JButton();
        b.setPreferredSize(new Dimension(22, 22));
        b.setBackground(c);
        b.setOpaque(true);
        b.setBorderPainted(true);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    private void refreshStatus(String extra) {
        String base =
                "Mode: " + drawPanel.getModeName() +
                " | Color: " + drawPanel.getColorName() +
                " | Style: " + (drawPanel.isDotted() ? "Dotted" : "Solid") +
                " | Fill: " + (drawPanel.isFill() ? "Yes" : "No") +
                " | Shapes: " + drawPanel.getShapesCount();

        if (extra != null && !extra.isBlank()) base += " | " + extra;
        statusLabel.setText(base);
    }

    public static void correspondingMain(String[] args) {
        SwingUtilities.invokeLater(() -> new PaintBrush().setVisible(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaintBrush().setVisible(true));
    }
}

 
enum DrawMode { LINE, RECT, OVAL, PENCIL, ERASER }

interface StatusCallback {
    void update(String extra);
}

class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

    private final ArrayList<MyShape> shapes = new ArrayList<>();
    private MyShape preview = null;

    private DrawMode mode = DrawMode.LINE;
    private Color currentColor = Color.BLACK;
    private String colorName = "Black";

    private boolean dotted = false;
    private boolean fill = false;

    private int x1, y1, x2, y2;

    private StatusCallback statusCallback;

    public DrawPanel() {
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

     
    public String getModeName() { return mode.name(); }
    public String getColorName() { return colorName; }
    public boolean isDotted() { return dotted; }
    public boolean isFill() { return fill; }
    public int getShapesCount() { return shapes.size(); }

    public void setStatusCallback(StatusCallback cb) {
        this.statusCallback = cb;
    }

    private void pushStatus(String extra) {
        if (statusCallback != null) statusCallback.update(extra);
    }
 
    public void setMode(DrawMode mode) { this.mode = mode; }
    public void setCurrentColor(Color c, String name) { this.currentColor = c; this.colorName = name; }
    public void setDotted(boolean dotted) { this.dotted = dotted; }
    public void setFill(boolean fill) { this.fill = fill; }

    public void clearAll() {
        shapes.clear();
        preview = null;
        repaint();
    }

    public void undo() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
            repaint();
        }
    }

     
    public void saveToFile(Component parent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Drawing");
        int result = chooser.showSaveDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".paint")) {
                file = new File(file.getAbsolutePath() + ".paint");
            }

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(shapes);
                JOptionPane.showMessageDialog(parent, "Saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent, "Save error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(Component parent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Load Drawing");
        int result = chooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = in.readObject();
                if (obj instanceof ArrayList) {
                    shapes.clear();
                    shapes.addAll((ArrayList<MyShape>) obj);
                    preview = null;
                    repaint();
                    JOptionPane.showMessageDialog(parent, "Loaded successfully!");
                } else {
                    JOptionPane.showMessageDialog(parent, "Invalid file format!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(parent, "Load error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (MyShape s : shapes) s.draw(g2);
        if (preview != null) preview.draw(g2);
    }

     
    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        x2 = x1;
        y2 = y1;

        if (mode == DrawMode.PENCIL) {
            preview = new MyFreehand(currentColor, dotted);
            ((MyFreehand) preview).addPoint(x1, y1);
        } else if (mode == DrawMode.ERASER) {
            preview = new MyFreehand(getBackground(), false);
            ((MyFreehand) preview).setStrokeWidth(16);
            ((MyFreehand) preview).addPoint(x1, y1);
        } else {
            preview = createShape(x1, y1, x2, y2);
        }

        pushStatus("X=" + x1 + " Y=" + y1);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        if (mode == DrawMode.PENCIL || mode == DrawMode.ERASER) {
            ((MyFreehand) preview).addPoint(x2, y2);
        } else {
            preview = createShape(x1, y1, x2, y2);
        }

        pushStatus("X=" + x2 + " Y=" + y2);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (preview != null) {
            shapes.add(preview);
            preview = null;
            repaint();
        }
        pushStatus("Released");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        pushStatus("X=" + e.getX() + " Y=" + e.getY());
    }

    private MyShape createShape(int x1, int y1, int x2, int y2) {
        return switch (mode) {
            case LINE -> new MyLine(x1, y1, x2, y2, currentColor, dotted);
            case RECT -> new MyRect(x1, y1, x2, y2, currentColor, dotted, fill);
            case OVAL -> new MyOval(x1, y1, x2, y2, currentColor, dotted, fill);
            default -> null;
        };
    }

     
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}

 
abstract class MyShape implements Serializable {
    private static final long serialVersionUID = 1L;

    protected int rgb;
    protected boolean dotted;

    protected MyShape(Color color, boolean dotted) {
        this.rgb = color.getRGB();
        this.dotted = dotted;
    }

    protected Color color() { return new Color(rgb, true); }

    protected Stroke stroke(int width) {
        if (dotted) {
            return new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                    0, new float[]{6, 6}, 0);
        }
        return new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    }

    public abstract void draw(Graphics2D g2);
}

class MyLine extends MyShape {
    private static final long serialVersionUID = 1L;
    private final int x1, y1, x2, y2;

    public MyLine(int x1, int y1, int x2, int y2, Color color, boolean dotted) {
        super(color, dotted);
        this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color());
        g2.setStroke(stroke(2));
        g2.drawLine(x1, y1, x2, y2);
    }
}

class MyRect extends MyShape {
    private static final long serialVersionUID = 1L;
    private final int x, y, w, h;
    private final boolean filled;

    public MyRect(int x1, int y1, int x2, int y2, Color color, boolean dotted, boolean filled) {
        super(color, dotted);
        this.filled = filled;

        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        w = Math.abs(x2 - x1);
        h = Math.abs(y2 - y1);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color());
        if (filled) g2.fillRect(x, y, w, h);

        g2.setStroke(stroke(2));
        g2.drawRect(x, y, w, h);
    }
}

class MyOval extends MyShape {
    private static final long serialVersionUID = 1L;
    private final int x, y, w, h;
    private final boolean filled;

    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean dotted, boolean filled) {
        super(color, dotted);
        this.filled = filled;

        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        w = Math.abs(x2 - x1);
        h = Math.abs(y2 - y1);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color());
        if (filled) g2.fillOval(x, y, w, h);

        g2.setStroke(stroke(2));
        g2.drawOval(x, y, w, h);
    }
}

class MyFreehand extends MyShape {
    private static final long serialVersionUID = 1L;

    private final ArrayList<SPoint> points = new ArrayList<>();
    private int strokeWidth = 3;

    public MyFreehand(Color color, boolean dotted) {
        super(color, dotted);
    }

    public void addPoint(int x, int y) {
        points.add(new SPoint(x, y));
    }

    public void setStrokeWidth(int w) {
        strokeWidth = w;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color());
        g2.setStroke(stroke(strokeWidth));

        for (int i = 1; i < points.size(); i++) {
            SPoint p1 = points.get(i - 1);
            SPoint p2 = points.get(i);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}

class SPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    int x, y;
    SPoint(int x, int y) { this.x = x; this.y = y; }
}
