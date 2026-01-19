import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class PaintBrush  extends JFrame{
    
    Tool_panel tool_panel;
    DrawArea draw_panel;

    public PaintBrush(){
    
        setVisible(true);
        setSize(1190,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Paint Brush");
        
        draw_panel =  new DrawArea();
        tool_panel = new Tool_panel();
        tool_panel.solid.doClick();
        
        tool_panel.line.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                draw_panel.Cshape = "line";
            }
        });
        
        tool_panel.rect.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                draw_panel.Cshape = "rect";
            }
        });
        
        tool_panel.oval.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                draw_panel.Cshape = "oval";
            }
        });
        
        tool_panel.pen.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                draw_panel.Cshape = "pen";
            }
        });

        tool_panel.erase.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                draw_panel.Cshape = "erase";
            }
        });
        
        tool_panel.undo.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              draw_panel.undo();
          }
        }); 

        tool_panel.redo.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              draw_panel.redo();
          }
        }); 
        
        tool_panel.clear.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              draw_panel.clear();
          }
        }); 
        
        tool_panel.black.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              draw_panel.setColor(Color.black);
          }
        });
        
        tool_panel.blue.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              draw_panel.setColor(Color.blue);
          }
        });
        
        tool_panel.red.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              draw_panel.setColor(Color.red);
          }
        });
        
        tool_panel.green.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              draw_panel.setColor(Color.green);
          }
        });
        
        tool_panel.solid.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                draw_panel.setMode("solid");
            }
        });
        tool_panel.dotted.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                draw_panel.setMode("dotted");
            }
        });
        
        add(tool_panel,BorderLayout.NORTH);
        add(draw_panel,BorderLayout.CENTER);
    }

    public static void main(String[] args){
        new PaintBrush();
    }
    
}   
