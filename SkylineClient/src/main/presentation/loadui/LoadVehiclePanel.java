package main.presentation.loadui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.businesslogicservice.LoadBLService;
import main.businesslogicservice.receiptblService.IntermediateReceipt;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.IntermediateMemory;
import main.vo.PlaneLoadingVO;
import main.vo.TrainLoadingVO;
import main.vo.VehicleLoadingVO;

public class LoadVehiclePanel {
	int year;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;//31天
	private JPanel panel;
	private JTabbedPane tabbedPane;//选择飞机/火车/汽车
	private JPanel carLoadInfo;
	private JPanel planeLoadInfo;
	private JPanel trainLoadInfo;
	private JLabel timeLabel;//装运日期
	private JComboBox<String> carYearBox;//表示年份的组合框
	private JComboBox<String> carMonthBox;//表示月份的组合框
	private JComboBox<String> carDayBox;//表示天的组合框
	private JComboBox<String> planeYearBox;
	private JComboBox<String> planeMonthBox;
	private JComboBox<String> planeDayBox;
	private JComboBox<String> TrainYearBox;
	private JComboBox<String> TrainMonthBox;
	private JComboBox<String> TrainDayBox;
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
	private JButton inquireButton;
	private JButton newButton;
	int panelWidth=0;
	int panelHeight=0;
	private JScrollPane scrollPane;
	private int tabWidth;
	private int tabHeight;
	
	private int HINTER;
	private int LABELWidth;
	private int LABELHEIGHT;
	//新建汽车装运
//	汽运编号", "车次号", "出发地", "到达地", "监装员", "押运员","托运区号","运费"
	private JPanel carPanel;
	private JLabel carLoadCode;//车运编号
	private JLabel carCode;//车次号
	private JLabel carStart;
	private JLabel carArrive;//到达地
	private JLabel carMontior;//监装员
	private JLabel carSupercargo;//押运员
	private JLabel carLoadArea;//托运区号
	private JLabel carFee;//运费
	private JTextField carLoadCodeText;
	private JTextField carCodeText;
	private JTextField carStartText;
	private JTextField carArriveText;
	private JTextField carMontiorText;
	private JTextField carSupercargoText;
	private JTextField carLoadAreaText;
	private JTextField carFeeText;
	private JButton carbackButton;
	private JButton carSaveButton;
	private JButton carCancleButton;
	
	//新建火车装运
	private JPanel trainPanel;
	private JLabel trainLoadCode;//
	private JLabel trainCode;//
	private JLabel trainStart;
	private JLabel trainArrive;//
	private JLabel trainMontior;//
	private JLabel trainCarriage ;//
	private JLabel trainLoadArea;//
	private JLabel trainFee;//
	private JTextField trainLoadCodeText;
	private JTextField trainCodeText;
	private JTextField trainStartText;
	private JTextField trainArriveText;
	private JTextField trainMontiorText;
	private JTextField trainCarrigeText;
	private JTextField trainLoadAreaText;
	private JTextField trainFeeText;
	private JButton trainbackButton;
	private JButton trainSaveButton;
	private JButton trainCancleButton;
	//新建飞机装运
	private JPanel planePanel;
	private JLabel planeLoadCode;//
	private JLabel planeCode;//
	private JLabel planeStart;
	private JLabel planeArrive;//
	private JLabel planeMontior;//
	private JLabel planeContainer;//
	private JLabel planeLoadArea;//
	private JLabel planeFee;//
	private JTextField planeLoadCodeText;
	private JTextField planeCodeText;
	private JTextField planeStartText;
	private JTextField planeArriveText;
	private JTextField planeMontiorText;
	private JTextField planeContainerText;
	private JTextField planeLoadAreaText;
	private JTextField planeFeeText;
	private JButton planebackButton;
	private JButton planeSaveButton;
	private JButton planeCancleButton;
	
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
		tabWidth = tabbedPane.getWidth();
		tabHeight = tabbedPane.getHeight();
		
		HINTER = tabHeight*4/35;
		LABELWidth = tabWidth/10;
		LABELHEIGHT = tabHeight/15;
		carPanel = new JPanel();
		carPanel.setLayout(null);
		panel.add(carPanel);
		carPanel.setBounds(panel.getWidth()/18,panel.getHeight()/12, panel.getWidth()/6*5+43,panel.getHeight()/6*5);
		newCarLoading();
		carPanel.setVisible(false);
		
		trainPanel = new JPanel();
		trainPanel.setLayout(null);
		panel.add(trainPanel);
		trainPanel.setBounds(panel.getWidth()/18,panel.getHeight()/12, panel.getWidth()/6*5+43,panel.getHeight()/6*5);
		newTrainLoading();
		trainPanel.setVisible(false);
	
		
		panel.add(tabbedPane);
		
		planeLoadConpo();
		trainLoadConpo();
		carLoadConpo();
//		tabbedPane.addChangeListener(new ChangeListener(){
//
//			@Override
//			public void stateChanged(ChangeEvent arg0) {
//				// TODO Auto-generated method stub
//				int select=tabbedPane.getSelectedIndex();
//				switch(select){
//				case 0:
//					tableData=getPlaneTableData();
//					for(int x=0;x<tableData.length;x++)
//						for(int y=0;y<9;y++)
//							planeTable.setValueAt(tableData[x][y],x,y);
//					break;
//				case 1:
//					tableData=getTrainTableData();
//					for(int x=0;x<tableData.length;x++)
//						for(int y=0;y<9;y++){
//							System.out.println("----------"+trainTable==null);
//							trainTable.setValueAt(tableData[x][y],x,y);
//						}
//					break;
//				case 2:
//					tableData=getCarTableData();
//					for(int x=0;x<tableData.length;x++)
//						for(int y=0;y<9;y++)
//							carTable.setValueAt(tableData[x][y],x,y);
//					break;
//				}
//			}
//			
//		});
		
		tabbedPane.repaint();
		panel.repaint();
		
	}
	public void planeLoadConpo(){
		panelWidth=tabbedPane.getWidth();
    	panelHeight=tabbedPane.getHeight();
		
		delButton=new JButton("删除");
		inquireButton=new JButton("查询");
		newButton=new JButton("新建");
		
		timeLabel=new JLabel("装运日期");
		
		planePanel = new JPanel();
		
		planePanel.setLayout(null);
		panel.add(planePanel);
		planePanel.setBounds(panel.getWidth()/18,panel.getHeight()/12, panel.getWidth()/6*5+43,panel.getHeight()/6*5);
		
		newButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				tabbedPane.setVisible(false);
				planePanel.setVisible(true);
			}
		});
//--------------------------------------------------------		
	
		
     	
     	initPlaneTable(tabbedPane,planeLoadInfo);
     	
     	inquireButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				IntermediateMemory memory=(IntermediateMemory) ((WritePanel)panel).getMemory();
				String dateInfo=memory.getAirLoadDate();
				System.out.println(dateInfo);
				String dateString[]=dateInfo.split(" ");
				String choose=(String)carYearBox.getItemAt(carYearBox.getSelectedIndex())+"/"+(String)carMonthBox.getItemAt(carMonthBox.getSelectedIndex())+"/"+
				(String)carDayBox.getItemAt(carDayBox.getSelectedIndex());
				System.out.println(choose);
				int x=1;
				int y=x;
				for(;x<dateString.length;x++){
					if(dateString[x].equals(choose)){
						for(y=x;y<dateString.length;y++){
							if(!dateString[y].equals(choose))
							break;
						}
						break;
					}
				}
				System.out.println(x+"--------"+y);
				if(y>=x)
				planeTable.setRowSelectionInterval(x-1,y-1);
			}
		});
	
		newPlaneLoading();
		planePanel.setVisible(false);
		
     	delButton.setSize(75,35);//删除与保存按钮的初始化
     	delButton.setLocation(panelWidth*13/20-100, panelHeight*72/85);
     	inquireButton.setSize(75,35);
		inquireButton.setLocation(panelWidth*13/20+100,panelHeight*72/85);
     	newButton.setSize(75,35);
     	newButton.setLocation(panelWidth*13/20,panelHeight*72/85);
		
		
		
		planeLoadInfo.add(timeLabel);
     	planeLoadInfo.add(delButton);
        planeLoadInfo.add(inquireButton);
        planeLoadInfo.add(newButton);
	}
	
	public void trainLoadConpo(){
		panelWidth=tabbedPane.getWidth();
    	panelHeight=tabbedPane.getHeight();
		
		delButton=new JButton("删除");
		inquireButton=new JButton("保存");
		newButton=new JButton("新建");
		timeLabel=new JLabel("装运日期");

//-----------------------------------------------------------
		newButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				tabbedPane.setVisible(false);
				trainPanel.setVisible(true);
			}
		});
	
     	delButton.setSize(75,35);//删除与保存按钮的初始化
     	delButton.setLocation(panelWidth*13/20-100, panelHeight*72/85);
     	inquireButton.setSize(75,35);
		inquireButton.setLocation(panelWidth*13/20+100,panelHeight*72/85);
		newButton.setSize(75,35);
     	newButton.setLocation(panelWidth*13/20,panelHeight*72/85);
		initTrainTable(tabbedPane,trainLoadInfo,trainTable);
		
		trainLoadInfo.add(timeLabel);
     	trainLoadInfo.add(delButton);
        trainLoadInfo.add(inquireButton);
        trainLoadInfo.add(newButton);
	}
	
	public void carLoadConpo(){
		panelWidth=tabbedPane.getWidth();
    	panelHeight=tabbedPane.getHeight();
		
		delButton=new JButton("删除");
		inquireButton=new JButton("保存");
		newButton=new JButton("新建");
		timeLabel=new JLabel("装运日期");
		
//--------------------------------------------------------------		
		newButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				tabbedPane.setVisible(false);
				carPanel.setVisible(true);
			}
		});
     	
     	this.setCarTime();
     	delButton.setSize(75,35);//删除与保存按钮的初始化
     	delButton.setLocation(panelWidth*13/20-100, panelHeight*72/85);
     	inquireButton.setSize(75,35);
		inquireButton.setLocation(panelWidth*13/20+100,panelHeight*72/85);
		newButton.setSize(75,35);
     	newButton.setLocation(panelWidth*13/20,panelHeight*72/85);
     	
		initCarTable(tabbedPane,carLoadInfo,carTable);
		
		carLoadInfo.add(timeLabel);
     	carLoadInfo.add(delButton);
        carLoadInfo.add(inquireButton);
        carLoadInfo.add(newButton);
	}
	
	
	
	private void setCarTime(){
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
		dayString = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		timeLabel.setBounds(panelWidth/20, panelHeight/10-15, panelWidth/10, panelHeight/20);
		carYearBox = new JComboBox<String>(yearString);
		carYearBox.setBounds(timeLabel.getX()+panelWidth/10, panelHeight/10-15, panelWidth/10, panelHeight/20);
		yearLabel.setBounds(carYearBox.getX()+panelWidth/10+10, panelHeight/10-15, panelWidth/20, panelHeight/20);
		carMonthBox = new JComboBox<String>(monthString);
		carMonthBox.setBounds(yearLabel.getX()+panelWidth/10, panelHeight/10-15, panelWidth/10, panelHeight/20);
		monthLabel.setBounds(carMonthBox.getX()+panelWidth/10+10, panelHeight/10-15, panelWidth/20, panelHeight/20);
		carDayBox = new JComboBox<String>(dayString);
		carDayBox.setBounds(monthLabel.getX()+panelWidth/10, panelHeight/10-15,  panelWidth/10, panelHeight/20);
		dayLabel.setBounds(carDayBox.getX()+10+panelWidth/10, panelHeight/10-15, panelWidth/10, panelHeight/20);
		ensureButton.setBounds(dayLabel.getX()+panelWidth/10+10, panelHeight/10-15, panelWidth/10, panelHeight/20);
		
		carPanel.add(ensureButton);
		carPanel.add(timeLabel);
		carPanel.add(yearLabel);
		carPanel.add(monthLabel);
		carPanel.add(dayLabel);
		carPanel.add(carYearBox);
		carPanel.add(carMonthBox);
		carPanel.add(carDayBox);
	}
	
	public String[][] getPlaneTableData(){
		IntermediateMemory memory=(IntermediateMemory) ((WritePanel)panel).getMemory();
		String[] codes=memory.getAirLoadCode().split(" ");
		int length=codes.length;
		String[][] table;
		if(length>10)
			table=new String[length-1][9];
		else
			table=new String[10][9];
		for(int x=0;x<table.length;x++)
			for(int y=0;y<9;y++)
				table[x][y]=null;
		LoadBLService service=ConstructFactory.LoadFactory();
		ArrayList<PlaneLoadingVO> volist=service.inquireLoadPlane(memory.getAirLoadCode());
		int x=0;
		for(PlaneLoadingVO vo:volist){
			table[x][0]=vo.getCarTourNum();
			table[x][1]=vo.getCarNum();
			table[x][2]=vo.getDeparture();
			table[x][3]=vo.getDestination();
			table[x][4]=vo.getMonitor();
			table[x][5]=vo.getStore();
			table[x][6]=vo.getShipment();
			table[x][7]=vo.getFreight()+"";
			table[x][8]=vo.getLoadingDate();
			x++;
		}
		return table;
	}
	public void initPlaneTable(JTabbedPane panel,JPanel panel2){
		int panelWidth=panel.getWidth()-26;
		int panelHeight=panel.getHeight()-26;
		tableTitle = new String[]{"航运编号", "航班号", "出发地", "到达地", "监装员", "货柜号","托运区号","运费","装运日期"};
		tableData = this.getPlaneTableData();
		planeTable = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(planeTable);
		planeTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		planeTable.setRowHeight(panelWidth/20);//设置列宽
		planeTable.setDragEnabled(false);//设置不可拖动
		planeTable.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		planeTable.getTableHeader().setResizingAllowed(true);//设置列宽不可变
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, (planeTable.getRowCount()+1)*planeTable.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, 10*planeTable.getRowHeight());
		}
		panel2.add(scrollPane);
	}
	
	public String[][] getTrainTableData(){
		IntermediateMemory memory=(IntermediateMemory) ((WritePanel)panel).getMemory();
		String codes[]=memory.getRailLoadCode().split(" ");
		int length=codes.length;
		String[][] table;
		if(length>10)
			table=new String[length-1][9];
		else
			table=new String[10][9];
		for(int x=0;x<table.length;x++)
			for(int y=0;y<9;y++)
				table[x][y]=null;
		LoadBLService service=ConstructFactory.LoadFactory();
		ArrayList<TrainLoadingVO> voList=service.inquireLoadTrain(memory.getRailLoadCode());
		int x=0;
		//"货运编号", "车次号", "出发地", "到达地", "监装员", "车厢号","托运区号","运费","装运日期"
		for(TrainLoadingVO vo:voList){
			table[x][0]=vo.getCarTourNum();
			table[x][1]=vo.getCarNum();
			table[x][2]=vo.getDeparture();
			table[x][3]=vo.getDestination();
			table[x][4]=vo.getMonitor();
			table[x][5]=vo.getGuard();
			table[x][6]=vo.getShipment();
			table[x][7]=vo.getFreight()+"";
			table[x][8]=vo.getLoadingDate();
			x++;
		}
		return table;	
	}
	public void initTrainTable(JTabbedPane panel,JPanel panel2,JTable table){
		int panelWidth=panel.getWidth()-26;
		int panelHeight=panel.getHeight()-26;
		tableTitle = new String[]{"货运编号", "车次号", "出发地", "到达地", "监装员", "车厢号","托运单号","运费","装运日期"};
		tableData =this.getTrainTableData();
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(panelWidth/20);//设置列宽
		table.setDragEnabled(false);//设置不可拖动
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table.getTableHeader().setResizingAllowed(true);//设置列宽不可变
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, 10*table.getRowHeight());
		}
		panel2.add(scrollPane);
	}
	
	public String[][] getCarTableData(){
		IntermediateMemory memory=(IntermediateMemory) ((WritePanel)panel).getMemory();
		String codes[]=memory.getRoadLoadCode().split(" ");
		int length=codes.length;
		String[][] table;
		if(length>10)
			table=new String[length-1][9];
		else
			table=new String[10][9];
		for(int x=0;x<table.length;x++)
			for(int y=0;y<9;y++)
				table[x][y]=null;
		LoadBLService service=ConstructFactory.LoadFactory();
		ArrayList<VehicleLoadingVO> voList=service.inquireLoadCar(memory.getRoadLoadCode());
		int x=0;
		for(VehicleLoadingVO vo:voList){
			table[x][0]=vo.getCarTourNum();
			table[x][1]=vo.getCarNum();
			table[x][2]=vo.getDeparture();
			table[x][3]=vo.getDestination();
			table[x][4]=vo.getMonitor();
			table[x][5]=vo.getGuard();
			table[x][6]=vo.getShipment();
			table[x][7]=vo.getFreight()+"";
			table[x][8]=vo.getLoadingDate();
			x++;
		}
		return table;
	}
	public void initCarTable(JTabbedPane panel,JPanel panel2,JTable table){
		int panelWidth=panel.getWidth()-26;
		int panelHeight=panel.getHeight()-26;
		tableTitle = new String[]{"汽运编号", "车次号", "出发地", "到达地", "监装员", "押运员","托运区号","运费","装运日期"};
		tableData = this.getCarTableData();
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
	
//新建一个汽车装运管理项
	public void newCarLoading(){
		carLoadCode = new JLabel("车运编号");//车运编号
		carCode = new JLabel("车次号");//车次号
		carStart = new JLabel("出发地");
		carArrive = new JLabel("到达地");//到达地
		carMontior = new JLabel("监装员");//监装员
		carSupercargo = new JLabel("押运员");//押运员
		carLoadArea = new JLabel("托运区号");//托运区号
		carFee = new JLabel("运费");//运费
		carLoadCodeText = new JTextField();
		carCodeText = new JTextField();
		carStartText = new JTextField();
		carArriveText = new JTextField();
		carMontiorText = new JTextField();
		carSupercargoText = new JTextField();
		carLoadAreaText = new JTextField();
		carFeeText = new JTextField();
		carbackButton = new JButton("返回");
		carSaveButton = new JButton("保存");
		carCancleButton = new JButton("取消");
		
		carSaveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				WritePanel wp=(WritePanel)panel;
				IntermediateMemory memory=(IntermediateMemory) wp.getMemory();
				String code=memory.getRoadLoadCode();
				ReceiptCode codeService=ConstructFactory.calculateCode();
				code=codeService.calculCode(code, memory.getUserName());
				Date dt=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
				String time=format.format(dt);
				VehicleLoadingVO vo=new VehicleLoadingVO(code,time,carLoadCodeText.getText(),carCodeText.getText(),
						carStartText.getText(),carArriveText.getText(),carMontiorText.getText(),carSupercargoText.getText(),
						wp.getBelong()+" "+carLoadAreaText.getText(),Double.parseDouble(carFeeText.getText()));
				IntermediateReceipt intermRservice=ConstructFactory.IntermediateFactory();
				intermRservice.saveRoadLoadCode(memory.getRoadLoadCode(), code);
				memory.setRoadLoadCode(memory.getRoadLoadCode()+" "+code);
				memory.setRoadLoadDate(memory.getAirLoadDate()+" "+time);
				LoadBLService service=ConstructFactory.LoadFactory();
				service.loadCar(vo);
				tableData=getCarTableData();
				for(int x=0;x<tableData.length;x++)
					for(int y=0;y<9;y++)
						carTable.setValueAt(tableData[x][y],x,y);
			}
		});
		
		carPanel.add(carLoadCode);
		carPanel.add(carCode);
		carPanel.add(carStart);
		carPanel.add(carArrive);
		carPanel.add(carMontior);
		carPanel.add(carSupercargo);
		carPanel.add(carLoadArea);
		carPanel.add(carFee);
		carPanel.add(carLoadCodeText);
		carPanel.add(carCodeText);
		carPanel.add(carStartText);
		carPanel.add(carArriveText);
		carPanel.add(carMontiorText);
		carPanel.add(carSupercargoText);
		carPanel.add(carLoadAreaText);
		carPanel.add(carFeeText);
		carPanel.add(carbackButton);
		carPanel.add(carSaveButton);
		carPanel.add(carCancleButton);
		
		carbackButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				carPanel.setVisible(false);
				tabbedPane.setVisible(true);
			}
		});
		
//		HINTER = tabHeight*3/35;
//		WINTER = tabWidth/10;
//		LABELWidth = tabWidth/10;
//		LABELHEIGHT = tabHeight/15;
//		TEXTWIDTH = tabWidth/4;
		carLoadCode.setBounds(tabWidth/10, HINTER, LABELWidth, LABELHEIGHT);
		carCode.setBounds(tabWidth/2, HINTER, LABELWidth, LABELHEIGHT);
		carStart.setBounds(carLoadCode.getX(), HINTER*2+LABELHEIGHT, LABELWidth, LABELHEIGHT);
		carArrive.setBounds(carCode.getX(), HINTER*2+LABELHEIGHT, LABELWidth, LABELHEIGHT);
		carMontior.setBounds(carLoadCode.getX(), HINTER*3+LABELHEIGHT*2, LABELWidth, LABELHEIGHT);
		carSupercargo.setBounds(carCode.getX(), HINTER*3+LABELHEIGHT*2, LABELWidth, LABELHEIGHT);
		carLoadArea.setBounds(carLoadCode.getX(), HINTER*4+LABELHEIGHT*3, LABELWidth, LABELHEIGHT);
		carFee.setBounds(carCode.getX(), HINTER*4+LABELHEIGHT*3, LABELWidth, LABELHEIGHT);
		carLoadCodeText.setBounds(carLoadCode.getX()+LABELWidth, carLoadCode.getY(), tabWidth/4, LABELHEIGHT);
		carCodeText.setBounds(carCode.getX()+LABELWidth, carCode.getY(), tabWidth/4, LABELHEIGHT);
		carStartText.setBounds(carStart.getX() + LABELWidth, carStart.getY(), tabWidth/4, LABELHEIGHT);
		carArriveText.setBounds(carArrive.getX() + LABELWidth, carArrive.getY(), tabWidth/4, LABELHEIGHT);
		carMontiorText.setBounds(carMontior.getX() + LABELWidth, carMontior.getY(), tabWidth/4, LABELHEIGHT);
		carSupercargoText.setBounds(carSupercargo.getX() + LABELWidth, carSupercargo.getY(), tabWidth/4, LABELHEIGHT);
		carLoadAreaText.setBounds(carLoadArea.getX() + LABELWidth, carLoadArea.getY(), tabWidth/4, LABELHEIGHT);
		carFeeText.setBounds(carFee.getX() + LABELWidth, carFee.getY(), tabWidth/4, LABELHEIGHT);
		carbackButton.setBounds(tabWidth*7/20, HINTER*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		carSaveButton.setBounds(tabWidth*15/20, HINTER*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		carCancleButton.setBounds(tabWidth*11/20, HINTER*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		
		carPanel.repaint();
	}
//新建一个火车装运管理项
	public void newTrainLoading(){
		trainLoadCode = new JLabel("货运编号");//车运编号
		trainCode = new JLabel("车次号");//车次号
		trainStart = new JLabel("出发地");
		trainArrive = new JLabel("到达地");//
		trainMontior = new JLabel("监装员");//
		trainCarriage  = new JLabel("车厢号");
		trainLoadArea = new JLabel("托运区号");//托运区号
		trainFee = new JLabel("运费");//运费

		trainLoadCodeText = new JTextField();
		trainCodeText = new JTextField();
		trainStartText = new JTextField();
		trainArriveText = new JTextField();
		trainMontiorText = new JTextField();
		trainCarrigeText = new JTextField();
		trainLoadAreaText = new JTextField();
		trainFeeText = new JTextField();
		trainbackButton = new JButton("返回");
		trainSaveButton = new JButton("保存");
		trainCancleButton = new JButton("取消");
		
		trainSaveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				WritePanel wp=(WritePanel)panel;
				IntermediateMemory memory=(IntermediateMemory) wp.getMemory();
				String code=memory.getRailLoadCode();
				ReceiptCode codeService=ConstructFactory.calculateCode();
				code=codeService.calculCode(code, memory.getUserName());
				Date dt=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
				String time=format.format(dt);
				TrainLoadingVO vo=new TrainLoadingVO(code,time,trainLoadCodeText.getText(),
						trainCodeText.getText(),trainStartText.getText(),trainArriveText.getText(),
						trainMontiorText.getText(),trainCarriage.getText(),wp.getBelong()+" "+trainLoadAreaText.getText(),
						Double.parseDouble(trainFeeText.getText()));
				IntermediateReceipt intermRservice=ConstructFactory.IntermediateFactory();
				intermRservice.saveRailLoadCode(memory.getUserName(), code);
				memory.setRailLoadCode(memory.getRailLoadCode()+" "+code);
				memory.setRailLoadDate(memory.getRailLoadDate()+" "+code);
				LoadBLService service=ConstructFactory.LoadFactory();
				service.loadTrain(vo);
				tableData=getTrainTableData();
				for(int x=0;x<tableData.length;x++)
					for(int y=0;y<9;y++){
						System.out.println(trainTable==null);
						trainTable.setValueAt(tableData[x][y],x,y);
					}
			}
		});
		
		trainPanel.add(trainLoadCode);
		trainPanel.add(trainCode);
		trainPanel.add(trainStart);
		trainPanel.add(trainArrive);
		trainPanel.add(trainMontior);
		trainPanel.add(trainCarriage );
		trainPanel.add(trainLoadArea);
		trainPanel.add(trainFee);
		trainPanel.add(trainLoadCodeText);
		trainPanel.add(trainCodeText);
		trainPanel.add(trainStartText);
		trainPanel.add(trainArriveText);
		trainPanel.add(trainMontiorText);
		trainPanel.add(trainCarrigeText);
		trainPanel.add(trainLoadAreaText);
		trainPanel.add(trainFeeText);
		trainPanel.add(trainbackButton);
		trainPanel.add(trainSaveButton);
		trainPanel.add(trainCancleButton);
		
		trainbackButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				trainPanel.setVisible(false);
				tabbedPane.setVisible(true);
			}
		});
		
		trainLoadCode.setBounds(tabWidth/10, HINTER, LABELWidth, LABELHEIGHT);
		trainCode.setBounds(tabWidth/2, HINTER, LABELWidth, LABELHEIGHT);
		trainStart.setBounds(trainLoadCode.getX(), LABELHEIGHT + HINTER*2, LABELWidth, LABELHEIGHT);
		trainArrive.setBounds(trainCode.getX(), LABELHEIGHT + HINTER*2, LABELWidth, LABELHEIGHT);
		trainMontior.setBounds(trainLoadCode.getX(), LABELHEIGHT*2 + HINTER*3, LABELWidth, LABELHEIGHT);
		trainCarriage .setBounds(trainCode.getX(), LABELHEIGHT*2 + HINTER*3, LABELWidth, LABELHEIGHT);
		trainLoadArea.setBounds(trainLoadCode.getX(), LABELHEIGHT*3 + HINTER*4, LABELWidth, LABELHEIGHT);
		trainFee.setBounds(trainCode.getX(), LABELHEIGHT*3 + HINTER*4, LABELWidth, LABELHEIGHT);
		trainLoadCodeText.setBounds(trainLoadCode.getX()+LABELWidth, HINTER, tabWidth/4,LABELHEIGHT);
		trainCodeText.setBounds(trainCode.getX() + LABELWidth, HINTER, tabWidth/4,LABELHEIGHT);
		trainStartText.setBounds(trainLoadCode.getX()+LABELWidth, LABELHEIGHT + HINTER*2, tabWidth/4,LABELHEIGHT);
		trainArriveText.setBounds(trainCode.getX() + LABELWidth, LABELHEIGHT + HINTER*2, tabWidth/4,LABELHEIGHT);
		trainMontiorText.setBounds(trainLoadCode.getX()+LABELWidth, LABELHEIGHT*2 + HINTER*3, tabWidth/4,LABELHEIGHT);
		trainCarrigeText.setBounds(trainCode.getX() + LABELWidth, LABELHEIGHT*2 + HINTER*3, tabWidth/4,LABELHEIGHT);
		trainLoadAreaText.setBounds(trainLoadCode.getX()+LABELWidth, LABELHEIGHT*3 + HINTER*4, tabWidth/4,LABELHEIGHT);
		trainFeeText.setBounds(trainCode.getX() + LABELWidth, LABELHEIGHT*3 + HINTER*4, tabWidth/4,LABELHEIGHT);
		trainbackButton.setBounds(tabWidth*7/20, HINTER*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		trainSaveButton.setBounds(tabWidth*15/20, HINTER*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		trainCancleButton.setBounds(tabWidth*11/20, HINTER*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		
		trainPanel.repaint();
	}
	
//新建一个飞机装运管理项
	public void newPlaneLoading(){
//		"航运编号", "航班号", "出发地", "到达地", "监装员", "货柜号","托运区号","运费"
		planeLoadCode = new JLabel("航运编号");//车运编号
		planeCode = new JLabel("航班号");//车次号
		planeStart = new JLabel("出发地");
		planeArrive = new JLabel("到达地");//到达地
		planeMontior = new JLabel("监装员");//监装员
		planeContainer = new JLabel("货柜号");//押运员
		planeLoadArea = new JLabel("托运区号");//托运区号
		planeFee = new JLabel("运费");//运费
		planeLoadCodeText = new JTextField();
		planeCodeText = new JTextField();
		planeStartText = new JTextField();
		planeArriveText = new JTextField();
		planeMontiorText = new JTextField();
		planeContainerText = new JTextField();
		planeLoadAreaText = new JTextField();
		planeFeeText = new JTextField();
		planebackButton = new JButton("返回");
		planeSaveButton = new JButton("保存");
		planeCancleButton = new JButton("取消");
		
		
		planeSaveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				WritePanel wp=(WritePanel)panel;
				IntermediateMemory memory=(IntermediateMemory) wp.getMemory();
				String code=memory.getAirLoadCode();
				ReceiptCode codeService=ConstructFactory.calculateCode();
				code=codeService.calculCode(code, memory.getUserName());
				Date dt=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
				String time=format.format(dt);
				PlaneLoadingVO vo=new PlaneLoadingVO(code,time,planeLoadCodeText.getText(),
						planeCodeText.getText(),planeStartText.getText(),planeArriveText.getText(),
						planeMontiorText.getText(),planeContainerText.getText(),wp.getBelong()+" "+planeLoadAreaText.getText(),
						Double.parseDouble(planeFeeText.getText()));
				IntermediateReceipt intermRservice=ConstructFactory.IntermediateFactory();
				intermRservice.saveAirLoadCode(memory.getUserName(), code);
				memory.setAirLoadCode(memory.getAirLoadCode()+" "+code);
				memory.setAirLoadDate(memory.getAirLoadDate()+" "+code);
				LoadBLService service=ConstructFactory.LoadFactory();
				service.loadPlane(vo);
				tableData=getPlaneTableData();
				for(int x=0;x<tableData.length;x++)
					for(int y=0;y<9;y++)
						planeTable.setValueAt(tableData[x][y],x,y);
			}
		});
		
		planePanel.add(planeLoadCode);
		planePanel.add(planeCode);
		planePanel.add(planeStart);
		planePanel.add(planeArrive);
		planePanel.add(planeMontior);
		planePanel.add(planeContainer);
		planePanel.add(planeLoadArea);
		planePanel.add(planeFee);
		planePanel.add(planeLoadCodeText);
		planePanel.add(planeCodeText);
		planePanel.add(planeStartText);
		planePanel.add(planeArriveText);
		planePanel.add(planeMontiorText);
		planePanel.add(planeContainerText);
		planePanel.add(planeLoadAreaText);
		planePanel.add(planeFeeText);
		planePanel.add(planebackButton);
		planePanel.add(planeSaveButton);
		planePanel.add(planeCancleButton);
		
		planebackButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				planePanel.setVisible(false);
				tabbedPane.setVisible(true);
			}
		});
		
		planeLoadCode.setBounds(tabWidth/10, HINTER, LABELWidth, LABELHEIGHT);
		planeCode.setBounds(tabWidth/2, HINTER, LABELWidth, LABELHEIGHT);
		planeStart.setBounds(planeLoadCode.getX(), HINTER*2+LABELHEIGHT, LABELWidth, LABELHEIGHT);
		planeArrive.setBounds(planeCode.getX(), HINTER*2+LABELHEIGHT, LABELWidth, LABELHEIGHT);
		planeMontior.setBounds(planeLoadCode.getX(), HINTER*3+LABELHEIGHT*2, LABELWidth, LABELHEIGHT);
		planeContainer.setBounds(planeCode.getX(), HINTER*3+LABELHEIGHT*2, LABELWidth, LABELHEIGHT);
		planeLoadArea.setBounds(planeLoadCode.getX(), HINTER*4+LABELHEIGHT*3, LABELWidth, LABELHEIGHT);
		planeFee.setBounds(planeCode.getX(), HINTER*4+LABELHEIGHT*3, LABELWidth, LABELHEIGHT);
		planeLoadCodeText.setBounds(planeLoadCode.getX()+LABELWidth, HINTER, tabWidth/4, LABELHEIGHT);
		planeCodeText.setBounds(planeCode.getX() + LABELWidth, HINTER, tabWidth/4, LABELHEIGHT);
		planeStartText.setBounds(planeLoadCodeText.getX(), HINTER*2+LABELHEIGHT, tabWidth/4, LABELHEIGHT);
		planeArriveText.setBounds(planeCode.getX() + LABELWidth, HINTER*2+LABELHEIGHT, tabWidth/4, LABELHEIGHT);
		planeMontiorText.setBounds(planeLoadCodeText.getX(), HINTER*3+LABELHEIGHT*2, tabWidth/4, LABELHEIGHT);
		planeContainerText.setBounds(planeCode.getX() + LABELWidth, HINTER*3+LABELHEIGHT*2, tabWidth/4, LABELHEIGHT);
		planeLoadAreaText.setBounds(planeLoadCodeText.getX(), HINTER*4+LABELHEIGHT*3, tabWidth/4, LABELHEIGHT);
		planeFeeText.setBounds(planeCode.getX() + LABELWidth, HINTER*4+LABELHEIGHT*3, tabWidth/4, LABELHEIGHT);
		planebackButton.setBounds(tabWidth*7/20, HINTER*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		planeSaveButton.setBounds(tabWidth*15/20, HINTER*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		planeCancleButton.setBounds(tabWidth*11/20, HINTER*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		
		planePanel.repaint();
	}
}

