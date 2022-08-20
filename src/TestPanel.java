import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 20; i++) {
            draw(g);
        }
    }

    public void draw(Graphics g) {
        Color c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        g.setColor(c);
        g.fillRect((int) (Math.random() * 400), (int) (Math.random() * 300), (int) (Math.random() * 40), (int) (Math.random() * 40));
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel row = new JPanel();
        row.add(new TestPanel(), BorderLayout.CENTER);
        row.add(new TestPanel(), BorderLayout.CENTER);
        row.add(new TestPanel(), BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 300);
        f.add(row);
        f.setVisible(true);
    }
}