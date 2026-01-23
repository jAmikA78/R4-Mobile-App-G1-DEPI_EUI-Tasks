
package com.mycompany.lec6assignment1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonApp extends javax.swing.JFrame {
    int x = 0;
    

    public ButtonApp() {
        initComponents();
        setTitle("Button counter");
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed ( ActionEvent e){
            x++;
            repaint();
            }
    });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed ( ActionEvent e){
            x= x-1;
            repaint();
        }});
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(b1);
        add(b2);
    }
    
    
    @Override
    public void paint (Graphics g){
        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("click count is : "+x,100,100); 
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b1.setText("++");

        b2.setText("--");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(b1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(b2)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1)
                    .addComponent(b2))
                .addContainerGap(251, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ButtonApp().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    // End of variables declaration//GEN-END:variables

}

