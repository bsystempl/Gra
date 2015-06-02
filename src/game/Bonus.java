package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Bonus {
    int x, y, dx;
    Image object;
    boolean alive;

    public Bonus() {
        ImageIcon i = new ImageIcon("C:/programowanie/bonus.png");
        object = i.getImage();
        x = 900;
        y = 125;
        dx = 3;
        alive = true;
    }

    public void move() {
        x = x - dx;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return object;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 50, 152);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            x = 900;
            alive = true;
        }
    }
}
