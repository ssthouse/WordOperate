package com.ssthouse;

import com.ssthouse.control.word.WordPicTest;
import com.ssthouse.test.WordDemo;
import com.ssthouse.view.Frame1;

import javax.swing.*;

/**
 * Created by ssthouse on 2015/9/1.
 */
public class Main {

    public static void main(String[] args){
//        JFrame frame = new Frame1("Frame1");
//        frame.setVisible(true);

        //TODO--测试word添加图片
//        WordPicTest.addPic();

        //TODO
        try {
            WordDemo.wordDemoTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
