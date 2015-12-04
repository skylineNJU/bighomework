package main.presentation.rightui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.businesslogicservice.InfoBLService;
import main.businesslogicservice.RightBLService;
import main.constructfactory.ConstructFactory;
import main.po.Rights;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.vo.AccountVO;
import main.vo.DriverVO;

public class RightAdminPanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	//按钮组件
	private JButton cancelButton;
	private JButton saveButton;
	private JButton lookCancleButton;
	private JButton lookSaveButton;
	//lookPanel上的组件
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private String[] identityString;
	
	//writePanel上的组件
	private JLabel nameLabel;//姓名标签
	private JLabel accountLabel;//账号标签
	private JLabel identityLabel;//身份标签
	private JLabel institutionLabel;//机构标签
	
	private JTextField nameText;
	private JTextField accountText;
	private JComboBox<String> identity;
	private JTextField institutionText;
	
	
	private JLabel title;
	private JPanel lookPanel;//查看权限管理单
	private JPanel writePanel;//填写权限管理
	private JTabbedPane tab;
	private Rights[] right={Rights.ACCOUNT,
										Rights.COURIER,
										Rights.FINANCE,
										Rights.INTERMEDIATE,
										Rights.LOBBY,
										Rights.MANAGER,
										Rights.STOREHOUSE};
	
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
		tab.setBounds(panelWidth/10, panelHeight/10, panelWidth*4/5, panelHeight*4/5);
		tab.setVisible(true);
		tab.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(tab.getSelectedIndex()==0){
					tableData =initTableData();
					for(int x=0;x<20;x++){
						for(int y=0;y<table.getColumnCount();y++)
						table.setValueAt(tableData[x][y],x,y);
					}
				}
			}
			
		});
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("权限管理");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	
	public void initButton(){
		cancelButton = new JButton("取消");
		saveButton = new JButton("保存");
		cancelButton.setBounds(panelWidth*2/5, panelHeight*13/20, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*6/10,  panelHeight*13/20, panelWidth/10, panelHeight/20);
		writePanel.add(cancelButton);
		writePanel.add(saveButton);
		cancelButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				nameText.setText(null);
				accountText.setText(null);
				identity.setSelectedIndex(0);
				institutionText.setText(null);
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
				
				AccountVO accountInfo=new AccountVO(staffIdentity
												,nameText.getText()
												,accountText.getText()
												,((WritePanel) panel).getBelong());
				RightBLService service=ConstructFactory.RightFactory();
				service.createNewAccount(accountInfo);
			}
		});
		lookCancleButton = new JButton("取消");
		lookSaveButton = new JButton("保存");
		lookCancleButton.setBounds(panelWidth*9/20, panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookSaveButton.setBounds(panelWidth*13/20,  panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookPanel.add(lookCancleButton);
		lookPanel.add(lookSaveButton);
		
	}
	
	public void lookTabel(){
		tableTitle = new String[]{"账号", "姓名", "身份", "机构"};
		tableData = this.initTableData();
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//设置不可调整大小
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(panelWidth/5);
		}
		
		table.getTableHeader().setPreferredSize(new Dimension(10000,panelWidth/20));
		scrollPane = new JScrollPane(table);
		if(tableData.length>9){
			scrollPane.setBounds(panelWidth/40, panelHeight/40, panelWidth*3/4, 10*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/40, panelHeight/40, panelWidth*3/4, (table.getRowCount()+1)*table.getRowHeight());
		}
		scrollPane.setVisible(true);
		lookPanel.add(scrollPane);
	}
	
	public String[][] initTableData(){
		String[][] content =new String[20][8];
//		for(int x=0;x<table.getRowCount();x++)
//			for(int y=0;y<table.getColumnCount();y++)
//				content[x][y]=null;
	
		ArrayList<AccountVO> volist=null;
		RightBLService service=ConstructFactory.RightFactory();
		volist=service.inquireAccount(((WritePanel)panel).getBelong());
		if(volist!=null){
		int counter=0;
		for(AccountVO vo:volist){
			content[counter][0]=vo.getCode();
			content[counter][1]=vo.getAccountName();
			content[counter][2]=vo.getRight().name();
			content[counter][3]=vo.getBelong();
		
			counter++;
		}
		}
		return content;
	}
	
	public void writeTabel(){
		nameLabel = new JLabel("姓名");
		accountLabel= new JLabel("账号");
		identityLabel = new JLabel("身份");
		institutionLabel = new JLabel("机构");
		
		nameText = new JTextField();
		accountText = new JTextField();
		identityString = new String[]{"快递员","营业厅业务员","中转中心业务员","总经理","仓库管理人员","财务人员","管理员"};
		institutionText = new JTextField();
		identity = new JComboBox<String>(identityString);
		
		
		
		nameLabel.setBounds(panelWidth/10, panelHeight/20, panelWidth*3/20, panelHeight/20);
		accountLabel.setBounds(panelWidth/10, panelHeight*3/40+nameLabel.getY(), panelWidth*3/20, panelHeight/20);
		identityLabel.setBounds(panelWidth/10, panelHeight*3/40+accountLabel.getY(), panelWidth*3/20, panelHeight/20);
		institutionLabel.setBounds(panelWidth/10, panelHeight*3/40+identityLabel.getY(), panelWidth*3/20, panelHeight/20);
		
		
		nameText.setBounds(panelWidth/4, panelHeight/20, panelWidth*9/20, panelHeight/20);
		accountText.setBounds(panelWidth/4, panelHeight*3/40+nameText.getY(), panelWidth*9/20, panelHeight/20);
		identity.setBounds(panelWidth/4+panelWidth/10, panelHeight*3/40+accountText.getY()-panelHeight/80, panelWidth*3/40, panelHeight*3/40);
		
		institutionText.setBounds(panelWidth/4, panelHeight*3/40+identity.getY()+panelHeight/80, panelWidth*9/20, panelHeight/20);
		writePanel.add(nameLabel);
		writePanel.add(accountLabel);
		writePanel.add(identityLabel);
		writePanel.add(institutionLabel);
		writePanel.add(nameText);
		writePanel.add(accountText);
		writePanel.add(identity);
		writePanel.add(institutionText);
		
		
	}
}
