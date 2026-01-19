import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.EmptyStackException;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DrawArea extends JPanel{
    
    public String Cshape = "";
    
    private Shapes selected;
    
    private Stack<Shapes> shapes = new Stack<>() , old_shapes  = new Stack<>();

    // private ArrayList<Shapes> cleared_shapes;
    
    private Color color = Color.black;
    
    static Color Background = Color.white;
    
    public static String Mode = "";
    

    
    public DrawArea(){
        
        this.setBackground(Background);
        
        addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                switch(Cshape){
                  case "line":
                      setShape(new line(color,Mode));
                      break;
                  case "rect":
                      setShape(new rectangle(color,Mode));
                      break;
                  case "oval":
                      setShape(new oval(color,Mode));
                      break;
                  case "pen":
                      setShape(new pencil(color,Mode));
                      break;
                  case "erase":
                      setShape(new erase(Background,Mode));
                      break;
                  default:
                      setShape(new pencil(color,Mode));
                      break;
                }
                selected.setX(e.getX());
                selected.setY(e.getY());

            }            
            @Override
            public void mouseReleased(MouseEvent e) {
                if(selected != null){
                    selected.setX2(e.getX());
                    selected.setY2(e.getY());
                    shapes.push(selected);
                    repaint();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(selected != null){
                    selected.setX2(e.getX());
                    selected.setY2(e.getY());
                    repaint();
                    }
            }
            @Override
            public void mouseMoved(MouseEvent e){}
        });
    
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try{
          for (Shapes s: shapes){
              s.paint(g);
          }
        }catch(NullPointerException ex){}
        catch(ArrayIndexOutOfBoundsException ex){}
        
        if(selected != null){
          if(selected instanceof line){
            if(!Mode.equals("solid")){
//                selected.paint_dotted(g);
            }
          }
        try{
          selected.paint(g);
        }catch(ArrayIndexOutOfBoundsException ex){}
      }
    }
            
    public void setShape(Shapes s){
        selected = s ;
    }
    
    public void undo(){
      try{
          if(!shapes.isEmpty()){
            old_shapes.push(shapes.pop());
            selected=null;
            repaint();
          }
      }catch(EmptyStackException ex){}
      
      repaint();
    }
    
    public void redo(){
      try{
          shapes.push(old_shapes.pop());
          selected=null;
          repaint();
      }catch(EmptyStackException ex){}
    }
    
    public void clear(){
      
      JDialog cl = new JDialog();
    
      JButton y = new JButton("Yes");
      
      JButton n = new JButton("No");

      JLabel lb = new JLabel("Are you sure you want to Clear ? (there's no undo for it)");
      
      cl.setSize(350,100);
      cl.setLocation(500,500);
      cl.setVisible(true);      
      cl.setLayout(new FlowLayout());
      cl.setDefaultCloseOperation(cl.DISPOSE_ON_CLOSE);
      cl.add(lb,BorderLayout.CENTER);
      cl.add(n,BorderLayout.SOUTH);
      cl.add(y,BorderLayout.SOUTH);
      y.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            shapes.clear();
            selected=null;
            repaint();
            cl.dispose();
        }
      });
      n.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.dispose();
        }
      });
    }
    
    public void setColor(Color c){
        color = c;
    }
    
    public void setMode(String m){
      Mode = m;
    }
    
}
