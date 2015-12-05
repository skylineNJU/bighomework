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

import main.presentation.mainui.MainController;

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
	
	public ExamAllOrderPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
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
	//���Ա�ĵ���
	public void courierOrder(){
		courierTitle = new String[]{"ְ���˺�", "����", "��λ���", "��������", "ѡ��", "�鿴����"};
		courierData = new String[][]{{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"}};
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
				if(courierTable.getSelectedColumn()==4&&courierTable.getValueAt(courierTable.getSelectedRow(),4).equals("��׼")){
					courierTable.setValueAt("",courierTable.getSelectedRow(),4);
				}else if(courierTable.getSelectedColumn()==4&&!courierTable.getValueAt(courierTable.getSelectedRow(),4).equals("��׼")){
					courierTable.setValueAt("��׼",courierTable.getSelectedRow(),4);
				}
				courierTable.repaint();
			}
		});

		courierChooseAll = new JButton("ȫѡ");
		courierChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < courierData.length; i++) {
					courierTable.setValueAt("��׼",i,4);
					courierTable.repaint();
				}
			}
		});
		
		
		courierCheck = new JButton("��׼");
		courierCheck.setBounds(tabWidth*3/4, 13*courierTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		courierChooseAll.setBounds(tabWidth*11/20, 13*courierTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		courierPanel.add(courierChooseAll);
		courierPanel.add(courierCheck);
		courierPanel.add(courierScrollPane);
	}
	//Ӫҵ��ҵ��Ա�ĵ���
	public void lobbyOrder(){
		lobbyTitle = new String[]{"ְ���˺�", "����", "��λ���", "��������", "ѡ��", "�鿴����"};
		lobbyData = new String[][]{{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"}};
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
				if(lobbyTable.getSelectedColumn()==4&&lobbyTable.getValueAt(lobbyTable.getSelectedRow(),4).equals("��׼")){
					lobbyTable.setValueAt("",lobbyTable.getSelectedRow(),4);
				}else if(lobbyTable.getSelectedColumn()==4&&!lobbyTable.getValueAt(lobbyTable.getSelectedRow(),4).equals("��׼")){
					lobbyTable.setValueAt("��׼",lobbyTable.getSelectedRow(),4);
				}
				lobbyTable.repaint();
			}
		});

		lobbyChooseAll = new JButton("ȫѡ");
		lobbyChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < lobbyData.length; i++) {
					lobbyTable.setValueAt("��׼",i,4);
					lobbyTable.repaint();
				}
			}
		});
		lobbyCheck = new JButton("��׼");
		lobbyCheck.setBounds(tabWidth*3/4, 13*lobbyTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		lobbyChooseAll.setBounds(tabWidth*11/20, 13*lobbyTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		lobbyPanel.add(lobbyChooseAll);
		lobbyPanel.add(lobbyCheck);
		lobbyPanel.add(lobbyScrollPane);
	}
	//��ת����ҵ��Ա�ĵ���
	public void IntermeOrder(){
		intermeTitle = new String[]{"ְ���˺�", "����", "��λ���", "��������", "ѡ��", "�鿴����"};
		intermeData = new String[][]{{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"}};
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
				if(intermeTable.getSelectedColumn()==4&&intermeTable.getValueAt(intermeTable.getSelectedRow(),4).equals("��׼")){
					intermeTable.setValueAt("",intermeTable.getSelectedRow(),4);
				}else if(intermeTable.getSelectedColumn()==4&&!intermeTable.getValueAt(intermeTable.getSelectedRow(),4).equals("��׼")){
					intermeTable.setValueAt("��׼",intermeTable.getSelectedRow(),4);
				}
				intermeTable.repaint();
			}
		});

		intermeChooseAll = new JButton("ȫѡ");
		intermeChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < intermeData.length; i++) {
					intermeTable.setValueAt("��׼",i,4);
					intermeTable.repaint();
				}
			}
		});
		
		intermeCheck = new JButton("��׼");
		intermeCheck.setBounds(tabWidth*3/4, 13*intermeTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		intermeChooseAll.setBounds(tabWidth*11/20, 13*intermeTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		intermePanel.add(intermeChooseAll);
		intermePanel.add(intermeCheck);
		intermePanel.add(intermeScrollPane);
	}
	//�ֿ������Ա�ĵ���
	public void warehouseOrder(){
		warehouseTitle = new String[]{"ְ���˺�", "����", "��λ���", "��������", "ѡ��", "�鿴����"};
		warehouseData = new String[][]{{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},
				{"2015", "2013/03/04", "2306", "����", " ", "����鿴"},{"2015", "2013/03/04", "2306", "����", " ", "����鿴"}};
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
				if(warehouseTable.getSelectedColumn()==4&&warehouseTable.getValueAt(warehouseTable.getSelectedRow(),4).equals("��׼")){
					warehouseTable.setValueAt("",warehouseTable.getSelectedRow(),4);
				}else if(warehouseTable.getSelectedColumn()==4&&!warehouseTable.getValueAt(warehouseTable.getSelectedRow(),4).equals("��׼")){
					warehouseTable.setValueAt("��׼",warehouseTable.getSelectedRow(),4);
				}
				warehouseTable.repaint();
			}
		});

		warehouseChooseAll = new JButton("ȫѡ");
		warehouseChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < warehouseData.length; i++) {
					warehouseTable.setValueAt("��׼",i,4);
					warehouseTable.repaint();
				}
			}
		});
		warehouseCheck = new JButton("��׼");
		warehouseCheck.setBounds(tabWidth*3/4, 13*warehouseTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		warehouseChooseAll.setBounds(tabWidth*11/20, 13*warehouseTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		warehousePanel.add(warehouseChooseAll);
		warehousePanel.add(warehouseCheck);
		warehousePanel.add(warehouseScrollPane);
	}
}
