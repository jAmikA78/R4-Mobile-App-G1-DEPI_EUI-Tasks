
import java.awt.Color;
import java.awt.Graphics;


public class NewJFrame extends javax.swing.JFrame implements Runnable{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame.class.getName());

    Thread thread;
    int x = 0, y = 100, i = 0;
    Color[] colors = {Color.BLUE, Color.RED, Color.GREEN};
    
    public NewJFrame() {
        initComponents();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(x < 400){
            x++;
            g.setColor(colors[i]);
            g.drawString("Zeyad Ahmed", x, y);
        } else{
            x = -80;
            if(y < 200){
                y += 70;
            }else {
                y = 100;
            }
            
            if(i < 2){
                i++;
            }else{
                i = 0;
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new NewJFrame().setVisible(true));
    }

    @Override
    public void run() {
        while(true){
            repaint();
            try {
                thread.sleep(10);
            } catch (InterruptedException ex) {
                System.getLogger(NewJFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
