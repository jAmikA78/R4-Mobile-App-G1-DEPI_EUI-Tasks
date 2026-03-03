import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextFrame extends JFrame {

  JTextArea textArea = new JTextArea();
  JButton saveBtn = new JButton("Save"), clearBtn = new JButton("Clear"), openBtn = new JButton("Open");
  JPanel topPanel = new JPanel(), bottomPanel = new JPanel(new BorderLayout());

  public TextFrame() {
    setLayout(new BorderLayout());

    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    JScrollPane scrollPane = new JScrollPane(textArea);
    bottomPanel.add(scrollPane, BorderLayout.CENTER);

    topPanel.add(saveBtn);
    saveBtn.addActionListener((ActionEvent e) -> {
      JFileChooser fileChooser = new JFileChooser();
      if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        String path = fileChooser.getSelectedFile().getPath();

        FileOutputStream fos;
        try {
          fos = new FileOutputStream(path);

          fos.write(textArea.getText().getBytes());
          fos.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    });
    topPanel.add(clearBtn);
    clearBtn.addActionListener(e -> textArea.setText(""));
    topPanel.add(openBtn);
    openBtn.addActionListener((ActionEvent e) -> {
      JFileChooser fileChooser = new JFileChooser();
      if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        String path = fileChooser.getSelectedFile().getPath();

        FileInputStream fis;
        try {
          fis = new FileInputStream(path);

          byte[] buffer = new byte[1024];
          int bytesRead;
          StringBuilder content = new StringBuilder();
          while ((bytesRead = fis.read(buffer)) != -1) {
            content.append(new String(buffer, 0, bytesRead));
          }
          textArea.setText(content.toString());
          fis.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    });

    setLayout(new BorderLayout());
    add(topPanel, BorderLayout.NORTH);
    add(bottomPanel, BorderLayout.CENTER);

    setTitle("اكتب اللى فى نفسك يا عزيزى");
    setSize(1200, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
