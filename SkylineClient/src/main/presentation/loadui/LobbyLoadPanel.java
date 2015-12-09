package main.presentation.loadui;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.businesslogicservice.LoadBLService;
import main.businesslogicservice.receiptblService.LobbyReceipt;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.LobbyMemory;
import main.vo.LobbyLoading;

//Ӫҵ��װ������
public class LobbyLoadPanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	//��ť���
	private JButton cancleButton;
	private JButton saveButton;
	private JButton lookCancleButton;
	private JButton lookSaveButton;
	private JButton ensureButton;
	//lookPanel�ϵ����
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel dataLabel;
	private int year;//��ǰ��
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;
	//writePanel�ϵ����
	private JLabel loadData;//װ������
	private JLabel loadYear;//װ����
	private JLabel loadMonth;//װ����
	private JLabel loadDay;//װ����
	private JLabel loadCode;//���˱��
	private JLabel startPlace;//������
	private JLabel endPlace;//�����
	private JLabel supervisor;//��װԱ
	private JLabel supercargo;//Ѻ��Ա
	private JLabel loadOrder;//���˵���
	private JLabel loadFee;//�˷�
	private JTextField loadDataText;
	private JComboBox<String> yearBox;
	private JComboBox<String> monthBox;
	private JComboBox<String> dayBox;
	private JTextField loadCodeText;
	private JTextField startPlaceText;
	private JTextField endPlaceText;
	private JTextField supervisorText;
	private JTextField supercargoText;
	private JTextField loadOrderText;
	private JTextField loadFeeText;
	
	private JLabel title;
	private JPanel lookPanel;//�鿴װ�˵�
	private JPanel writePanel;//��дװ�˵�
	private JTabbedPane tab;
	public LobbyLoadPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();//��ʼ������
		lookPanel = new JPanel();
		lookPanel.setLayout(null);
		writePanel = new JPanel();
		writePanel.setLayout(null);
		
		lookTabel();//��ʼ���鿴װ�˵����
		writeTabel();//��ʼ����дװ�˵����
		initButton();//��ʼ����ť
		
		tab = new JTabbedPane();
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.add("�鿴װ����Ϣ",lookPanel);
		tab.add("����װ����Ϣ",writePanel);
		panel.add(tab);
		tab.setBounds(panelWidth/15, panelHeight/15, panelWidth*13/15, panelHeight*13/15);
		tab.setVisible(true);
		panel.repaint();
		tab.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(tab.getSelectedIndex()==0){
					tableData=initTableData();
					for(int x=0;x<tableData.length;x++)
						for(int y=0;y<8;y++)
							table.setValueAt(tableData[x][y],x,y);
				}
			}
			
		});
	}
	
	public void title(){
		title = new JLabel("װ�˹���");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	
	public void initButton(){
		cancleButton = new JButton("ȡ��");
		saveButton = new JButton("����");
		cancleButton.setBounds(panelWidth*2/5, panelHeight*7/10, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*6/10,  panelHeight*7/10, panelWidth/10, panelHeight/20);
		writePanel.add(cancleButton);
		writePanel.add(saveButton);
		lookCancleButton = new JButton("ȡ��");
		lookSaveButton = new JButton("����");
		lookCancleButton.setBounds(panelWidth/2, panelHeight*3/4, panelWidth/10, panelHeight/20);
		lookSaveButton.setBounds(panelWidth*7/10,  panelHeight*3/4, panelWidth/10, panelHeight/20);
		lookPanel.add(lookCancleButton);
		lookPanel.add(lookSaveButton);
		ensureButton = new JButton("ȷ��");
		lookPanel.add(ensureButton);
		ensureButton.setBounds(panel.getWidth()*29/40, panelHeight/30, panelWidth/10, panelHeight/20);
		
		saveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LoadBLService service=ConstructFactory.LoadFactory();
				String code=null;
				LobbyMemory memory=(LobbyMemory) ((WritePanel)panel).getMemory();
				String codeList=memory.getLobbyLoading();
				String userName=memory.getUserName();
				ReceiptCode service2=ConstructFactory.calculateCode();
				code=service2.calculCode(codeList, userName);
				memory.setLobbyLoading(memory.getLobbyLoading()+" "+code);
				System.out.println("-------"+code);
				LobbyLoading vo=new LobbyLoading(code,yearBox.getItemAt(yearBox.getSelectedIndex())+"/"+monthBox.getItemAt(monthBox.getSelectedIndex())+"/"+dayBox.getItemAt(dayBox.getSelectedIndex()),
						loadCodeText.getText(),startPlaceText.getText(),endPlaceText.getText(),
						supervisorText.getText(),supercargoText.getText(),loadOrderText.getText()+" "+
						((WritePanel)panel).getBelong(),Double.parseDouble(loadFeeText.getText()));
				vo.setBelong(((WritePanel)panel).getBelong());
				service.loadVehicle(vo);
				LobbyReceipt receiptService=ConstructFactory.LobbyReceiptFactory();
				receiptService.SaveLoadingCode(userName, code);
			}
		});
	}
	
	public String[][] initTableData(){
		LobbyMemory memory=(LobbyMemory) ((WritePanel)panel).getMemory();
		String[] codes=memory.getLobbyLoading().split(" ");
		int length=codes.length;
		String[][] table;
		if(length>10)
			table=new String[length-1][8];
		else
			table=new String[10][8];
		for(int x=0;x<table.length;x++)
			for(int y=0;y<8;y++)
				table[x][y]=null;
		
		LoadBLService service=ConstructFactory.LoadFactory();
		ArrayList<LobbyLoading> list=service.inquireLoadVehicle(memory.getLobbyLoading());
		int x=0;
		//"װ������", "���˱��", "������", "�����", "��װԱ", "Ѻ��Ա", "���˵���", "�˷�"
		for(LobbyLoading vo:list){
			table[x][0]=vo.getLoadingDate();
			table[x][1]=vo.getAutoMobileNum();
			table[x][2]=vo.getDeparture();
			table[x][3]=vo.getDestination();
			table[x][4]=vo.getMonitor();
			table[x][5]=vo.getGuard();
			table[x][6]=vo.getShipment();
			table[x][7]=vo.getFreight()+"";
			x++;
		}
		return table;		
	}
	public void lookTabel(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		yearString = new String[]{String.valueOf(year-1),String.valueOf(year),String.valueOf(year+1)};
		monthString = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		dataLabel = new JLabel("װ��ʱ��:");
		loadYear = new JLabel("��");
		loadMonth = new JLabel("��");
		loadDay = new JLabel("��");
		yearBox = new JComboBox<String>(yearString);
		monthBox = new JComboBox<String>(monthString);
		dayBox = new JComboBox<String>(dayString);
		
		lookPanel.add(dataLabel);
		lookPanel.add(loadYear);
		lookPanel.add(loadMonth);
		lookPanel.add(loadDay);
		lookPanel.add(yearBox);
		lookPanel.add(monthBox);
		lookPanel.add(dayBox);
		
		dataLabel.setBounds(panelWidth/40, panelHeight/30, panelWidth/10, panelHeight/20);
		yearBox.setBounds(dataLabel.getX()+panelWidth/10, panelHeight/30, panelWidth/10, panelHeight/20);
		loadYear.setBounds(yearBox.getX()+panelWidth/10+panelWidth/100, panelHeight/30, panelWidth/20, panelHeight/20);
		monthBox.setBounds(loadYear.getX()+panelWidth/10, panelHeight/30, panelWidth/10, panelHeight/20);
		loadMonth.setBounds(monthBox.getX()+panelWidth/10+panelWidth/100, panelHeight/30, panelWidth/20, panelHeight/20);
		dayBox.setBounds(loadMonth.getX()+panelWidth/10, panelHeight/30,  panelWidth/10, panelHeight/20);
		loadDay.setBounds(dayBox.getX()+panelWidth/100+panelWidth/10, panelHeight/30, panelWidth/10, panelHeight/20);
		
		tableTitle = new String[]{"װ������", "���˱��", "������", "�����", "��װԱ", "Ѻ��Ա", "���˵���", "�˷�"};
		tableData =this.initTableData();
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//���ò��ɵ�����С
		
		for(int i = 0;i<tableTitle.length;i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(panelWidth/6);
		}
		table.getTableHeader().setPreferredSize(new Dimension(10000,panelWidth/20));
		
		scrollPane = new JScrollPane(table);
		if(tableData.length>9){
			scrollPane.setBounds(panelWidth/40, yearBox.getY()+panelHeight/12, panelWidth*4/5, 10*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/40, yearBox.getY()+panelHeight/12, panelWidth*4/5, (table.getRowCount()+1)*table.getRowHeight());
		}
		
		scrollPane.setVisible(true);
		lookPanel.add(scrollPane);
	}
	
	public void writeTabel(){

		loadData = new JLabel("װ������");//װ������
		loadCode = new JLabel("���˱��");//���˱��
		startPlace = new JLabel("������");//������
		endPlace = new JLabel("�����");//�����
		supervisor = new JLabel("��װԱ");//��װԱ
		supercargo = new JLabel("Ѻ��Ա");//Ѻ��Ա
		loadOrder = new JLabel("���˵���");//���˵���
		loadFee = new JLabel("�˷�");//�˷�
		loadDataText = new JTextField();
		loadCodeText = new JTextField();
		startPlaceText = new JTextField();
		endPlaceText = new JTextField();
		supervisorText = new JTextField();
		supercargoText = new JTextField();
		loadOrderText = new JTextField();
		loadFeeText = new JTextField();
		
		writePanel.add(loadData);
		writePanel.add(loadCode);
		writePanel.add(startPlace);
		writePanel.add(endPlace);
		writePanel.add(supervisor);
		writePanel.add(supercargo);
		writePanel.add(loadOrder);
		writePanel.add(loadFee);
		writePanel.add(loadDataText);
		writePanel.add(loadCodeText);
		writePanel.add(startPlaceText);
		writePanel.add(endPlaceText);
		writePanel.add(supervisorText);
		writePanel.add(supercargoText);
		writePanel.add(loadOrderText);
		writePanel.add(loadFeeText);
		
		loadData.setBounds(panelWidth/10, panelHeight/20, panelWidth*3/20, panelHeight/20);
		loadCode.setBounds(panelWidth/10, panelHeight*3/40+loadData.getY(), panelWidth*3/20, panelHeight/20);
		startPlace.setBounds(panelWidth/10, panelHeight*3/40+loadCode.getY(), panelWidth*3/20, panelHeight/20);
		endPlace.setBounds(panelWidth/10, panelHeight*3/40+startPlace.getY(), panelWidth*3/20, panelHeight/20);
		supervisor.setBounds(panelWidth/10, panelHeight*3/40+endPlace.getY(), panelWidth*3/20, panelHeight/20);
		supercargo.setBounds(panelWidth/10, panelHeight*3/40+supervisor.getY(), panelWidth*3/20, panelHeight/20);
		loadOrder.setBounds(panelWidth/10, panelHeight*3/40+supercargo.getY(), panelWidth*3/20, panelHeight/20);
		loadFee.setBounds(panelWidth/10, panelHeight*3/40+loadOrder.getY(), panelWidth*3/20, panelHeight/20);
		
		loadDataText.setBounds(panelWidth/4, panelHeight/20, panelWidth*9/20, panelHeight/20);
		loadCodeText.setBounds(panelWidth/4, panelHeight*3/40+loadDataText.getY(), panelWidth*9/20, panelHeight/20);
		startPlaceText.setBounds(panelWidth/4, panelHeight*3/40+loadCodeText.getY(), panelWidth*9/20, panelHeight/20);
		endPlaceText.setBounds(panelWidth/4, panelHeight*3/40+startPlaceText.getY()+panelHeight/80, panelWidth*9/20, panelHeight/20);
		supervisorText.setBounds(panelWidth/4, panelHeight*3/40+endPlaceText.getY(), panelWidth*9/20, panelHeight/20);
		supercargoText.setBounds(panelWidth/4, panelHeight*3/40+supervisorText.getY(), panelWidth*9/20, panelHeight/20);
		loadOrderText.setBounds(panelWidth/4, panelHeight*3/40+supercargoText.getY(), panelWidth*9/20, panelHeight/20);
		loadFeeText.setBounds(panelWidth/4, panelHeight*3/40+loadOrderText.getY(), panelWidth*9/20, panelHeight/20);
		
	}
	
}
