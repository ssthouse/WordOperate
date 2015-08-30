package com.ssthouse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * Excel文件工具类
 * Created by ssthouse on 2015/8/29.
 */
public class ExcelHelper {
    private static String TAG = "ExcelHelper";

    private static ExcelHelper excelHelper;

    private ExcelHelper(){}

    public static ExcelHelper getInstance(){
        if(excelHelper == null){
            excelHelper = new ExcelHelper();
        }
        return excelHelper;
    }

    public void generateFromTemplate(String path){

    }

    /**
     * 传入路径---不管文件存不存在--都可以写入数据
     *
     * @param path
     */
    public void write(String path) {
        //创建工作文档对象
        Workbook wb;
        wb = new XSSFWorkbook();
        //创建sheet对象
        Sheet sheet1 = wb.createSheet("sheet1");
        //循环写入行数据
        for (int i = 0; i < 5; i++) {
            Row row = sheet1.createRow(i);
            //循环写入列数据
            for (int j = 0; j < 8; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue("测试" + j);
            }
        }
        try {
            //创建文件流
            OutputStream stream = new FileOutputStream(path);
            //写入数据
            wb.write(stream);
            //关闭文件流
            stream.close();
        } catch (IOException e) {
            Log.log(TAG, "wrong!!!");
            e.printStackTrace();
        }
    }

    /**
     * 读取指定路径的xlsx文件
     * @param path
     */
    public void read(String path) {
        try {
            InputStream stream = new FileInputStream(path);
            Workbook wb;
            wb = new XSSFWorkbook(stream);
            Sheet sheet1 = wb.getSheetAt(0);
            for (Row row : sheet1) {
                for (Cell cell : row) {
                    System.out.print(cell.getStringCellValue() + "  ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
