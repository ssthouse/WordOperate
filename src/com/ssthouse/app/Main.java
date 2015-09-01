package com.ssthouse.app;

import com.ssthouse.view.Frame1;

import javax.swing.*;

/**
 * Created by ssthouse on 2015/9/1.
 */
public class Main {

    public static void main(String[] args){
        JFrame frame = new JFrame("Frame1");
        frame.setContentPane(new Frame1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 200);
        frame.pack();
        frame.setVisible(true);
    }
}
