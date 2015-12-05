package main.presentation.financeui;

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

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
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
	//�鿴�տ���Ϣ�����
	private JTable table;
	private JScrollPane srollPane;
	private JLabel date;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JComboBox<String> yearBox;
	private JComboBox<String> monthBox;
	private JComboBox<String> dayBox;
	private JButton ensureButton;
	private JButton lookSaveButton;
	private JButton lookCancleButton;
	//��д�տ���Ϣ�����
	private JLabel earnData;//�տ�����
	private JLabel earnFee;//�տ���
	private JLabel earnStaff;//�տ���Ա
	private JLabel earnOrder;//�������
	private JTextField dataText;
	private JTextField feeText;
	private JTextField staffText;
	private JTextField orderText;
	private JButton saveButton;
	private JButton cancleButton;

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
		tab.addTab("�鿴�տ���Ϣ", lookPanel);
		tab.addTab("��д�տ���Ϣ",writePanel);
		initLook();
		initLookPanel();
		initWritePanel();
		panel.repaint();
	}
	public void title(){
		titleLabel = new JLabel("�տ");
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
		date = new JLabel("����");
		yearLabel = new JLabel("��");
		monthLabel = new JLabel("��");
		dayLabel = new JLabel("��");
		yearBox = new JComboBox<String>(yearString);
		monthBox = new JComboBox<String>(monthString);
		dayBox = new JComboBox<String>(dayString);
		ensureButton = new JButton("ȷ��");
		lookSaveButton = new JButton("����");
		lookCancleButton = new JButton("ȡ��");
		lookPanel.add(date);
		lookPanel.add(yearLabel);
		lookPanel.add(monthLabel);
		lookPanel.add(dayLabel);
		lookPanel.add(yearBox);
		lookPanel.add(monthBox);
		lookPanel.add(dayBox);
		lookPanel.add(ensureButton);
		lookPanel.add(lookSaveButton);
		lookPanel.add(lookCancleButton);
		date.setBounds(lookPanel.getWidth()/15, lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		yearBox.setBounds(lookPanel.getWidth()/10+date.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		yearLabel.setBounds(lookPanel.getWidth()*7/60+yearBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/20, lookPanel.getHeight()/20);
		monthBox.setBounds(lookPanel.getWidth()/5+yearBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		monthLabel.setBounds(lookPanel.getWidth()*7/60+monthBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/20, lookPanel.getHeight()/20);
		dayBox.setBounds(lookPanel.getWidth()/5+monthBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		dayLabel.setBounds(lookPanel.getWidth()*7/60+dayBox.getX(), lookPanel.getHeight()/30, lookPanel.getWidth()/20, lookPanel.getHeight()/20);
		ensureButton.setBounds(lookPanel.getWidth()*5/6, lookPanel.getHeight()/30, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		lookCancleButton.setBounds(lookPanel.getWidth()*13/20, lookPanel.getHeight()*5/6, lookPanel.getWidth()/10, lookPanel.getHeight()/20);
		lookSaveButton.setBounds(lookCancleButton.getX()+lookPanel.getWidth()/6, lookPanel.getHeight()*5/6, lookPanel.getWidth()/10, lookPanel.getHeight()/20);

	}
	
	public void getData(){
		int counter = 0;
		tableTitle = new String[]{"�տ����", "�տ���", "���뵥λ", "��������","�����˻�","�Ƿ����","��ע"};
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
//		tableTitle = new String[]{"�տ�����","�տ���", "�տ��˺�", "�տ��"};
//		tableData = new String[][]{{"2012/03/16", "20", "201515", "200959"}, {"2012/03/16", "20", "201515", "200959"},
//				{"2012/03/16", "20", "201515", "200959"},{"2012/03/16", "20", "201515", "200959"},{"2012/03/16", "20", "201515", "200959"},
//				{"2012/03/16", "20", "201515", "200959"},{"2012/03/16", "20", "201515", "200959"},{"2012/03/16", "20", "201515", "200959"},
//				{"2012/03/16", "20", "201515", "200959"},{"2012/03/16", "20", "201515", "200959"},{"2012/03/16", "20", "201515", "200959"},
//				{"2012/03/16", "20", "201515", "200959"},{"2012/03/16", "20", "201515", "200959"},{"2012/03/16", "20", "201515", "200959"}};
		table = new JTable(tableData,tableTitle);
		srollPane = new JScrollPane(table);
		
		table.setEnabled(false);
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setRowHeight(panel.getHeight()/20);//�����п�
		table.setDragEnabled(false);//���ò����϶�
		table.getTableHeader().setPreferredSize(new Dimension(10000, panel.getHeight()/20));//���ñ�ͷ�߶�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
	
		lookPanel.add(srollPane);
		srollPane.setBounds(lookPanel.getWidth()/15, lookPanel.getHeight()*2/15, lookPanel.getWidth()*13/15, lookPanel.getHeight()*13/20);			
		srollPane.setVisible(true);
		lookPanel.repaint();
	}
	
	public void initWritePanel(){
		
		earnData = new JLabel("�տ�����");//�տ�����
		earnFee = new JLabel("�տ���");//�տ���
		earnStaff = new JLabel("�տ���Ա");//�տ���Ա
		earnOrder = new JLabel("�������");//�������
		dataText = new JTextField();
		feeText = new JTextField();
		staffText = new JTextField();
		orderText = new JTextField();
		saveButton = new JButton("����");
		cancleButton = new JButton("ȡ��");
		
		writePanel.add(earnData);
		writePanel.add(earnFee);
		writePanel.add(earnStaff);
		writePanel.add(earnOrder);
		writePanel.add(dataText);
		writePanel.add(feeText);
		writePanel.add(staffText);
		writePanel.add(orderText);
		writePanel.add(saveButton);
		writePanel.add(cancleButton);
		
		earnData.setBounds(writePanel.getWidth()/6, writePanel.getHeight()/9, writePanel.getWidth()/8, writePanel.getHeight()/15);
		earnFee.setBounds(writePanel.getWidth()/6, writePanel.getHeight()*8/45+earnData.getY(), writePanel.getWidth()/8, writePanel.getHeight()/15);
		earnStaff.setBounds(writePanel.getWidth()/6, writePanel.getHeight()*8/45+earnFee.getY(), writePanel.getWidth()/8, writePanel.getHeight()/15);
		earnOrder.setBounds(writePanel.getWidth()/6, writePanel.getHeight()*8/45+earnStaff.getY(), writePanel.getWidth()/8, writePanel.getHeight()/15);
		dataText.setBounds(writePanel.getWidth()/3, writePanel.getHeight()/9, writePanel.getWidth()/2, writePanel.getHeight()/15);
		feeText.setBounds(writePanel.getWidth()/3, writePanel.getHeight()*8/45+earnData.getY(), writePanel.getWidth()/2, writePanel.getHeight()/15);
		staffText.setBounds(writePanel.getWidth()/3, writePanel.getHeight()*8/45+earnFee.getY(), writePanel.getWidth()/2, writePanel.getHeight()/15);
		orderText.setBounds(writePanel.getWidth()/3,   writePanel.getHeight()*8/45+earnStaff.getY(), writePanel.getWidth()/2, writePanel.getHeight()/15);
		saveButton.setBounds(writePanel.getWidth()/2, writePanel.getHeight()*8/45+earnOrder.getY(), writePanel.getWidth()/8, writePanel.getHeight()/15);
		cancleButton.setBounds(writePanel.getWidth()*17/24, writePanel.getHeight()*8/45+earnOrder.getY(), writePanel.getWidth()/8, writePanel.getHeight()/15);
		
		writePanel.repaint();
	}
}
