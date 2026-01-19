import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotePad extends JFrame{
    
    JTextArea text_area;
    JButton btn_save,btn_open;
    JFileChooser file_chooser;
    JPanel panel;
    String path;

    
    public NotePad(){
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MiniNotePad");
        setVisible(true);
        setLayout(new BorderLayout());

        text_area= new JTextArea();
        btn_save= new JButton("Save");
        btn_open= new JButton("Open");
        file_chooser = new JFileChooser();
        panel = new JPanel();
        add(new JScrollPane(text_area),BorderLayout.CENTER);
        add(panel,BorderLayout.NORTH);
        panel.add(btn_save);
        panel.add(btn_open);
        
        
        btn_save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(file_chooser.showSaveDialog(NotePad.this)==JFileChooser.APPROVE_OPTION){
                    path=file_chooser.getSelectedFile().getAbsolutePath();
                    try(FileWriter writer = new FileWriter(path)){
                        writer.write(text_area.getText());
                        text_area.setText("");
                    }catch(FileNotFoundException ex){
                        ex.printStackTrace();
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                }
            }});
        
        btn_open.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(file_chooser.showOpenDialog(NotePad.this)==JFileChooser.OPEN_DIALOG){
                    path= file_chooser.getSelectedFile().getAbsolutePath();
                    try(FileReader reader = new FileReader(path)){
                        String text = reader.readAllAsString();
                        text_area.setText(text);
                    }catch(FileNotFoundException ex){
                        ex.printStackTrace();
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                }
                
            }
        });
    }


    public static void main(String[] args){
        new NotePad();
    }
}
