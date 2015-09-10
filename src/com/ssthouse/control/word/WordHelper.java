package com.ssthouse.control.word;

import com.ssthouse.app.DialogHelper;
import com.ssthouse.control.util.Log;
import com.ssthouse.model.MarkerItem;
import com.ssthouse.model.TransferItem;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Word文件工具类(.docx)
 * Created by ssthouse on 2015/8/29.
 */
public class WordHelper {
    private static final String TAG = "WordHelper";

    interface WordKey {
        //${title} ${item1} ${item2} ${item3}${date}
        public static String TITLE = "title";
        public static String DATE = "date";
        public static String ITEM1 = "item1";
        public static String ITEM2 = "item2";
        public static String ITEM3 = "item3";
    }

    //单例
    private static WordHelper wordHelper;

    /**
     * 获取唯一的单例
     *
     * @return
     */
    public static WordHelper getInstance() {
        if (wordHelper == null) {
            wordHelper = new WordHelper();
        }
        return wordHelper;
    }

    private WordHelper() {}

    /**
     * 用一个docx文档作为模板，然后替换其中的内容，再写入目标文档中。
     *
     * @throws Exception
     */
    public void generateWord(Component parent, TransferItem transferItem,
                             List<MarkerItem> markerItemList) {
        //获取需要替换的数据
        Map<String, String> params = new HashMap<String, String>();
        params.put(WordKey.TITLE, transferItem.getTitle());
        params.put(WordKey.DATE, transferItem.getDateStr());
        try {
            //获取template文件输入流
            InputStream is = this.getClass().getResourceAsStream("/template.docx");
            //DialogHelper.showErrorDialog(parent, "我运行到了这里"+(is==null));

            //根据输入流获取doc文件
            XWPFDocument doc = new XWPFDocument(is);

            // 替换段落里面的变量
            this.replaceInPara(doc, params);
            // 替换表格里面的变量
            this.replaceInTable(doc, params);

            //生成表格数据
            insertTable(doc, markerItemList);

            //输出文件
            OutputStream os = new FileOutputStream(transferItem.getWordOutputPath());
            doc.write(os);
            //关闭流
            os.close();
            is.close();
        } catch (IOException e) {
            Log.log(TAG, "word文件生成失败");
            DialogHelper.showErrorDialog(parent, "生成文件出错！");
        }
    }

    private void insertTable(XWPFDocument doc, List<MarkerItem> markerItemList) {
        List<String> columnList = new ArrayList<String>();
        columnList.add("工程名");
        columnList.add("经度");
        columnList.add("纬度");
        //插入表格
        XWPFTable table = doc.createTable(markerItemList.size() + 1, 3);
        setTableWidth(table, "8000");

        //插入表头
        XWPFTableRow rowHeader = table.getRow(0);
        for (int i = 0; i < 3; i++) {
            rowHeader.getCell(i).setText(columnList.get(i));
        }

        //插入其他数据
        for (int i = 0; i < markerItemList.size(); i++) {
            XWPFTableRow dataRow = table.getRow(i + 1);
            dataRow.getCell(0).setText(markerItemList.get(i).getPrjName());
            dataRow.getCell(1).setText(markerItemList.get(i).getLongtitude());
            dataRow.getCell(2).setText(markerItemList.get(i).getLatitude());
        }
    }

    /**
     * 设置Table高度
     *
     * @param table
     * @param width
     */
    public void setTableWidth(XWPFTable table, String width) {
        CTTbl ttbl = table.getCTTbl();
        CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl
                .getTblPr();
        CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr
                .addNewTblW();
        CTJc cTJc = tblPr.addNewJc();
        cTJc.setVal(STJc.Enum.forString("center"));
        tblWidth.setW(new BigInteger(width));
        tblWidth.setType(STTblWidth.DXA);
    }


    /**
     * 替换段落里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private void replaceInPara(XWPFDocument doc, Map<String, String> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            this.replaceInPara(para, params);
        }
    }

    /**
     * 替换段落里面的变量
     *
     * @param para   要替换的段落
     * @param params 参数
     */
    private void replaceInPara(XWPFParagraph para, Map<String, String> params) {
        List<XWPFRun> runs;
        Matcher matcher;
        if (this.matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();
            for (int i = 0; i < runs.size(); i++) {
                XWPFRun run = runs.get(i);
                //Log.logError(run.toString());
                String runText = run.toString();
                matcher = this.matcher(runText);
                if (matcher.find()) {
                    while ((matcher = this.matcher(runText)).find()) {
                        runText = matcher.replaceFirst(String.valueOf(params
                                .get(matcher.group(1))));
                    }
                    //Log.logError("我替换了一个!!!");
                    // 直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
                    // 所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
                    para.removeRun(i);
                    para.insertNewRun(i).setText(runText);
                }
            }
        }
    }

    /**
     * 替换表格里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private void replaceInTable(XWPFDocument doc, Map<String, String> params) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        this.replaceInPara(para, params);
                    }
                }
            }
        }
    }

    /**
     * 正则匹配字符串
     *
     * @param str
     * @return
     */
    private Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
}
