public class RepaintThread implements Runnable {

    private DrawingPanel panel;
    private boolean running = true;

    public RepaintThread(DrawingPanel panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        while (running) {
            panel.repaint();
            try {
                Thread.sleep(30); 
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void stopThread() {
        running = false;
    }
}
