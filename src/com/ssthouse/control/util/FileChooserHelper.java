package com.ssthouse.control.util;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;

/**
 * 打开文件浏览器获取文件路径
 * Created by ssthouse on 2015/9/8.
 */
public class FileChooserHelper {

    /**
     * 获取数据库文件路径
     * @param parent
     * @return
     */
    public static File getDbFile(Component parent) {
        JFileChooser fileChooser = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.getName().contains(".db")) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String getDescription() {
                return ".db(sqlite数据库文件)";
            }
        });
        fileChooser.showOpenDialog(parent);
        return fileChooser.getSelectedFile();
    }

    /**
     * 获取word文件存储路径
     * @param parent
     * @return
     */
    public static File getWordOutputFilePath(Component parent){
        JFileChooser fileChooser = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return true;
            }

            @Override
            public String getDescription() {
                return ".docx(word文档)";
            }
        });
        fileChooser.showSaveDialog(parent);
        return fileChooser.getSelectedFile();
    }


    /**
     * 获取Excel文件存储路径
     * @param parent
     * @return
     */
    public static File getExcelOutputFilePath(Component parent){
        JFileChooser fileChooser = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return true;
            }

            @Override
            public String getDescription() {
                return ".xlsx(excel文档)";
            }
        });
        fileChooser.showSaveDialog(parent);
        return fileChooser.getSelectedFile();
    }
}
