
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

public class additional7 extends javax.swing.JFrame {    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(additional7.class.getName());

    JTextArea textArea;
    JButton btnSave, btnOpen;
    
    public additional7() {
        initComponents();
        setLayout(new BorderLayout());
        
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(additional7.this) == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    
                    // try with resources
                    try(FileOutputStream fos = new FileOutputStream(path)) {
                        byte[] bytes = textArea.getText().getBytes();
                        fos.write(bytes);
                        
                        textArea.setText("");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        btnOpen = new JButton("Open");
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(additional7.this) == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    
                    // try with resources
                    try(FileInputStream fis = new FileInputStream(path)) {
                        int availableSize = fis.available();
                        
                        byte[] bytes = new byte[availableSize];
                        
                        fis.read(bytes);
                        
                        String textData = new String(bytes);
                        
                        textArea.setText(textData);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        JPanel southPanel = new JPanel();
        southPanel.add(btnSave);
        southPanel.add(btnOpen);
        
        add(southPanel, BorderLayout.SOUTH);
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
        java.awt.EventQueue.invokeLater(() -> new additional7().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
