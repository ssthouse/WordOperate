package com.ssthouse.model;

/**
 * 一次转换的数据
 * Created by ssthouse on 2015/9/9.
 */
public class TransferItem {

    //当前选中工程名
    private String prjName;
    //当前各种路径
    private String dbPath;
    private String wordOutputPath;
    private String excelOutputPath;
    //word的专属属性----可以不要
    private String title;
    private String dateStr;

    /**
     * 数据是否齐全
     *
     * @return
     */
    public boolean isEmpty() {
        if (dbPath.isEmpty() || title.isEmpty()
                || dateStr.isEmpty()) {
            return true;
        } else if (wordOutputPath.isEmpty() && excelOutputPath.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * word数据是否齐备
     * @return
     */
    public boolean isWordEnable(){
        if(dbPath.isEmpty() || title.isEmpty()
                || dateStr.isEmpty()
                || wordOutputPath.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Excel数据是否齐备
     * @return
     */
    public boolean isExcelEnable(){
        if(dbPath.isEmpty() || title.isEmpty()
                || dateStr.isEmpty()
                || wordOutputPath.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    //getter----and----setter---------------------------------------

    public String getDbPath() {
        if (dbPath == null) {
            return "";
        }
        return dbPath;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }

    public String getWordOutputPath() {
        return wordOutputPath;
    }

    public void setWordOutputPath(String wordOutputPath) {
        this.wordOutputPath = wordOutputPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getExcelOutputPath() {
        return excelOutputPath;
    }

    public void setExcelOutputPath(String excelOutputPath) {
        this.excelOutputPath = excelOutputPath;
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName;
    }
}
