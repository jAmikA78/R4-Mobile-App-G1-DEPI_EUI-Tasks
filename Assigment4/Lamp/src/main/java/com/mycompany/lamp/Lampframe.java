
package com.mycompany.lamp;

import java.awt.*;
import javax.swing.*;


public class Lampframe extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Lampframe.class.getName());

 
    JPanel panel ;
   
   
    public Lampframe() {
        initComponents();
        setTitle("اللمبة");
        new JPanel();
       
        
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        g.setColor(Color.YELLOW);
        
       
        g.fillOval(150, 50, 100, 30);  
        g.fillOval(180, 100, 40, 80);  
        g.fillOval(140, 110, 20, 40);
        g.fillOval(240, 110, 20, 40);  

      
        g.setColor(Color.BLACK);
     
        g.drawOval(150, 50, 100, 30);
        
        g.drawLine(150, 65, 120, 200); 
        g.drawLine(250, 65, 280, 200); 
        
      
        g.drawArc(120, 180, 160, 40, 180, 180);
        
        
        g.drawOval(180, 100, 40, 80);
        g.drawOval(140, 110, 20, 40);
        g.drawOval(240, 110, 20, 40);
        
        g.drawLine(180, 215, 160, 300); 
        g.drawLine(220, 215, 240, 300); 
        
       
        g.drawRect(140, 300, 120, 20);
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
         JFrame frame = new JFrame("اللمبة");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Lampframe().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
