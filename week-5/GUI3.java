import javax.swing.JFrame;
import java.awt.Graphics;

public class GUI3  extends JFrame implements Runnable {
    
    public GUI3(){
        initComponents();
        setVisible(true);
    }
    
    static int x = 0;
    static String str= "Mahmoud Ahmed Ali";
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawString(str, x,getHeight()/2);
        g.drawString(str, x+str.length()-getWidth(), getHeight()/2);
    }
    
    @Override
    public void run (){
        this.repaint();
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
        while(true){
            try{
                Thread.sleep(20);
                x++;
                if(x+str.length()>=frame.getWidth()){
                       x=0;   
                   }
                frame.repaint();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
