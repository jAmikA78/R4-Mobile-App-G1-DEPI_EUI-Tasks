import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;

public class osText extends JFrame {

    JTextArea textArea = new JTextArea();
    JButton saveBtn = new JButton("Save");
    JButton clearBtn = new JButton("Clear");
    JButton openBtn = new JButton("Open");

    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel(new BorderLayout());

    public osText() {

        setLayout(new BorderLayout());

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        // Save
        saveBtn.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (FileOutputStream fos =
                        new FileOutputStream(fileChooser.getSelectedFile())) {

                    fos.write(textArea.getText().getBytes("UTF-8"));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Clear
        clearBtn.addActionListener(e -> textArea.setText(""));

        // Open
        openBtn.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (FileInputStream fis =
                        new FileInputStream(fileChooser.getSelectedFile())) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    StringBuilder content = new StringBuilder();

                    while ((bytesRead = fis.read(buffer)) != -1) {
                        content.append(new String(buffer, 0, bytesRead, "UTF-8"));
                    }

                    textArea.setText(content.toString());

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        topPanel.add(saveBtn);
        topPanel.add(clearBtn);
        topPanel.add(openBtn);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);

        setTitle("Open and Save Text");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new osText();
    }
}
