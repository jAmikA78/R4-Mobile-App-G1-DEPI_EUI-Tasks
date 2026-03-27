
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class NewJFrame6 extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame6.class.getName());
    
    int x;
    JButton incr, decr;
    
    public NewJFrame6() {
        initComponents();
        x = 0;
        incr = new JButton("++");
        incr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                x++;
                repaint();
            }
        });
        decr = new JButton("--");
        decr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                x--;
                repaint();
            }
        });
        
        
        setLayout(new FlowLayout());
        add(incr);
        add(decr);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawString("Click count is: " + x, 50 , 200);
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
        
        java.awt.EventQueue.invokeLater(() -> new NewJFrame6().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
