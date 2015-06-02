package game;

import javax.swing.*;

public class Frame {

    public Frame(){
        JFrame frame = new JFrame();
        frame.add(new Board());
        frame.setTitle("SUPER GRA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,225);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        new Frame();
    }
}
