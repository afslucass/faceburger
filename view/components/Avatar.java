package view.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Avatar extends JPanel {
    private int x, y, d;

    public Avatar(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, this.d, this.d);
    }
}
