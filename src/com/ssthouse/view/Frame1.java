package com.ssthouse.view;

import com.ssthouse.model.DbHelper;
import com.ssthouse.util.FileHelper;
import com.ssthouse.util.Log;
import com.ssthouse.word.WordHelper;
import com.ssthouse.word.WordKey;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 主界面
 * Created by ssthouse on 2015/8/28.
 */
public class Frame1 extends JFrame {
    private static final String TAG = "Frame1";

    //数据库帮助类
    private DbHelper dbHelper;

    public JPanel panel1;
    private JPanel Input;
    private JTextField tfTitle;
    private JTextField tfItem3;
    private JTextField tfItem1;
    private JTextField tfItem2;
    private JButton btnSubmit;
    private JButton btnOpenDb;

    public Frame1() {
        dbHelper = new DbHelper(panel1);

        initView();
    }

    private void initView() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Log.log(TAG, "生成word");
                WordHelper.getInstance().generateWordFormTemplate(generateDataMap());
            }
        });

        btnOpenDb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dbHelper.showDbChooseDialog();
            }
        });
    }

    private Map<String, String> generateDataMap() {
        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put(WordKey.TITLE, tfTitle.getText());
        dataMap.put(WordKey.ITEM1, tfItem1.getText());
        dataMap.put(WordKey.ITEM2, tfItem2.getText());
        dataMap.put(WordKey.ITEM3, tfItem3.getText());
        return dataMap;
    }
}
