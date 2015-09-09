package com.ssthouse.control.excel;

import com.ssthouse.control.util.Log;
import com.ssthouse.model.MarkerItem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

/**
 * Excel文件工具类
 * Created by ssthouse on 2015/8/29.
 */
public class ExcelHelper {
    private static String TAG = "ExcelHelper";

    private static ExcelHelper excelHelper;

    private ExcelHelper() {
    }

    public static ExcelHelper getInstance() {
        if (excelHelper == null) {
            excelHelper = new ExcelHelper();
        }
        return excelHelper;
    }

    /**
     * 创建Excel文件
     *
     * @param path
     */
    public void generateExcel(String path, String prjName, List<MarkerItem> markerItemList) {
        //创建工作文档对象
        Workbook wb = new XSSFWorkbook();
        //创建sheet对象
        Sheet sheet1 = wb.createSheet(prjName);
        //创建Header
        createHeader(sheet1);
        //循环写入行数据
        for (int i = 0; i < markerItemList.size(); i++) {
            Row row = sheet1.createRow(i+1);
            //循环写入列数据
            Cell cell0 = row.createCell(0);
            Cell cell1 = row.createCell(1);
            Cell cell2 = row.createCell(2);
            cell0.setCellValue(markerItemList.get(i).getPrjName());
            cell1.setCellValue(markerItemList.get(i).getLongtitude());
            cell2.setCellValue(markerItemList.get(i).getLatitude());
        }
        try {
            //创建文件流
            OutputStream stream = new FileOutputStream(path);
            //写入数据
            wb.write(stream);
            //关闭文件流
            stream.close();
            Log.log(TAG, "Excel创建完毕");
        } catch (IOException e) {
            Log.log(TAG, "wrong!!!");
            e.printStackTrace();
        }
    }

    /**
     * 创建表头
     * @param sheet
     */
    private void createHeader(Sheet sheet){
        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        Cell cell1 = row.createCell(1);
        Cell cell2 = row.createCell(2);
        cell0.setCellValue("工程名");
        cell1.setCellValue("经度");
        cell2.setCellValue("纬度");
    }

    /**
     * 读取指定路径的xlsx文件
     *
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
