import javax.swing.*;
import java.awt.*;

public class PaintFrame extends JFrame {

    public PaintFrame() {
        setTitle("Paint Brush");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        DrawingPanel drawingPanel = new DrawingPanel();
        ToolBarPanel toolBar = new ToolBarPanel(drawingPanel);

        add(toolBar, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
