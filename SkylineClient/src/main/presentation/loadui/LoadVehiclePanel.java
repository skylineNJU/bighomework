package main.presentation.loadui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.businesslogicservice.LoadBLService;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.IntermediateMemory;
import main.vo.PlaneLoadingVO;

public class LoadVehiclePanel {
	int year;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;//31天
	private JPanel panel;
	private JTabbedPane tabbedPane;//选择飞机/火车/汽车
	private JTextField transmitCenterNumber;//中转中心编号输入框
	private JLabel  transmitCenterNumberLabel;
    private JLabel  receiptNumberLabel;
    private JTextField receiptNumber;//订单单号输入框
    private JLabel receiveDateLabel;
    private JTextField receiveDate;//接收时间输入框
	private JPanel carLoadInfo;
	private JPanel planeLoadInfo;
	private JPanel trainLoadInfo;
	private JLabel timeLabel;//装运日期
	private JComboBox<String> yearBox;//表示年份的组合框
	private JComboBox<String> monthBox;//表示月份的组合框
	private JComboBox<String> dayBox;//表示天的组合框
	private JButton searchFromDate;//根据日期查询
	private JTable planeTable;//飞机表格
	private JTable trainTable;
	private JTable carTable;
	private JButton ensureButton;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private String[] tableTitle;
	private String[][] tableData;
	private JButton delButton;
	private JButton saveButton;
	private JButton newButton;
	int panelWidth=0;
	int panelHeight=0;
	private JScrollPane scrollPane;
	public LoadVehiclePanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		tabbedPane=new JTabbedPane(JTabbedPane.TOP);//设置在上方选择
		carLoadInfo=new JPanel();
		planeLoadInfo=new JPanel();
		trainLoadInfo=new JPanel();
		
		carLoadInfo.setBackground(Color.red);
		planeLoadInfo.setBackground(Color.pink);
		trainLoadInfo.setBackground(Color.orange);
		
		carLoadInfo.setLayout(null);
		planeLoadInfo.setLayout(null);
		trainLoadInfo.setLayout(null);
		
		tabbedPane.addTab("飞机装运",planeLoadInfo);
		tabbedPane.addTab("火车装运",trainLoadInfo);
		tabbedPane.addTab("汽车装运",carLoadInfo);
		
		tabbedPane.setSize(panel.getWidth()/6*5+43,panel.getHeight()/6*5);
		tabbedPane.setLocation(panel.getWidth()/18,panel.getHeight()/12);
		panel.add(tabbedPane);
		planeLoadConpo();
		trainLoadConpo();
		carLoadConpo();
		
		
		tabbedPane.repaint();
		panel.repaint();
		
	}
	public void planeLoadConpo(){
		panelWidth=tabbedPane.getWidth();
    	panelHeight=tabbedPane.getHeight();
		
		delButton=new JButton("删除");
		saveButton=new JButton("保存");
		newButton=new JButton("新建");
		
		timeLabel=new JLabel("装运日期");
		
		saveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LoadBLService service=ConstructFactory.LoadFactory();
				int row=planeTable.getSelectedRow();
				WritePanel write=(WritePanel)panel;
				String code=null;
				IntermediateMemory memory=(IntermediateMemory)write.getMemory();
				ReceiptCode service1=ConstructFactory.calculateCode();
				code=service1.calculCode(memory.getAirLoadCode(),memory.getUserName());
				String loadingDate=yearBox.getItemAt(yearBox.getSelectedIndex())+"/"+monthBox.getItemAt(monthBox.getSelectedIndex())+"/"+dayBox.getItemAt(dayBox.getSelectedIndex());
				PlaneLoadingVO loading=new PlaneLoadingVO(code,loadingDate,
						(String)planeTable.getValueAt(row,0),(String)planeTable.getValueAt(row,1),(String)planeTable.getValueAt(row,2),
						(String)planeTable.getValueAt(row,3),(String)planeTable.getValueAt(row,4),(String)planeTable.getValueAt(row,5),
					write.getBelong()+" "+(String)planeTable.getValueAt(row,6),Double.parseDouble((String)planeTable.getValueAt(row,7)));
				System.out.println(loading.getCarNum());
			}
		});
     	
     	setTime(tabbedPane,planeLoadInfo);
     	
     	initPlaneTable(tabbedPane,planeLoadInfo,planeTable);
     	
     	delButton.setSize(75,35);//删除与保存按钮的初始化
     	delButton.setLocation(panelWidth*13/20-100, panelHeight*72/85);
     	saveButton.setSize(75,35);
		saveButton.setLocation(panelWidth*13/20+100,panelHeight*72/85);
     	newButton.setSize(75,35);
     	newButton.setLocation(panelWidth*13/20,panelHeight*72/85);
		
		
		
		planeLoadInfo.add(timeLabel);
     	planeLoadInfo.add(delButton);
        planeLoadInfo.add(saveButton);
        planeLoadInfo.add(newButton);
	}
	
	public void trainLoadConpo(){
		panelWidth=tabbedPane.getWidth();
    	panelHeight=tabbedPane.getHeight();
		
		delButton=new JButton("删除");
		saveButton=new JButton("保存");
		newButton=new JButton("新建");
		timeLabel=new JLabel("装运日期");
		
	
     	setTime(tabbedPane ,trainLoadInfo);
     	delButton.setSize(75,35);//删除与保存按钮的初始化
     	delButton.setLocation(panelWidth*13/20-100, panelHeight*72/85);
     	saveButton.setSize(75,35);
		saveButton.setLocation(panelWidth*13/20+100,panelHeight*72/85);
		newButton.setSize(75,35);
     	newButton.setLocation(panelWidth*13/20,panelHeight*72/85);
		initTrainTable(tabbedPane,trainLoadInfo,trainTable);
		
		trainLoadInfo.add(timeLabel);
     	trainLoadInfo.add(delButton);
        trainLoadInfo.add(saveButton);
        trainLoadInfo.add(newButton);
	}
	
	public void carLoadConpo(){
		panelWidth=tabbedPane.getWidth();
    	panelHeight=tabbedPane.getHeight();
		
		delButton=new JButton("删除");
		saveButton=new JButton("保存");
		newButton=new JButton("新建");
		timeLabel=new JLabel("装运日期");
		
     	
     	setTime(tabbedPane ,carLoadInfo);
     	delButton.setSize(75,35);//删除与保存按钮的初始化
     	delButton.setLocation(panelWidth*13/20-100, panelHeight*72/85);
     	saveButton.setSize(75,35);
		saveButton.setLocation(panelWidth*13/20+100,panelHeight*72/85);
		newButton.setSize(75,35);
     	newButton.setLocation(panelWidth*13/20,panelHeight*72/85);
     	
		initCarTable(tabbedPane,carLoadInfo,carTable);
		
		carLoadInfo.add(timeLabel);
     	carLoadInfo.add(delButton);
        carLoadInfo.add(saveButton);
        carLoadInfo.add(newButton);
	}
	
	
	public void setTime(JTabbedPane panel,JPanel panel2){
		int panelWidth=panel.getWidth();
		int panelHeight=panel.getHeight();
		
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		timeLabel = new JLabel("装运日期");
		yearLabel = new JLabel("年");
		monthLabel = new JLabel("月");
		dayLabel = new JLabel("日");
		ensureButton = new JButton("确认");
		
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		timeLabel.setBounds(panelWidth/20, panelHeight/10-15, panelWidth/10, panelHeight/20);
		yearBox = new JComboBox<String>(yearString);
		yearBox.setBounds(timeLabel.getX()+panelWidth/10, panelHeight/10-15, panelWidth/10, panelHeight/20);
		yearLabel.setBounds(yearBox.getX()+panelWidth/10+10, panelHeight/10-15, panelWidth/20, panelHeight/20);
		monthBox = new JComboBox<String>(monthString);
		monthBox.setBounds(yearLabel.getX()+panelWidth/10, panelHeight/10-15, panelWidth/10, panelHeight/20);
		monthLabel.setBounds(monthBox.getX()+panelWidth/10+10, panelHeight/10-15, panelWidth/20, panelHeight/20);
		dayBox = new JComboBox<String>(dayString);
		dayBox.setBounds(monthLabel.getX()+panelWidth/10, panelHeight/10-15,  panelWidth/10, panelHeight/20);
		dayLabel.setBounds(dayBox.getX()+10+panelWidth/10, panelHeight/10-15, panelWidth/10, panelHeight/20);
		ensureButton.setBounds(dayLabel.getX()+panelWidth/10+10, panelHeight/10-15, panelWidth/10, panelHeight/20);
		
		panel2.add(ensureButton);
		panel2.add(timeLabel);
		panel2.add(yearLabel);
		panel2.add(monthLabel);
		panel2.add(dayLabel);
		panel2.add(yearBox);
		panel2.add(monthBox);
		panel2.add(dayBox);
	}
	public void initPlaneTable(JTabbedPane panel,JPanel panel2,JTable table){
		int panelWidth=panel.getWidth()-26;
		int panelHeight=panel.getHeight()-26;
		tableTitle = new String[]{"航运编号", "航班号", "出发地", "到达地", "监装员", "货柜号","托运区号","运费"};
		tableData = new String[][]{{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"}};
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(panelWidth/20);//设置列宽
		table.setDragEnabled(false);//设置不可拖动
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, 10*table.getRowHeight());
		}
		panel2.add(scrollPane);
	}
	
	public void initTrainTable(JTabbedPane panel,JPanel panel2,JTable table){
		int panelWidth=panel.getWidth()-26;
		int panelHeight=panel.getHeight()-26;
		tableTitle = new String[]{"货运编号", "车次号", "出发地", "到达地", "监装员", "车厢号","托运区号","运费"};
		tableData = new String[][]{{"1216171910", "AA774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "11","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "11","66","10000"}};
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(panelWidth/20);//设置列宽
		table.setDragEnabled(false);//设置不可拖动
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, 10*table.getRowHeight());
		}
		panel2.add(scrollPane);
	}
	public void initCarTable(JTabbedPane panel,JPanel panel2,JTable table){
		int panelWidth=panel.getWidth()-26;
		int panelHeight=panel.getHeight()-26;
		tableTitle = new String[]{"汽运编号", "车次号", "出发地", "到达地", "监装员", "押运员","托运区号","运费"};
		tableData = new String[][]{{"1216171910", "AA774", "南京", "内蒙古", "村夫", "司徒","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "司徒","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "司徒","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "司徒","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "司徒","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "司徒","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "司徒","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "司徒","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "司徒","66","10000"},
				{"12161719", "K774", "南京", "内蒙古", "村夫", "司徒","66","10000"}};
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(panelWidth/20);//设置列宽
		table.setDragEnabled(false);//设置不可拖动
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, 10*table.getRowHeight());
		}
		panel2.add(scrollPane);
	}
}

