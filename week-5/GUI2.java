import java.awt.Graphics;
import java.util.Date;


public class GUI2 extends javax.swing.JFrame {

    Date d;

    public GUI2() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        d = new Date();
        g.drawString(d.toString(), 100, 100);
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
        GUI2 frame = new GUI2();
        frame.setVisible(true);
        frame.setTitle("Date");

        Runnable run = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        frame.repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(run).start();
    }
}
