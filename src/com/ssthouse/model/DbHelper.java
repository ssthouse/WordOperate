package com.ssthouse.model;

import com.ssthouse.model.database.ProjectDbCons;
import com.ssthouse.util.FileHelper;
import com.ssthouse.util.Log;
import com.ssthouse.view.DialogHelper;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.sql.*;

/**
 * 数据库管理类
 * Created by ssthouse on 2015/9/1.
 */
public class DbHelper {
    private static String TAG = "DbHelper";

    private static String targetFileName = "data.db";

    private Component parent;

    private File dbFile;

    //数据库操作源
    private Connection connection;

    public DbHelper(Component parent) {
        this.parent = parent;

        //构造方法中判断文件夹中有没有****有的话***就打开成数据库--File
        initDbFile();
    }

    /**
     * 显示数据库选择Dialog
     */
    public void showDbChooseDialog() {
        final JFileChooser fileChooseDialog = new JFileChooser(".");
        fileChooseDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooseDialog.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                String fileName = f.getName();
                if (fileName.endsWith(".db")) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String getDescription() {
                return "请选择sqlite数据库文件";
            }
        });
        fileChooseDialog.setAcceptAllFileFilterUsed(false);
        fileChooseDialog.showDialog(new JLabel(), "选择数据库文件");
        //窗口应该会停在这里等待文件被选中
        dbFile = fileChooseDialog.getSelectedFile();

        //将文件复制到项目目录
        FileHelper.copy(dbFile, new File(System.getProperty("user.dir") + "\\" + targetFileName));
//        System.out.println("文件:" + file.getAbsolutePath());

        //尝试打开文件
        openDb();

        //TODO--读取Marker和Project数据
        readMarker();
//        readProject();
    }

    public void openDb() {
        Log.log("我在试图打开数据库");
        try {
            //连接SQLite的JDBC
            Class.forName("org.sqlite.JDBC");
            //建立一个数据库名test.db的连接，如果不存在就在当前目录下创建之
            connection = DriverManager.getConnection("jdbc:sqlite:" + targetFileName);
            //测试数据库是否可用
            Statement st = connection.createStatement();
            st.executeQuery("SELECT * FROM "+ProjectDbCons.TABLE_PRJS);
        } catch (SQLException e) {
//            e.printStackTrace();
            DialogHelper.showDbWrongDialog(parent);
            connection = null;
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
            DialogHelper.showDriveErrorDialog(parent);
            connection = null;
        }
    }

    /**
     * 初始化DbFile---如果已经有了的话
     */
    private void initDbFile() {
        File file = new File(System.getProperty("user.dir") + "\\" + "data.db");
        if (file.exists()) {
            dbFile = file;
        } else {
            dbFile = null;
        }
    }

    /**
     * 读取Circle数据(从获取的Connection中得到)
     */
    private void readCircle() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Circle");
            while (rs.next()) {
                String x = rs.getString("X");   // Column 1
                String y = rs.getString("Y"); // Column 2
                String radius = rs.getString("Radius"); // Column 3
                Log.log("X" + x + "   Y" + y + "    radius" + radius);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *读取Marker表
     */
    private void readMarker() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + ProjectDbCons.TABLE_Markers);
            while (rs.next()) {
                String prjName = rs.getString(ProjectDbCons.Marker.ITEM_PRJ_NAME);   // Column 1
                String longitude = rs.getString(ProjectDbCons.Marker.ITEM_LONGITUDE); // Column 2
                String latitude = rs.getString(ProjectDbCons.Marker.ITEM_LATITUDE); // Column 3
                Log.log("prjName:   " + prjName + "    longitude:   "
                        + longitude + "    latitude:  " + latitude);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取Project表
     */
    private void readProject() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + ProjectDbCons.TABLE_PRJS);
            while (rs.next()) {
                String prjName = rs.getString(ProjectDbCons.Prj.ITEM_PRJ_NAME);   // Column 1
                Log.log("prjName:   " + prjName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
