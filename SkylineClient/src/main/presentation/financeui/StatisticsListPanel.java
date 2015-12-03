package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.CostVO;
import main.vo.EarnVO;

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
	private JLabel time;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JComboBox<String> yearBox;
	private JComboBox<String> monthBox;
	private JComboBox<String> dayBox;
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
		initTime();
		title();
		initButton();
		earnItem = new String[]{"编号", "费用", "收入日期", "收入单位", "收入账户", "备注"};
		costItem = new String[]{"编号", "费用", "支出日期", "支出类型", "支出账户", "备注"};
		getData();
		initCostTable();
		initEarnTable();
		panel.repaint();
	}
	
	public void initButton(){
		ensureButton = new JButton("确认");
		ensureButton.setBounds(dayBox.getX()+panelWidth/5, panelHeight/10, panelWidth/10, panelHeight/20);
		ensureButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				costData = null;
				earnData = null;
				costPane.remove(costListTable);
				earnPane.remove(earnListTable);
				panel.remove(costPane);
				panel.remove(earnPane);
				panel.repaint();
				getData();
//				DefaultTableModel costModel = new DefaultTableModel(costData,costItem);
//				DefaultTableModel earnModel = new DefaultTableModel(earnData,earnItem);
//				costListTable.setModel(costModel);
//				earnListTable.setModel(earnModel);
				initCostTable();
				initEarnTable();
				panel.repaint();
			}
		});
		panel.add(ensureButton);
	}
	public void title(){
		title = new JLabel("统计报表");
		title.setBounds(panelWidth/3, 5, panelWidth/6, 30);
		costTitle1 = new JLabel("成");
		costTitle1.setBounds(time.getX(), time.getY()+panelHeight/10, panelWidth/40, panelHeight/20);
		costTitle2 = new JLabel("本");
		costTitle2.setBounds(time.getX(), time.getY()+panelHeight/10+panelHeight/10, panelWidth/40, panelHeight/20);
		earnTitle1 = new JLabel("收");
		earnTitle1.setBounds(time.getX(), panelHeight*3/5, panelWidth/40, panelHeight/20);
		earnTitle2 = new JLabel("益");
		earnTitle2.setBounds(time.getX(), panelHeight*3/5+panelHeight/10, panelWidth/40, panelHeight/20);
		
		panel.add(costTitle1);
		panel.add(costTitle2);
		panel.add(earnTitle1);
		panel.add(earnTitle2);
		panel.add(title);
	}
	//开始时间
	public void initTime(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		time = new JLabel("开始日期");
		yearLabel = new JLabel("年");
		monthLabel = new JLabel("月");
		dayLabel = new JLabel("日");
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		time.setBounds(panelWidth/20, panelHeight/10, panelWidth/10, panelHeight/20);
		yearBox = new JComboBox<String>(yearString);
		yearBox.setBounds(time.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		yearLabel.setBounds(yearBox.getX()+panelWidth/10+10, panelHeight/10, panelWidth/20, panelHeight/20);
		monthBox = new JComboBox<String>(monthString);
		monthBox.setBounds(yearLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		monthLabel.setBounds(monthBox.getX()+panelWidth/10+10, panelHeight/10, panelWidth/20, panelHeight/20);
		dayBox = new JComboBox<String>(dayString);
		dayBox.setBounds(monthLabel.getX()+panelWidth/10, panelHeight/10,  panelWidth/10, panelHeight/20);
		dayLabel.setBounds(dayBox.getX()+10+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		
		panel.add(time);
		panel.add(yearLabel);
		panel.add(monthLabel);
		panel.add(dayLabel);
		panel.add(yearBox);
		panel.add(monthBox);
		panel.add(dayBox);
	}
	
	public void getData(){
		int earnCounter = 0;
		int costCounter = 0;
		earnData = null;
		costData = null;
		String date = yearBox.getSelectedItem()+"/"+monthBox.getSelectedItem()+"/"+dayBox.getSelectedItem();
		System.out.println("选择的日期是：------------"+date);
		FinanceBLService finance = ConstructFactory.FinanceFactory();
		@SuppressWarnings("rawtypes")
		ArrayList<ArrayList> list = finance.showStatisticsList(date);
		@SuppressWarnings("unchecked")
		ArrayList<EarnVO> earnList = list.get(0);
		@SuppressWarnings("unchecked")
		ArrayList<CostVO> costList = list.get(1);
		if(earnList.size()!=0){
			earnData = new String[earnList.size()][earnItem.length];
		}else{
			earnData = new String[1][earnItem.length];
			earnData[0][0] = "  no data";
			earnData[0][1] = "  no data";
			earnData[0][2] = "  no data";
			earnData[0][3] = "  no data";
			earnData[0][4] = "  no data";
			earnData[0][5] = "  no data";
		}
		if(costList.size()!=0){
			costData = new String[costList.size()][earnItem.length];
		}else{
			costData = new String[1][earnItem.length];
			costData[0][0] = "  no data";
			costData[0][1] = "  no data";
			costData[0][2] = "  no data";
			costData[0][3] = "  no data";
			costData[0][4] = "  no data";
			costData[0][5] = "  no data";
		}
		for(EarnVO earnVO:earnList){
			earnData[earnCounter][0] = earnVO.getCollectionCode();
			earnData[earnCounter][1] = String.valueOf(earnVO.getMoney());
			earnData[earnCounter][2] = earnVO.getDate();
			earnData[earnCounter][3] = earnVO.getUnit();
			earnData[earnCounter][4] = earnVO.getBankAccount();
			earnData[earnCounter][5] = earnVO.getRemark();
			earnCounter++;
		}
		for(CostVO costVO:costList){
			costData[costCounter][0] = costVO.getCostCode();
			costData[costCounter][1] = String.valueOf(costVO.getCost());
			costData[costCounter][2] = costVO.getDate();
			costData[costCounter][3] = costVO.getCostType();
			costData[costCounter][4] = costVO.getBankAccount();
			costData[costCounter][5] = costVO.getComment();
			costCounter++;
		}
	}
	
	//成本列表
	public void initCostTable(){
		costListTable = new JTable(costData,costItem);
		costListTable.setEnabled(false);//设置不可编辑内容
		costListTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		costListTable.setRowHeight(panelWidth/25);//设置列宽
		costListTable.getTableHeader().setPreferredSize(new Dimension(10000, panelWidth/25));//设置表头高度
		costListTable.setDragEnabled(false);//不可拖动
		costListTable.getTableHeader().setResizingAllowed(false);//列宽不可以改动
		costPane = new JScrollPane(costListTable);
		if(costData.length<=6){
			costPane.setBounds(time.getX()+panelWidth/30, time.getY()+panelHeight/10,
					panelWidth - time.getX()*2-panelWidth/15, (costListTable.getRowCount()+1)*costListTable.getRowHeight());
		}else{
			costPane.setBounds(time.getX()+panelWidth/30, time.getY()+panelHeight/10, 
					panelWidth - time.getX()*2-panelWidth/15, 7*costListTable.getRowHeight());
		}
		panel.add(costPane);
	}
	
	//收益列表
	public void initEarnTable(){
		earnListTable = new JTable(earnData,earnItem);
		earnListTable.setEnabled(false);//设置不可编辑内容
		earnListTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		earnListTable.setRowHeight(panelWidth/25);//设置列宽
		earnListTable.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/25));//设置表头高度
		earnListTable.setDragEnabled(false);//不可拖动
		earnListTable.getTableHeader().setResizingAllowed(false);//列宽不可改动
		earnPane = new JScrollPane(earnListTable);
		if(earnData.length<=6){
			earnPane.setBounds(time.getX()+panelWidth/30, panelHeight*3/5,
					panelWidth - time.getX()*2-panelWidth/15, (earnListTable.getRowCount()+1)*earnListTable.getRowHeight());
		}else{
			earnPane.setBounds(time.getX()+panelWidth/30, panelHeight*3/5, 
					panelWidth - time.getX()*2-panelWidth/15, 7*earnListTable.getRowHeight());
		}
		panel.add(earnPane);
	}
}
