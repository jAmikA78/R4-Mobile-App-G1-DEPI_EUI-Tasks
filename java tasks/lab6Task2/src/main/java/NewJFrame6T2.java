
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class NewJFrame6T2 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame6T2.class.getName());

    JPanel panel;
    int x1, x2, y1, y2;
    boolean dragging;
    
    public NewJFrame6T2() {
        x1 = 0; y1 = 0;
        x2 = 0; y2 = 0;
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawLine(x1, y1, x2, y2);
            }
        };
        panel.setPreferredSize(new java.awt.Dimension(400, 300));
        panel.addMouseMotionListener(
            new MouseMotionListener(){
                @Override
                public void mouseDragged(MouseEvent e) {                   
                    x2 = e.getX();
                    y2 = e.getY();
                    panel.repaint();                   
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    x1= e.getX();
                    y1 = e.getY();                
                }    
            }
        );
        add(panel);
        pack();
        setTitle("Draw Line");
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
        java.awt.EventQueue.invokeLater(() -> new NewJFrame6T2().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
