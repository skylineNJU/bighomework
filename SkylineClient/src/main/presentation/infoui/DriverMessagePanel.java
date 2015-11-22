package main.presentation.infoui;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class DriverMessagePanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	//按钮组件
	private JButton cancleButton;
	private JButton saveButton;
	private JButton lookCancleButton;
	private JButton lookSaveButton;
	//lookPanel上的组件
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	//writePanel上的组件
	private JLabel driverCodeLabel;//司机编号
	private JLabel driverNameLabel;//司机姓名
	private JLabel driverSexLabel;//司机性别
	private JLabel driverBirthLabel;//司机生日
	private JLabel idCodeLabel;//身份证号
	private JLabel driverPhoneLabel;//司机手机号
	private JLabel carUnitLabel;//车辆单位
	private JLabel licenseDataLabel;//驾驶证截止日期
	private JTextField driverCodeText;
	private JTextField driverNameText;
	private JCheckBox driverSex1;
	private JCheckBox driverSex2;
	private JTextField driverBirthText;
	private JTextField idCodeText;
	private JTextField driverPhoneText;
	private JTextField carUnitText;
	private JTextField licenseDataText;
	private ButtonGroup buttonGroup;
	
	private JLabel title;
	private JPanel lookPanel;//查看接收单
	private JPanel writePanel;//填写接收单
	private JTabbedPane tab;
	public DriverMessagePanel(){
		panel = MainController.getWritepanel();
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
		initButton();//初始化按钮
		lookTabel();//初始化查看司机面板
		writeTabel();//初始化填写信息面板
		tab = new JTabbedPane();
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.add("查看司机信息",lookPanel);
		tab.add("新增司机信息",writePanel);
		panel.add(tab);
		tab.setBounds(panelWidth/10, panelHeight/10, panelWidth*4/5, panelHeight*4/5);
		tab.setVisible(true);
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("司机信息管理");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	
	public void initButton(){
		cancleButton = new JButton("取消");
		saveButton = new JButton("保存");
		cancleButton.setBounds(panelWidth*2/5, panelHeight*13/20, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*6/10,  panelHeight*13/20, panelWidth/10, panelHeight/20);
		writePanel.add(cancleButton);
		writePanel.add(saveButton);
		lookCancleButton = new JButton("取消");
		lookSaveButton = new JButton("保存");
		lookCancleButton.setBounds(panelWidth*9/20, panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookSaveButton.setBounds(panelWidth*13/20,  panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookPanel.add(lookCancleButton);
		lookPanel.add(lookSaveButton);
	}
	
	public void lookTabel(){
		tableTitle = new String[]{"司机编号", "司机姓名", "司机性别", "司机生日", "身份证号", "联系方式", "车辆单位", "行驶证截止日期"};
		tableData = new String[][]{{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "刘钦", "女", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"}
		};
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//设置不可调整大小
		for(int i = 0;i<8;i++){
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
	
	public void writeTabel(){
		driverCodeLabel = new JLabel("司机编号");//司机编号
		driverNameLabel = new JLabel("司机姓名");//司机姓名
		driverSexLabel = new JLabel("司机性别");//司机性别
		driverBirthLabel = new JLabel("司机生日");//司机生日
		idCodeLabel = new JLabel("身份证号");//身份证号
		driverPhoneLabel = new JLabel("联系方式");//司机手机号
		carUnitLabel = new JLabel("车辆单位");//车辆单位
		licenseDataLabel = new JLabel("行驶证截止日期");//驾驶证截止日期
		driverCodeText = new JTextField();
		driverNameText = new JTextField();
		driverSex1 = new JCheckBox("男");
		driverSex2 = new JCheckBox("女");
		driverBirthText = new JTextField();
		idCodeText = new JTextField();
		driverPhoneText = new JTextField();
		carUnitText = new JTextField();
		licenseDataText = new JTextField();
		buttonGroup = new ButtonGroup();
		buttonGroup.add(driverSex1);
		buttonGroup.add(driverSex2);
		
		writePanel.add(driverCodeLabel);
		writePanel.add(driverNameLabel);
		writePanel.add(driverSexLabel);
		writePanel.add(driverBirthLabel);
		writePanel.add(idCodeLabel);
		writePanel.add(driverPhoneLabel);
		writePanel.add(carUnitLabel);
		writePanel.add(licenseDataLabel);
		writePanel.add(driverCodeText);
		writePanel.add(driverNameText);
		writePanel.add(driverSex1);
		writePanel.add(driverSex2);
		writePanel.add(driverBirthText);
		writePanel.add(idCodeText);
		writePanel.add(driverPhoneText);
		writePanel.add(carUnitText);
		writePanel.add(licenseDataText);
		
		driverCodeLabel.setBounds(panelWidth/10, panelHeight/20, panelWidth*3/20, panelHeight/20);
		driverNameLabel.setBounds(panelWidth/10, panelHeight*3/40+driverCodeLabel.getY(), panelWidth*3/20, panelHeight/20);
		driverSexLabel.setBounds(panelWidth/10, panelHeight*3/40+driverNameLabel.getY(), panelWidth*3/20, panelHeight/20);
		driverBirthLabel.setBounds(panelWidth/10, panelHeight*3/40+driverSexLabel.getY(), panelWidth*3/20, panelHeight/20);
		idCodeLabel.setBounds(panelWidth/10, panelHeight*3/40+driverBirthLabel.getY(), panelWidth*3/20, panelHeight/20);
		driverPhoneLabel.setBounds(panelWidth/10, panelHeight*3/40+idCodeLabel.getY(), panelWidth*3/20, panelHeight/20);
		carUnitLabel.setBounds(panelWidth/10, panelHeight*3/40+driverPhoneLabel.getY(), panelWidth*3/20, panelHeight/20);
		licenseDataLabel.setBounds(panelWidth/10, panelHeight*3/40+carUnitLabel.getY(), panelWidth*3/20, panelHeight/20);
		
		driverCodeText.setBounds(panelWidth/4, panelHeight/20, panelWidth*9/20, panelHeight/20);
		driverNameText.setBounds(panelWidth/4, panelHeight*3/40+driverCodeText.getY(), panelWidth*9/20, panelHeight/20);
		
		driverSex1.setBounds(panelWidth/4+panelWidth/10, panelHeight*3/40+driverNameText.getY()-panelHeight/80, panelWidth*3/40, panelHeight*3/40);
		driverSex2.setBounds(panelWidth/4+panelWidth*13/40, panelHeight*3/40+driverNameText.getY()-panelHeight/80, panelWidth*3/40, panelHeight*3/40);
		
		driverBirthText.setBounds(panelWidth/4, panelHeight*3/40+driverSex1.getY()+panelHeight/80, panelWidth*9/20, panelHeight/20);
		idCodeText.setBounds(panelWidth/4, panelHeight*3/40+driverBirthText.getY(), panelWidth*9/20, panelHeight/20);
		driverPhoneText.setBounds(panelWidth/4, panelHeight*3/40+idCodeText.getY(), panelWidth*9/20, panelHeight/20);
		carUnitText.setBounds(panelWidth/4, panelHeight*3/40+driverPhoneText.getY(), panelWidth*9/20, panelHeight/20);
		licenseDataText.setBounds(panelWidth/4, panelHeight*3/40+carUnitText.getY(), panelWidth*9/20, panelHeight/20);
		
	}
}
