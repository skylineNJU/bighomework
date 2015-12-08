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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.BankAccountVO;
import main.vo.EarnVO;

public class LobbyEarnPanel {
	
	private int year;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;
	private String[] tableTitle;
	private String[][] tableData;
	private JPanel panel;
	private JLabel titleLabel;
	private JTabbedPane tab;
	private JPanel lookPanel;
	private JPanel writePanel;
	//查看收款信息的组件
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel date;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JComboBox<String> yearBox;
	private JComboBox<String> monthBox;
	private JComboBox<String> dayBox;
	private JButton ensureButton;
	//填写收款信息的组件
	private JLabel addTime;
	private JLabel addYear;
	private JLabel addMonth;
	private JLabel addDay;
	private JLabel codeLabel;
	private JLabel feeLabel;
	private JLabel unitLabel;
	private JLabel bankLabel;
	private JLabel isPaidLabel;
	private JLabel commentLabel;
	private JComboBox<String> addYearBox;
	private JComboBox<String> addMonthBox;
	private JComboBox<String> addDayBox;
	private JTextField codeText;
	private JTextField feeText;
	private JComboBox<String> unitBox;
	private JComboBox<String> bankBox;
	private JComboBox<String> isPaidBox;
	private JTextField commentText;
	private JButton blankButton;
	private JButton addButton;
	private String[] paidType = new String[]{"001"};//这个地方需要用memory获得其单位
	private String[] isPaidType = new String[]{"已结算", "未结算"};
	private String[] bankType;

	public LobbyEarnPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		title();
		tab = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tab);
		tab.setBounds(panel.getWidth()/20, panel.getHeight()*5/40, panel.getWidth()*9/10, panel.getHeight()*4/5);
		lookPanel = new JPanel();
		writePanel = new JPanel();
		lookPanel.setBounds(0, 0, tab.getWidth(), tab.getHeight());
		writePanel.setBounds(0, 0, tab.getWidth(), tab.getHeight());
		lookPanel.setLayout(null);
		writePanel.setLayout(null);
		tab.addTab("查看收款信息", lookPanel);
		tab.addTab("填写收款信息",writePanel);
		initLook();
		initLookPanel();
		initWritePanel();
		panel.repaint();
	}
	public void title(){
		titleLabel = new JLabel("收款单");
		panel.add(titleLabel);
		titleLabel.setBounds(panel.getWidth()*2/5, panel.getHeight()/80, panel.getWidth()/10, panel.getHeight()/20);
	}
	
	public void initLook(){
		Calendar calendar = Calendar.getInstance();
		this.year = calendar.get(Calendar.YEAR);
		yearString = new String[]{String.valueOf(year-1),String.valueOf(year),String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		date = new JLabel("日期");
		yearLabel = new JLabel("年");
		monthLabel = new JLabel("月");
		dayLabel = new JLabel("日");
		yearBox = new JComboBox<String>(yearString);
		monthBox = new JComboBox<String>(monthString);
		dayBox = new JComboBox<String>(dayString);
		ensureButton = new JButton("确认");
		lookPanel.add(date);
		lookPanel.add(yearLabel);
		lookPanel.add(monthLabel);
		lookPanel.add(dayLabel);
		lookPanel.add(yearBox);
		lookPanel.add(monthBox);
		lookPanel.add(dayBox);
		lookPanel.add(ensureButton);
		date.setBounds(lookPanel.getWidth()/15, lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		yearBox.setBounds(lookPanel.getWidth()/10+date.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		yearLabel.setBounds(lookPanel.getWidth()*7/60+yearBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/20, lookPanel.getHeight()/20);
		monthBox.setBounds(lookPanel.getWidth()/5+yearBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		monthLabel.setBounds(lookPanel.getWidth()*7/60+monthBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/20, lookPanel.getHeight()/20);
		dayBox.setBounds(lookPanel.getWidth()/5+monthBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		dayLabel.setBounds(lookPanel.getWidth()*7/60+dayBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/20, lookPanel.getHeight()/20);
		ensureButton.setBounds(lookPanel.getWidth()*5/6, lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
	
		ensureButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				scrollPane.remove(table);
				lookPanel.remove(scrollPane);
				initLookPanel();
				lookPanel.repaint();
			}
		});
	}
	
	public void getData(){
		int counter = 0;
		tableTitle = new String[]{"收款单单号", "收款金额", "收入单位", "收入日期","收入账户","是否结算","备注"};
		FinanceBLService finance = ConstructFactory.FinanceFactory();
		String date = yearBox.getSelectedItem()+"/"+monthBox.getSelectedItem()+"/"+dayBox.getSelectedItem();
		ArrayList<EarnVO> voList = finance.showLobbyEarn(date, "001");		
		if(voList.size()==0){
			tableData = new String[1][tableTitle.length];
			tableData[0][0] = "   no data";
			tableData[0][1] = "   no data";
			tableData[0][2] = "   no data";
			tableData[0][3] = "   no data";
			tableData[0][4] = "   no data";
			tableData[0][5] = "   no data";
			tableData[0][6] = "   no data";
		}else{
			tableData = new String[voList.size()][tableTitle.length];
		}
		for(EarnVO earnVO:voList){
			tableData[counter][0] = earnVO.getCollectionCode();
			tableData[counter][1] = String.valueOf(earnVO.getMoney());
			tableData[counter][2] = earnVO.getUnit();
			tableData[counter][3] = earnVO.getDate();
			tableData[counter][4] = earnVO.getBankAccount();
			tableData[counter][5] = earnVO.getIsPaid();
			tableData[counter][6] = earnVO.getRemark();
			counter++;
		}
	}
	public void initLookPanel(){
		getData();
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table.setEnabled(false);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(panel.getHeight()/20);//设置列宽
		table.setDragEnabled(false);//设置不可拖动
		table.getTableHeader().setPreferredSize(new Dimension(10000, panel.getHeight()/20));//设置表头高度
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		lookPanel.add(scrollPane);
		if(table.getRowCount()<11){
			scrollPane.setBounds(lookPanel.getWidth()/15, lookPanel.getHeight()*2/15, lookPanel.getWidth()*13/15, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(lookPanel.getWidth()/15, lookPanel.getHeight()*2/15, lookPanel.getWidth()*13/15, 12*table.getRowHeight());			

		}
		scrollPane.setVisible(true);
		lookPanel.repaint();
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
	
	public void initWritePanel(){
		
		getBank();
		addTime = new JLabel("日期");
		addYear = new JLabel("年");
		addMonth = new JLabel("月");
		addDay = new JLabel("日");
		codeLabel = new JLabel("收款单号");
		feeLabel = new JLabel("收入额");
		unitLabel = new JLabel("收款单位");
		bankLabel = new JLabel("收入账户");
		isPaidLabel = new JLabel("是否结算");
		commentLabel = new JLabel("备注");
		addYearBox = new JComboBox<String>(yearString);
		addMonthBox = new JComboBox<String>(monthString);
		addDayBox = new JComboBox<String>(dayString);
		codeText = new JTextField();
		feeText = new JTextField();
		unitBox = new JComboBox<String>(paidType);
		bankBox = new JComboBox<String>(bankType);
		isPaidBox = new JComboBox<String>(isPaidType);
		commentText = new JTextField();
		blankButton = new JButton("清空");//清空按钮
		addButton = new JButton("保存");
		
		blankButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				addYearBox.setSelectedIndex(0);
				addMonthBox.setSelectedIndex(0);
				addDayBox.setSelectedIndex(0);
				codeText.setText(null);
				feeText.setText(null);
				commentText.setText(null);
				unitBox.setSelectedIndex(0);
				bankBox.setSelectedIndex(0);
				isPaidBox.setSelectedIndex(0);
			}
		});
		
		addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				String date = addYearBox.getSelectedItem()+"/"+addMonthBox.getSelectedItem()+"/"+
						addDayBox.getSelectedItem();
				EarnVO earnVO = new EarnVO(codeText.getText(), date, String.valueOf(unitBox.getSelectedItem()), 
						String.valueOf(bankBox.getSelectedItem()), Double.valueOf(feeText.getText()), 
						commentText.getText(), String.valueOf(isPaidBox.getSelectedItem())
						);
				FinanceBLService finance = ConstructFactory.FinanceFactory();
				if(finance.writeEarn(earnVO)){//存储成功时,人机交互部分
					
				}else{//存储失败时
					
				}
			}
		});
		
		writePanel.add(addTime);
		writePanel.add(addYear);
		writePanel.add(addMonth);
		writePanel.add(addDay);
		writePanel.add(codeLabel);
		writePanel.add(feeLabel);
		writePanel.add(unitLabel);
		writePanel.add(bankLabel);
		writePanel.add(isPaidLabel);
		writePanel.add(commentLabel);
		writePanel.add(addYearBox);
		writePanel.add(addMonthBox);
		writePanel.add(addDayBox);
		writePanel.add(codeText);
		writePanel.add(feeText);
		writePanel.add(unitBox);
		writePanel.add(bankBox);
		writePanel.add(isPaidBox);
		writePanel.add(commentText);
		writePanel.add(blankButton);
		writePanel.add(addButton);
		
		final int HINTER = tab.getHeight()/8;
		
		addTime.setBounds(tab.getWidth()/20, tab.getHeight()/20, tab.getWidth()/20, tab.getHeight()/20);
		addYearBox.setBounds(addTime.getX()+tab.getWidth()/8, tab.getHeight()/20, tab.getWidth()/10, tab.getHeight()/20);
		addYear.setBounds(addYearBox.getX()+addYearBox.getWidth()+tab.getWidth()/40, tab.getHeight()/20, tab.getWidth()/20, tab.getHeight()/20);
		addMonthBox.setBounds(addYear.getX()+tab.getWidth()/8, tab.getHeight()/20, tab.getWidth()/10, tab.getHeight()/20);
		addMonth.setBounds(addMonthBox.getX()+addMonthBox.getWidth()+tab.getWidth()/40, tab.getHeight()/20, tab.getWidth()/20, tab.getHeight()/20);
		addDayBox.setBounds(addMonth.getX()+tab.getWidth()/8, tab.getHeight()/20,  tab.getWidth()/10, tab.getHeight()/20);
		addDay.setBounds(addDayBox.getX()+tab.getWidth()/40+addDayBox.getWidth(), tab.getHeight()/20, tab.getWidth()/10, tab.getHeight()/20);
		
		codeLabel.setBounds(tab.getWidth()/20, addTime.getY()+addTime.getHeight()+HINTER, tab.getWidth()/10, tab.getHeight()/16);
		feeLabel.setBounds(tab.getWidth()/2, codeLabel.getY(), tab.getWidth()/10, tab.getHeight()/16);
		unitLabel.setBounds(codeLabel.getX(), codeLabel.getY()+codeLabel.getHeight()+HINTER, tab.getWidth()/10, tab.getHeight()/16);
		bankLabel.setBounds(tab.getWidth()/2, unitLabel.getY(), tab.getWidth()/10, tab.getHeight()/16);
		isPaidLabel.setBounds(codeLabel.getX(), unitLabel.getY()+unitLabel.getHeight()+HINTER, tab.getWidth()/10, tab.getHeight()/16);
		commentLabel.setBounds(tab.getWidth()/2, isPaidLabel.getY(), tab.getWidth()/10, tab.getHeight()/16);
		codeText.setBounds(codeLabel.getX()+codeLabel.getWidth(), addTime.getY()+addTime.getHeight()+HINTER, tab.getWidth()*3/10, tab.getHeight()/16);
		feeText.setBounds(feeLabel.getX()+feeLabel.getWidth(), codeLabel.getY(), tab.getWidth()*3/10, tab.getHeight()/16);
		unitBox.setBounds(unitLabel.getX()+unitLabel.getWidth(), codeLabel.getY()+codeLabel.getHeight()+HINTER, tab.getWidth()*3/10, tab.getHeight()/16);
		bankBox.setBounds(bankLabel.getX()+bankLabel.getWidth(), unitLabel.getY(), tab.getWidth()*3/10, tab.getHeight()/16);
		isPaidBox.setBounds(isPaidLabel.getX()+isPaidLabel.getWidth(), unitLabel.getY()+unitLabel.getHeight()+HINTER, tab.getWidth()*3/10, tab.getHeight()/16);
		commentText.setBounds(commentLabel.getX()+commentLabel.getWidth(), isPaidLabel.getY(), tab.getWidth()*3/10, tab.getHeight()/16);
		blankButton.setBounds(tab.getWidth()*3/5, tab.getHeight()*4/5, tab.getWidth()/10, tab.getHeight()/16);
		addButton.setBounds(tab.getWidth()*3/5+blankButton.getWidth()*2, tab.getHeight()*4/5, tab.getWidth()/10, tab.getHeight()/16);
		
		writePanel.repaint();
	}
}
