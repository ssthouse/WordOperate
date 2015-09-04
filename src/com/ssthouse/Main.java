package com.ssthouse;

import com.ssthouse.test.FrameTest;
import com.ssthouse.test.ListAndCombo;
import com.ssthouse.test.ProgressBarTest;

import javax.swing.*;

/**
 * Created by ssthouse on 2015/9/1.
 */
public class Main {

    public static void main(String[] args){
//        JFrame frame = new Frame1("Frame1");
//        frame.setVisible(true);

//        FrameTest frameTest = new FrameTest("hahaha");
//        frameTest.setVisible(true);

//        ProgressBarTest progressBarTest = new ProgressBarTest("hahaha");
//        progressBarTest.setVisible(true);

        JFrame frame = new JFrame("ahhahah");
        frame.setContentPane(new ListAndCombo("xii").mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 300);
        frame.pack();
        frame.setVisible(true);

        //TODO--测试word添加图片
//        WordPicTest.addPic();

        //TODO
//        try {
//            WordDemo.wordDemoTest();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
