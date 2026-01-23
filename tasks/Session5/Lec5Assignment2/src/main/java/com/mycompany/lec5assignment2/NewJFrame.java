
package com.mycompany.lec5assignment2;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;


public class NewJFrame extends javax.swing.JFrame implements Runnable {
    private String message = "KareemEhab";
    private int x = 0;
    private int y = 150;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame.class.getName());


    public NewJFrame() {
        initComponents();
        setTitle("Text Banner JFrame");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        Thread th = new Thread(this);
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

        java.awt.EventQueue.invokeLater(() -> new NewJFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void paint (Graphics g){
        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString(message, x, y);
    }

    @Override
    public void run() {
        while (true) {
            x += 3;
            if (x > getWidth()) {
                x = -10; 
            }
            repaint();
            try {
                Thread.sleep(25); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    

