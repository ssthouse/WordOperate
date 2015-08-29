package com.company;

import javax.sql.rowset.FilteredRowSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ssthouse on 2015/8/28.
 */
public class Form1 extends JFrame {


    private JPanel panel1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button1;
    private JPanel Input;
    private JButton button7;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form1");
        frame.setContentPane(new Form1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
