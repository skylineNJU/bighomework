package main.presentation.financeui;

import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import main.presentation.mainui.MainController;

public class StatisticsListPanel {
	
	private int year;//当前年份
	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	private JLabel title;//标题
	private JLabel costTitle1;//成本管理的标题
	private JLabel costTitle2;//成本管理的标题
	private JLabel earnTitle1;//收益管理的标题
	private JLabel earnTitle2;//收益管理的标题
	private JLabel startTime;
	private JLabel endTime;
	private JLabel startYear;
	private JLabel startMonth;
	private JLabel startDay;
	private JLabel endYear;
	private JLabel endMonth;
	private JLabel endDay;
	private JComboBox<String> startYearBox;
	private JComboBox<String> startMonthBox;
	private JComboBox<String> startDayBox;
	private JComboBox<String> endYearBox;
	private JComboBox<String> endMonthBox;
	private JComboBox<String> endDayBox;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;
	private JTable costListTable;
	private JTable earnListTable;
	private JScrollPane costPane;
	private JScrollPane earnPane;
	private String[] costItem;//表的标题
	private String[] earnItem;//表的标题
	private String[][] costData;
	private String[][] earnData;
	private JButton ensureButton;//确认时间的按钮
	
	public StatisticsListPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		initStartTime();
		initEndTime();
		ensureButton = new JButton("确认");
		ensureButton.setBounds(endDayBox.getX()+panelWidth/5, panelHeight/8, panelWidth/10, panelHeight/20);
		panel.add(ensureButton);
		initCostTable();
		initEarnTable();
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("统计报表");
		title.setBounds(panelWidth/3, 5, panelWidth/6, 30);
		panel.add(title);
	}
	//开始时间
	public void initStartTime(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		startTime = new JLabel("开始日期");
		startYear = new JLabel("年");
		startMonth = new JLabel("月");
		startDay = new JLabel("日");
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		startTime.setBounds(panelWidth/20, panelHeight/15, panelWidth/10, panelHeight/20);
		startYearBox = new JComboBox<String>(yearString);
		startYearBox.setBounds(startTime.getX()+panelWidth/10, panelHeight/15, panelWidth/10, panelHeight/20);
		startYear.setBounds(startYearBox.getX()+panelWidth/10+10, panelHeight/15, panelWidth/20, panelHeight/20);
		startMonthBox = new JComboBox<String>(monthString);
		startMonthBox.setBounds(startYear.getX()+panelWidth/10, panelHeight/15, panelWidth/10, panelHeight/20);
		startMonth.setBounds(startMonthBox.getX()+panelWidth/10+10, panelHeight/15, panelWidth/20, panelHeight/20);
		startDayBox = new JComboBox<String>(dayString);
		startDayBox.setBounds(startMonth.getX()+panelWidth/10, panelHeight/15,  panelWidth/10, panelHeight/20);
		startDay.setBounds(startDayBox.getX()+10+panelWidth/10, panelHeight/15, panelWidth/10, panelHeight/20);
		panel.add(startTime);
		panel.add(startYear);
		panel.add(startMonth);
		panel.add(startDay);
		panel.add(startYearBox);
		panel.add(startMonthBox);
		panel.add(startDayBox);
	}
	
	//结束时间
	public void initEndTime(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		endTime = new JLabel("结束日期");
		endYear = new JLabel("年");
		endMonth = new JLabel("月");
		endDay = new JLabel("日");
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		endTime.setBounds(panelWidth/20, panelHeight/8, panelWidth/10, panelHeight/20);
		endYearBox = new JComboBox<String>(yearString);
		endYearBox.setBounds(endTime.getX()+panelWidth/10, panelHeight/8, panelWidth/10, panelHeight/20);
		endYear.setBounds(endYearBox.getX()+panelWidth/10+10, panelHeight/8, panelWidth/20, panelHeight/20);
		endMonthBox = new JComboBox<String>(monthString);
		endMonthBox.setBounds(endYear.getX()+panelWidth/10, panelHeight/8, panelWidth/10, panelHeight/20);
		endMonth.setBounds(endMonthBox.getX()+panelWidth/10+10, panelHeight/8, panelWidth/20, panelHeight/20);
		endDayBox = new JComboBox<String>(dayString);
		endDayBox.setBounds(endMonth.getX()+panelWidth/10, panelHeight/8,  panelWidth/10, panelHeight/20);
		endDay.setBounds(endDayBox.getX()+10+panelWidth/10, panelHeight/8, panelWidth/10, panelHeight/20);
		panel.add(endTime);
		panel.add(endYear);
		panel.add(endMonth);
		panel.add(endDay);
		panel.add(endYearBox);
		panel.add(endMonthBox);
		panel.add(endDayBox);
	}
	
	//成本列表
	public void initCostTable(){
		costTitle1 = new JLabel("成");
		costTitle1.setBounds(endTime.getX(), endTime.getY()+panelHeight/10, panelWidth/40, panelHeight/20);
		costTitle2 = new JLabel("本");
		costTitle2.setBounds(endTime.getX(), endTime.getY()+panelHeight/10+panelHeight/10, panelWidth/40, panelHeight/20);
		costItem = new String[]{"ID", "费用", "编号", "账户", "类型", "备注"};
		costData = new String[][]{{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "2013167", "快递费", "追求卓越"}};
		costListTable = new JTable(costData,costItem);
		costListTable.setEnabled(false);//设置不可编辑内容
		costListTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		costListTable.setRowHeight(panelWidth/25);//设置列宽
		costListTable.getTableHeader().setPreferredSize(new Dimension(10000, panelWidth/25));//设置表头高度
		costListTable.setDragEnabled(false);//不可拖动
		costListTable.getTableHeader().setResizingAllowed(false);//列宽不可以改动
		costPane = new JScrollPane(costListTable);
		if(costData.length<=6){
			costPane.setBounds(endTime.getX()+panelWidth/30, endTime.getY()+panelHeight/10,
					panelWidth - endTime.getX()*2-panelWidth/15, (costListTable.getRowCount()+1)*costListTable.getRowHeight());
		}else{
			costPane.setBounds(endTime.getX()+panelWidth/30, endTime.getY()+panelHeight/10, 
					panelWidth - endTime.getX()*2-panelWidth/15, 7*costListTable.getRowHeight());
		}
		
		panel.add(costTitle1);
		panel.add(costTitle2);
		panel.add(costPane);
	}
	
	//收益列表
	public void initEarnTable(){
		earnTitle1 = new JLabel("收");
		earnTitle1.setBounds(endTime.getX(), panelHeight*3/5, panelWidth/40, panelHeight/20);
		earnTitle2 = new JLabel("益");
		earnTitle2.setBounds(endTime.getX(), panelHeight*3/5+panelHeight/10, panelWidth/40, panelHeight/20);
		earnItem = new String[]{"ID", "费用", "编号", "备注"};
		earnData = new String[][]{{"刘钦", "1毛钱", "2015", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "追求卓越"},
				{"刘钦", "1毛钱", "2015", "追求卓越"}};
		earnListTable = new JTable(earnData,earnItem);
		earnListTable.setEnabled(false);//设置不可编辑内容
		earnListTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		earnListTable.setRowHeight(panelWidth/25);//设置列宽
		earnListTable.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/25));//设置表头高度
		earnListTable.setDragEnabled(false);//不可拖动
		earnListTable.getTableHeader().setResizingAllowed(false);//列宽不可改动
		earnPane = new JScrollPane(earnListTable);
		if(earnData.length<=6){
			earnPane.setBounds(endTime.getX()+panelWidth/30, panelHeight*3/5,
					panelWidth - endTime.getX()*2-panelWidth/15, (costListTable.getRowCount()+1)*costListTable.getRowHeight());
		}else{
			earnPane.setBounds(endTime.getX()+panelWidth/30, panelHeight*3/5, 
					panelWidth - endTime.getX()*2-panelWidth/15, 7*costListTable.getRowHeight());
		}
		panel.add(earnTitle1);
		panel.add(earnTitle2);
		panel.add(earnPane);
	}
}
