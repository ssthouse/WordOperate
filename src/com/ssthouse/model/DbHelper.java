package com.ssthouse.model;

import com.ssthouse.model.database.ProjectDbCons;
import com.ssthouse.util.FileHelper;
import com.ssthouse.util.Log;

import javax.swing.*;
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

    private Component parent;

    private File dbFile;

    //数据库操作源
    private Connection connection;

    public DbHelper(Component parent) {
        this.parent = parent;

    }

    /**
     * 显示数据库选择Dialog
     */
    public void showDbChooseDialog() {
        JFileChooser fileChooseDialog = new JFileChooser();
        fileChooseDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooseDialog.showDialog(new JLabel(), "选择数据库文件");
        //窗口应该会停在这里等待文件被选中
        File file = fileChooseDialog.getSelectedFile();
        dbFile = fileChooseDialog.getSelectedFile();
        //将文件复制到项目目录
        FileHelper.copy(dbFile, new File(System.getProperty("user.dir") + "\\" + dbFile.getName()));
        System.out.println("文件:" + file.getAbsolutePath());

        //TODO
        //尝试打开文件
        openDb();

        //读取Marker和Project数据
        readMarker();
        readProject();
    }

    public void openDb() {
        try {
            //连接SQLite的JDBC
            Class.forName("org.sqlite.JDBC");
            //建立一个数据库名test.db的连接，如果不存在就在当前目录下创建之
            connection = DriverManager.getConnection("jdbc:sqlite:" + "test.db");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("打开数据库失败");
        } catch (ClassNotFoundException e) {
            Log.log("没找到类");
            e.printStackTrace();
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
