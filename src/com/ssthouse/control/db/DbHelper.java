package com.ssthouse.control.db;

import com.ssthouse.control.util.FileHelper;
import com.ssthouse.control.util.Log;
import com.ssthouse.app.DialogHelper;
import com.ssthouse.model.MarkerItem;

import java.awt.*;
import java.io.File;
import java.sql.*;
import java.util.*;
import java.util.List;

/**
 * 数据库管理类
 * Created by ssthouse on 2015/9/1.
 */
public class DbHelper {
    private static final String TAG = "DbHelper";

    private static final String dbCopyName = "location.db";

    //Marker表常量
    interface MarkerCons{
        public static String ITEM_PRJ_NAME = "prjName";
        public static String ITEM_LONGITUDE = "longitude";
        public static String ITEM_LATITUDE = "latitude";
    }
    //Project表常量
    interface ProjectCons {
        public String TABLE_PRJS = "Projects";
        public String TABLE_Markers="Markers";
        public String ITEM_PRJ_NAME = "prjName";
    }

    private Component parent;
    private File dbFile;
    //数据库操作源
    private Connection connection;

    /**
     * 构造方法
     * 初始化数据库---之后可以直接进行读取操作
     *
     * @param parent
     * @param dbFile
     */
    public DbHelper(Component parent, File dbFile) {
        this.parent = parent;
        this.dbFile = dbFile;
        //将数据库复制到本地
        FileHelper.copy(dbFile, new File(System.getProperty("user.dir")+"\\"+dbCopyName));
        //连接数据库
        openDb();
    }

    /**
     * 打开数据库    并建立连接
     */
    public void openDb() {
        if(dbFile == null){
            return;
        }
        try {
            //加载数据库驱动
            Class.forName("org.sqlite.JDBC");
            //建立和当前目录数据库的链接
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbCopyName);
        } catch (SQLException e) {
            DialogHelper.showDbWrongDialog(parent);
            connection = null;
        } catch (ClassNotFoundException e) {
            DialogHelper.showDriveErrorDialog(parent);
            connection = null;
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
     * 读取Marker表
     */
    public List<MarkerItem> getMarkers(String prjName) {
        List<MarkerItem> markerList = new ArrayList<MarkerItem>();
        try {
            Statement statement = connection.createStatement();
            String str = "'" + prjName +"';";
            ResultSet rs = statement.executeQuery("SELECT * FROM " + ProjectCons.TABLE_Markers
                    +" WHERE prjName = "+str);
            while (rs.next()) {
                String projectName = rs.getString(MarkerCons.ITEM_PRJ_NAME);
                String longitude = rs.getString(MarkerCons.ITEM_LONGITUDE);
                String latitude = rs.getString(MarkerCons.ITEM_LATITUDE);
                Log.log("prjName:   " + prjName + "    longitude:   "
                        + longitude + "    latitude:  " + latitude);
                markerList.add(new MarkerItem(projectName, longitude, latitude));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return markerList;
    }

    /**
     * 读取Project表
     */
    public List<String> getProjects() {
        List<String> list = new ArrayList<String>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + ProjectCons.TABLE_PRJS);
            while (rs.next()) {
                String prjName = rs.getString(ProjectCons.ITEM_PRJ_NAME);
                list.add(prjName);
//                Log.log("prjName:   " + prjName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //**************getter********and*********setter***********
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public File getDbFile() {
        return dbFile;
    }

    public void setDbFile(File dbFile) {
        this.dbFile = dbFile;
    }
}
