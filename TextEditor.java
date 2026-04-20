 package com.mycompany.texteditor;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TextEditor extends JFrame {

    private final JTextArea area = new JTextArea();

    public TextEditor() {
        setTitle("Text Editor");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        area.setFont(new Font("Arial", Font.PLAIN, 16));
        add(new JScrollPane(area), BorderLayout.CENTER);

        setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar bar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        bar.add(fileMenu);
        return bar;
    }

   /* private void openFile() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            try (FileInputStream fis = new FileInputStream(file)) {
                
                byte[] data = fis.readAllBytes();
                area.setText(new String(data));  
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error opening file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            try (FileOutputStream fos = new FileOutputStream(file)) {
                byte[] data = area.getText().getBytes();
                fos.write(data);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error saving file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }*/
    private void openFile() {
    JFileChooser chooser = new JFileChooser();
    int result = chooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            area.setText(sb.toString());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error opening file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

private void saveFile() {
    JFileChooser chooser = new JFileChooser();
    int result = chooser.showSaveDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(area.getText());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditor().setVisible(true));
    }
}

