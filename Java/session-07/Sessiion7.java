/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class Sessiion7 extends JFrame{
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPanel = new JScrollPane(textArea);
    JButton openBt = new JButton("Open"), saveBt = new JButton("Save");
    JPanel buttonPanel = new JPanel();
    JFileChooser fileChoose = new JFileChooser();
    
    public Sessiion7(){
        setTitle("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        buttonPanel.add(openBt);
        buttonPanel.add(saveBt);
        
        add(scrollPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        openBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFil();
            }
        });
        saveBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFil();
            }
        });
    }
    
    private void openFil(){
        int result = fileChoose.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChoose.getSelectedFile();
            
            try {
                FileInputStream fis = new FileInputStream(selectedFile);
                int fileSize = fis.available();
                byte[] fileData = new byte[fileSize];
                fis.read(fileData);
                fis.close();
                String content = new String(fileData);
                textArea.setText(content);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                }
        }
    }
    
    private void saveFil() {
        int result = fileChoose.showSaveDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChoose.getSelectedFile();
            
            try {
                FileOutputStream fos = new FileOutputStream(selectedFile);
                String text = textArea.getText();
                byte[] data = text.getBytes();
                fos.write(data);
                fos.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Sessiion7 editor = new Sessiion7();
                editor.setVisible(true);
            }
        });
    }
}