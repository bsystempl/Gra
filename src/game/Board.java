package game;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    Dude p;
    Object o;
    Object u;
    public Image img;
    public Image img1;
    Timer time;
    Integer punkty;



    public Board() {
        p = new Dude();
        o = new Object();
        u = new Object();
        u.y = 0;
        u.x = 900;
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("C:/programowanie/test.png");
        ImageIcon loser = new ImageIcon("C:/programowanie/przegryw.png");
        img = i.getImage();
        img1 = loser.getImage();
        time = new Timer(5, this);
        time.start();
        punkty = p.z;
    }

    public void actionPerformed(ActionEvent e) {
            CheckAlive();
            p.move();
            p.moveY();
            u.move();
            o.move();

            if(punkty > 100 )
            {

                punkty = 0;
                u.dx++;
                o.dx++;

            }

            if(p.y > 150)
            {
                p.dy = 0;
            }

            if(p.y <= 0)
            {
                p.dy = 2;
            }


            if(o.x < 0 && u.x < 0)
            {
                Random generator = new Random();
                int a = p.getX()+400;
                o.x = a;
                u.x = a;
            }
            repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img, 0, 0, null);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        g2d.drawImage(o.getImage(), o.getX(), o.getY(), null);
        g2d.drawImage(u.getImage(), u.getX(), u.getY(), null);
        g2d.setColor(Color.red);
        g2d.setFont(new Font("arial", Font.PLAIN, 20));
        g2d.drawString(p.z.toString(), 900, 20);

        if(p.alive == false)
        {

            g2d.drawImage(img1, 0, 0, null);
            g2d.drawString("twoje punkty: " + p.z.toString(), 600, 20);
        }


    }

    private class AL extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
            p.keyReleased(e);
            o.keyReleased(e);
            u.keyReleased(e);
            //CheckAlive();
        }

        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
            //CheckAlive();

        }
    }

    public void CheckAlive(){
        Rectangle dude1 = p.getBounds();
        Rectangle object1 = o.getBounds();
        Rectangle object2 = u.getBounds();

        if(dude1.intersects(object1) || dude1.intersects(object2))
        {
            p.alive = false;
            punkty = 0;
            u.dx = 2;
            o.dx = 2;

        }

        if(p.getBounds().getX() > o.getBounds().getX() && p.getBounds().getX() < o.getBounds().getX() + 60 && p.alive == true ){
                System.out.println("przeskoczono!");
                p.z = p.z + 1;
                punkty ++;
            }


    }
}
