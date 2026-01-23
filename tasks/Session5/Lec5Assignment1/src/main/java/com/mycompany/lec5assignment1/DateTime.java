
package com.mycompany.lec5assignment1;

import java.awt.Graphics;
import java.util.Date;


public class DateTime extends javax.swing.JFrame implements Runnable  {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DateTime.class.getName());

    public DateTime() {
        setTitle("Date & Time");
        initComponents();
        Thread th = new Thread(this) ;
        th.start();
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

        java.awt.EventQueue.invokeLater(() -> new DateTime().setVisible(true));
    }

    @Override
    public void run() {
        while (true){
            repaint() ;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                 ex.printStackTrace();
            }
            
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    @Override
    public void paint (Graphics g){
    super.paint(g);
    Date d = new Date ();
    g.drawString(d.toString(), 150, 150);
    g.drawRect(125, 120, 200, 50);
    }

}
