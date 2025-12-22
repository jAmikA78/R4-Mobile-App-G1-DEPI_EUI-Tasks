import java.awt.Color;
import java.awt.Graphics;


public class GUI2 extends javax.swing.JFrame {
    
    public GUI2() {
        initComponents();
        setSize(400,500);
        setBackground(Color.WHITE);
    }
    
        @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(Color.YELLOW);
        g.fillOval(115, 100, 170, 40);
        g.fillOval(105,185,35,50);
        g.fillOval(170,160,65,100);
        g.fillOval(260,185,35,50);
                
        g.setColor(Color.black);
        g.drawOval(115, 100, 170, 40);
        g.drawLine(115,120, 90, 250);
        g.drawLine(285, 120, 310, 250);
        g.drawOval(105,185,35,50);
        g.drawOval(170,160,65,100);
        g.drawOval(260,185,35,50);
        g.drawArc(90,200,220,100,180,180);
        g.drawLine(190,300,175,355);
        g.drawLine(200,300,215,355);
        g.drawRect(125, 355, 145, 15);
        
   
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

    public static void main(String args[]) {
        GUI2 frame = new GUI2();
        frame.setVisible(true);
        frame.setTitle("Lamp");

    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
