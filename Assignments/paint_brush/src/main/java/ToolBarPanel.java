import javax.swing.*;
import java.awt.*;

public class ToolBarPanel extends JPanel {

    public ToolBarPanel(DrawingPanel drawingPanel) {

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(new JLabel("Functions:"));

        JButton clearBtn = new JButton("Clear");
        JButton undoBtn = new JButton("Undo");

        add(clearBtn);
        add(undoBtn);


        add(new JLabel("  Paint Mode:"));
        JButton lineBtn = new JButton("Line");
        JButton rectBtn = new JButton("Rectangle");
        JButton ovalBtn = new JButton("Oval");
        JButton pencilBtn = new JButton("Pencil");
        JButton eraserBtn = new JButton("Eraser");
        
        add(lineBtn);
        add(rectBtn);
        add(ovalBtn);
        add(pencilBtn);
        add(eraserBtn);
        
        JCheckBox solidBox = new JCheckBox("Solid", true);
        JCheckBox dottedBox = new JCheckBox("Dotted");
        add(solidBox);
        add(dottedBox);
        
        ButtonGroup strokeGroup = new ButtonGroup();
        strokeGroup.add(solidBox);
        strokeGroup.add(dottedBox);


        add(new JLabel(" Colors:"));
        JButton blackBtn = createColorBtn(Color.BLACK);
        JButton redBtn = createColorBtn(Color.RED);
        JButton greenBtn = createColorBtn(Color.GREEN);
        JButton blueBtn = createColorBtn(Color.BLUE);
        add(blackBtn);
        add(redBtn);
        add(greenBtn);
        add(blueBtn);
        
        
        
        lineBtn.addActionListener(e -> drawingPanel.setMode(DrawMode.LINE));
        rectBtn.addActionListener(e -> drawingPanel.setMode(DrawMode.RECTANGLE));
        ovalBtn.addActionListener(e -> drawingPanel.setMode(DrawMode.OVAL));
        pencilBtn.addActionListener(e -> drawingPanel.setMode(DrawMode.PENCIL));
        eraserBtn.addActionListener(e -> drawingPanel.setMode(DrawMode.ERASER));
        clearBtn.addActionListener(e -> drawingPanel.clearAll());
        undoBtn.addActionListener(e -> drawingPanel.undo());
        solidBox.addActionListener(e -> drawingPanel.setSolid());
        dottedBox.addActionListener(e -> drawingPanel.setDotted());
        blackBtn.addActionListener(e -> drawingPanel.setColor(Color.BLACK));
        redBtn.addActionListener(e -> drawingPanel.setColor(Color.RED));
        greenBtn.addActionListener(e -> drawingPanel.setColor(Color.GREEN));
        blueBtn.addActionListener(e -> drawingPanel.setColor(Color.BLUE));
    }

    private JButton createColorBtn(Color c) {
        JButton btn = new JButton();
        btn.setBackground(c);
        btn.setPreferredSize(new Dimension(25, 25));
        return btn;
    }
}
