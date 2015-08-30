package com.ssthouse;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * 主界面
 * Created by ssthouse on 2015/8/28.
 */
public class Frame1 extends JFrame {
    private static final String TAG = "Frame1";

    private JPanel panel1;
    private JPanel Input;
    private JTextField tfTitle;
    private JTextField tfItem3;
    private JTextField tfItem1;
    private JTextField tfItem2;
    private JButton btnSubmit;

    public Frame1() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Log.logError("点击发生");
                Log.log(TAG, "生成word");
                WordHelper.getInstance().generateWordFormTemplate(gengerateDataMap());
            }
        });

    }

    private Map<String , String> gengerateDataMap(){
        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put(WordKey.TITLE, tfTitle.getText());
        dataMap.put(WordKey.ITEM1, tfItem1.getText());
        dataMap.put(WordKey.ITEM2, tfItem2.getText());
        dataMap.put(WordKey.ITEM3, tfItem3.getText());
        return dataMap;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Frame1");
        frame.setContentPane(new Frame1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
//        Frame1 frame1 = new Frame1();
//        frame1.setVisible(true);
    }

}
