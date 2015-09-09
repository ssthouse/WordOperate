package com.ssthouse.control.word;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssthouse on 2015/9/2.
 */
public class WordDemo {

    public static void wordDemoTest() throws Exception {
        WordDemo t = new WordDemo();
        CustomXWPFDocument document = new CustomXWPFDocument();
        //设置页边距
        t.setDocumentMargin(document, "1797", "1440", "1797", "1440");
        //测试添加文字与图片
        t.testAddTextParagraph(document);
        //测试设置段落间距
        t.testParagraphSpacingInfo(document);
        //测试设置段落缩进
        t.testParagraphIndInfo(document);
        //测试表格单元格合并
        t.testMegerTableCell(document);
        //测试添加超链接
        t.testAddHyperlink(document);
        //TODO---测试添加页眉页脚
//        t.testAddHeaderFooter(document);
        t.saveDocument(document,
                "f:/testDemo.docx");
    }

    public void testAddTextParagraph(CustomXWPFDocument document)
            throws Exception {
        XWPFParagraph p = document.createParagraph();
        setTextFontInfo(p, false, false, "基本实验技能（常见实验仪器及基本操作）", "宋体", "000000",
                "40", true, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.CENTER,
                TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "班级：________    姓名：________", "宋体",
                "000000", "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.CENTER,
                TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "一、单选题(共10道，每道10分)", "宋体", "000000",
                "21", true, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "100", null, true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "1.下列有关仪器用途的说法错误的是(    )", "宋体",
                "000000", "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "A.烧杯用于较多量试剂的反应容器", "宋体", "000000",
                "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "100", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "B.烧杯用于较多量试剂的反应容器", "宋体", "000000",
                "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "C.烧杯用于较多量试剂的反应容器", "宋体", "000000",
                "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "D.烧杯用于较多量试剂的反应容器", "宋体", "000000",
                "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "2.下列实验操作中，正确的是(    ) ", "宋体",
                "000000", "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "100", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "A.", "宋体", "000000", "21", false,
                null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "100", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);
        String blipId = p.getDocument().addPictureData(
                new FileInputStream(new File("C:\\Workspace\\Intelij\\WordOperate\\123.jpg")),
                Document.PICTURE_TYPE_JPEG);
        document.createPicture(blipId,
                document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90, 93);

//        setTextFontInfo(p, true, false, "B", "宋体",
//                "000000", "21", false, null, false, false, null, 0, null);
//        blipId = p.getDocument().addPictureData(
//                new FileInputStream(new File("f:/saveFile/temp/image2.png")),
//                Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,
//                document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90, 93);
//
//        setTextFontInfo(p, true, true, "C.", "宋体", "000000", "21", false, null,
//                false, false, null, 0, null);
//        blipId = p.getDocument().addPictureData(
//                new FileInputStream(new File("f:/saveFile/temp/image3.png")),
//                Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,
//                document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90, 93);
//
//        setTextFontInfo(p, true, false, "D", "宋体",
//                "000000", "21", false, null, false, false, null, 0, null);
//        blipId = p.getDocument().addPictureData(
//                new FileInputStream(new File("f:/saveFile/temp/image4.png")),
//                Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,
//                document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90, 93);
    }

    public void testParagraphSpacingInfo(XWPFDocument document) {
        addNewPage(document, BreakType.PAGE);
        XWPFParagraph p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试单倍行距", "宋体", "000000", "21", false,
                null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, true, false, "测试最小值10磅", "宋体", "000000", "21",
                false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "200",
                STLineSpacingRule.Enum.forString("atLeast"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试固定值12磅", "宋体", "000000", "21",
                false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
                STLineSpacingRule.Enum.forString("exact"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试1.5倍行距", "宋体", "000000", "21",
                false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "360",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试2倍行距", "宋体", "000000", "21", false,
                null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "480",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试多倍行距3", "宋体", "000000", "21",
                false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "720",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试段前2行段后2行单倍行距", "宋体", "000000",
                "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "0", "0", "200", "200", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试段前2磅段后2磅单倍行距", "宋体", "000000",
                "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "40", "40", null, null, true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试段前2行段后2磅单倍行距", "宋体", "000000",
                "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, null, "40", "200", null, true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试段前2磅段后2行单倍行距", "宋体", "000000",
                "21", false, null, false, false, null, 0, null);
        setParagraphSpacingInfo(p, true, "40", null, null, "200", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);
    }

    public void testAddHyperlink(XWPFDocument document) {
        addNewPage(document, BreakType.TEXT_WRAPPING);
        XWPFParagraph p = document.createParagraph();
        setTextFontInfo(p, false, true, "", "宋体", "ff0000", "24", false, null,
                false, false, null, 0, null);
        setTextFontInfo(p, true, false, "测试", "宋体", "ff0000", "24", false,
                null, false, false, null, 0, "20");
        appendExternalHyperlink("mailto:1329186624@qq.com?subject=测试poi超链接",
                "联系我", p, "微软雅黑", "28", true, true, false, null, "4", "80");
        setTextFontInfo(p, true, false, "测试", "黑体", "00ff00", "26", false,
                null, false, false, null, 0, "20");
        setTextFontInfo(p, true, true, "", "宋体", "ff0000", "24", false, null,
                false, false, null, 0, null);
        setParagraphAlignInfo(p, ParagraphAlignment.CENTER,
                TextAlignment.CENTER);
        setParagraphSpacingInfo(p, true, "0", "0", "100", "100", true, "240",
                STLineSpacingRule.Enum.forString("auto"));
        setParagraphBorder(p, Borders.DOUBLE, Borders.DOUBLE, Borders.DOUBLE,
                Borders.DOUBLE, null);
    }

    public void testParagraphIndInfo(XWPFDocument document) {
        addNewPage(document, BreakType.PAGE);
        XWPFParagraph p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试首行缩进2字符", "宋体", "000000", "21",
                false, null, false, false, null, 0, null);
        setParagraphIndInfo(p, "440", "200", null, null, null, null, null, null);
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试悬挂缩进2字符", "宋体", "000000", "21",
                false, null, false, false, null, 0, null);
        setParagraphIndInfo(p, null, null, "440", "200", null, null, null, null);
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试左侧缩进2字符", "宋体", "000000", "21",
                false, null, false, false, null, 0, null);
        setParagraphIndInfo(p, null, null, null, null, null, null, "440", "200");
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);

        p = document.createParagraph();
        setTextFontInfo(p, false, false, "测试右侧缩进2字符", "宋体", "000000", "21",
                false, null, false, false, null, 0, null);
        setParagraphIndInfo(p, null, null, null, null, "440", "200", null, null);
        setParagraphAlignInfo(p, ParagraphAlignment.LEFT, TextAlignment.CENTER);
    }

    public void testMegerTableCell(XWPFDocument doc) {
        addNewPage(doc, BreakType.PAGE);
        List<String> columnList = new ArrayList<String>();
        columnList.add("序号");
        columnList.add("姓名信息|姓甚|名谁");
        columnList.add("名刺信息|籍贯|营生");
        columnList.add("字");
        XWPFTable table = doc.createTable(4, 6);
        setTableWidth(table, "8000");

        XWPFTableRow firstRow = table.getRow(0);
        XWPFTableRow secondRow = table.getRow(1);
        firstRow.setHeight(400);
        secondRow.setHeight(400);
        XWPFTableCell firstCell = null;
        XWPFTableCell secondCell = null;
        int firstCellIndex = 0;
        for (String str : columnList) {
            if (str.indexOf("|") == -1) {
                firstCell = firstRow.getCell(firstCellIndex);
                setCellText(firstCell, str, "CCCCCC", 1600);
                firstCellIndex++;
            } else {
                String[] strArr = str.split("\\|");
                for (int i = 1; i < strArr.length; i++) {
                    firstCell = firstRow.getCell(firstCellIndex);
                    setCellText(firstCell, strArr[0], "CCCCCC", 1600);
                    secondCell = secondRow.getCell(firstCellIndex);
                    setCellText(secondCell, strArr[i], "CCCCCC", 1600);
                    firstCellIndex++;
                }
            }
        }

        // 合并行(跨列)
        firstCellIndex = 0;
        for (String str : columnList) {
            if (str.indexOf("|") == -1) {
                firstCellIndex++;
            } else {
                String[] strArr = str.split("\\|");
                mergeCellsHorizontal(table, 0, firstCellIndex, firstCellIndex
                        + strArr.length - 2);
                firstCellIndex += strArr.length - 1;
            }
        }

        // 合并列(跨行)
        firstCellIndex = 0;
        for (String str : columnList) {
            if (str.indexOf("|") == -1) {
                mergeCellsVertically(table, firstCellIndex, 0, 1);
                firstCellIndex++;
            } else {
                String[] strArr = str.split("\\|");
                firstCellIndex += strArr.length - 1;
            }
        }

        // 数据
        for (int i = 2; i < 4; i++) {
            firstRow = table.getRow(i);
            firstRow.setHeight(380);
            for (int j = 0; j < 6; j++) {
                firstCell = firstRow.getCell(j);
                setCellText(firstCell, "测试", "FFFFC9", 1600);
            }
        }
    }

    public void testAddHeaderFooter(XWPFDocument doc) throws Exception {
        simpleDateHeader(doc);
        simpleNumberFooter(doc);
    }

    // 页脚:显示页码信息
    public void simpleNumberFooter(XWPFDocument document) throws Exception {
        CTP ctp = CTP.Factory.newInstance();
        XWPFParagraph codePara = new XWPFParagraph(ctp, document);
        XWPFRun r1 = codePara.createRun();
        r1.setText("第");
        r1.setFontSize(11);
        CTRPr rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr
                .addNewRFonts();
        fonts.setAscii("宋体");
        fonts.setEastAsia("宋体");
        fonts.setHAnsi("宋体");

        r1 = codePara.createRun();
        CTFldChar fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

        r1 = codePara.createRun();
        CTText ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("PAGE  \\* MERGEFORMAT");
        ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
        r1.setFontSize(11);
        rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii("宋体");
        fonts.setEastAsia("宋体");
        fonts.setHAnsi("宋体");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

        r1 = codePara.createRun();
        r1.setText("页 总共");
        r1.setFontSize(11);
        rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii("宋体");
        fonts.setEastAsia("宋体");
        fonts.setHAnsi("宋体");

        r1 = codePara.createRun();
        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

        r1 = codePara.createRun();
        ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("NUMPAGES  \\* MERGEFORMAT ");
        ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
        r1.setFontSize(11);
        rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii("宋体");
        fonts.setEastAsia("宋体");
        fonts.setHAnsi("宋体");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

        r1 = codePara.createRun();
        r1.setText("页");
        r1.setFontSize(11);
        rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii("宋体");
        fonts.setEastAsia("宋体");
        fonts.setHAnsi("宋体");

        codePara.setAlignment(ParagraphAlignment.CENTER);
        codePara.setVerticalAlignment(TextAlignment.CENTER);
        codePara.setBorderTop(Borders.THICK);
        XWPFParagraph[] newparagraphs = new XWPFParagraph[1];
        newparagraphs[0] = codePara;
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(
                document, sectPr);
        headerFooterPolicy.createFooter(STHdrFtr.DEFAULT, newparagraphs);
    }

    public void simpleDateHeader(XWPFDocument document) throws Exception {
        CTP ctp = CTP.Factory.newInstance();
        XWPFParagraph codePara = new XWPFParagraph(ctp, document);

        XWPFRun r1 = codePara.createRun();
        CTFldChar fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

        r1 = codePara.createRun();
        CTText ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("TIME \\@ \"EEEE\"");
        ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
        r1.setFontSize(11);
        CTRPr rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr
                .addNewRFonts();
        fonts.setAscii("微软雅黑");
        fonts.setEastAsia("微软雅黑");
        fonts.setHAnsi("微软雅黑");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

        r1 = codePara.createRun();
        r1.setText("年");
        r1.setFontSize(11);
        rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii("微软雅黑");
        fonts.setEastAsia("微软雅黑");
        fonts.setHAnsi("微软雅黑");

        r1 = codePara.createRun();
        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

        r1 = codePara.createRun();
        ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("TIME \\@ \"O\"");
        ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
        r1.setFontSize(11);
        rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii("微软雅黑");
        fonts.setEastAsia("微软雅黑");
        fonts.setHAnsi("微软雅黑");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

        r1 = codePara.createRun();
        r1.setText("月");
        r1.setFontSize(11);
        rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii("微软雅黑");
        fonts.setEastAsia("微软雅黑");
        fonts.setHAnsi("微软雅黑");

        r1 = codePara.createRun();
        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

        r1 = codePara.createRun();
        ctText = r1.getCTR().addNewInstrText();
        ctText.setStringValue("TIME \\@ \"A\"");
        ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
        r1.setFontSize(11);
        rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii("微软雅黑");
        fonts.setEastAsia("微软雅黑");
        fonts.setHAnsi("微软雅黑");

        fldChar = r1.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

        r1 = codePara.createRun();
        r1.setText("日");
        r1.setFontSize(11);
        rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
                .addNewRPr();
        fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii("微软雅黑");
        fonts.setEastAsia("微软雅黑");
        fonts.setHAnsi("微软雅黑");

        codePara.setAlignment(ParagraphAlignment.CENTER);
        codePara.setVerticalAlignment(TextAlignment.CENTER);
        codePara.setBorderBottom(Borders.THICK);
        XWPFParagraph[] newparagraphs = new XWPFParagraph[1];
        newparagraphs[0] = codePara;
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(
                document, sectPr);
        headerFooterPolicy.createHeader(STHdrFtr.DEFAULT, newparagraphs);
    }

    public void setCellText(XWPFTableCell cell, String text, String bgcolor,
                            int width) {
        CTTc cttc = cell.getCTTc();
        CTTcPr ctPr = cttc.addNewTcPr();
        CTShd ctshd = ctPr.addNewShd();
        ctPr.addNewTcW().setW(BigInteger.valueOf(width));
        ctshd.setFill(bgcolor);
        ctPr.addNewVAlign().setVal(STVerticalJc.CENTER);
        cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        cell.setText(text);
    }

    /**
     * @Description: 跨列合并
     */
    public void mergeCellsHorizontal(XWPFTable table, int row, int fromCell,
                                     int toCell) {
        for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
            XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
            if (cellIndex == fromCell) {
//                cell.getCTTc().addNewTcPr().addNewHMerge()
//                        .setVal(STMerge.RESTART);
            } else {
//                cell.getCTTc().addNewTcPr().addNewHMerge()
//                        .setVal(STMerge.CONTINUE);
            }
        }
    }

    /**
     * @Description: 跨行合并
     */
    public void mergeCellsVertically(XWPFTable table, int col, int fromRow,
                                     int toRow) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            if (rowIndex == fromRow) {
//                cell.getCTTc().addNewTcPr().addNewVMerge()
//                        .setVal(STMerge.RESTART);
            } else {
//                cell.getCTTc().addNewTcPr().addNewVMerge()
//                        .setVal(STMerge.CONTINUE);
            }
        }
    }

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

    // 设置段落边框
    public void setParagraphBorder(XWPFParagraph p, Borders lborder,
                                   Borders tBorders, Borders rBorders, Borders bBorders,
                                   Borders btborders) {
        if (lborder != null) {
            p.setBorderLeft(lborder);
        }
        if (tBorders != null) {
            p.setBorderTop(tBorders);
        }
        if (rBorders != null) {
            p.setBorderRight(rBorders);
        }
        if (bBorders != null) {
            p.setBorderBottom(bBorders);
        }
        if (btborders != null) {
            p.setBorderBetween(btborders);
        }
    }

    // 设置段落对齐
    public void setParagraphAlignInfo(XWPFParagraph p,
                                      ParagraphAlignment pAlign, TextAlignment valign) {
        p.setAlignment(pAlign);
        p.setVerticalAlignment(valign);
    }

    // 设置段落缩进信息 1厘米≈567
    public void setParagraphIndInfo(XWPFParagraph p, String firstLine,
                                    String firstLineChar, String hanging, String hangingChar,
                                    String right, String rigthChar, String left, String leftChar) {
        CTPPr pPPr = null;
        if (p.getCTP() != null) {
            if (p.getCTP().getPPr() != null) {
                pPPr = p.getCTP().getPPr();
            } else {
                pPPr = p.getCTP().addNewPPr();
            }
        }
        CTInd pInd = pPPr.getInd() != null ? pPPr.getInd() : pPPr.addNewInd();
        if (firstLine != null) {
            pInd.setFirstLine(new BigInteger(firstLine));
        }
        if (firstLineChar != null) {
            pInd.setFirstLineChars(new BigInteger(firstLineChar));
        }
        if (hanging != null) {
            pInd.setHanging(new BigInteger(hanging));
        }
        if (hangingChar != null) {
            pInd.setHangingChars(new BigInteger(hangingChar));
        }
        if (left != null) {
            pInd.setLeft(new BigInteger(left));
        }
        if (leftChar != null) {
            pInd.setLeftChars(new BigInteger(leftChar));
        }
        if (right != null) {
            pInd.setRight(new BigInteger(right));
        }
        if (rigthChar != null) {
            pInd.setRightChars(new BigInteger(rigthChar));
        }
    }

    // 设置段落间距信息
    // 一行=100 一磅=20
    public void setParagraphSpacingInfo(XWPFParagraph p, boolean isSpace,
                                        String before, String after, String beforeLines, String afterLines,
                                        boolean isLine, String line, STLineSpacingRule.Enum lineValue) {
        CTPPr pPPr = null;
        if (p.getCTP() != null) {
            if (p.getCTP().getPPr() != null) {
                pPPr = p.getCTP().getPPr();
            } else {
                pPPr = p.getCTP().addNewPPr();
            }
        }
        CTSpacing pSpacing = pPPr.getSpacing() != null ? pPPr.getSpacing()
                : pPPr.addNewSpacing();
        if (isSpace) {
            // 段前磅数
            if (before != null) {
                pSpacing.setBefore(new BigInteger(before));
            }
            // 段后磅数
            if (after != null) {
                pSpacing.setAfter(new BigInteger(after));
            }
            // 段前行数
            if (beforeLines != null) {
                pSpacing.setBeforeLines(new BigInteger(beforeLines));
            }
            // 段后行数
            if (afterLines != null) {
                pSpacing.setAfterLines(new BigInteger(afterLines));
            }
        }
        if (isLine) {
            if (line != null) {
                pSpacing.setLine(new BigInteger(line));
            }
            if (lineValue != null) {
                pSpacing.setLineRule(lineValue);
            }
        }
    }

    /**
     * @param verticalAlign SUPERSCRIPT上标 SUBSCRIPT下标
     * @param position      字符位置 1磅=2
     */
    // 设置字体信息 设置字符间距信息(CTSignedTwipsMeasure)
    public void setTextFontInfo(XWPFParagraph p, boolean isInsert,
                                boolean isNewLine, String content, String fontFamily,
                                String colorVal, String fontSize, boolean isBlod,
                                UnderlinePatterns underPatterns, boolean isItalic,
                                boolean isStrike, VerticalAlign verticalAlign, int position, String spacingValue) {
        XWPFRun pRun = null;
        if (isInsert) {
            pRun = p.createRun();
        } else {
            if (p.getRuns() != null && p.getRuns().size() > 0) {
                pRun = p.getRuns().get(0);
            } else {
                pRun = p.createRun();
            }
        }
        if (isNewLine) {
            pRun.addBreak();
        }
        pRun.setText(content);
        // 设置字体样式
        pRun.setBold(isBlod);
        pRun.setItalic(isItalic);
        pRun.setStrike(isStrike);
        if (underPatterns != null) {
            pRun.setUnderline(underPatterns);
        }
        pRun.setColor(colorVal);
        if (verticalAlign != null) {
            pRun.setSubscript(verticalAlign);
        }
        pRun.setTextPosition(position);

        CTRPr pRpr = null;
        if (pRun.getCTR() != null) {
            pRpr = pRun.getCTR().getRPr();
            if (pRpr == null) {
                pRpr = pRun.getCTR().addNewRPr();
            }
        } else {
            // pRpr = p.getCTP().addNewR().addNewRPr();
        }
        // 设置字体
        CTFonts fonts = pRpr.isSetRFonts() ? pRpr.getRFonts() : pRpr
                .addNewRFonts();
        fonts.setAscii(fontFamily);
        fonts.setEastAsia(fontFamily);
        fonts.setHAnsi(fontFamily);

        // 设置字体大小
        CTHpsMeasure sz = pRpr.isSetSz() ? pRpr.getSz() : pRpr.addNewSz();
        sz.setVal(new BigInteger(fontSize));

        CTHpsMeasure szCs = pRpr.isSetSzCs() ? pRpr.getSzCs() : pRpr
                .addNewSzCs();
        szCs.setVal(new BigInteger(fontSize));

        if (spacingValue != null) {
            //设置字符间距信息
//            CTSignedTwipsMeasure ctSTwipsMeasure=pRpr.isSetSpacing()?pRpr.getSpacing(): pRpr.addNewSpacing();
//            ctSTwipsMeasure.setVal(new BigInteger(spacingValue));
        }
    }

    /**
     * @param position 1磅=2
     * @Description: 添加超链接
     */
    // 为段落添加超链接
    public void appendExternalHyperlink(String url, String text,
                                        XWPFParagraph paragraph, String fontFamily, String fontSize,
                                        boolean isBlod, boolean isItalic, boolean isStrike,
                                        String verticalAlign, String position, String spacingValue) {
        // Add the link as External relationship
        String id = paragraph
                .getDocument()
                .getPackagePart()
                .addExternalRelationship(url,
                        XWPFRelation.HYPERLINK.getRelation()).getId();
        // Append the link and bind it to the relationship
        CTHyperlink cLink = paragraph.getCTP().addNewHyperlink();
        cLink.setId(id);

        // Create the linked text
        CTText ctText = CTText.Factory.newInstance();
        ctText.setStringValue(text);
        CTR ctr = CTR.Factory.newInstance();
        CTRPr rpr = ctr.addNewRPr();

        // 设置超链接样式
        CTColor color = CTColor.Factory.newInstance();
        color.setVal("0000FF");
        rpr.setColor(color);
        rpr.addNewU().setVal(STUnderline.SINGLE);
        if (isBlod) {
            rpr.addNewB().setVal(STOnOff.Enum.forString("true"));
        }
        if (isItalic) {
            rpr.addNewI().setVal(STOnOff.Enum.forString("true"));
        }
        if (isStrike) {
            rpr.addNewStrike().setVal(STOnOff.Enum.forString("true"));
        }
        if (verticalAlign != null) {
            rpr.addNewVertAlign().setVal(
                    STVerticalAlignRun.Enum.forString(verticalAlign));
        }
        rpr.addNewPosition().setVal(new BigInteger(position));

        // 设置字体
        CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr
                .addNewRFonts();
        fonts.setAscii(fontFamily);
        fonts.setEastAsia(fontFamily);
        fonts.setHAnsi(fontFamily);

        // 设置字体大小
        CTHpsMeasure sz = rpr.isSetSz() ? rpr.getSz() : rpr.addNewSz();
        sz.setVal(new BigInteger(fontSize));

        CTHpsMeasure szCs = rpr.isSetSzCs() ? rpr.getSzCs() : rpr.addNewSzCs();
        szCs.setVal(new BigInteger(fontSize));

        if (spacingValue != null) {
            //设置字符间距信息
//            CTSignedTwipsMeasure ctSTwipsMeasure = rpr.isSetSpacing() ? rpr.getSpacing()
//            getSpacing:
//            rpr.addNewSpacing();
//            ctSTwipsMeasure.setVal(new BigInteger(spacingValue));
        }

        ctr.setTArray(new CTText[]{ctText});
        cLink.setRArray(new CTR[]{ctr});
    }

    public void addNewPage(XWPFDocument document, BreakType breakType) {
        XWPFParagraph xp = document.createParagraph();
        xp.createRun().addBreak(breakType);
    }

    //设置页边距 1厘米约等于567
    public void setDocumentMargin(XWPFDocument document, String left, String top,
                                  String right, String bottom) {
        CTSectPr sectPr = document.getDocument().getBody().isSetSectPr() ?
                document.getDocument().getBody().getSectPr()
                : document.getDocument().getBody().addNewSectPr();
//        CTPageMar ctpagemar=sectPr.addNewPgMar();
//        ctpagemar.setLeft(new BigInteger(left));
//        ctpagemar.setTop(new BigInteger(top));
//        ctpagemar.setRight(new BigInteger(right));
//        ctpagemar.setBottom(new BigInteger(bottom));
    }

    public void saveDocument(XWPFDocument document, String savePath)
            throws Exception {
        FileOutputStream fos = new FileOutputStream(savePath);
        document.write(fos);
        fos.close();
    }

}
