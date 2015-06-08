package game;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Dude {
    int x, dx, y, dy;
    Image still;
    boolean alive;
    boolean pause;
    Integer z;
    public Dude() {
        ImageIcon i = new ImageIcon("C:/programowanie/still.png");
        still = i.getImage();
        z = 0;
        x = 10;
        y = 150;
        alive = true;
        pause = false;
    }

    public void move() {
        x = x + dx;
    }

    public void moveY() { y = y + dy;  }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return still;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            dx = -1;

        if (key == KeyEvent.VK_RIGHT)
            dx = 1;

        if (key ==  KeyEvent.VK_UP){
            dy = -1;
            ImageIcon i = new ImageIcon("C:/programowanie/jump.png");
            still = i.getImage();

        }

        if(key == KeyEvent.VK_ESCAPE)
        {
            if(pause)
            {
                pause = false;
            }
            else
            {
                pause = true;
            }
        }



        if (key ==  KeyEvent.VK_X)
            dy = -2;

        if (key == KeyEvent.VK_SPACE)
        {
            alive = true;
            z = 0;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
            dx = 0;

        if (key == KeyEvent.VK_RIGHT)
            dx = 0;
        if (key == KeyEvent.VK_UP)
        {
            dy = 1;
            ImageIcon i = new ImageIcon("C:/programowanie/still.png");
            still = i.getImage();

        }

        if (key ==  KeyEvent.VK_X)
            dy = 2;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x,y, 18, 25);
    }
}
