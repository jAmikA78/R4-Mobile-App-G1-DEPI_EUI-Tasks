
package com.mycompany.lec7assignment1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Notepad extends javax.swing.JFrame {
    JButton btnSave , btnOpen ;
    JTextArea ta;
    
    


    public Notepad() {
        initComponents();
        setTitle("Text editor");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout (new BorderLayout());
        
        ta = new JTextArea();
        add(new JScrollPane(ta), BorderLayout.CENTER);
        btnSave = new JButton("save");
        btnOpen = new JButton("open");
        

        btnSave.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) {
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(Notepad.this) == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
        try (FileOutputStream fos = new FileOutputStream(path)){
            byte[] b = ta.getText().getBytes();
            fos.write(b);
            } catch (FileNotFoundException ex) {
              ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
   
       }
    }
        });
        
        btnOpen.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(Notepad.this) == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = fc.getSelectedFile().getPath();
                    FileInputStream fis = new FileInputStream(path);
                    int size = fis.available();
                    byte[] b = new byte[size];
                    fis.read(b);
                    ta.setText(new String(b));
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        });

        JPanel southPanel = new JPanel();
        southPanel.add(btnSave);
        southPanel.add(btnOpen);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    
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
        new Notepad() ;

        java.awt.EventQueue.invokeLater(() -> new Notepad().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
