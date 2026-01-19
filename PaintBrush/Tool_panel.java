import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;

public class Tool_panel extends JPanel {        
        
    JButton clear,undo,redo;
    JButton line,rect,oval,pen,erase;
    JCheckBox solid,dotted;
    JButton black,red,green,blue;
    ButtonGroup grp;
    
    public Tool_panel(){
        
        setVisible(true);

        clear = new JButton("Clear");
        undo = new JButton("Undo");
        redo = new JButton("Redo");

        line = new JButton("Line");
        rect = new JButton("Rectangle");
        oval = new JButton("Oval");
        pen = new JButton("Pencile");
        erase = new JButton("Eraser");
        solid = new JCheckBox("Solid");
        dotted = new JCheckBox("Dotted");
        grp = new ButtonGroup();
        grp.add(solid);
        grp.add(dotted);
        

        black = new JButton("Black");
        black.setBackground(Color.black);
        red = new JButton("Red");
        red.setBackground(Color.red);
        green = new JButton("Green");
        green.setBackground(Color.green);
        blue = new JButton("Blue");
        blue.setBackground(Color.blue);
        

        add(new JLabel("Functions: "),new FlowLayout());
        add(clear,new FlowLayout());
        add(undo,new FlowLayout());
        add(redo,new FlowLayout());
        add(erase,new FlowLayout());
        add(new JLabel("Paint Mode: "),new FlowLayout());
        add(line,new FlowLayout());
        add(rect,new FlowLayout());
        add(oval,new FlowLayout());
        add(pen,new FlowLayout());
        add(solid,new FlowLayout());
        add(dotted,new FlowLayout());
        add(new JLabel(" Colors: "),new FlowLayout());
        add(black,new FlowLayout());
        add(red,new FlowLayout());
        add(green,new FlowLayout());
        add(blue,new FlowLayout());
    
    }
    
    
}
