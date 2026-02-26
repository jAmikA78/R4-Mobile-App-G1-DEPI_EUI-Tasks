
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class ToolBarPanel extends JPanel{
    // Function buttons
    JButton clearBtn;
    JButton undoBtn;
    
    // Paint mode buttons
    JToggleButton lineBtn;
    JToggleButton rectBtn;
    JToggleButton ovalBtn;
    JToggleButton pencilBtn;
    JToggleButton eraserBtn;
    ButtonGroup paintModeGroup;
    
    // paint sytle
    JRadioButton solidBtn;
    JRadioButton dottedBtn;
    ButtonGroup styleGroup;
    
    // color buttons
    JToggleButton blackColBtn;
    JToggleButton redColBtn;
    JToggleButton greenColBtn;
    JToggleButton blueColBtn;
    ButtonGroup colorGroup;
    
    public ToolBarPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // Function part
        add(new JLabel("Function: "));
        clearBtn = new JButton("Clear");
        undoBtn = new JButton("Undo");
        add(clearBtn);
        add(undoBtn);
        
        // Paint mode Part
        add(new JLabel("Paint Mode: "));
        lineBtn = new JToggleButton("Line");
        rectBtn = new JToggleButton("Rectangle");
        ovalBtn = new JToggleButton("Oval");
        pencilBtn = new JToggleButton("Pencil");
        eraserBtn = new JToggleButton("Eraser");

        paintModeGroup = new ButtonGroup();
        paintModeGroup.add(lineBtn);
        paintModeGroup.add(rectBtn);
        paintModeGroup.add(ovalBtn);
        paintModeGroup.add(pencilBtn);
        paintModeGroup.add(eraserBtn);
        pencilBtn.setSelected(true);
        
        add(lineBtn);
        add(rectBtn);
        add(ovalBtn);
        add(pencilBtn);
        add(eraserBtn);
        
        // style part (dotted/solid)
        add(new JLabel("Style:"));
        solidBtn = new JRadioButton("Solid");
        dottedBtn = new JRadioButton("Dotted");
        styleGroup = new ButtonGroup();
        styleGroup.add(solidBtn);
        styleGroup.add(dottedBtn);
        dottedBtn.setSelected(true);

        add(solidBtn);
        add(dottedBtn);
        
        // color part
        blackColBtn = new JToggleButton("Black");
        redColBtn = new JToggleButton("Red");
        greenColBtn = new JToggleButton("Green");
        blueColBtn = new JToggleButton("Blue");
        blackColBtn.setForeground(Color.white);
        redColBtn.setForeground(Color.white);
        greenColBtn.setForeground(Color.white);
        blueColBtn.setForeground(Color.white);
        blackColBtn.setBackground(Color.black);
        redColBtn.setBackground(Color.red);
        greenColBtn.setBackground(Color.green);
        blueColBtn.setBackground(Color.blue);
        
        colorGroup = new ButtonGroup();
        colorGroup.add(blackColBtn);
        colorGroup.add(redColBtn);
        colorGroup.add(greenColBtn);
        colorGroup.add(blueColBtn);
        blackColBtn.setSelected(true);
        
        add(blackColBtn);
        add(redColBtn);
        add(greenColBtn);
        add(blueColBtn);
    }
}
