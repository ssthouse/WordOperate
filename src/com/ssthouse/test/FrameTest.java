package com.ssthouse.test;

import com.ssthouse.util.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ssthouse on 2015/9/4.
 */
public class FrameTest extends JFrame {
    private JButton btnShowColorDialog;
    private JPanel panelMain;
    private JButton btnInput;
    private JButton btnConfirmDialog;
    private JButton btnMessage;
    private JButton btnOptions;

    public FrameTest(String title) throws HeadlessException {
        super(title);
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 300);
        pack();

        initView();


    }

    private void initView() {
        //Color chooser
        btnShowColorDialog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JColorChooser.showDialog(FrameTest.this, "选择颜色", Color.white);
            }
        });

        //Confirm
        btnConfirmDialog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int result = JOptionPane.showConfirmDialog(FrameTest.this, "hahaha",
                        "Title", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                //获取返回值
                if (result == JOptionPane.OK_OPTION) {
                    Log.log("ok");
                } else if (result == JOptionPane.CANCEL_OPTION) {
                    Log.log("cancel");
                }
            }
        });

        //message
        btnMessage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(FrameTest.this, new String[]{"hahaha", "xixixi"},
                        "woshi Title", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //input
        btnInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String str = JOptionPane.showInputDialog(FrameTest.this, new String[]{"hahaha", "xixixi"},
                        "haxi");
                Log.log("我得到了:  " + str);
            }
        });

        //option
        btnOptions.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Object[] options = new Object[]{"hahaha", "xixixi", "hehehe"};
                JOptionPane.showOptionDialog(FrameTest.this, "hahaha", "tttitle",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        options, options[1]);
            }
        });
    }

}
