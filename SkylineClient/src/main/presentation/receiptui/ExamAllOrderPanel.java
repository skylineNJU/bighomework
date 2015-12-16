package main.presentation.receiptui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.FinanceBLService;
import main.businesslogicservice.LoadBLService;
import main.businesslogicservice.ReceiveBLService;
import main.businesslogicservice.WarehouseBLService;
import main.businesslogicservice.receiptblService.SubmitReceipt;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.ReceiptRecordMemory;
import main.vo.LobbyLoading;
import main.vo.LobbyReceptionVO;
import main.vo.OrderVO;
import main.vo.PlaneLoadingVO;
import main.vo.ReceiptRecordVO;
import main.vo.TrainLoadingVO;
import main.vo.TransitReceptionVO;
import main.vo.VehicleLoadingVO;
import main.vo.WarehouseInVO;
import main.vo.WarehouseOutVO;

public class ExamAllOrderPanel {
	
	private JPanel panel;
	private JLabel title;
	private JTabbedPane tab;
	private JPanel courierPanel;
	private JPanel lobbyPanel;
	private JPanel intermePanel;
	private JPanel warehousePanel;
	private int tabWidth;
	private int tabHeight;
	
	//快递员组件
	private JTable courierTable;
	private JScrollPane courierScrollPane;
	private String[] courierTitle;
	private String[][] courierData;
	private JButton courierChooseAll;
	private JButton courierCheck;
	//营业厅业务员组件
	private JTable lobbyTable;
	private JScrollPane lobbyScrollPane;
	private String[] lobbyTitle;
	private String[][] lobbyData;
	private JButton lobbyChooseAll;
	private JButton lobbyCheck;
	//中转中心业务员组件
	private JTable intermeTable;
	private JScrollPane intermeScrollPane;
	private String[] intermeTitle;
	private String[][] intermeData;
	private JButton intermeChooseAll;
	private JButton intermeCheck;
	//中转仓库组件
	private JTable warehouseTable;
	private JScrollPane warehouseScrollPane;
	private String[] warehouseTitle;
	private String[][] warehouseData;
	private JButton warehouseChooseAll;
	private JButton warehouseCheck;
	private ReceiptRecordMemory memory;
	private String[] courrierKinds={"订单","收件单"};
	private String[] lobbyKinds={"接收单","入款单","装运单"};
	private String[] intermKinds={"中转接收单","飞机装运单","火车装运单","汽车装运单"};
	private String[] warehouseKinds={"入库单","出库单"};
	
	public ExamAllOrderPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		memory=(ReceiptRecordMemory) ((WritePanel)panel).getMemory();
	}
	
	public void approve(){
		SubmitReceipt service=ConstructFactory.SubMitFactory();
		ReceiptRecordVO vo=new ReceiptRecordVO(
				memory.getCourrierCode(),
				memory.getLobbyCode(),
				memory.getIntermediateCode(),
				memory.getWarehouseCode(),
				memory.getFinanceCode());
		service.approveReceipt(vo);
	}
	public void init(){
		initTitle();
		tab = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tab);
		tab.setBounds(panel.getWidth()/10, panel.getHeight()/15, panel.getWidth()*4/5, panel.getHeight()*13/15);
		tabWidth = tab.getWidth();
		tabHeight = tab.getHeight();
		courierPanel = new JPanel();
		courierPanel.setLayout(null);
		lobbyPanel = new JPanel();
		lobbyPanel.setLayout(null);
		intermePanel = new JPanel();
		intermePanel.setLayout(null);
		warehousePanel = new JPanel();
		warehousePanel.setLayout(null);
		tab.addTab("快递员", courierPanel);
		tab.addTab("营业厅业务员", lobbyPanel);
		tab.addTab("中转中心业务员", intermePanel);
		tab.addTab("仓库管理人员", warehousePanel);
		
		courierOrder();
		lobbyOrder();
		IntermeOrder();
		warehouseOrder();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("单据审批");
		panel.add(title);
		title.setBounds(panel.getWidth()*2/5, panel.getHeight()/60, panel.getWidth()/5, panel.getHeight()/30);
	}
	
	public void initCourierReceipt(){
		String codes[]=memory.getCourrierCode().split(" ");
		courierData=new String[codes.length-1][4];
		for(int x=1;x<codes.length;x++){
			courierData[x-1][0]=codes[x].substring(0,9);
			courierData[x-1][1]=this.courrierKinds[codes[x].charAt(9)-'0'];
			courierData[x-1][2]="";
			courierData[x-1][2]="";
		}
	}
	
	public void refreshCourierReceipt(){
		initCourierReceipt();
		DefaultTableModel model=(DefaultTableModel) courierTable.getModel();
		model.setDataVector(this.courierData,courierTitle);
	}
	//快递员的单据
	public void courierOrder(){
		courierTitle = new String[]{"职工账号","单据类型","选择","查看单据"};
		this.initCourierReceipt();
		courierTable = new JTable(courierData,courierTitle);
		courierTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		courierTable.setRowHeight(tabWidth/20);//设置列宽
		courierTable.setDragEnabled(false);//设置不可拖动
		courierTable.getTableHeader().setPreferredSize(new Dimension(10000, tabWidth/20));//设置表头高度
		courierTable.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		courierScrollPane = new JScrollPane(courierTable);
		if(courierData.length<=12){
			courierScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, (courierTable.getRowCount()+1)*courierTable.getRowHeight());
		}else{
			courierScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, 13*courierTable.getRowHeight());
		}
		courierTable.setModel(new DefaultTableModel(courierData,courierTitle){//设置第四行不可被编辑
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row,int column){  
				if(column == 4){  
				     return false;  
				}else{  
				      return true;  
				}  
			}  
		});
		
		courierTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(courierTable.getSelectedColumn()==2&&courierTable.getValueAt(courierTable.getSelectedRow(),2).equals("批准")){
					courierTable.setValueAt("",courierTable.getSelectedRow(),2);
				}else if(courierTable.getSelectedColumn()==2&&!courierTable.getValueAt(courierTable.getSelectedRow(),2).equals("批准")){
					courierTable.setValueAt("批准",courierTable.getSelectedRow(),2);
				}
				courierTable.repaint();
				
				if(courierTable.getSelectedColumn()==3){
					int x=courierTable.getSelectedRow();
					HtmlMultiLineControl hmlc = new HtmlMultiLineControl();
					String content=null;
					String codes[]=memory.getCourrierCode().split(" ");
					String selectCode="0 "+codes[x+1];
					//"订单","收件单"
					switch((String)courierTable.getValueAt(x,1)){
					case "订单":
						ReceiveBLService service0=ConstructFactory.ReceiveFactory();
						OrderVO vo1=service0.inquireOrderReceive(selectCode).get(0);
						content="寄件人姓名："+vo1.getSenderName()+"<br>"
							   +"寄件人地址："+vo1.getSenderAddress()+"<br>"
							   +"寄件人单位："+vo1.getReceiverCom()+"<br>"
							   +"寄件人电话："+vo1.getSenderMobile()+"<br>"
							   +"收件人姓名："+vo1.getReceiverName()+"<br>"
							   +"收件人地址："+vo1.getReceiverAddress()+"<br>"
							   +"收件人单位："+vo1.getReceiverCom()+"<br>"
							   +"收件人电话："+vo1.getSenderMobile()+"<br>";
					}
					content=hmlc.CovertDestionString(content);
					courierTable.setToolTipText(content);
				}
				
				
			}
		});

		courierChooseAll = new JButton("全选");
		courierChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < courierData.length; i++) {
					courierTable.setValueAt("批准",i,2);
					courierTable.repaint();
				}
			}
		});
		
		
		courierCheck = new JButton("批准");
		courierCheck.setBounds(tabWidth*3/4, 13*courierTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		courierChooseAll.setBounds(tabWidth*11/20, 13*courierTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		courierCheck.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String codes=memory.getCourrierCode();
				String list[]=codes.split(" ");
				for(int x=0;x<courierTable.getRowCount();x++){
					if(((String)courierTable.getValueAt(x,2)).equals("批准")){
						System.out.println(list[x+1]);
						codes=codes.replace(" "+list[x+1],"");
					}
				}
				memory.setCourrierCode(codes);
				approve();
				refreshCourierReceipt();
			}
		});
		
		courierPanel.add(courierChooseAll);
		courierPanel.add(courierCheck);
		courierPanel.add(courierScrollPane);
	}
	
	public void initLobbyReceipt(){
		String[] codes=memory.getLobbyCode().split(" ");
		lobbyData=new String[codes.length-1][4];
		for(int x=1;x<codes.length;x++){
			lobbyData[x-1][0]=codes[x].substring(0,9);
			lobbyData[x-1][1]=this.lobbyKinds[codes[x].charAt(9)-'1'];
			lobbyData[x-1][2]="";
			lobbyData[x-1][3]="";
		}
	}
	
	public void refreshLobbyReceipt(){
		initLobbyReceipt();
		DefaultTableModel model=(DefaultTableModel)lobbyTable.getModel();
		model.setDataVector(lobbyData,lobbyTitle);
	}
	//营业厅业务员的单据
	public void lobbyOrder(){
		lobbyTitle = new String[]{"职工账号","单据类型","选择", "查看单据"};
		this.initLobbyReceipt();
		lobbyTable = new JTable(lobbyData,lobbyTitle);
		lobbyTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		lobbyTable.setRowHeight(tabWidth/20);//设置列宽
		lobbyTable.setDragEnabled(false);//设置不可拖动
		lobbyTable.getTableHeader().setPreferredSize(new Dimension(10000, tabWidth/20));//设置表头高度
		lobbyTable.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		lobbyScrollPane = new JScrollPane(lobbyTable);
		if(lobbyData.length<=12){
			lobbyScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, (lobbyTable.getRowCount()+1)*lobbyTable.getRowHeight());
		}else{
			lobbyScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, 13*lobbyTable.getRowHeight());
		}
		
		lobbyTable.setModel(new DefaultTableModel(lobbyData,lobbyTitle){//设置第四行不可被编辑
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row,int column){  
				if(column == 4){  
				     return false;  
				}else{  
				      return true;  
				}  
			}  
		});
		
		lobbyTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(lobbyTable.getSelectedColumn()==2&&lobbyTable.getValueAt(lobbyTable.getSelectedRow(),2).equals("批准")){
					lobbyTable.setValueAt("",lobbyTable.getSelectedRow(),2);
				}else if(lobbyTable.getSelectedColumn()==2&&!lobbyTable.getValueAt(lobbyTable.getSelectedRow(),2).equals("批准")){
					lobbyTable.setValueAt("批准",lobbyTable.getSelectedRow(),2);
				}
				lobbyTable.repaint();
				
				if(lobbyTable.getSelectedColumn()==3){
					//"接收单","入款单","装运单"
					int x=lobbyTable.getSelectedRow();
					String codes[]=memory.getLobbyCode().split(" ");
					String selectCode="0 "+codes[x+1];
					HtmlMultiLineControl hmlc = new HtmlMultiLineControl();
					String content=null;
					switch((String)lobbyTable.getValueAt(x,1)){
					case "接收单":
						ReceiveBLService service=ConstructFactory.ReceiveFactory();
						LobbyReceptionVO vo0=service.inquireLobbyReceive(selectCode).get(0);
						content="接收日期: "+vo0.getReceiveYear()+"/"+vo0.getReceiveMonth()+"/"+vo0.getReceiveDay()+"<br>"
							   +"货物到达状态: "+vo0.getCondition()+"<br>"
							   +"订单号: "+vo0.getExpressBar()+"<br>"
							   +"营业厅单号："+vo0.getBelong();
						break;
					case "入款单":
						@SuppressWarnings("unused")
						FinanceBLService service1=ConstructFactory.FinanceFactory();
						
						break;
					case "装运单":
						LoadBLService service2=ConstructFactory.LoadFactory();
						LobbyLoading vo2=service2.inquireLoadVehicle(selectCode).get(0);
						content="装车日期："+vo2.getLoadingDate()+"<br>"
							   +"营业厅汽运编号："+vo2.getAutoMobileNum()+"<br>"
							   +"出发地: "+vo2.getDeparture()+"<br>"
							   +"到达地："+vo2.getDestination()+"<br>"
							   +"监装员："+vo2.getMonitor()+"<br>"
							   +"押运员："+vo2.getGuard()+"<br>"
							   +"运费："+vo2.getBelong();
						break;
					}
					content=hmlc.CovertDestionString(content);
					lobbyTable.setToolTipText(content);
				}
			}
		});

		lobbyChooseAll = new JButton("全选");
		lobbyChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < lobbyData.length; i++) {
					lobbyTable.setValueAt("批准",i,2);
					lobbyTable.repaint();
				}
			}
		});
		lobbyCheck = new JButton("批准");
		lobbyCheck.setBounds(tabWidth*3/4, 13*lobbyTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		lobbyChooseAll.setBounds(tabWidth*11/20, 13*lobbyTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		lobbyCheck.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String codes=memory.getLobbyCode();
				String[] list=codes.split(" ");
				for(int x=0;x<lobbyTable.getRowCount();x++){
					if(((String)lobbyTable.getValueAt(x,2)).equals("批准")){
						codes=codes.replace(" "+list[x+1],"");
					}
				}
				memory.setLobbyCode(codes);
				approve();
				refreshLobbyReceipt();
			}
		});
		lobbyPanel.add(lobbyChooseAll);
		lobbyPanel.add(lobbyCheck);
		lobbyPanel.add(lobbyScrollPane);
	}
	//中转中心业务员的单据
	
	public void initIntermReceipt(){
		String codes[]=memory.getIntermediateCode().split(" ");
		intermeData=new String[codes.length-1][4];
		for(int x=1;x<codes.length-1;x++){
			intermeData[x-1][0]=codes[x].substring(0, 9);
			intermeData[x-1][1]=this.intermKinds[codes[x].charAt(9)-'1'];
			intermeData[x-1][2]="";
			intermeData[x-1][3]="";
		}
	}
	
	public void refreshIntermeReceipt(){
		this.initIntermReceipt();
		DefaultTableModel model=(DefaultTableModel) intermeTable.getModel();
		model.setDataVector(intermeData, intermeTitle);
	}
	
	public void IntermeOrder(){
		intermeTitle = new String[]{"职工账号", "单据类型", "选择", "查看单据"};
		this.initIntermReceipt();
		intermeTable = new JTable(intermeData,intermeTitle);
		intermeTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		intermeTable.setRowHeight(tabWidth/20);//设置列宽
		intermeTable.setDragEnabled(false);//设置不可拖动
		intermeTable.getTableHeader().setPreferredSize(new Dimension(10000, tabWidth/20));//设置表头高度
		intermeTable.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		intermeScrollPane = new JScrollPane(intermeTable);
		if(intermeData.length<=12){
			intermeScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, (intermeTable.getRowCount()+1)*intermeTable.getRowHeight());
		}else{
			intermeScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, 13*intermeTable.getRowHeight());
		}
		
		intermeTable.setModel(new DefaultTableModel(intermeData,intermeTitle){//设置第四行不可被编辑
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row,int column){  
				if(column == 4){  
				     return false;  
				}else{  
				      return true;  
				}  
			}  
		});
		
		intermeTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(intermeTable.getSelectedColumn()==2&&intermeTable.getValueAt(intermeTable.getSelectedRow(),2).equals("批准")){
					intermeTable.setValueAt("",intermeTable.getSelectedRow(),2);
				}else if(intermeTable.getSelectedColumn()==2&&!intermeTable.getValueAt(intermeTable.getSelectedRow(),2).equals("批准")){
					intermeTable.setValueAt("批准",intermeTable.getSelectedRow(),2);
				}
				intermeTable.repaint();
				if(intermeTable.getSelectedColumn()==3){
					int x=intermeTable.getSelectedRow();
					String codes[]=memory.getIntermediateCode().split(" ");
					System.out.println(codes[x+1]);
					String selectCode="0 "+codes[x+1];
					System.out.println(selectCode);
					HtmlMultiLineControl hmlc = new HtmlMultiLineControl();
					//"中转接收单","飞机装运单","火车装运单","汽车装运单"
					switch((String)intermeTable.getValueAt(x,1)){
					case "中转接收单":
						System.out.println("中转接收单");
						ReceiveBLService service0=ConstructFactory.ReceiveFactory();
						TransitReceptionVO vo0=service0.inquireTransitReception(selectCode).get(0);
						String content0="接收日期："+vo0.getReceiveYear()+"/"
								+vo0.getReceiveMonth()+"/"+vo0.getReceiveDay()+"<br>"+
								"中转中心编号："+vo0.getCenterNumber()+"<br>"+
								"订单号："+vo0.getBar();
						content0=hmlc.CovertDestionString(content0);
						intermeTable.setToolTipText(content0);
						break;
					case "飞机装运单":
						System.out.println("飞机装运单");
						LoadBLService service1=ConstructFactory.LoadFactory();
						PlaneLoadingVO vo1=service1.inquireLoadPlane(selectCode).get(0);
						String content="装运日期："+vo1.getLoadingDate()+"<br>"
						              +"航运编号："+vo1.getCarTourNum()+"<br>"
						              +"航班号："+vo1.getCarNum()+"<br>"
						              +"出发地："+vo1.getDeparture()+"<br>"
						              +"到达地："+vo1.getDestination()+"<br>"
						              +"监装员："+vo1.getMonitor()+"<br>"
						              +"押运员："+vo1.getStore()+"<br>"
						              ;
						content=hmlc.CovertDestionString(content);
						intermeTable.setToolTipText(content);
						break;
					case "火车装运单":
						System.out.println("火车装运单");
						LoadBLService service2=ConstructFactory.LoadFactory();
						TrainLoadingVO vo2=service2.inquireLoadTrain(selectCode).get(0);
						String content1="装运日期："+vo2.getLoadingDate()+"<br>"
								       +"铁运编号："+vo2.getCarTourNum()+"<br>"
								       +"火车车次号："+vo2.getCarNum()+"<br>"
							           +"出发地："+vo2.getDeparture()+"<br>"
							           +"到达地："+vo2.getDestination()+"<br>"
							           +"监装员: "+vo2.getMonitor()+"<br>"
							           +"押运员: "+vo2.getGuard()+"<br>"
							           ;
						content1=hmlc.CovertDestionString(content1);
						intermeTable.setToolTipText(content1);
						break;
					case "汽车装运单":
						System.out.println("汽车装运单");
						LoadBLService service3=ConstructFactory.LoadFactory();
						VehicleLoadingVO vo3=service3.inquireLoadCar(selectCode).get(0);
						String content2="装运日期："+vo3.getLoadingDate()+"<br>"
								       +"汽运编号："+vo3.getCarTourNum()+"<br>"
								       +"车次号："+vo3.getCarNum()+"<br>"
								       +"出发地: "+vo3.getDeparture()+"<br>"
								       +"到达地："+vo3.getCarTourNum()+"<br>"
								       +"监装员："+vo3.getMonitor()+"<br>"
								       +"押运员："+vo3.getGuard()+"<br>"
								       ;
						content2=hmlc.CovertDestionString(content2);
						intermeTable.setToolTipText(content2);
						break;
					}
				}
			}
		});

		intermeChooseAll = new JButton("全选");
		intermeChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < intermeData.length; i++) {
					intermeTable.setValueAt("批准",i,2);
					intermeTable.repaint();
				}
			}
		});
		
		intermeCheck = new JButton("批准");
		intermeCheck.setBounds(tabWidth*3/4, 13*intermeTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		intermeChooseAll.setBounds(tabWidth*11/20, 13*intermeTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		intermeCheck.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String code=memory.getIntermediateCode();
				String[] list=code.split(" ");
				for(int x=0;x<intermeTable.getRowCount();x++){
					if(((String)intermeTable.getValueAt(x,2)).equals("批准")){
						code=code.replace(" "+list[x+1],"");
					}
				}
				memory.setIntermediateCode(code);
				approve();
				 refreshIntermeReceipt();
			}
		});
		intermePanel.add(intermeChooseAll);
		intermePanel.add(intermeCheck);
		intermePanel.add(intermeScrollPane);
	}
	
	public void initWarehouseReceipt(){
		String codes[]=memory.getWarehouseCode().split(" ");
		warehouseData=new String[codes.length-1][4];
		for(int x=1;x<codes.length;x++){
			warehouseData[x-1][0]=codes[x].substring(0,9);
			warehouseData[x-1][1]=this.warehouseKinds[codes[x].charAt(9)-'1'];
			warehouseData[x-1][2]="";
			warehouseData[x-1][3]="";
		}
	}
	
	public void refreshWarehouseReceipt(){
		initWarehouseReceipt();
		DefaultTableModel model=(DefaultTableModel) warehouseTable.getModel();
		model.setDataVector(warehouseData, warehouseTitle);
	}
	//仓库管理人员的单据
	public void warehouseOrder(){
		warehouseTitle = new String[]{"职工账号", "单据类型", "选择", "查看单据"};
		this.initWarehouseReceipt();
		warehouseTable = new JTable(warehouseData,warehouseTitle);
		warehouseTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		warehouseTable.setRowHeight(tabWidth/20);//设置列宽
		warehouseTable.setDragEnabled(false);//设置不可拖动
		warehouseTable.getTableHeader().setPreferredSize(new Dimension(10000, tabWidth/20));//设置表头高度
		warehouseTable.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		warehouseScrollPane = new JScrollPane(warehouseTable);
		if(warehouseData.length<=12){
			warehouseScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, (warehouseTable.getRowCount()+1)*warehouseTable.getRowHeight());
		}else{
			warehouseScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, 13*warehouseTable.getRowHeight());
		}
		warehouseTable.setModel(new DefaultTableModel(warehouseData,warehouseTitle){//设置第四行不可被编辑
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row,int column){  
				if(column == 4){  
				     return false;  
				}else{  
				      return true;  
				}  
			}  
			
		});
		
		warehouseTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				if(warehouseTable.getSelectedColumn()==2&&warehouseTable.getValueAt(warehouseTable.getSelectedRow(),2).equals("批准")){
//					warehouseTable.setValueAt("",warehouseTable.getSelectedRow(),2);
//				}else if(warehouseTable.getSelectedColumn()==2&&!warehouseTable.getValueAt(warehouseTable.getSelectedRow(),2).equals("批准")){
//					warehouseTable.setValueAt("批准",warehouseTable.getSelectedRow(),2);
//				}
				
				if(warehouseTable.getSelectedColumn()==3){
					int x=warehouseTable.getSelectedRow();
					String codes[]=memory.getWarehouseCode().split(" ");
					String selectCode=codes[x+1];
					System.out.println(selectCode);
					switch((String)warehouseTable.getValueAt(x,1)){
					case "入库单":
						System.out.println("入库单");
						WarehouseBLService service=ConstructFactory.WarehouseFactory();
						WarehouseInVO vo=service.showWarehouseInInfo(selectCode).get(0);
						String content="订单号："+vo.getBar()+"<br>"
								      +"入库单编号： "+vo.getCode()+"<br>" 
								      +"目的地： "+vo.getDestination()+"<br>" 
								      +"入库日期： "+vo.getInDate()+"<br>" 
								      +"区号： "+vo.getArea()+"<br>" 
								      +"排号： "+vo.getRow()+"<br>" 
								      +"架号： "+vo.getShelf()+"<br>" 
								      +"位号： "+vo.getPosition()+"<br>" 
								      +"损坏情况： "+vo.getDamageCondition()+"<br>" 
								   ;
						HtmlMultiLineControl hmlc = new HtmlMultiLineControl();
						content= hmlc.CovertDestionString(content);
						warehouseTable.setToolTipText(content);
						break;
					case "出库单":
						System.out.println("出库单");
						WarehouseBLService service1=ConstructFactory.WarehouseFactory();
						WarehouseOutVO vo1=service1.showWarehouseOutInfo("0 "+selectCode).get(0);
						String str="订单号："+vo1.getBar()+"<br>"
								  +"目的地："+vo1.getDestination()+"<br>"
								  +"装运形式："+vo1.getTransType().name()+"<br>"
								  +"出库日期："+vo1.getOutDate()+"<br>"
								  +"中转中心编号："+vo1.getTransferCode()+"<br>"
								  +"运输工具编号："+vo1.getVehicleCode()+"<br>"
								  +"损坏情况："+vo1.getDamageCondition()+"<br>"
								  +"出库区号："+vo1.getArea()+"<br>"
								  +"排号："+vo1.getRow()+"<br>"
								  +"架号："+vo1.getShelf()+"<br>"
								  +"位号: "+vo1.getPosition();
						HtmlMultiLineControl hmlc1 = new HtmlMultiLineControl();
						str= hmlc1.CovertDestionString(str);
						warehouseTable.setToolTipText(str);		  
						break;
					}
				}
			}
			
		});

		warehouseChooseAll = new JButton("全选");
		warehouseChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < warehouseData.length; i++) {
					warehouseTable.setValueAt("批准",i,2);
					warehouseTable.repaint();
				}
			}
		});
		
		
		warehouseCheck = new JButton("批准");
		warehouseCheck.setBounds(tabWidth*3/4, 13*warehouseTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		warehouseChooseAll.setBounds(tabWidth*11/20, 13*warehouseTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		warehouseCheck.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String codes=memory.getWarehouseCode();
				String[] list=codes.split(" ");
				for(int x=0;x<warehouseTable.getRowCount();x++){
					if(((String)warehouseTable.getValueAt(x, 2)).equals("批准")){
						codes=codes.replace(" "+list[x+1],"");
					}
				}
				memory.setWarehouseCode(codes);
				approve();
				refreshWarehouseReceipt();
			}
		});
		
		warehousePanel.add(warehouseChooseAll);
		warehousePanel.add(warehouseCheck);
		warehousePanel.add(warehouseScrollPane);
	}
}
