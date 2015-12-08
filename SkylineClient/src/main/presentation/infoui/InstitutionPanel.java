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
	//������������
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
	//��ѯ��������
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
	private JLabel dataLabel;//���label������������ѯ��setTrue
	
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
		tab.addTab("��������", addPanel);
		tab.addTab("��ѯ����", inquirePanel);
		initAddPanel();
		initInquirePanel();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("��������");
		panel.add(title);
		title.setBounds(panelWidth*2/5, panelHeight/60, panelWidth/5, panelHeight/30);
	}
	public void initAddPanel(){
		kindString = new String[]{"1", "2", "3", "4", "5"};
		kindLabel = new JLabel("����");
		nameLabel = new JLabel("����");
		placeLabel = new JLabel("�ص�");
		codeLabel = new JLabel("���");
		kind = new JComboBox<String>(kindString);
		name = new JTextField();
		place = new JTextField();
		code = new JTextField();
		saveButton = new JButton("����");
		cancleButton = new JButton("ȡ��");
		
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
		inquireLabel = new JLabel("��ѯ");
		inquireKind = new JLabel("����");
		inquireName = new JLabel("����");
		inquirePlace = new JLabel("��ַ");
		inquireCode = new JLabel("���");
		kindBox = new JComboBox<String>(inquireString);
		nameText = new JTextField();
		placeText = new JTextField();
		codeText = new JTextField();
		inquireSave = new JButton("����");
		inquireCancle = new JButton("ȡ��");
		inquireButton = new JButton("��ѯ");
		backButton = new JButton("����");
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
		tab.addTab("��ת����", IntermPanel);
		tab.addTab("Ӫҵ��", LobbyPanel);
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
	
		tableTitle11 = new String[]{"��������","��ת���ı��","����Ա����","ռ�����/m^2"};
		tableData11=new String[][]{{"�Ϻ�","0210","400","1000"}};
		defaultModel11   =  new   DefaultTableModel(tableData11,tableTitle11);;
		table11 = new JTable(defaultModel11);
		table11.setEnabled(false);//���ò��ɱ༭����
		table11.setRowHeight(panel.getWidth()/20);//�����п�
		table11.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//���ñ�ͷ�߶�
		table11.getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table11.setDragEnabled(false);
		table11.setVisible(true);
		table11.setBorder(BorderFactory.createEtchedBorder());
		scrollPane11 = new JScrollPane(table11);
		scrollPane11.setBounds(tab.getX()-panel.getWidth()/16, tab.getY()-panel.getWidth()/7,tab.getWidth()+panel.getWidth()/30, (table11.getRowCount()+1)*table11.getRowHeight());
		table11.getColumnModel().getColumn(0).setPreferredWidth(scrollPane11.getWidth()/5);
		table11.getColumnModel().getColumn(1).setPreferredWidth(scrollPane11.getWidth()/6);
	
		table11.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		scrollPane11.setVisible(true);
	
		
		tableTitle1 = new String[]{"�ֿ�����","��Ա����","ռ�����/m^2","�ֿ⾯��ֵ"};
		tableData1=new String[][]{{"A","50","500","90%"},{"B","50","600","90%"},{"C","50","500","90%"},{"D","50","508","90%"},{"E","50","508","80%"}};	
		defaultModel1   =  new   DefaultTableModel(tableData1,tableTitle1);;
		table1 = new JTable(defaultModel1);
		table1.setEnabled(false);//���ò��ɱ༭����
		table1.setRowHeight(panel.getWidth()/20);//�����п�
		table1.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//���ñ�ͷ�߶�
		table1.getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
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
		table1.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		scrollPane1.setVisible(true);
		
		IntermPanel.add(scrollPane1);
		IntermPanel.add(scrollPane11);
	}
	
	public void initLobbyTable(){
	//	���б������Ϻ������ݡ��Ͼ�������ת���ġ�ÿ����ת�����������20��20��15��20��10��Ӫҵ����δ������չ���е���ת���ĺ�Ӫҵ��������
	//   ÿӪҵ��ҵ��Ա��Լ5�ˡ�˾��20�ˡ�
	//Ӫҵ���������λ��000
		tableTitle2 = new String[]{"��������","Ӫҵ�����","����Ա����","ռ�����/m^2"};
		tableData2=new String[][]{{"�Ϻ�","001","28","100"},{"�Ϻ�","002","24","80"},{"�Ϻ�","003","25","1000"},
				{"�Ϻ�","004","25","98"},{"�Ϻ�","005","26","100"},{"�Ϻ�","006","25","98"},{"�Ϻ�","007","26","100"},
				{"�Ϻ�","008","25","98"},{"�Ϻ�","009","26","100"},{"�Ϻ�","010","25","98"},{"�Ϻ�","011","26","100"},
				{"�Ϻ�","012","25","98"},{"�Ϻ�","013","26","100"},{"�Ϻ�","014","25","98"},{"�Ϻ�","015","26","100"},
				{"�Ϻ�","016","25","98"},{"�Ϻ�","017","26","100"},{"�Ϻ�","018","25","98"},{"�Ϻ�","019","26","100"},
				{"�Ϻ�","020","25","98"}};	
		defaultModel2   =  new   DefaultTableModel(tableData2,tableTitle2);;
		table2 = new JTable(defaultModel2);
		table2.setEnabled(false);//���ò��ɱ༭����
		table2.setRowHeight(panel.getWidth()/20);//�����п�
		table2.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//���ñ�ͷ�߶�
		table2.getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
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
		table2.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		scrollPane2.setVisible(true);
		
		LobbyPanel.add(scrollPane2);
		
	}
	
	public void Button(){
		//���÷��Ŵ���
		newWarehouse = new JLabel("�����ֿ�");
		newInterm = new JLabel("������ת����");
		save = new JLabel("����");
		newLobby = new JLabel("����Ӫҵ��");
		newWarehouse.setBounds(panel.getWidth()*60/100,panel.getHeight()*53/60, panel.getWidth()/10, panel.getHeight()/15);
		newInterm.setBounds(panel.getWidth()*70/100,panel.getHeight()*53/60, panel.getWidth()/5, panel.getHeight()/15);
		newLobby.setBounds(panel.getWidth()*70/100,panel.getHeight()*53/60, panel.getWidth()/5, panel.getHeight()/15);
		save.setBounds(panel.getWidth()*85/100,panel.getHeight()*53/60, panel.getWidth()/10, panel.getHeight()/15);
	
		message = new JLabel("������Ҫ�鿴�Ļ������ڳ��У�");
		message.setBounds(panel.getWidth()*8/100,panel.getHeight()*2/60, panel.getWidth()/3, panel.getHeight()/15);
		city=new JTextField();
		city.setBounds(panel.getWidth()*9/100,panel.getHeight()*6/60, panel.getWidth()/12, panel.getHeight()/20);
		ok = new JLabel("ȷ��");
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
		    	  if(tab.getTitleAt(tab.getSelectedIndex()).equals("��ת����") ){
		    		  newLobby.setVisible(false);
		    		  newWarehouse.setVisible(true);
		    		  newInterm.setVisible(true);
		    	  }
		
		    	  else if(tab.getTitleAt(tab.getSelectedIndex()).equals("Ӫҵ��")){
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
