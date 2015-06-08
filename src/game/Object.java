package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Object {
    int x, y, dx;
    Image object;

    public Object() {
        ImageIcon i = new ImageIcon("C:/programowanie/slupek_bez_tla.png");
        object = i.getImage();
        x = 900;
        y = 125;
        Random generator = new Random();
        dx = generator.nextInt(2)+1;
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
        if(key == KeyEvent.VK_UP)
        {
            Random generator = new Random();
            if(generator.nextBoolean())
            {
                ImageIcon i = new ImageIcon("C:/programowanie/slupek_bez_tla.png");
                object = i.getImage();
            }
            else
            {
                ImageIcon i = new ImageIcon("C:/programowanie/slupek_bez_tla2.png");
                object = i.getImage();
            }
        }

        if (key == KeyEvent.VK_SPACE) {
            x = 900;
        }
    }
}
