 package com.mycompany.textbanner;

import javax.swing.*;
import java.awt.*;

public class TextBanner extends JFrame {

    public TextBanner() {
        setTitle("Text Banner");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new BannerPanel("lamiaa is the smartest girl"));
    }

     
    static class BannerPanel extends JPanel {
        private final String text;
        private int x;               
        private final int y = 140;    
        private final Timer timer;

        public BannerPanel(String text) {
            this.text = text;
            setBackground(new Color(230, 230, 230));

            x = 10; 

            timer = new Timer(20, e -> moveText());
            timer.start();
        }

        private void moveText() {
            x += 2;  

             
            int textWidth = getFontMetrics(getFont()).stringWidth(text);
            if (x > getWidth()) {
                x = -textWidth;
            }

            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.setColor(Color.BLACK);

            g.drawString(text, x, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextBanner().setVisible(true));
    }
}

