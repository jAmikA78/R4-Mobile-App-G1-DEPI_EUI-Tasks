import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;

public class PaintBrush extends JFrame{
    private JPanel drawingPanel;
    private JPanel controlPanel;
    private ArrayList<Shape> shapes;
    private Stack<ArrayList<Shape>> undoStack;
    private Shape currentShape;
    private Point startPoint;
    private Point endPoint;
    private PenDraw currentPencilDrawing;
    private String currentTool = "Pencil";
    private Color currentColor = Color.BLACK;
    private boolean isDotted = false;
    private boolean isErasing = false;
    private Ereaser eraser;
    private Point eraserPoint;
    private JButton lineButton, rectButton, ovalButton, pencilButton, eraserButton;
    private JButton blackButton, redButton, greenButton, blueButton, yellowButton;
    private JButton clearButton, undoButton;
    private JCheckBox dottedCheckBox;
    
    public PaintBrush() {
        shapes = new ArrayList<>();
        undoStack = new Stack<>();
        eraser = new Ereaser();
        setupFrame();
        setupControlPanel();
        setupDrawingPanel();
        setupListeners();
        saveState();
    }
    private void setupFrame() {
        setTitle("Paint Brush");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }
    private void setupControlPanel() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 6));
        controlPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel shapeLabel = new JLabel("Paint Mode:");
        
        lineButton = createToolButton("Line", "Line");
        rectButton = createToolButton("Rectangle", "Rectangle");
        ovalButton = createToolButton("Oval", "Oval");
        pencilButton = createToolButton("Pencil", "Pencil");
        eraserButton = createToolButton("Eraser", "Eraser");
        
        JLabel colorLabel = new JLabel("Colors:");
        blackButton = createColorButton("Black", Color.BLACK);
        redButton = createColorButton("Red", Color.RED);
        greenButton = createColorButton("Green", Color.GREEN.darker());
        blueButton = createColorButton("Blue", Color.BLUE);
        yellowButton = createColorButton("Yellow", Color.YELLOW);
        
        dottedCheckBox = new JCheckBox("Dotted");
        dottedCheckBox.setBackground(Color.LIGHT_GRAY);
        
        undoButton = createActionButton("Undo", new Color(100, 100, 100));
        clearButton = createActionButton("Clear All", new Color(150, 50, 50));
        
        controlPanel.add(shapeLabel);
        controlPanel.add(lineButton);
        controlPanel.add(rectButton);
        controlPanel.add(ovalButton);
        controlPanel.add(pencilButton);
        controlPanel.add(eraserButton);
        controlPanel.add(Box.createHorizontalStrut(10));
        controlPanel.add(colorLabel);
        controlPanel.add(blackButton);
        controlPanel.add(redButton);
        controlPanel.add(greenButton);
        controlPanel.add(blueButton);
        controlPanel.add(yellowButton);
        controlPanel.add(Box.createHorizontalStrut(10));
        controlPanel.add(dottedCheckBox);
        controlPanel.add(Box.createHorizontalStrut(10));
        controlPanel.add(undoButton);
        controlPanel.add(clearButton);
        add(controlPanel, BorderLayout.NORTH);
    }
    private JButton createToolButton(String text, String tool) {
        JButton button = new JButton(text);
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(80, 30));
        button.putClientProperty("tool", tool);
        return button;
    }
    private JButton createColorButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(90, 30));
        button.putClientProperty("color", color);
        return button;
    }
    private JButton createActionButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(100, 30));
        return button;
    }
    private void setupDrawingPanel() {
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                
                for (Shape shape : shapes) {
                    shape.draw(g2d);
                }
                if (currentShape != null) {
                    currentShape.draw(g2d);
                }
                if (currentPencilDrawing != null) {
                    currentPencilDrawing.draw(g2d);
                }
                if (isErasing && eraserPoint != null) {
                    eraser.drawEraser(g2d, eraserPoint);
                }
            }
        };
        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(drawingPanel, BorderLayout.CENTER);
    }
    private void saveState() {
        ArrayList<Shape> stateCopy = new ArrayList<>(shapes);
        undoStack.push(stateCopy);
        if (undoStack.size() > 20) {
            undoStack.remove(0);
        }
    }
    private void undo() {
        if (undoStack.size() > 1) {
            undoStack.pop();
            shapes = new ArrayList<>(undoStack.peek());
            drawingPanel.repaint();
        }
    }
    private void setupListeners() {
        ActionListener toolListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String newTool = (String) source.getClientProperty("tool");
                lineButton.setBackground(Color.DARK_GRAY);
                lineButton.setForeground(Color.BLACK);
                rectButton.setBackground(Color.DARK_GRAY);
                rectButton.setForeground(Color.BLACK);
                ovalButton.setBackground(Color.DARK_GRAY);
                ovalButton.setForeground(Color.BLACK);
                pencilButton.setBackground(Color.DARK_GRAY);
                pencilButton.setForeground(Color.BLACK);
                eraserButton.setBackground(Color.DARK_GRAY);
                eraserButton.setForeground(Color.BLACK);
                
                source.setBackground(Color.GRAY);
                source.setForeground(Color.BLACK);
                
                currentTool = newTool;
                isErasing = currentTool.equals("Eraser");
                currentShape = null;
                currentPencilDrawing = null;
            }
        };
        lineButton.addActionListener(toolListener);
        rectButton.addActionListener(toolListener);
        ovalButton.addActionListener(toolListener);
        pencilButton.addActionListener(toolListener);
        eraserButton.addActionListener(toolListener);
        
        ActionListener colorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                currentColor = (Color) source.getClientProperty("color");
            }
        };
        blackButton.addActionListener(colorListener);
        redButton.addActionListener(colorListener);
        greenButton.addActionListener(colorListener);
        blueButton.addActionListener(colorListener);
        yellowButton.addActionListener(colorListener);
        
        dottedCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                isDotted = (e.getStateChange() == ItemEvent.SELECTED);
            }
        });
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapes.clear();
                saveState();
                drawingPanel.repaint();
            }
        });
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                if (isErasing) {
                    eraserPoint = startPoint;
                    if (eraser.eraseAtPoint(startPoint, shapes)) {
                        saveState();
                    }
                } else if (currentTool.equals("Pencil")) {
                    currentPencilDrawing = new PenDraw(currentColor, isDotted);
                    currentPencilDrawing.addPoint(startPoint);
                } else {
                    endPoint = startPoint;
                }
                drawingPanel.repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isErasing) {
                    eraserPoint = null;
                } else if (currentTool.equals("Pencil")) {
                    if (currentPencilDrawing != null) {
                        shapes.add(currentPencilDrawing);
                        saveState();
                        currentPencilDrawing = null;
                    }
                } else if (currentShape != null) {
                    shapes.add(currentShape);
                    saveState();
                    currentShape = null;
                }
                drawingPanel.repaint();
            }
        });
        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isErasing) {
                    eraserPoint = e.getPoint();
                    if (eraser.eraseAtPoint(e.getPoint(), shapes)) {
                        saveState();
                    }
                } else if (currentTool.equals("Pencil")) {
                    if (currentPencilDrawing != null) {
                        currentPencilDrawing.addPoint(e.getPoint());
                    }
                } else {
                    endPoint = e.getPoint();
                    createCurrentShape();
                }
                drawingPanel.repaint();
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                if (isErasing) {
                    eraserPoint = e.getPoint();
                    drawingPanel.repaint();
                }
            }
        });
    }
    private void createCurrentShape() {
        switch (currentTool) {
            case "Line":
                currentShape = new Line(startPoint, endPoint, currentColor, isDotted);
                break;
            case "Rectangle":
                currentShape = new RectShape(startPoint, endPoint, currentColor, isDotted);
                break;
            case "Oval":
                currentShape = new OvalShape(startPoint, endPoint, currentColor, isDotted);
                break;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PaintBrush paintBrush = new PaintBrush();
                paintBrush.setVisible(true);
            }
        });
    }
}