package main.presentation.financeui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.EarnVO;

public class EarnListPanel {

	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	private JLabel title;
	private int year;//当前年份
	private JLabel timeLabel;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;//31天
	private JComboBox<String> yearBox;//表示年份的组合框
	private JComboBox<String> monthBox;//表示月份的组合框
	private JComboBox<String> dayBox;//表示天的组合框
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton delButton;
	private JButton saveButton;
	private JButton ensureButton;//确认选择时间完毕
	
	public EarnListPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		setTime();
		initTable();
		delButton = new JButton("删除");
		saveButton = new JButton("保存");
		delButton.setBounds(panelWidth*3/5, panelHeight*9/10, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*3/5+delButton.getWidth()*2, panelHeight*9/10, panelWidth/10, panelHeight/20);
		panel.add(delButton);
		panel.add(saveButton);
		panel.repaint();
	}
	public void title(){
		title = new JLabel("结算管理");
		title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
		panel.add(title);
	}
	//设置时间的框
	public void setTime(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		
		timeLabel = new JLabel("时间");
		yearLabel = new JLabel("年");
		monthLabel = new JLabel("月");
		dayLabel = new JLabel("日");
		ensureButton = new JButton("确认");
		yearBox = new JComboBox<String>(yearString);
		monthBox = new JComboBox<String>(monthString);
		dayBox = new JComboBox<String>(dayString);
		
		panel.add(ensureButton);
		panel.add(timeLabel);
		panel.add(yearLabel);
		panel.add(monthLabel);
		panel.add(dayLabel);
		panel.add(yearBox);
		panel.add(monthBox);
		panel.add(dayBox);
		

		timeLabel.setBounds(panelWidth/20, panelHeight/10, panelWidth/10, panelHeight/20);
		yearBox.setBounds(timeLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		yearLabel.setBounds(yearBox.getX()+panelWidth/10+panelWidth/40, panelHeight/10, panelWidth/20, panelHeight/20);
		monthBox.setBounds(yearLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		monthLabel.setBounds(monthBox.getX()+panelWidth/10+panelWidth/40, panelHeight/10, panelWidth/20, panelHeight/20);
		dayBox.setBounds(monthLabel.getX()+panelWidth/10, panelHeight/10,  panelWidth/10, panelHeight/20);
		dayLabel.setBounds(dayBox.getX()+panelWidth/40+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		ensureButton.setBounds(dayLabel.getX()+panelWidth/10+panelWidth/40, panelHeight/10, panelWidth/10, panelHeight/20);
		
	}
	
	public void data(){
		int counter = 0;
		String date = yearBox.getSelectedItem()+"/"+monthBox.getSelectedItem()+"/"+dayBox.getSelectedItem();
		FinanceBLService finance = ConstructFactory.FinanceFactory();
		ArrayList<EarnVO> voList = finance.showEarnListDependsOnDay(date);
		tableData = new String[voList.size()][tableTitle.length];
		for(EarnVO earnVO:voList){
			tableData[counter][0] = earnVO.getBankAccount();
			tableData[counter][1] = earnVO.getCollectionCode();
			tableData[counter][2] = earnVO.getDate();
			tableData[counter][3] = earnVO.getUnit();
			tableData[counter][4] = earnVO.getRemark();
			tableData[counter][5] = String.valueOf(earnVO.getMoney());
			counter++;
		}
	}
	//成本管理列表
	public void initTable(){
		tableTitle = new String[]{"ID", "费用", "编号", "备注","收入账户","收入单位"};
		data();
//		tableData = new String[][]{{"刘钦", "1毛钱", "2015", "追求卓越"},
//				{"刘钦", "1毛钱", "2015", "追求卓越"},
//				{"刘钦", "1毛钱", "2015", "追求卓越"},
//				{"刘钦", "1毛钱", "2015", "追求卓越"},
//				{"刘钦", "1毛钱", "2015", "追求卓越"},
//				{"刘钦", "1毛钱", "2015", "追求卓越"},
//				{"刘钦", "1毛钱", "2015", "追求卓越"},
//				{"刘钦", "1毛钱", "2015", "追求卓越"},
//				{"刘钦", "1毛钱", "2015", "追求卓越"},
//				{"刘钦", "1毛钱", "2015", "追求卓越"}};
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.setDragEnabled(false);
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5, panelWidth/6*5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5, panelWidth/6*5, 10*table.getRowHeight());
		}
		panel.add(scrollPane);
	}
}
