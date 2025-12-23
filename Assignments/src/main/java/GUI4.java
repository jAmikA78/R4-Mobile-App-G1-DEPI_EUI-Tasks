import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI4 extends javax.swing.JFrame {
    
    int counter = 0;
    
    public GUI4() {
        initComponents();
        Button btn_incre = new Button("Increment");
        btn_incre.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                repaint();
            }  
        });
        
        Button btn_dcre = new Button("Decrement");
        btn_dcre.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                counter--;
                repaint();
            }
        });
        setLayout(new FlowLayout());
        add(btn_incre);
        add(btn_dcre);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawString("Counter = "+counter, 100, 100);
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
        java.awt.EventQueue.invokeLater(() -> new GUI4().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
