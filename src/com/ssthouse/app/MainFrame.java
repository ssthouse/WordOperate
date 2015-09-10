package com.ssthouse.app;

import com.ssthouse.control.db.DbHelper;
import com.ssthouse.control.excel.ExcelHelper;
import com.ssthouse.control.word.WordHelper;
import com.ssthouse.model.MarkerItem;
import com.ssthouse.model.TransferItem;
import com.ssthouse.control.util.FileChooserHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * 主程序入口
 * Created by ssthouse on 2015/9/8.
 */
public class MainFrame extends JFrame {
    //UI控件
    private JTextField tfDatabse;
    private JButton btnGetDatabase;
    private JTable table;
    private JTextField tfWordOutput;
    private JButton btnWordOutputFile;
    private JPanel mainPanel;
    private JTextArea tfTip;
    private JComboBox cbPrjName;
    private JButton btnGenerateWord;
    private JButton btnGenerateExcel;
    private JTextField tfTitle;
    private JTextField tfDate;
    private JTextField tfExcelOutput;
    private JButton btnExcelOutput;

    //当前文档导出的数据
    private TransferItem transferItem;
    //当前数据库操作类
    private DbHelper dbHelper;
    //combobox数据
    private DefaultComboBoxModel<String> comboBoxModel;
    //table数据
    private DefaultTableModel tableModel;

    /**
     * 程序入口
     *
     * @param title
     * @throws java.awt.HeadlessException
     */
    public MainFrame(String title) throws HeadlessException {
        super(title);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 200);
        this.pack();

        transferItem = new TransferItem();
        comboBoxModel = new DefaultComboBoxModel<String>();
        tableModel = new DefaultTableModel();

        initView();
    }

    /**
     * 初始化控件和Event
     */
    private void initView() {
        //打开数据库
        btnGetDatabase.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                File file = FileChooserHelper.getDbFile(MainFrame.this);
                //初始化数据库
                dbHelper = new DbHelper(MainFrame.this, file);
                //初始化comboBox
                initComboBox();

                //当前转换数据更新
                transferItem.setDbPath(file.getAbsolutePath());
                transferItem.setPrjName(comboBoxModel.getElementAt(cbPrjName.getSelectedIndex()));
                //数据库路径文字显示
                tfDatabse.setText(file.getName());

                //初始化table
                initMarkerTable();
            }
        });

        //comboBox选择工程
        cbPrjName.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //更新当前选中的Prjname
                String prjName = comboBoxModel.getElementAt(cbPrjName.getSelectedIndex());
                transferItem.setPrjName(prjName);
                //更新Marker表格
                initMarkerTable();
                //更新Table数据
                initMarkerTable();
            }
        });

        //打开Word文件路径
        btnWordOutputFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                File file = FileChooserHelper.getWordOutputFilePath(MainFrame.this);
                transferItem.setWordOutputPath(file.getAbsolutePath() + ".docx");
                tfWordOutput.setText(file.getName() + ".docx");
                //更新word标题---日期
                transferItem.setTitle(transferItem.getPrjName());
                tfTitle.setText(transferItem.getPrjName());
                //日期
                Calendar cal = Calendar.getInstance();
                //注意： Calendar月份要加一
                String str = cal.get(Calendar.YEAR) + ":" + cal.get(Calendar.MONTH + 1)
                        + ":" + cal.get(Calendar.DAY_OF_MONTH);
                transferItem.setDateStr(str);
                tfDate.setText(str);
            }
        });

        //打开Excel路径
        btnExcelOutput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                File file = FileChooserHelper.getExcelOutputFilePath(MainFrame.this);
                transferItem.setExcelOutputPath(file.getAbsolutePath() + ".xlsx");
                tfExcelOutput.setText(file.getName() + ".xlsx");
            }
        });

        //生成word文件
        btnGenerateWord.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //判断条件是否符合
                if (!transferItem.isWordEnable()) {
                    DialogHelper.showWordUnableDialog(MainFrame.this);
                } else {
                    //TODO---生成word文件
                    WordHelper.getInstance().generateWord(MainFrame.this, transferItem,
                            dbHelper.getMarkers(transferItem.getPrjName()));
                    //弹出Dialog
                    DialogHelper.showWordCompleteDialog(MainFrame.this);
                }
            }
        });

        //生成excel文件
        btnGenerateExcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //判断条件是否符合
                if (!transferItem.isExcelEnable()) {
                    DialogHelper.showExcelUnableDialog(MainFrame.this);
                } else {
                    ExcelHelper.getInstance().generateExcel(transferItem.getExcelOutputPath(),
                            transferItem.getPrjName(), dbHelper.getMarkers(transferItem.getPrjName()));
                    //弹出Dialog
                    DialogHelper.showExcelCompleteDialog(MainFrame.this);
                }
            }
        });
    }

    /**
     * 初始化ComboBox数据
     */
    private void initComboBox() {
        // 初始化ComboBox数据
        java.util.List<String> list = dbHelper.getProjects();
        for (String prjName : list) {
            comboBoxModel.addElement(prjName);
        }
        cbPrjName.setModel(comboBoxModel);
    }

    /**
     * 初始化Table数据
     */
    private void initMarkerTable() {
        List<MarkerItem> markerList = dbHelper.getMarkers(transferItem.getPrjName());
        String[] columnNames = {"工程名", "经度", "纬度"};
        tableModel = new DefaultTableModel(null, columnNames);
        tableModel.addRow(columnNames);
        for (MarkerItem item : markerList) {
            String data[] = {item.getPrjName(), item.getLongtitude(), item.getLatitude()};
            tableModel.addRow(data);
        }
        table.setModel(tableModel);
    }
}
