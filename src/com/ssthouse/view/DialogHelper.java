package com.ssthouse.view;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog工具类
 * Created by ssthouse on 2015/9/1.
 */
public class DialogHelper {

    public static void showInputDialog(Component parent, String msg) {
        JOptionPane.showInputDialog(parent, msg);
    }

    public static void showDbWrongDialog(Component parent) {
        JOptionPane.showMessageDialog(parent, "该文件可能不是数据库, 或该文件已损坏.", "数据库打开失败", JOptionPane.YES_OPTION);
    }

    public static void showDriveErrorDialog(Component parent){
        JOptionPane.showMessageDialog(parent, "数据库驱动启动失败");
    }
}
