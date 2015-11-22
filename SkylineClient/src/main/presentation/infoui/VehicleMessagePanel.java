package main.presentation.infoui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class VehicleMessagePanel {
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
	private JLabel vehicleCode;//车辆号
	private JLabel engineCode;//发动机号
	private JLabel chassisCode;//底盘号
	private JLabel buyTime;//购买时间
	private JLabel serviceTime;//服役时间
	private JTextField vehicleCodeText;
	private JTextField engineCodeText;
	private JTextField chassisCodeText;
	private JTextField buyTimeText;
	private JTextField serviceTimeText;
	
	private JLabel title;
	private JPanel lookPanel;//查看接收单
	private JPanel writePanel;//填写接收单
	private JTabbedPane tab;
	public VehicleMessagePanel(){
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
		tab.add("查看车辆信息",lookPanel);
		tab.add("新增车辆信息",writePanel);
		panel.add(tab);
		tab.setBounds(panelWidth/10, panelHeight/10, panelWidth*4/5, panelHeight*4/5);
		tab.setVisible(true);
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("车辆信息管理");
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
		tableTitle = new String[]{"车辆代号", "发动机号", "底盘号", "购买时间", "服役时间"};
		tableData = new String[][]{{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"}
		};
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.getTableHeader().setPreferredSize(new Dimension(1000,panelWidth/20));
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
		vehicleCode = new JLabel("车辆号");//车辆号
		engineCode = new JLabel("发动机号");//发动机号
		chassisCode = new JLabel("底盘号");//底盘号
		buyTime = new JLabel("购买时间");//购买时间
		serviceTime = new JLabel("服役时间");//服役时间
		vehicleCodeText = new JTextField();
		engineCodeText = new JTextField();
		chassisCodeText = new JTextField();
		buyTimeText = new JTextField();
		serviceTimeText = new JTextField();
		
		writePanel.add(vehicleCode);
		writePanel.add(engineCode);
		writePanel.add(chassisCode);
		writePanel.add(buyTime);
		writePanel.add(serviceTime);
		writePanel.add(vehicleCodeText);
		writePanel.add(engineCodeText);
		writePanel.add(chassisCodeText);
		writePanel.add(buyTimeText);
		writePanel.add(serviceTimeText);
		
		vehicleCode.setBounds(panelWidth/20, panelHeight/20, panelWidth/10, panelHeight/15);
		engineCode.setBounds(panelWidth/20, panelHeight/8+vehicleCode.getY(), panelWidth/10, panelHeight/15);
		chassisCode.setBounds(panelWidth/20, panelHeight/8+engineCode.getY(), panelWidth/10, panelHeight/15);
		buyTime.setBounds(panelWidth/20, panelHeight/8+chassisCode.getY(), panelWidth/10, panelHeight/15);
		serviceTime.setBounds(panelWidth/20, panelHeight/8+buyTime.getY(), panelWidth/10, panelHeight/15);
		vehicleCodeText.setBounds(panelWidth/5, panelHeight/20, panelWidth/2, panelHeight/15);
		engineCodeText.setBounds(panelWidth/5, panelHeight/8+vehicleCode.getY(), panelWidth/2, panelHeight/15);
		chassisCodeText.setBounds(panelWidth/5, panelHeight/8+engineCode.getY(), panelWidth/2, panelHeight/15);
		buyTimeText.setBounds(panelWidth/5, panelHeight/8+chassisCode.getY(), panelWidth/2, panelHeight/15);
		serviceTimeText.setBounds(panelWidth/5, panelHeight/8+buyTime.getY(), panelWidth/2, panelHeight/15);
	}

}
