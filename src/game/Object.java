package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Object {
    int x, y, dx;
    Image object;

    public Object() {
        ImageIcon i = new ImageIcon("C:/programowanie/slupek.png");
        object = i.getImage();
        x = 900;
        y = 125;
        dx = 2;
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

    public Rectangle getBounds()
    {
        return new Rectangle(x,y, 60, 50);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            x = 900;
        }
    }
}
