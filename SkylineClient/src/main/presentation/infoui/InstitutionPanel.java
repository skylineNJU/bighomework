package main.presentation.infoui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
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
import javax.swing.table.DefaultTableModel;

import main.presentation.mainui.MainController;

public class InstitutionPanel {
/*	private JPanel panel;
	private JTabbedPane tab;
	private JPanel addPanel;
	private JPanel inquirePanel;
	private JLabel title;
	private int panelWidth;
	private int panelHeight;
	private int tabWidth;
	private int tabHeight;
	private String[] kindString;
	private String[] inquireString;
	//新增界面的组件
	private JLabel kindLabel;
	private JLabel nameLabel;
	private JLabel placeLabel;
	private JLabel codeLabel;
	private JComboBox<String> kind;
	private JTextField name;
	private JTextField place;
	private JTextField code;
	private JButton saveButton;
	private JButton cancleButton;
	//查询界面的组件
	private JTextField inquireText;
	private JLabel inquireLabel;
	private JLabel inquireKind;
	private JLabel inquireName;
	private JLabel inquirePlace;
	private JLabel inquireCode;
	private JComboBox<String> kindBox;
	private JTextField nameText;
	private JTextField codeText;
	private JTextField placeText;
	private JButton inquireSave;
	private JButton  inquireCancle;
	private JButton inquireButton;
	private JButton backButton;
	private JLabel label;//
	private JLabel dataLabel;//这个label放组件，点击查询后setTrue
	
	public InstitutionPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		initTitle();
		tab = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tab);
		tab.setBounds(panelWidth/10, panelHeight/15, panelWidth*4/5, panelHeight*13/15);
		tabWidth = tab.getWidth();
		tabHeight = tab.getHeight();
		addPanel = new JPanel();
		inquirePanel = new JPanel();
		addPanel.setLayout(null);
		inquirePanel.setLayout(null);
		tab.addTab("新增机构", addPanel);
		tab.addTab("查询机构", inquirePanel);
		initAddPanel();
		initInquirePanel();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("机构管理");
		panel.add(title);
		title.setBounds(panelWidth*2/5, panelHeight/60, panelWidth/5, panelHeight/30);
	}
	public void initAddPanel(){
		kindString = new String[]{"1", "2", "3", "4", "5"};
		kindLabel = new JLabel("种类");
		nameLabel = new JLabel("名字");
		placeLabel = new JLabel("地点");
		codeLabel = new JLabel("编号");
		kind = new JComboBox<String>(kindString);
		name = new JTextField();
		place = new JTextField();
		code = new JTextField();
		saveButton = new JButton("保存");
		cancleButton = new JButton("取消");
		
		addPanel.add(kindLabel);
		addPanel.add(nameLabel);
		addPanel.add(placeLabel);
		addPanel.add(codeLabel);
		addPanel.add(kind);
		addPanel.add(name);
		addPanel.add(place);
		addPanel.add(code);
		addPanel.add(saveButton);
		addPanel.add(cancleButton);
		
		saveButton.addMouseListener(new MouseAdapter(){
			
		});
		
		kindLabel.setBounds(tabWidth/10, tabHeight/9, tabWidth/10, tabHeight/15);
		nameLabel.setBounds(kindLabel.getX(), kindLabel.getY()+kindLabel.getHeight()+tabHeight/9, kindLabel.getWidth(), kindLabel.getHeight());
		placeLabel.setBounds(kindLabel.getX(), nameLabel.getY()+nameLabel.getHeight()+tabHeight/9, kindLabel.getWidth(), kindLabel.getHeight());
		codeLabel.setBounds(kindLabel.getX(), placeLabel.getY()+placeLabel.getHeight()+tabHeight/9, kindLabel.getWidth(), kindLabel.getHeight());
		kind.setBounds(tabWidth/4, kindLabel.getY(), tabWidth*13/20, kindLabel.getHeight());
		name.setBounds(kind.getX(), nameLabel.getY(), kind.getWidth(), kind.getHeight());
		place.setBounds(kind.getX(), placeLabel.getY(), kind.getWidth(), kind.getHeight());
		code.setBounds(kind.getX(), codeLabel.getY(), kind.getWidth(), kind.getHeight());
		saveButton.setBounds(tabWidth*3/4, code.getY()+code.getHeight()+tabHeight/9, tabWidth/8, tabHeight/15);
		cancleButton.setBounds(tabWidth*11/20, saveButton.getY(), tabWidth/8, tabHeight/15);
	}
	public void initInquirePanel(){
		inquireString = new String[]{"1", "2", "3", "4", "5"};
		inquireText = new JTextField();
		inquireLabel = new JLabel("查询");
		inquireKind = new JLabel("种类");
		inquireName = new JLabel("名字");
		inquirePlace = new JLabel("地址");
		inquireCode = new JLabel("编号");
		kindBox = new JComboBox<String>(inquireString);
		nameText = new JTextField();
		placeText = new JTextField();
		codeText = new JTextField();
		inquireSave = new JButton("保存");
		inquireCancle = new JButton("取消");
		inquireButton = new JButton("查询");
		backButton = new JButton("返回");
		label = new JLabel();
		dataLabel = new JLabel();
		
		inquirePanel.add(label);
		inquirePanel.add(dataLabel);
		label.setBounds(0, 0, panelWidth, panelHeight);
		dataLabel.setBounds(0, 0, panelWidth, panelHeight);
		label.setVisible(true);
		dataLabel.setVisible(false);
	
		label.add(inquireText);
		label.add(inquireLabel);
		label.add(inquireButton);
		
		inquireLabel.setBounds(tabWidth/10-tabWidth/40,tabHeight*2/5,tabWidth/10, tabHeight/15);
		inquireText.setBounds(tabWidth*3/20, tabHeight*2/5, tabWidth*3/5, tabHeight/15);
		inquireButton.setBounds(tabWidth*4/5, tabHeight*2/5, tabWidth/8, tabHeight/15);
		inquireButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				dataLabel.setVisible(true);
				label.setVisible(false);
			}
		});
		
		dataLabel.add(inquireKind);
		dataLabel.add(inquireName);
		dataLabel.add(inquirePlace);
		dataLabel.add(inquireCode);
		dataLabel.add(kindBox);
		dataLabel.add(nameText);
		dataLabel.add(placeText);
		dataLabel.add(codeText);
		dataLabel.add(inquireSave);
		dataLabel.add(inquireCancle);
		dataLabel.add(backButton);
		
		inquireKind.setBounds(tabWidth/10, tabHeight/9, tabWidth/10, tabHeight/15);
		inquireName.setBounds(inquireKind.getX(), inquireKind.getY()+inquireKind.getHeight()+tabHeight/9, inquireKind.getWidth(), inquireKind.getHeight());
		inquirePlace.setBounds(inquireKind.getX(), inquireName.getY()+inquireName.getHeight()+tabHeight/9, inquireKind.getWidth(), inquireKind.getHeight());
		inquireCode.setBounds(inquireKind.getX(), inquirePlace.getY()+inquirePlace.getHeight()+tabHeight/9, inquireKind.getWidth(), inquireKind.getHeight());
		kindBox.setBounds(tabWidth/4, inquireKind.getY(), tabWidth*13/20, inquireKind.getHeight());
		nameText.setBounds(kindBox.getX(), inquireName.getY(), kindBox.getWidth(), kindBox.getHeight());
		placeText.setBounds(kindBox.getX(), inquirePlace.getY(), kindBox.getWidth(), kindBox.getHeight());
		codeText.setBounds(kindBox.getX(), inquireCode.getY(), kindBox.getWidth(), kindBox.getHeight());
		inquireSave.setBounds(tabWidth*3/4, codeText.getY()+codeText.getHeight()+tabHeight/9, tabWidth/8, tabHeight/15);
		inquireCancle.setBounds(tabWidth*11/20, inquireSave.getY(), tabWidth/8, tabHeight/15);
		backButton.setBounds(2*inquireCancle.getX()-inquireSave.getX(), inquireSave.getY(), tabWidth/8, tabHeight/15);
		
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				label.setVisible(true);
				dataLabel.setVisible(false);
			}
		});
	}
*/
	
	
	private JPanel panel;
	private JPanel IntermPanel;
	private JPanel LobbyPanel;
	private JTabbedPane tab;
	private JTable table1;
	private JTable table11;
	private JTable table2;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane11;
	private JScrollPane scrollPane2;
	private String[] tableTitle1;
	private String[] tableTitle11;
	private String[] tableTitle2;
	private String[][] tableData1;
	private String[][] tableData11;
	private String[][] tableData2;
	private JLabel citys;
	private JLabel newWarehouse;
	private JLabel newInterm;
	private JLabel save;
	private JLabel newLobby;
	private JLabel ok;
	private JTextField city;
	private JLabel message;
	private	DefaultTableModel   defaultModel11 ;
	private	DefaultTableModel   defaultModel1 ;
	private	DefaultTableModel   defaultModel2 ;
	
	public InstitutionPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		IntermPanel = new JPanel();
		IntermPanel.setLayout(null);
		IntermPanel.setVisible(true);
		LobbyPanel = new JPanel();
		LobbyPanel.setLayout(null);
		LobbyPanel.setVisible(true);
		
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("中转中心", IntermPanel);
		tab.addTab("营业厅", LobbyPanel);
		tab.setSize(panel.getWidth()*7/8,panel.getHeight()/100*75);
		tab.setLocation(panel.getWidth()/16,panel.getHeight()/6);
	
		
		initIntermTable();
		initLobbyTable();
		Button();
		Listener();
		panel.add(tab);	
		tab.repaint();
		panel.repaint();
		
	}
	
	public void initIntermTable(){
	
		tableTitle11 = new String[]{"所属城市","中转中心编号","机构员工数","占地面积/m^2"};
		tableData11=new String[][]{{"上海","0210","400","1000"}};
		defaultModel11   =  new   DefaultTableModel(tableData11,tableTitle11);;
		table11 = new JTable(defaultModel11);
		table11.setEnabled(false);//设置不可编辑内容
		table11.setRowHeight(panel.getWidth()/20);//设置列宽
		table11.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table11.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table11.setDragEnabled(false);
		table11.setVisible(true);
		table11.setBorder(BorderFactory.createEtchedBorder());
		scrollPane11 = new JScrollPane(table11);
		scrollPane11.setBounds(tab.getX()-panel.getWidth()/16, tab.getY()-panel.getWidth()/7,tab.getWidth()+panel.getWidth()/30, (table11.getRowCount()+1)*table11.getRowHeight());
		table11.getColumnModel().getColumn(0).setPreferredWidth(scrollPane11.getWidth()/5);
		table11.getColumnModel().getColumn(1).setPreferredWidth(scrollPane11.getWidth()/6);
	
		table11.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane11.setVisible(true);
	
		
		tableTitle1 = new String[]{"仓库区号","总员工数","占地面积/m^2","仓库警戒值"};
		tableData1=new String[][]{{"A","50","500","90%"},{"B","50","600","90%"},{"C","50","500","90%"},{"D","50","508","90%"},{"E","50","508","80%"}};	
		defaultModel1   =  new   DefaultTableModel(tableData1,tableTitle1);;
		table1 = new JTable(defaultModel1);
		table1.setEnabled(false);//设置不可编辑内容
		table1.setRowHeight(panel.getWidth()/20);//设置列宽
		table1.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table1.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table1.setDragEnabled(false);
		table1.setVisible(true);
		scrollPane1 = new JScrollPane(table1);
		if(tableData1.length>=7){
			scrollPane1.setBounds(tab.getX()+panel.getWidth()/25, tab.getY(),tab.getWidth()*4/5, 7*table1.getRowHeight());
		}else{
			scrollPane1.setBounds(tab.getX()+panel.getWidth()/25, tab.getY(),tab.getWidth()*4/5, (table1.getRowCount()+1)*table1.getRowHeight());
		}
		table1.getColumnModel().getColumn(0).setPreferredWidth(scrollPane1.getWidth()/5);;
		table1.getColumnModel().getColumn(1).setPreferredWidth(scrollPane1.getWidth()/6);;
		table1.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane1.setVisible(true);
		
		IntermPanel.add(scrollPane1);
		IntermPanel.add(scrollPane11);
	}
	
	public void initLobbyTable(){
	//	现有北京、上海、广州、南京设有中转中心。每个中转中心下设各设20、20、15、20、10个营业厅。未来会扩展城市的中转中心和营业厅数量。
	//   每营业厅业务员大约5人。司机20人。
	//营业厅编号是三位数000
		tableTitle2 = new String[]{"所属城市","营业厅编号","机构员工数","占地面积/m^2"};
		tableData2=new String[][]{{"上海","001","28","100"},{"上海","002","24","80"},{"上海","003","25","1000"},
				{"上海","004","25","98"},{"上海","005","26","100"},{"上海","006","25","98"},{"上海","007","26","100"},
				{"上海","008","25","98"},{"上海","009","26","100"},{"上海","010","25","98"},{"上海","011","26","100"},
				{"上海","012","25","98"},{"上海","013","26","100"},{"上海","014","25","98"},{"上海","015","26","100"},
				{"上海","016","25","98"},{"上海","017","26","100"},{"上海","018","25","98"},{"上海","019","26","100"},
				{"上海","020","25","98"}};	
		defaultModel2   =  new   DefaultTableModel(tableData2,tableTitle2);;
		table2 = new JTable(defaultModel2);
		table2.setEnabled(false);//设置不可编辑内容
		table2.setRowHeight(panel.getWidth()/20);//设置列宽
		table2.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table2.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table2.setDragEnabled(false);
		table2.setVisible(true);
		scrollPane2 = new JScrollPane(table2);
		if(tableData2.length>=10){
			scrollPane2.setBounds(tab.getX()-panel.getWidth()/16, tab.getY()-panel.getWidth()/7,tab.getWidth(), 10*table2.getRowHeight());
		}else{
			scrollPane2.setBounds(tab.getX()-panel.getWidth()/16, tab.getY()-panel.getWidth()/7,tab.getWidth(), (table2.getRowCount()+1)*table2.getRowHeight());
		}
		table2.getColumnModel().getColumn(0).setPreferredWidth(scrollPane2.getWidth()/5);;
		table2.getColumnModel().getColumn(1).setPreferredWidth(scrollPane2.getWidth()/6);;
		table2.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane2.setVisible(true);
		
		LobbyPanel.add(scrollPane2);
		
	}
	
	public void Button(){
		//可用符号代替
		newWarehouse = new JLabel("新增仓库");
		newInterm = new JLabel("新增中转中心");
		save = new JLabel("保存");
		newLobby = new JLabel("新增营业厅");
		newWarehouse.setBounds(panel.getWidth()*60/100,panel.getHeight()*53/60, panel.getWidth()/10, panel.getHeight()/15);
		newInterm.setBounds(panel.getWidth()*70/100,panel.getHeight()*53/60, panel.getWidth()/5, panel.getHeight()/15);
		newLobby.setBounds(panel.getWidth()*70/100,panel.getHeight()*53/60, panel.getWidth()/5, panel.getHeight()/15);
		save.setBounds(panel.getWidth()*85/100,panel.getHeight()*53/60, panel.getWidth()/10, panel.getHeight()/15);
	
		message = new JLabel("请输入要查看的机构所在城市：");
		message.setBounds(panel.getWidth()*8/100,panel.getHeight()*2/60, panel.getWidth()/3, panel.getHeight()/15);
		city=new JTextField();
		city.setBounds(panel.getWidth()*9/100,panel.getHeight()*6/60, panel.getWidth()/12, panel.getHeight()/20);
		ok = new JLabel("确认");
		ok.setBounds(panel.getWidth()*25/100,panel.getHeight()*7/80, panel.getWidth()/10, panel.getHeight()/15);
		
		
		newLobby.setVisible(false);
		newWarehouse.setVisible(true);
		newInterm.setVisible(true);
		ok.setVisible(true);
		city.setVisible(true);
		message.setVisible(true);
		
		panel.add(newWarehouse);
		panel.add(newInterm);
		panel.add(newLobby);
		panel.add(save);
		panel.add(ok);
		panel.add(city);
		panel.add(message);
	}
	
	public void Listener(){
		tab.addChangeListener( new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		    	  if(tab.getTitleAt(tab.getSelectedIndex()).equals("中转中心") ){
		    		  newLobby.setVisible(false);
		    		  newWarehouse.setVisible(true);
		    		  newInterm.setVisible(true);
		    	  }
		
		    	  else if(tab.getTitleAt(tab.getSelectedIndex()).equals("营业厅")){
		    		  newWarehouse.setVisible(false);
		    		  newInterm.setVisible(false);
		    		  newLobby.setVisible(true);
		    	
		    	  }
		    	  System.out.println(":::::::::::"+tab.getTitleAt(tab.getSelectedIndex()));
		      }});
		
		newWarehouse.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				 defaultModel1.addRow(new  Vector());
			}
		});
		newLobby.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				 defaultModel2.addRow(new  Vector());
			}
		});
		
	}
}
