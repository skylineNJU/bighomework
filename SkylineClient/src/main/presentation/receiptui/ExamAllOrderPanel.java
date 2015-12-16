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
	
	//���Ա���
	private JTable courierTable;
	private JScrollPane courierScrollPane;
	private String[] courierTitle;
	private String[][] courierData;
	private JButton courierChooseAll;
	private JButton courierCheck;
	//Ӫҵ��ҵ��Ա���
	private JTable lobbyTable;
	private JScrollPane lobbyScrollPane;
	private String[] lobbyTitle;
	private String[][] lobbyData;
	private JButton lobbyChooseAll;
	private JButton lobbyCheck;
	//��ת����ҵ��Ա���
	private JTable intermeTable;
	private JScrollPane intermeScrollPane;
	private String[] intermeTitle;
	private String[][] intermeData;
	private JButton intermeChooseAll;
	private JButton intermeCheck;
	//��ת�ֿ����
	private JTable warehouseTable;
	private JScrollPane warehouseScrollPane;
	private String[] warehouseTitle;
	private String[][] warehouseData;
	private JButton warehouseChooseAll;
	private JButton warehouseCheck;
	private ReceiptRecordMemory memory;
	private String[] courrierKinds={"����","�ռ���"};
	private String[] lobbyKinds={"���յ�","��","װ�˵�"};
	private String[] intermKinds={"��ת���յ�","�ɻ�װ�˵�","��װ�˵�","����װ�˵�"};
	private String[] warehouseKinds={"��ⵥ","���ⵥ"};
	
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
		tab.addTab("���Ա", courierPanel);
		tab.addTab("Ӫҵ��ҵ��Ա", lobbyPanel);
		tab.addTab("��ת����ҵ��Ա", intermePanel);
		tab.addTab("�ֿ������Ա", warehousePanel);
		
		courierOrder();
		lobbyOrder();
		IntermeOrder();
		warehouseOrder();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("��������");
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
	//���Ա�ĵ���
	public void courierOrder(){
		courierTitle = new String[]{"ְ���˺�","��������","ѡ��","�鿴����"};
		this.initCourierReceipt();
		courierTable = new JTable(courierData,courierTitle);
		courierTable .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		courierTable.setRowHeight(tabWidth/20);//�����п�
		courierTable.setDragEnabled(false);//���ò����϶�
		courierTable.getTableHeader().setPreferredSize(new Dimension(10000, tabWidth/20));//���ñ�ͷ�߶�
		courierTable.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		courierScrollPane = new JScrollPane(courierTable);
		if(courierData.length<=12){
			courierScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, (courierTable.getRowCount()+1)*courierTable.getRowHeight());
		}else{
			courierScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, 13*courierTable.getRowHeight());
		}
		courierTable.setModel(new DefaultTableModel(courierData,courierTitle){//���õ����в��ɱ��༭
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
				if(courierTable.getSelectedColumn()==2&&courierTable.getValueAt(courierTable.getSelectedRow(),2).equals("��׼")){
					courierTable.setValueAt("",courierTable.getSelectedRow(),2);
				}else if(courierTable.getSelectedColumn()==2&&!courierTable.getValueAt(courierTable.getSelectedRow(),2).equals("��׼")){
					courierTable.setValueAt("��׼",courierTable.getSelectedRow(),2);
				}
				courierTable.repaint();
				
				if(courierTable.getSelectedColumn()==3){
					int x=courierTable.getSelectedRow();
					HtmlMultiLineControl hmlc = new HtmlMultiLineControl();
					String content=null;
					String codes[]=memory.getCourrierCode().split(" ");
					String selectCode="0 "+codes[x+1];
					//"����","�ռ���"
					switch((String)courierTable.getValueAt(x,1)){
					case "����":
						ReceiveBLService service0=ConstructFactory.ReceiveFactory();
						OrderVO vo1=service0.inquireOrderReceive(selectCode).get(0);
						content="�ļ���������"+vo1.getSenderName()+"<br>"
							   +"�ļ��˵�ַ��"+vo1.getSenderAddress()+"<br>"
							   +"�ļ��˵�λ��"+vo1.getReceiverCom()+"<br>"
							   +"�ļ��˵绰��"+vo1.getSenderMobile()+"<br>"
							   +"�ռ���������"+vo1.getReceiverName()+"<br>"
							   +"�ռ��˵�ַ��"+vo1.getReceiverAddress()+"<br>"
							   +"�ռ��˵�λ��"+vo1.getReceiverCom()+"<br>"
							   +"�ռ��˵绰��"+vo1.getSenderMobile()+"<br>";
					}
					content=hmlc.CovertDestionString(content);
					courierTable.setToolTipText(content);
				}
				
				
			}
		});

		courierChooseAll = new JButton("ȫѡ");
		courierChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < courierData.length; i++) {
					courierTable.setValueAt("��׼",i,2);
					courierTable.repaint();
				}
			}
		});
		
		
		courierCheck = new JButton("��׼");
		courierCheck.setBounds(tabWidth*3/4, 13*courierTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		courierChooseAll.setBounds(tabWidth*11/20, 13*courierTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		courierCheck.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String codes=memory.getCourrierCode();
				String list[]=codes.split(" ");
				for(int x=0;x<courierTable.getRowCount();x++){
					if(((String)courierTable.getValueAt(x,2)).equals("��׼")){
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
	//Ӫҵ��ҵ��Ա�ĵ���
	public void lobbyOrder(){
		lobbyTitle = new String[]{"ְ���˺�","��������","ѡ��", "�鿴����"};
		this.initLobbyReceipt();
		lobbyTable = new JTable(lobbyData,lobbyTitle);
		lobbyTable .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		lobbyTable.setRowHeight(tabWidth/20);//�����п�
		lobbyTable.setDragEnabled(false);//���ò����϶�
		lobbyTable.getTableHeader().setPreferredSize(new Dimension(10000, tabWidth/20));//���ñ�ͷ�߶�
		lobbyTable.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		lobbyScrollPane = new JScrollPane(lobbyTable);
		if(lobbyData.length<=12){
			lobbyScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, (lobbyTable.getRowCount()+1)*lobbyTable.getRowHeight());
		}else{
			lobbyScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, 13*lobbyTable.getRowHeight());
		}
		
		lobbyTable.setModel(new DefaultTableModel(lobbyData,lobbyTitle){//���õ����в��ɱ��༭
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
				if(lobbyTable.getSelectedColumn()==2&&lobbyTable.getValueAt(lobbyTable.getSelectedRow(),2).equals("��׼")){
					lobbyTable.setValueAt("",lobbyTable.getSelectedRow(),2);
				}else if(lobbyTable.getSelectedColumn()==2&&!lobbyTable.getValueAt(lobbyTable.getSelectedRow(),2).equals("��׼")){
					lobbyTable.setValueAt("��׼",lobbyTable.getSelectedRow(),2);
				}
				lobbyTable.repaint();
				
				if(lobbyTable.getSelectedColumn()==3){
					//"���յ�","��","װ�˵�"
					int x=lobbyTable.getSelectedRow();
					String codes[]=memory.getLobbyCode().split(" ");
					String selectCode="0 "+codes[x+1];
					HtmlMultiLineControl hmlc = new HtmlMultiLineControl();
					String content=null;
					switch((String)lobbyTable.getValueAt(x,1)){
					case "���յ�":
						ReceiveBLService service=ConstructFactory.ReceiveFactory();
						LobbyReceptionVO vo0=service.inquireLobbyReceive(selectCode).get(0);
						content="��������: "+vo0.getReceiveYear()+"/"+vo0.getReceiveMonth()+"/"+vo0.getReceiveDay()+"<br>"
							   +"���ﵽ��״̬: "+vo0.getCondition()+"<br>"
							   +"������: "+vo0.getExpressBar()+"<br>"
							   +"Ӫҵ�����ţ�"+vo0.getBelong();
						break;
					case "��":
						@SuppressWarnings("unused")
						FinanceBLService service1=ConstructFactory.FinanceFactory();
						
						break;
					case "װ�˵�":
						LoadBLService service2=ConstructFactory.LoadFactory();
						LobbyLoading vo2=service2.inquireLoadVehicle(selectCode).get(0);
						content="װ�����ڣ�"+vo2.getLoadingDate()+"<br>"
							   +"Ӫҵ�����˱�ţ�"+vo2.getAutoMobileNum()+"<br>"
							   +"������: "+vo2.getDeparture()+"<br>"
							   +"����أ�"+vo2.getDestination()+"<br>"
							   +"��װԱ��"+vo2.getMonitor()+"<br>"
							   +"Ѻ��Ա��"+vo2.getGuard()+"<br>"
							   +"�˷ѣ�"+vo2.getBelong();
						break;
					}
					content=hmlc.CovertDestionString(content);
					lobbyTable.setToolTipText(content);
				}
			}
		});

		lobbyChooseAll = new JButton("ȫѡ");
		lobbyChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < lobbyData.length; i++) {
					lobbyTable.setValueAt("��׼",i,2);
					lobbyTable.repaint();
				}
			}
		});
		lobbyCheck = new JButton("��׼");
		lobbyCheck.setBounds(tabWidth*3/4, 13*lobbyTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		lobbyChooseAll.setBounds(tabWidth*11/20, 13*lobbyTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		lobbyCheck.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String codes=memory.getLobbyCode();
				String[] list=codes.split(" ");
				for(int x=0;x<lobbyTable.getRowCount();x++){
					if(((String)lobbyTable.getValueAt(x,2)).equals("��׼")){
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
	//��ת����ҵ��Ա�ĵ���
	
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
		intermeTitle = new String[]{"ְ���˺�", "��������", "ѡ��", "�鿴����"};
		this.initIntermReceipt();
		intermeTable = new JTable(intermeData,intermeTitle);
		intermeTable .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		intermeTable.setRowHeight(tabWidth/20);//�����п�
		intermeTable.setDragEnabled(false);//���ò����϶�
		intermeTable.getTableHeader().setPreferredSize(new Dimension(10000, tabWidth/20));//���ñ�ͷ�߶�
		intermeTable.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		intermeScrollPane = new JScrollPane(intermeTable);
		if(intermeData.length<=12){
			intermeScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, (intermeTable.getRowCount()+1)*intermeTable.getRowHeight());
		}else{
			intermeScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, 13*intermeTable.getRowHeight());
		}
		
		intermeTable.setModel(new DefaultTableModel(intermeData,intermeTitle){//���õ����в��ɱ��༭
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
				if(intermeTable.getSelectedColumn()==2&&intermeTable.getValueAt(intermeTable.getSelectedRow(),2).equals("��׼")){
					intermeTable.setValueAt("",intermeTable.getSelectedRow(),2);
				}else if(intermeTable.getSelectedColumn()==2&&!intermeTable.getValueAt(intermeTable.getSelectedRow(),2).equals("��׼")){
					intermeTable.setValueAt("��׼",intermeTable.getSelectedRow(),2);
				}
				intermeTable.repaint();
				if(intermeTable.getSelectedColumn()==3){
					int x=intermeTable.getSelectedRow();
					String codes[]=memory.getIntermediateCode().split(" ");
					System.out.println(codes[x+1]);
					String selectCode="0 "+codes[x+1];
					System.out.println(selectCode);
					HtmlMultiLineControl hmlc = new HtmlMultiLineControl();
					//"��ת���յ�","�ɻ�װ�˵�","��װ�˵�","����װ�˵�"
					switch((String)intermeTable.getValueAt(x,1)){
					case "��ת���յ�":
						System.out.println("��ת���յ�");
						ReceiveBLService service0=ConstructFactory.ReceiveFactory();
						TransitReceptionVO vo0=service0.inquireTransitReception(selectCode).get(0);
						String content0="�������ڣ�"+vo0.getReceiveYear()+"/"
								+vo0.getReceiveMonth()+"/"+vo0.getReceiveDay()+"<br>"+
								"��ת���ı�ţ�"+vo0.getCenterNumber()+"<br>"+
								"�����ţ�"+vo0.getBar();
						content0=hmlc.CovertDestionString(content0);
						intermeTable.setToolTipText(content0);
						break;
					case "�ɻ�װ�˵�":
						System.out.println("�ɻ�װ�˵�");
						LoadBLService service1=ConstructFactory.LoadFactory();
						PlaneLoadingVO vo1=service1.inquireLoadPlane(selectCode).get(0);
						String content="װ�����ڣ�"+vo1.getLoadingDate()+"<br>"
						              +"���˱�ţ�"+vo1.getCarTourNum()+"<br>"
						              +"����ţ�"+vo1.getCarNum()+"<br>"
						              +"�����أ�"+vo1.getDeparture()+"<br>"
						              +"����أ�"+vo1.getDestination()+"<br>"
						              +"��װԱ��"+vo1.getMonitor()+"<br>"
						              +"Ѻ��Ա��"+vo1.getStore()+"<br>"
						              ;
						content=hmlc.CovertDestionString(content);
						intermeTable.setToolTipText(content);
						break;
					case "��װ�˵�":
						System.out.println("��װ�˵�");
						LoadBLService service2=ConstructFactory.LoadFactory();
						TrainLoadingVO vo2=service2.inquireLoadTrain(selectCode).get(0);
						String content1="װ�����ڣ�"+vo2.getLoadingDate()+"<br>"
								       +"���˱�ţ�"+vo2.getCarTourNum()+"<br>"
								       +"�𳵳��κţ�"+vo2.getCarNum()+"<br>"
							           +"�����أ�"+vo2.getDeparture()+"<br>"
							           +"����أ�"+vo2.getDestination()+"<br>"
							           +"��װԱ: "+vo2.getMonitor()+"<br>"
							           +"Ѻ��Ա: "+vo2.getGuard()+"<br>"
							           ;
						content1=hmlc.CovertDestionString(content1);
						intermeTable.setToolTipText(content1);
						break;
					case "����װ�˵�":
						System.out.println("����װ�˵�");
						LoadBLService service3=ConstructFactory.LoadFactory();
						VehicleLoadingVO vo3=service3.inquireLoadCar(selectCode).get(0);
						String content2="װ�����ڣ�"+vo3.getLoadingDate()+"<br>"
								       +"���˱�ţ�"+vo3.getCarTourNum()+"<br>"
								       +"���κţ�"+vo3.getCarNum()+"<br>"
								       +"������: "+vo3.getDeparture()+"<br>"
								       +"����أ�"+vo3.getCarTourNum()+"<br>"
								       +"��װԱ��"+vo3.getMonitor()+"<br>"
								       +"Ѻ��Ա��"+vo3.getGuard()+"<br>"
								       ;
						content2=hmlc.CovertDestionString(content2);
						intermeTable.setToolTipText(content2);
						break;
					}
				}
			}
		});

		intermeChooseAll = new JButton("ȫѡ");
		intermeChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < intermeData.length; i++) {
					intermeTable.setValueAt("��׼",i,2);
					intermeTable.repaint();
				}
			}
		});
		
		intermeCheck = new JButton("��׼");
		intermeCheck.setBounds(tabWidth*3/4, 13*intermeTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		intermeChooseAll.setBounds(tabWidth*11/20, 13*intermeTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		intermeCheck.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String code=memory.getIntermediateCode();
				String[] list=code.split(" ");
				for(int x=0;x<intermeTable.getRowCount();x++){
					if(((String)intermeTable.getValueAt(x,2)).equals("��׼")){
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
	//�ֿ������Ա�ĵ���
	public void warehouseOrder(){
		warehouseTitle = new String[]{"ְ���˺�", "��������", "ѡ��", "�鿴����"};
		this.initWarehouseReceipt();
		warehouseTable = new JTable(warehouseData,warehouseTitle);
		warehouseTable .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		warehouseTable.setRowHeight(tabWidth/20);//�����п�
		warehouseTable.setDragEnabled(false);//���ò����϶�
		warehouseTable.getTableHeader().setPreferredSize(new Dimension(10000, tabWidth/20));//���ñ�ͷ�߶�
		warehouseTable.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		warehouseScrollPane = new JScrollPane(warehouseTable);
		if(warehouseData.length<=12){
			warehouseScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, (warehouseTable.getRowCount()+1)*warehouseTable.getRowHeight());
		}else{
			warehouseScrollPane.setBounds(tabWidth/12, tabHeight/24, tabWidth/6*5, 13*warehouseTable.getRowHeight());
		}
		warehouseTable.setModel(new DefaultTableModel(warehouseData,warehouseTitle){//���õ����в��ɱ��༭
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
//				if(warehouseTable.getSelectedColumn()==2&&warehouseTable.getValueAt(warehouseTable.getSelectedRow(),2).equals("��׼")){
//					warehouseTable.setValueAt("",warehouseTable.getSelectedRow(),2);
//				}else if(warehouseTable.getSelectedColumn()==2&&!warehouseTable.getValueAt(warehouseTable.getSelectedRow(),2).equals("��׼")){
//					warehouseTable.setValueAt("��׼",warehouseTable.getSelectedRow(),2);
//				}
				
				if(warehouseTable.getSelectedColumn()==3){
					int x=warehouseTable.getSelectedRow();
					String codes[]=memory.getWarehouseCode().split(" ");
					String selectCode=codes[x+1];
					System.out.println(selectCode);
					switch((String)warehouseTable.getValueAt(x,1)){
					case "��ⵥ":
						System.out.println("��ⵥ");
						WarehouseBLService service=ConstructFactory.WarehouseFactory();
						WarehouseInVO vo=service.showWarehouseInInfo(selectCode).get(0);
						String content="�����ţ�"+vo.getBar()+"<br>"
								      +"��ⵥ��ţ� "+vo.getCode()+"<br>" 
								      +"Ŀ�ĵأ� "+vo.getDestination()+"<br>" 
								      +"������ڣ� "+vo.getInDate()+"<br>" 
								      +"���ţ� "+vo.getArea()+"<br>" 
								      +"�źţ� "+vo.getRow()+"<br>" 
								      +"�ܺţ� "+vo.getShelf()+"<br>" 
								      +"λ�ţ� "+vo.getPosition()+"<br>" 
								      +"������� "+vo.getDamageCondition()+"<br>" 
								   ;
						HtmlMultiLineControl hmlc = new HtmlMultiLineControl();
						content= hmlc.CovertDestionString(content);
						warehouseTable.setToolTipText(content);
						break;
					case "���ⵥ":
						System.out.println("���ⵥ");
						WarehouseBLService service1=ConstructFactory.WarehouseFactory();
						WarehouseOutVO vo1=service1.showWarehouseOutInfo("0 "+selectCode).get(0);
						String str="�����ţ�"+vo1.getBar()+"<br>"
								  +"Ŀ�ĵأ�"+vo1.getDestination()+"<br>"
								  +"װ����ʽ��"+vo1.getTransType().name()+"<br>"
								  +"�������ڣ�"+vo1.getOutDate()+"<br>"
								  +"��ת���ı�ţ�"+vo1.getTransferCode()+"<br>"
								  +"���乤�߱�ţ�"+vo1.getVehicleCode()+"<br>"
								  +"�������"+vo1.getDamageCondition()+"<br>"
								  +"�������ţ�"+vo1.getArea()+"<br>"
								  +"�źţ�"+vo1.getRow()+"<br>"
								  +"�ܺţ�"+vo1.getShelf()+"<br>"
								  +"λ��: "+vo1.getPosition();
						HtmlMultiLineControl hmlc1 = new HtmlMultiLineControl();
						str= hmlc1.CovertDestionString(str);
						warehouseTable.setToolTipText(str);		  
						break;
					}
				}
			}
			
		});

		warehouseChooseAll = new JButton("ȫѡ");
		warehouseChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < warehouseData.length; i++) {
					warehouseTable.setValueAt("��׼",i,2);
					warehouseTable.repaint();
				}
			}
		});
		
		
		warehouseCheck = new JButton("��׼");
		warehouseCheck.setBounds(tabWidth*3/4, 13*warehouseTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		warehouseChooseAll.setBounds(tabWidth*11/20, 13*warehouseTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		warehouseCheck.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String codes=memory.getWarehouseCode();
				String[] list=codes.split(" ");
				for(int x=0;x<warehouseTable.getRowCount();x++){
					if(((String)warehouseTable.getValueAt(x, 2)).equals("��׼")){
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
