import javax.swing.JFrame;
import java.awt.Graphics;

public class GUI3 extends JFrame {
    
    public GUI3(){
        initComponents();
        setVisible(true);
    }
    
    static int x = 0;
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.drawString("M", x, 150);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold> 

    public static void main(String[] args){
        GUI3 frame = new GUI3();
        
        for(int i=0;i<401;i++){
            try{
                Thread.sleep(90);
                frame.repaint();
                x++;
                if(i>=400){
                    x=0;
                    i=0;
                    frame.repaint();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
