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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import main.businesslogic.financebl.Balance;
import main.businesslogic.financebl.UpdateBank;
import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.BankAccountVO;
import main.vo.CostVO;

public class CostListPanel {
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
	private JButton newCostButton;
	private JButton payButton;
	private JButton ensureButton;
	private JPanel lookPanel;
	private JPanel addPanel;
	
	//-----addPanel------的界面
	private JLabel addTime;
	private JLabel addYear;
	private JLabel addMonth;
	private JLabel addDay;
	private JLabel codeLabel;
	private JLabel feeLabel;
	private JLabel typeLabel;
	private JLabel bankLabel;
	private JLabel isPaidLabel;
	private JLabel commentLabel;
	private JComboBox<String> addYearBox;
	private JComboBox<String> addMonthBox;
	private JComboBox<String> addDayBox;
	private JTextField codeText;
	private JTextField feeText;
	private JComboBox<String> typeBox;
	private JComboBox<String> bankBox;
	private JComboBox<String> isPaidBox;
	private JTextField commentText;
	private JButton backButton;
	private JButton addButton;
	private String[] paidType = new String[]{"租金", "工资", "提成", "运费", "其它"};
	private String[] isPaidType = new String[]{"已结算", "未结算"};
	private String[] bankType;
	
	
	public CostListPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		tableTitle = new String[]{"付款单单号", "费用", "支出类型", "银行账户名", "支出时间", "是否结算", "备注"};
		lookPanel = new JPanel();
		addPanel = new JPanel();
		panel.add(lookPanel);
		panel.add(addPanel);
		lookPanel.setBounds(0, 0, panelWidth, panelHeight);
		lookPanel.setOpaque(false);;
		lookPanel.setLayout(null);
		addPanel.setBounds(0, 0, panelWidth, panelHeight);
		addPanel.setOpaque(false);
		addPanel.setLayout(null);
		lookPanel.setVisible(true);
		addPanel.setVisible(false);
		setTime();
		initButton();
		initAddPanel();
		title();
		initTable();
		panel.repaint();
	}
	public void title(){
		title = new JLabel("成本管理");
		title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
		lookPanel.add(title);
	}
	public void initButton(){
		ensureButton = new JButton("确认");
		newCostButton = new JButton("新增");
		payButton = new JButton("结算");
		lookPanel.add(ensureButton);
		lookPanel.add(newCostButton);
		lookPanel.add(payButton);
		ensureButton.setBounds(dayLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		newCostButton.setBounds(panelWidth*3/5, panelHeight*9/10, panelWidth/10, panelHeight/20);
		payButton.setBounds(panelWidth*3/5+newCostButton.getWidth()*2, panelHeight*9/10, panelWidth/10, panelHeight/20);
		
		payButton.addMouseListener(new MouseAdapter() {//把未结算全部改成已结算，保存至数据库，然后再修改银行账户余额
			public void mouseClicked(MouseEvent e){
				updateCost();
				table.repaint();
			}
		});
		
		newCostButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				lookPanel.setVisible(false);
				addPanel.setVisible(true);
			}
		});
		
		ensureButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				scrollPane.remove(table);
				lookPanel.remove(scrollPane);
				setData();
				initTable();
				lookPanel.repaint();
			}
		});

		panel.repaint();
	}
	
	public void updateCost(){
		UpdateBank updateBank = new UpdateBank();
		String[][] allData = new String[tableData.length][tableData[0].length];
		for(int i = 0; i<tableData.length; i++) {//拿到表中的数据
			for(int j = 0; j<tableData[i].length; j++){
				allData[i][j] = String.valueOf(table.getModel().getValueAt(i, j));
			}
		}
		FinanceBLService service = ConstructFactory.FinanceFactory();
		for(int i = 0; i<tableData.length; i++) {//结算
			if(allData[i][5].equals("未结算")){
				table.getModel().setValueAt("已结算", i, 5);
				CostVO costVO = new CostVO(allData[i][4],allData[i][0],
						allData[i][3],Double.valueOf(allData[i][1]),
						allData[i][6],allData[i][2],allData[i][5]
								);
				service.modifyCost(costVO);
				updateBank.updateMoney(allData[i][3], Double.valueOf(allData[i][1]));
			}
		}
		ArrayList<BankAccountVO> voList = updateBank.getBankList();
		for(int i = 0; i<voList.size(); i++){
			service.modifyBalance(voList.get(i));
		}
		panel.repaint();
	}
	
	//设置时间的框
	public void setTime(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		timeLabel = new JLabel("时间");
		yearLabel = new JLabel("年");
		monthLabel = new JLabel("月");
		dayLabel = new JLabel("日");
		
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		yearBox = new JComboBox<String>(yearString);
		monthBox = new JComboBox<String>(monthString);
		dayBox = new JComboBox<String>(dayString);
		
		lookPanel.add(timeLabel);
		lookPanel.add(yearLabel);
		lookPanel.add(monthLabel);
		lookPanel.add(dayLabel);
		lookPanel.add(yearBox);
		lookPanel.add(monthBox);
		lookPanel.add(dayBox);
		
		timeLabel.setBounds(panelWidth/20, panelHeight/10, panelWidth/10, panelHeight/20);
		yearBox.setBounds(timeLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		yearLabel.setBounds(yearBox.getX()+yearBox.getWidth()+panelWidth/40, panelHeight/10, panelWidth/20, panelHeight/20);
		monthBox.setBounds(yearLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		monthLabel.setBounds(monthBox.getX()+monthBox.getWidth()+panelWidth/40, panelHeight/10, panelWidth/20, panelHeight/20);
		dayBox.setBounds(monthLabel.getX()+panelWidth/10, panelHeight/10,  panelWidth/10, panelHeight/20);
		dayLabel.setBounds(dayBox.getX()+panelWidth/40+dayBox.getWidth(), panelHeight/10, panelWidth/10, panelHeight/20);
			
		lookPanel.repaint();
	}
	
	public void setData(){
		int counter = 0;
		String date = yearBox.getSelectedItem()+"/"+monthBox.getSelectedItem()+"/"+dayBox.getSelectedItem();
		FinanceBLService finance = ConstructFactory.FinanceFactory();
		ArrayList<CostVO> voList = finance.showCostList(date);
		if(voList.size()!=0){
			tableData = new String[voList.size()][tableTitle.length];
		}else{
			tableData = new String[1][tableTitle.length];
			tableData[0][0] = "   no data";
			tableData[0][1] = "   no data";
			tableData[0][2] = "   no data";
			tableData[0][3] = "   no data";
			tableData[0][4] = "   no data";
			tableData[0][5] = "   no data";
			tableData[0][6] = "   no data";
		}
		for(CostVO costVO:voList){
			tableData[counter][0] = costVO.getCostCode();
			tableData[counter][1] = String.valueOf(costVO.getCost());
			tableData[counter][2] = costVO.getCostType();
			tableData[counter][3] = costVO.getBankAccount();
			tableData[counter][4] = costVO.getDate();
			tableData[counter][5] = costVO.getIsPaid();
			tableData[counter][6] = costVO.getComment();
			counter++;
		}
		
	}
	//成本管理列表
	@SuppressWarnings("serial")
	public void initTable(){
		setData();
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(panelWidth/20);//设置列宽
		table.setDragEnabled(false);//设置不可拖动
		table.getTableHeader().setPreferredSize(new Dimension(10000, panelWidth/20));//设置表头高度
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5, panelWidth/6*5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5, panelWidth/6*5, 10*table.getRowHeight());
		}
		
		table.setModel(new DefaultTableModel(tableData,tableTitle){
			public boolean isCellEditable(int row,int column){
				if(column==0||column==5||tableData[row][5].equals("已结算")
						||tableData[row][column].equals("   no data")){//规定不能修改是否结算和单号，规定不能对已结算的单据修改任何信息
					return false;
				}else if(column==1||column==6){//只允许修改金额和备注
					return true;
				}else{
					return false;
				}
			}
		});

		lookPanel.add(scrollPane);
	}
	
	public void getBank(){
		FinanceBLService service = ConstructFactory.FinanceFactory();
		ArrayList<BankAccountVO> bankListVO = service.showBalance();
		int counter = 0;
		bankType = new String[bankListVO.size()];
		for(BankAccountVO bankVO:bankListVO){
			bankType[counter] = bankVO.getCode();
			counter++;
		}
	}
	
	public boolean isLegal(){//判断是否可以存储
		return true;
	}
	public void initAddPanel(){
		getBank();
		addTime = new JLabel("日期");
		addYear = new JLabel("年");
		addMonth = new JLabel("月");
		addDay = new JLabel("日");
		codeLabel = new JLabel("付款单号");
		feeLabel = new JLabel("费用");
		typeLabel = new JLabel("付款类型");
		bankLabel = new JLabel("支出账户");
		isPaidLabel = new JLabel("是否结算");
		commentLabel = new JLabel("备注");
		addYearBox = new JComboBox<String>(yearString);
		addMonthBox = new JComboBox<String>(monthString);
		addDayBox = new JComboBox<String>(dayString);
		codeText = new JTextField();
		feeText = new JTextField();
		typeBox = new JComboBox<String>(paidType);
		bankBox = new JComboBox<String>(bankType);
		isPaidBox = new JComboBox<String>(isPaidType);
		commentText = new JTextField();
		backButton = new JButton("返回");
		addButton = new JButton("保存");
		
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				codeText.setText(null);
				feeText.setText(null);
				commentText.setText(null);
				addPanel.setVisible(false);
				lookPanel.setVisible(true);
			}
		});
		
		addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(isLegal()){
					String date = addYearBox.getSelectedItem()+"/"+addMonthBox.getSelectedItem()+"/"+addDayBox.getSelectedItem();
					CostVO costVO = new CostVO(date, codeText.getText(), 
							String.valueOf(bankBox.getSelectedItem()), Double.valueOf(feeText.getText()), 
							commentText.getText(), String.valueOf(typeBox.getSelectedItem()), 
							String.valueOf(isPaidBox.getSelectedItem()));
					FinanceBLService finance = ConstructFactory.FinanceFactory();
					if(finance.writeCost(costVO)){//返回值是布尔类型，在这里添加人机交互内容
					}
				}else{
					//TODO 当不合法的收款单时，人机交互
				}
			}
		});
		
		addPanel.add(addTime);
		addPanel.add(addYear);
		addPanel.add(addMonth);
		addPanel.add(addDay);
		addPanel.add(codeLabel);
		addPanel.add(feeLabel);
		addPanel.add(typeLabel);
		addPanel.add(bankLabel);
		addPanel.add(isPaidLabel);
		addPanel.add(commentLabel);
		addPanel.add(addYearBox);
		addPanel.add(addMonthBox);
		addPanel.add(addDayBox);
		addPanel.add(codeText);
		addPanel.add(feeText);
		addPanel.add(typeBox);
		addPanel.add(bankBox);
		addPanel.add(isPaidBox);
		addPanel.add(commentText);
		addPanel.add(backButton);
		addPanel.add(addButton);
		
		final int HINTER = panelHeight/7;
		
		addTime.setBounds(panelWidth/20, panelHeight/10, panelWidth/10, panelHeight/20);
		addYearBox.setBounds(addTime.getX()+panelWidth/8, panelHeight/10, panelWidth/10, panelHeight/20);
		addYear.setBounds(addYearBox.getX()+addYearBox.getWidth()+panelWidth/40, panelHeight/10, panelWidth/20, panelHeight/20);
		addMonthBox.setBounds(addYear.getX()+panelWidth/8, panelHeight/10, panelWidth/10, panelHeight/20);
		addMonth.setBounds(addMonthBox.getX()+addMonthBox.getWidth()+panelWidth/40, panelHeight/10, panelWidth/20, panelHeight/20);
		addDayBox.setBounds(addMonth.getX()+panelWidth/8, panelHeight/10,  panelWidth/10, panelHeight/20);
		addDay.setBounds(addDayBox.getX()+panelWidth/40+addDayBox.getWidth(), panelHeight/10, panelWidth/10, panelHeight/20);
		
		codeLabel.setBounds(panelWidth/20, addTime.getY()+addTime.getHeight()+HINTER, panelWidth/12, panelHeight/20);
		feeLabel.setBounds(panelWidth/2, codeLabel.getY(), panelWidth/12, panelHeight/20);
		typeLabel.setBounds(codeLabel.getX(), codeLabel.getY()+codeLabel.getHeight()+HINTER, panelWidth/12, panelHeight/20);
		bankLabel.setBounds(panelWidth/2, typeLabel.getY(), panelWidth/12, panelHeight/20);
		isPaidLabel.setBounds(codeLabel.getX(), typeLabel.getY()+typeLabel.getHeight()+HINTER, panelWidth/12, panelHeight/20);
		commentLabel.setBounds(panelWidth/2, isPaidLabel.getY(), panelWidth/12, panelHeight/20);
		codeText.setBounds(codeLabel.getX()+codeLabel.getWidth(), addTime.getY()+addTime.getHeight()+HINTER, panelWidth*3/10, panelHeight/20);
		feeText.setBounds(feeLabel.getX()+feeLabel.getWidth(), codeLabel.getY(), panelWidth*3/10, panelHeight/20);
		typeBox.setBounds(typeLabel.getX()+typeLabel.getWidth(), codeLabel.getY()+codeLabel.getHeight()+HINTER, panelWidth*3/10, panelHeight/20);
		bankBox.setBounds(bankLabel.getX()+bankLabel.getWidth(), typeLabel.getY(), panelWidth*3/10, panelHeight/20);
		isPaidBox.setBounds(isPaidLabel.getX()+isPaidLabel.getWidth(), typeLabel.getY()+typeLabel.getHeight()+HINTER, panelWidth*3/10, panelHeight/20);
		commentText.setBounds(commentLabel.getX()+commentLabel.getWidth(), isPaidLabel.getY(), panelWidth*3/10, panelHeight/20);
		backButton.setBounds(panelWidth*3/5, panelHeight*9/10, panelWidth/10, panelHeight/20);
		addButton.setBounds(panelWidth*3/5+newCostButton.getWidth()*2, panelHeight*9/10, panelWidth/10, panelHeight/20);
		
		addPanel.repaint();
	}
}
