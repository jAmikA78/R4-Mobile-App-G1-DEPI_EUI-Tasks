
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NewJFrame7T extends javax.swing.JFrame {    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame7T.class.getName());

    JTextArea textArea;
    JButton openbtn, savebtn;
    
    public NewJFrame7T() {
        initComponents();
        
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        savebtn = new JButton("Save");
        savebtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                if(fc.showSaveDialog(NewJFrame7T.this) == JFileChooser.APPROVE_OPTION){
                    String path = fc.getSelectedFile().getPath();
                    try(FileWriter fwr = new FileWriter(path)) {
                        fwr.write(textArea.getText());
                        
                        textArea.setText("");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        openbtn = new JButton("Open");
        openbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                if(fc.showOpenDialog(NewJFrame7T.this) == JFileChooser.APPROVE_OPTION){
                    String path = fc.getSelectedFile().getPath();
                    try(FileReader fr = new FileReader(path)) {
                        int ch;
                        textArea.setText("");
                        while((ch = fr.read()) != -1){
                            Character textChar = (char) ch;
                            textArea.append(textChar.toString());
                        }
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }            }
        });
        
        JPanel btnPanel = new JPanel();
        btnPanel.add(savebtn);
        btnPanel.add(openbtn);
        add(btnPanel,BorderLayout.SOUTH);
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
        java.awt.EventQueue.invokeLater(() -> new NewJFrame7T().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
