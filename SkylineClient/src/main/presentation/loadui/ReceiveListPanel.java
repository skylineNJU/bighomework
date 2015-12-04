package main.presentation.loadui;

import java.awt.Dimension;
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

import main.businesslogicservice.LoadBLService;
import main.businesslogicservice.ReceiveBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.IntermediateMemory;
import main.vo.PlaneLoadingVO;
import main.vo.TransitReceptionVO;

public class ReceiveListPanel {
	int year;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;//31��
	private JPanel panel;
	private JLabel title;
	private JLabel timeLabel;//װ������
	private JComboBox<String> yearBox;//��ʾ��ݵ���Ͽ�
	private JComboBox<String> monthBox;//��ʾ�·ݵ���Ͽ�
	private JComboBox<String> dayBox;//��ʾ�����Ͽ�
	private JButton searchFromDate;//�������ڲ�ѯ
	private JTable table;
	private JButton ensureButton;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private String[] tableTitle;
	private String[][] tableData;
	private JButton delButton;
	private JButton saveButton;
	int panelWidth=0;
	int panelHeight=0;
	
	private JScrollPane scrollPane;
	
	public ReceiveListPanel(){
		
		panel=MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth=panel.getWidth();
		panelHeight=panel.getHeight();
	}
 public	void init(){
		
	    title();
		setTime();
		initReceiveTable(panel,table);
		delButton = new JButton("ɾ��");
		saveButton = new JButton("����");
		delButton.setBounds(panelWidth*3/5, panelHeight*9/10, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*3/5+delButton.getWidth()*2, panelHeight*9/10, panelWidth/10, panelHeight/20);
		panel.add(delButton);
		panel.add(saveButton);
		
		panel.repaint();
	}
 
 public void title(){
		title = new JLabel("���յ��б�");
		title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
		panel.add(title);
	}
 
 public void setTime(){
		
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		timeLabel = new JLabel("��������");
		yearLabel = new JLabel("��");
		monthLabel = new JLabel("��");
		dayLabel = new JLabel("��");
		ensureButton = new JButton("ȷ��");
		
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
		
		panel.add(ensureButton);
		panel.add(timeLabel);
		panel.add(yearLabel);
		panel.add(monthLabel);
		panel.add(dayLabel);
		panel.add(yearBox);
		panel.add(monthBox);
		panel.add(dayBox);
	}
 
 public String[][] getReceiveTableData(){
		IntermediateMemory memory=(IntermediateMemory) ((WritePanel)panel).getMemory();
		String[] codes=memory.getIntermReceiptCode().split(" ");
		int length=codes.length;
		String[][] table;
		if(length>10)
			table=new String[length-1][9];
		else
			table=new String[10][9];
		for(int x=0;x<table.length;x++)
			for(int y=0;y<9;y++)
				table[x][y]=null;
		ReceiveBLService service=ConstructFactory.ReceiveFactory();
		ArrayList<TransitReceptionVO> volist=service.inquireTransitReception(memory.getIntermReceiptCode());
		int x=0;
		for(TransitReceptionVO vo:volist){
			table[x][0]=vo.getReceiveYear()+"/"+vo.getReceiveMonth()+"/"+vo.getReceiveDay();
		    table[x][1]=vo.getCenterNumber();
	        table[x][2]=vo.getBar();
		
			x++;
		}
		return table;
	}
 
 public void initReceiveTable(JPanel panel,JTable table){
		int panelWidth=panel.getWidth()-26;
	    int panelHeight=panel.getHeight()-26;
	    tableTitle = new String[]{"���յ�����", "��������", "��ת���ı��"};
	    tableData = new String[][]{{"1416191089", "333333", "888888"}};
	    tableData = this.getReceiveTableData();
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setRowHeight(panelWidth/20);//�����п�
		table.setDragEnabled(false);//���ò����϶�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table.getTableHeader().setResizingAllowed(true);//�����п��ɱ�
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, 10*table.getRowHeight());
		}
		panel.add(scrollPane);
	}
 
 
// public void initTable(){
//		tableTitle = new String[]{"���յ�����", "��������", "��ת���ı��"};
//		tableData = new String[][]{{"1416191089", "333333", "888888"},
//				{"1416191089", "333333", "888888"},
//				{"1416191089", "333333", "888888"},
//				{"1416191089", "333333", "888888"},
//				{"1416191089", "333333", "888888"},
//				{"1416191089", "333333", "888888"},
//				{"1416191089", "333333", "888888"},
//				{"1416191089", "333333", "888888"},
//				{"1416191089", "333333", "888888"},
//				};
//		table = new JTable(tableData,tableTitle);
//		scrollPane = new JScrollPane(table);
//		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
//		table.setRowHeight(panelWidth/20);//�����п�
//		table.setDragEnabled(false);//���ò����϶�
//		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
//		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
//		if(tableData.length<=9){
//			scrollPane.setBounds(panelWidth/12, panelHeight/5, panelWidth/6*5, (table.getRowCount()+1)*table.getRowHeight());
//		}else{
//			scrollPane.setBounds(panelWidth/12, panelHeight/5, panelWidth/6*5, 10*table.getRowHeight());
//		}
//		panel.add(scrollPane);
//	}
}
