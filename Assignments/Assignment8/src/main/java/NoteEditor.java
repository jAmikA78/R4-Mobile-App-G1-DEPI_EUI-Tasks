import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class NoteEditor extends JFrame {
    private JTextArea area;
    private JButton openBtn, saveBtn, clearBtn;

    public NoteEditor() {
        area = new JTextArea();
        area.setLineWrap(true); 

        openBtn = new JButton("Open File");
        saveBtn = new JButton("Save File");
        clearBtn = new JButton("Clear");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(openBtn);
        buttonsPanel.add(saveBtn);
        buttonsPanel.add(clearBtn);

        add(buttonsPanel, BorderLayout.SOUTH);
        add(new JScrollPane(area), BorderLayout.CENTER);

        openBtn.addActionListener(openFile());
        saveBtn.addActionListener(saveFile());
        clearBtn.addActionListener(e -> area.setText(""));

        setTitle("Simple Note Editor");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private ActionListener openFile() {
        return e -> { 
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                   area.setText("");
                String line;
                    while ((line = reader.readLine()) != null) {
                        area.append(line + "\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error opening file");
                }
            }
        };
    }

    
    private ActionListener saveFile() {
        return e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(chooser.getSelectedFile()))) {
              writer.write(area.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file");
                }
            }
        };
    }

    public static void main(String[] args) {
        new NoteEditor();
    }
}
