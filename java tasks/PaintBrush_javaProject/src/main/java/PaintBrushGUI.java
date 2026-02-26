
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PaintBrushGUI extends javax.swing.JFrame {
    
    ToolBarPanel toolBar;
    JPanel drawingPanel;
    
    
    // Current states
    String paintMode;
    Color color;    //current color
    boolean isDotted;   // Current style
    int x1, y1; // coordinates
    ArrayList<Shape> shapes;
    Shape currentShape;
    
    public PaintBrushGUI() {
        setTitle("Paint Brush");
        setSize(1100, 700);
        setLayout(new BorderLayout());
        
        // states initialization 
        paintMode = "pencil";
        color = Color.BLACK;
        isDotted = true;
        x1 = 0; y1 = 0;
        shapes = new ArrayList();
        currentShape = null;
        
        toolBar = new ToolBarPanel();
        
        //-------------------Function buttons part--------------------------
        toolBar.undoBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!shapes.isEmpty()){
                    shapes.remove(shapes.size()-1);
                    repaint();
                }
            }
        });
        toolBar.clearBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                shapes.clear();
                repaint();
            }
        });
        
        //----------------- paint mode part-------------------------------
        toolBar.lineBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                paintMode = "line";
            }
        });
        toolBar.rectBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                paintMode = "rect";
            }
        });
        toolBar.ovalBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                paintMode = "oval";
            }
        });
        toolBar.pencilBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                paintMode = "pencil";
            }
        });
        toolBar.eraserBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                paintMode = "eraser";
            }
        });
        
        //------------------change style----------------------------------------
        toolBar.solidBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                isDotted = false;
            }
        });
        toolBar.dottedBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                isDotted = true;
            }
        });
        
        //----------------- color part --------------------------------------------
        toolBar.blackColBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.BLACK;
            }
        });
        toolBar.redColBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.red;
            }
        });
        toolBar.greenColBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.GREEN;
            }
        });
        toolBar.blueColBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.BLUE;
            }
        });
                
        
        drawingPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                for (Shape s : shapes) {
                    s.draw(g);
                }
                if (currentShape != null) {
                    currentShape.draw(g);
                }
            }
        };
        drawingPanel.setBackground(Color.white);
        drawingPanel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                
                if(paintMode.equals("line")){
                    currentShape = new Line(color, x1,y1,x1,y1,isDotted);
                }else if(paintMode.equals("rect")){
                    currentShape = new Rectangle(color, x1,y1,x1,y1,isDotted);                    
                }else if(paintMode.equals("oval")){
                    currentShape = new Oval(color, x1,y1,x1,y1,isDotted);                    
                }else if(paintMode.equals("pencil")){
                    currentShape = new Pencil(color, e.getX(),e.getY());
                }else if(paintMode.equals("eraser")){
                    currentShape = new Pencil(Color.white, e.getX(),e.getY(),20);                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(currentShape != null){
                    shapes.add(currentShape);
                    currentShape = null;
                    repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        drawingPanel.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {
                if (paintMode.equals("pencil") || paintMode.equals("eraser")) {
                    ((Pencil) currentShape).addPoint(e.getX(), e.getY());
                    repaint();
                }else{
                    currentShape.x2 = e.getX();
                    currentShape.y2 = e.getY();
                
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {}
        });
        
        add(toolBar, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PaintBrushGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
