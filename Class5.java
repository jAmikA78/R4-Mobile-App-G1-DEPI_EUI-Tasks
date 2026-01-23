


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Class5 {
    public static void main(String []args){
    
        JLabel l =new JLabel();
        l.setText("Hello java");
        l.setHorizontalAlignment(SwingConstants.CENTER); 
        l.setVerticalAlignment(SwingConstants.CENTER); 
        JFrame f= new JFrame();
        f.setSize(500,500);
        f.setVisible(true);
        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
    
    }
}
