import java.awt.Font;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFrame extends JFrame implements Runnable {

    private final JLabel dateTimeLabel;
    private final Thread t;

    public DateTimeFrame() {
        setTitle("Date and Time");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        dateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(dateTimeLabel);

        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd 'Time' HH:mm:ss 'EET' yyyy");
            dateTimeLabel.setText(now.format(formatter));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        DateTimeFrame frame = new DateTimeFrame();
        frame.setVisible(true);
    }
}