package com.ssthouse.util;

import java.io.*;

/**
 * 文件处理工具类
 * Created by ssthouse on 2015/9/1.
 */
public class FileHelper {
    private static String TAG = "FileHelper";

    /**
     * 复制文件
     *
     * @param srcFile
     * @param targetFile
     */
    public static void copy(File srcFile, File targetFile) {
        Log.log(TAG, srcFile.getAbsolutePath() + "    " + targetFile.getAbsolutePath());
        //判断两个文件是否存在
        if (!srcFile.exists()) {
            return;
        }
        if (!targetFile.exists()) {
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //复制文件
        try {
            byte[] bytes = new byte[1024];
            FileInputStream fi = new FileInputStream(srcFile);
            OutputStream os = new FileOutputStream(targetFile);
            while (fi.read(bytes) != -1) {
                os.write(bytes);
            }
            //关闭流
            fi.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
