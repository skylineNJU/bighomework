package main.presentation.rightui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.InfoBLService;
import main.businesslogicservice.RightBLService;
import main.constructfactory.ConstructFactory;
import main.po.Rights;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.vo.AccountVO;
import main.vo.CityVO;

public class RightAdminPanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	//按钮组件
	private JButton cancelButton;
	private JButton saveButton;
	private JButton lookDeleteButton;
	private JButton lookModifyButton;
	//lookPanel上的组件
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private String[] identityString;
	private String[] cityString;
	DefaultTableModel model ;
	//writePanel上的组件
	private JLabel accountLabel;//账号标签
	private JLabel codeLabel;//密码标签
	private JLabel identityLabel;//身份标签
	private JLabel cityLabel;//城市标签
	private JLabel institutionLabel;//机构标签
	private JLabel tip; 
	private JTextField accountText;
	private JTextField codeText;
	private JComboBox<String> identity;
	private JComboBox<String > institution;
	private JComboBox<String > city;
	private boolean[] selectRow;
	
	private JLabel title;
	private JPanel lookPanel;//查看权限管理单
	private JPanel writePanel;//填写权限管理
	private JTabbedPane tab;
	private Rights[] right={Rights.COURIER,
										Rights.LOBBY,
										Rights.INTERMEDIATE,
										Rights.MANAGER,
										Rights.STOREHOUSE,
										Rights.FINANCE,
										Rights.ACCOUNT};
	private ArrayList<String>array;
	public RightAdminPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();//初始化标题
		lookPanel = new JPanel();
		lookPanel.setLayout(null);
		writePanel = new JPanel();
		writePanel.setLayout(null);

		lookTabel();//初始化查看权限管理面板
		writeTabel();//初始化填写权限管理面板
		initButton();//初始化按钮
		tab = new JTabbedPane();
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.add("查看账号",lookPanel);
		tab.add("新增账号",writePanel);
		panel.add(tab);	
		tab.setBounds(panelWidth/20, panelHeight/10, panelWidth*8/9, panelHeight*4/5);
		tab.setVisible(true);
		tab.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
			
				
			}
			
		});
		panel.repaint();
	}
	public void refresh(){
		tableData=this.initTableData();
		while(table.getRowCount()<tableData.length){
		((DefaultTableModel)table.getModel()).addRow(new String[4]);
		}
		for(int x=0;x<tableData.length;x++){
			for(int y=0;y<4;y++){
				table.setValueAt(tableData[x][y],x,y);
			}
		}
	}
	
	public void title(){
		title = new JLabel("权限管理");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	
	public void initButton(){
		cancelButton = new JButton("取消");
		saveButton = new JButton("保存");
		cancelButton.setBounds(panelWidth*9/20, panelHeight*12/20, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*12/20,  panelHeight*12/20, panelWidth/10, panelHeight/20);
		writePanel.add(cancelButton);
		writePanel.add(saveButton);
		cancelButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				accountText.setText(null);
				codeText.setText(null);
				identity.setSelectedIndex(0);
				//institutionText.setText(null);
			}
		});
		//0 快递员
		//1 营业厅业务员
		//2 中转中心业务员
		//3 总经理
		//4 仓库管理人员
		//5 财务人员
		//6 管理人员
		saveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Rights staffIdentity=right[identity.getSelectedIndex()];
				if(codeText.getText().equals("")){		
					codeText.setText("请输入密码");
					codeText.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
							codeText.setText("");
					}});
				}
				
				if(accountText.getText().equals("")){
					accountText.setText("请输入账号");
					accountText.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
							accountText.setText("");
					}});
				}
				
				else{
				AccountVO accountInfo=new AccountVO(staffIdentity
												,accountText.getText()
												,codeText.getText()
												,((WritePanel) panel).getBelong());
				RightBLService service=ConstructFactory.RightFactory();
				service.createNewAccount(accountInfo);
			}}
		});
		lookDeleteButton = new JButton("删除");
		lookModifyButton = new JButton("修改");
		lookDeleteButton.setBounds(panelWidth*12/20, panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookModifyButton.setBounds(panelWidth*15/20,  panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookPanel.add(lookDeleteButton);
		lookPanel.add(lookModifyButton);
		
		lookModifyButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				for(int x=0;x<selectRow.length;x++){
		//"账号"“密码”“权限”“机构”
					if(selectRow[x]){
						AccountVO vo=new AccountVO(Rights.valueOf((String)table.getValueAt(x,2)),
								(String)table.getValueAt(x,0),
								(String)table.getValueAt(x,1),
								(String) table.getValueAt(x,3)
								);
						System.out.println(vo.getCode());
						RightBLService service1=ConstructFactory.RightFactory();
						service1.modifyAccount(vo);
					}
				}
				refresh();
			}
		});
		lookDeleteButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				for(int x=0;x<selectRow.length;x++){
					if(selectRow[x]){
						RightBLService service=ConstructFactory.RightFactory();
						service.deleteAccount((String) table.getValueAt(x,0));
					}
				}
				
				refresh();
			}
		});
	}
	
	
	public void lookTabel(){
		tableTitle = new String[]{"账号", "密码", "身份", "机构","选择"};
		tableData = this.initTableData();
		MyTableModel model=new MyTableModel();
		model.setColumnCount(5);
		model.setColumnIdentifiers(tableTitle);
		for(int x=0;x<tableData.length;x++){
			model.addRow(tableData[x]);
		}
		table = new JTable(model);

		table.setEditingColumn(1);
		table.setEditingColumn(3);
		
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//设置不可调整大小
		for(int i = 0;i<4;i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(panelWidth/5);
		}
		
		table.getTableHeader().setPreferredSize(new Dimension(10000,panelWidth/20));
		scrollPane = new JScrollPane(table);
		if(tableData.length>9){
			scrollPane.setBounds(panelWidth/41, panelHeight/40, panelWidth*86/100, 10*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/41, panelHeight/40, panelWidth*86/100, (table.getRowCount()+1)*table.getRowHeight());
		}
		scrollPane.setVisible(true);
	//	table.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/5);
	//	table.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/6);
		table.getColumnModel().getColumn(3).setPreferredWidth(scrollPane.getWidth()/7);
		lookPanel.add(scrollPane);
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int x=table.getSelectedRow();
				if(!selectRow[x]){
					selectRow[x]=true;
					table.setValueAt("已选",x,4);
				}else{
					selectRow[x]=false;
					table.setValueAt("",x,4);
				}
			}
		});
		
	}
	
	public String[][] initTableData(){
//		for(int x=0;x<table.getRowCount();x++)
//			for(int y=0;y<table.getColumnCount();y++)
//				content[x][y]=null;
		
		ArrayList<AccountVO> volist=null;
		RightBLService service=ConstructFactory.RightFactory();
		volist=service.inquireAccount();
		String[][] content =new String[volist.size()][5];
		for(int x=0;x<volist.size();x++)
			for(int y=0;y<5;y++)
				content[x][y]=null;
		
		if(volist!=null){
		int counter=0;
		
		for(AccountVO vo:volist){
			content[counter][0]=vo.getAccountName();
			content[counter][1]=vo.getCode();
			content[counter][2]=vo.getRight().name();
			content[counter][3]=vo.getBelong();
			content[counter][4]="";
			counter++;
		}
		
		}
		selectRow=new boolean[content.length];
		for(int x=0;x<content.length;x++){
			selectRow[x]=false;
		}
		return content;
	}
	
	public void writeTabel(){
		Font font= new Font("宋体", Font.BOLD, 20);
		accountLabel = new JLabel("账号");
		accountLabel.setFont(font);
		codeLabel= new JLabel("密码");
		codeLabel.setFont(font);
		identityLabel = new JLabel("身份");
		identityLabel.setFont(font);
		institutionLabel = new JLabel("机构");
		institutionLabel.setFont(font);
		cityLabel =new JLabel("城市");
		cityLabel.setFont(font);
		
		accountText = new JTextField();
		codeText = new JTextField();
		identityString = new String[]{"快递员","营业厅业务员","中转中心业务员","总经理","仓库管理人员","财务人员","管理员"};
		
		institution =new JComboBox<String>();
		//institution.setVisible(false);
		identity = new JComboBox<String>(identityString);
		InfoBLService service = ConstructFactory.InfoFactory();		
		CityVO cityVO = service.inquireCity();	
		
		
	
		if(cityVO!=null){
		
	
			cityString=cityVO.getCityName().substring(1).split(" ");
			
			array=new ArrayList<String>();
			array=cityVO.getInsititutionNum();
			
		System.out.println(cityString[0]);
			//cityString[counter][1]=vo.getInsititutionNum();		
			
	
		}
		city=new JComboBox<String>(cityString);
		city.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				String args=array.get(city.getSelectedIndex());
				String[] insNum=args.split(" ");
				institution.removeAllItems();
				for(int x=0;x<insNum.length;x++){
					institution.addItem(insNum[x]);
				}
				institutionLabel.setVisible(true);
				institution.setVisible(true);
			}
			
		});
		
		accountLabel.setBounds(panelWidth/10, panelHeight/17, panelWidth/5, panelHeight/20);
		codeLabel.setBounds(accountLabel.getX(), panelHeight/10+accountLabel.getY(), panelWidth/5, panelHeight/20);
		identityLabel.setBounds(accountLabel.getX(), panelHeight/10+codeLabel.getY(), panelWidth*3/20, panelHeight/20);
		cityLabel.setBounds(accountLabel.getX(), panelHeight/10+identityLabel.getY(),panelWidth*3/20, panelHeight/20);
		institutionLabel.setBounds(panelWidth*9/20,panelHeight/10+identityLabel.getY(),panelWidth*3/20, panelHeight/20);
		
		accountText.setBounds(accountLabel.getX()+panel.getWidth()/8,accountLabel.getY(), panelWidth/3, panelHeight/20);
		codeText.setBounds(accountText.getX(), panelHeight/10+accountText.getY(), panelWidth/3, panelHeight/20);
		identity.setBounds(identityLabel.getX()+panel.getWidth()/8, identityLabel.getY(), panelWidth/10, panelHeight/20);
		city.setBounds(cityLabel.getX()+panel.getWidth()/8,cityLabel.getY(), panelWidth/10, panelHeight/20);
		institution.setBounds(institutionLabel.getX()+panel.getWidth()/8,institutionLabel.getY(),  panelWidth/10, panelHeight/20);
	
		
		institutionLabel.setVisible(false);
		institution.setVisible(false);
		
		writePanel.add(accountLabel);
		writePanel.add(codeLabel);
		writePanel.add(identityLabel);
		writePanel.add(institutionLabel);
		writePanel.add(accountText);
		writePanel.add(codeText);
		writePanel.add(identity);
		writePanel.add(institution);
		writePanel.add(city);
		writePanel.add(cityLabel);
		
		
	}
	
	class MyTableModel extends DefaultTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			if(column%2==0){
				return false;
			}
			return true;
		}
    }
	}
