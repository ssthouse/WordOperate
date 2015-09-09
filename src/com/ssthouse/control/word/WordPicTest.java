package com.ssthouse.control.word;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 可以添加图片
 * Created by ssthouse on 2015/9/2.
 */
public class WordPicTest {

    public static void addPic() {
        try {
            CustomXWPFDocument docx = new CustomXWPFDocument(new FileInputStream(
                    "C:\\Workspace\\Intelij\\WordOperate\\template.docx"));

            //这句话只是把一张图片文件添加到.docx文件中去....
            String picId = docx.addPictureData(new FileInputStream("C:\\Workspace\\Intelij\\WordOperate\\123.jpg"),
                    XWPFDocument.PICTURE_TYPE_JPEG);
            //这句话才是真正地把图片插入到文档中去
            docx.createPicture(picId, docx.getNextPicNameNumber(XWPFDocument.PICTURE_TYPE_JPEG),
                    100, 100);
            docx.createPicture(picId, docx.getNextPicNameNumber(XWPFDocument.PICTURE_TYPE_JPEG),
                    100, 100);
            docx.createPicture(picId, docx.getNextPicNameNumber(XWPFDocument.PICTURE_TYPE_JPEG),
                    100, 100);

            //输出文件
            OutputStream os = new FileOutputStream("C:\\Workspace\\Intelij\\WordOperate\\pic.docx");
            docx.write(os);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
