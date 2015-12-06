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
	//快递员的单据
	public void courierOrder(){
		courierTitle = new String[]{"职工账号", "日期", "单位编号", "单据类型", "选择", "查看单据"};
		courierData = new String[][]{{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"}};
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
				if(courierTable.getSelectedColumn()==4&&courierTable.getValueAt(courierTable.getSelectedRow(),4).equals("批准")){
					courierTable.setValueAt("",courierTable.getSelectedRow(),4);
				}else if(courierTable.getSelectedColumn()==4&&!courierTable.getValueAt(courierTable.getSelectedRow(),4).equals("批准")){
					courierTable.setValueAt("批准",courierTable.getSelectedRow(),4);
				}
				courierTable.repaint();
			}
		});

		courierChooseAll = new JButton("全选");
		courierChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < courierData.length; i++) {
					courierTable.setValueAt("批准",i,4);
					courierTable.repaint();
				}
			}
		});
		
		
		courierCheck = new JButton("批准");
		courierCheck.setBounds(tabWidth*3/4, 13*courierTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		courierChooseAll.setBounds(tabWidth*11/20, 13*courierTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		courierPanel.add(courierChooseAll);
		courierPanel.add(courierCheck);
		courierPanel.add(courierScrollPane);
	}
	//营业厅业务员的单据
	public void lobbyOrder(){
		lobbyTitle = new String[]{"职工账号", "日期", "单位编号", "单据类型", "选择", "查看单据"};
		lobbyData = new String[][]{{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"}};
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
				if(lobbyTable.getSelectedColumn()==4&&lobbyTable.getValueAt(lobbyTable.getSelectedRow(),4).equals("批准")){
					lobbyTable.setValueAt("",lobbyTable.getSelectedRow(),4);
				}else if(lobbyTable.getSelectedColumn()==4&&!lobbyTable.getValueAt(lobbyTable.getSelectedRow(),4).equals("批准")){
					lobbyTable.setValueAt("批准",lobbyTable.getSelectedRow(),4);
				}
				lobbyTable.repaint();
			}
		});

		lobbyChooseAll = new JButton("全选");
		lobbyChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < lobbyData.length; i++) {
					lobbyTable.setValueAt("批准",i,4);
					lobbyTable.repaint();
				}
			}
		});
		lobbyCheck = new JButton("批准");
		lobbyCheck.setBounds(tabWidth*3/4, 13*lobbyTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		lobbyChooseAll.setBounds(tabWidth*11/20, 13*lobbyTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		lobbyPanel.add(lobbyChooseAll);
		lobbyPanel.add(lobbyCheck);
		lobbyPanel.add(lobbyScrollPane);
	}
	//中转中心业务员的单据
	public void IntermeOrder(){
		intermeTitle = new String[]{"职工账号", "日期", "单位编号", "单据类型", "选择", "查看单据"};
		intermeData = new String[][]{{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"}};
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
				if(intermeTable.getSelectedColumn()==4&&intermeTable.getValueAt(intermeTable.getSelectedRow(),4).equals("批准")){
					intermeTable.setValueAt("",intermeTable.getSelectedRow(),4);
				}else if(intermeTable.getSelectedColumn()==4&&!intermeTable.getValueAt(intermeTable.getSelectedRow(),4).equals("批准")){
					intermeTable.setValueAt("批准",intermeTable.getSelectedRow(),4);
				}
				intermeTable.repaint();
			}
		});

		intermeChooseAll = new JButton("全选");
		intermeChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < intermeData.length; i++) {
					intermeTable.setValueAt("批准",i,4);
					intermeTable.repaint();
				}
			}
		});
		
		intermeCheck = new JButton("批准");
		intermeCheck.setBounds(tabWidth*3/4, 13*intermeTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		intermeChooseAll.setBounds(tabWidth*11/20, 13*intermeTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		intermePanel.add(intermeChooseAll);
		intermePanel.add(intermeCheck);
		intermePanel.add(intermeScrollPane);
	}
	//仓库管理人员的单据
	public void warehouseOrder(){
		warehouseTitle = new String[]{"职工账号", "日期", "单位编号", "单据类型", "选择", "查看单据"};
		warehouseData = new String[][]{{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},
				{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"},{"2015", "2013/03/04", "2306", "订单", " ", "点击查看"}};
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
				if(warehouseTable.getSelectedColumn()==4&&warehouseTable.getValueAt(warehouseTable.getSelectedRow(),4).equals("批准")){
					warehouseTable.setValueAt("",warehouseTable.getSelectedRow(),4);
				}else if(warehouseTable.getSelectedColumn()==4&&!warehouseTable.getValueAt(warehouseTable.getSelectedRow(),4).equals("批准")){
					warehouseTable.setValueAt("批准",warehouseTable.getSelectedRow(),4);
				}
				warehouseTable.repaint();
			}
		});

		warehouseChooseAll = new JButton("全选");
		warehouseChooseAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < warehouseData.length; i++) {
					warehouseTable.setValueAt("批准",i,4);
					warehouseTable.repaint();
				}
			}
		});
		warehouseCheck = new JButton("批准");
		warehouseCheck.setBounds(tabWidth*3/4, 13*warehouseTable.getRowHeight() + tabHeight/10, tabWidth/8, tabHeight/15);
		warehouseChooseAll.setBounds(tabWidth*11/20, 13*warehouseTable.getRowHeight()+ tabHeight/10, tabWidth/8, tabHeight/15);
		
		warehousePanel.add(warehouseChooseAll);
		warehousePanel.add(warehouseCheck);
		warehousePanel.add(warehouseScrollPane);
	}
}
