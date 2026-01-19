import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;

public class GUI5 extends javax.swing.JFrame{
    int X1,Y1,x,y;
    public GUI5() {
        initComponents();
        this.addMouseListener(new MouseListener(){
                @Override
                public void mousePressed(MouseEvent e){X1=e.getX();Y1=e.getY();}
                @Override
                public void mouseReleased(MouseEvent e){repaint();}
                @Override
                public void mouseClicked(MouseEvent e) {}
                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
             });
        
        this.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {x=e.getX();y=e.getY();repaint();}
            @Override
            public void mouseMoved(MouseEvent e) {}
        });
        setLayout(new FlowLayout());
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
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawLine(X1, Y1, x,y);
    }
    
    public static void main(String args[]) {
        new GUI5().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
