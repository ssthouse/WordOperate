package com.ssthouse.test;

import com.ssthouse.util.Log;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ssthouse on 2015/9/4.
 */
public class ListAndCombo extends JFrame {

    public JPanel mainPanel;
    private JList list;
    private JComboBox cb;
    private JButton btnDelete;
    private JButton button2;
    private JTextField textField1;


    DefaultListModel<String> listModel = new DefaultListModel<String>();

    public ListAndCombo(String title) throws HeadlessException {
        super(title);
        setContentPane(mainPanel);
        setLocation(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        initView();
    }

    private void initView() {
        listModel.addElement("哈哈哈");
        listModel.addElement("嘻嘻嘻");
        listModel.addElement("呵呵呵");
        list.setModel(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Log.log(e.toString());
            }
        });

        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                listModel.remove(0);
            }
        });
    }

}
