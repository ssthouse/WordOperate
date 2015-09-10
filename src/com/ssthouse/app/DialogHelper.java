package com.ssthouse.app;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog工具类
 * Created by ssthouse on 2015/9/1.
 */
public class DialogHelper {

    /**
     * 输入框Dialog
     * @param parent
     * @param msg
     */
    public static void showInputDialog(Component parent, String msg) {
        JOptionPane.showInputDialog(parent, msg);
    }

    /**
     * Error的Dialog
     * @param parent
     * @param msg
     */
    public static void showErrorDialog(Component parent, String msg){
        JOptionPane.showMessageDialog(parent, msg);
    }


    /**
     * 数据库没打开Dialog
     * @param parent
     */
    public static void showDbWrongDialog(Component parent) {
        JOptionPane.showMessageDialog(parent, "该文件可能不是数据库, 或该文件已损坏.",
                "数据库打开失败", JOptionPane.YES_OPTION);
    }

    /**
     * 驱动有问题Dialog
     * @param parent
     */
    public static void showDriveErrorDialog(Component parent) {
        JOptionPane.showMessageDialog(parent, "数据库驱动启动失败");
    }

    /**
     * Excel有问题Dialog
     * @param parent
     */
    public static void showExcelUnableDialog(Component parent){
        JOptionPane.showMessageDialog(parent, "请先指定Excel输出路径");
    }

    /**
     * Excel生成完毕
     * @param parent
     */
    public static void showExcelCompleteDialog(Component parent){
        JOptionPane.showMessageDialog(parent, "Excel文件生成完毕");
    }


    /**
     * word有问题Dialog
     * @param parent
     */
    public static void showWordUnableDialog(Component parent){
        JOptionPane.showMessageDialog(parent, "请先指定Word输出路径");
    }

    public static void showWordCompleteDialog(Component parent){
        JOptionPane.showMessageDialog(parent, "Word文件生成完毕");
    }
}
