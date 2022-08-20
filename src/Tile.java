import javax.swing.*;
import java.awt.*;

import static java.awt.Color.WHITE;

public class Tile extends JPanel {

    private final int width = 25;
    private final int height = 25;
    private int x = 0;
    private int y = 0;
    private Color color = WHITE;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void setColor(Color color) {
        this.color = color;
    }

}




