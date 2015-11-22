package main.presentation.receiveui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

//营业厅接收单
public class LobbyReceivePanel {
	
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JLabel title;
	private JTabbedPane tabbedPane;
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton cancleButton;
	private JButton saveButton;
	private JPanel lookPanel;//查看接收单
	private JPanel writePanel;//填写接收单
	private JLabel arriveLabel;//到达日期
	private JLabel orderCode;//订单号
	private JLabel trainsCode;//中转单编号
	private JLabel startPlace;//出发地
	private JLabel endPlace;//到达地
	private JTextField arriveText;//到达日期文本框
	private JTextField orderCodeText;//订单号文本框
	private JTextField trainsCodeText;//中转单号文本框
	private JTextField startText;//出发地文本框
	private JTextField endText;//到达地文本框
	private JButton writeCancleButton;//取消按钮
	private JButton writeSaveButton;//保存按钮
	
	public LobbyReceivePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}

	public void init(){
		lookPanel = new JPanel();
		lookPanel.setLayout(null);
		writePanel = new JPanel();
		writePanel.setLayout(null);
		lookTable();
		writeTable();
		initButton();
		tabbedPane=new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane);
		tabbedPane.setBounds(panelWidth/10, panelHeight/10, panelWidth*4/5, panelHeight*4/5);
		tabbedPane.add("查看接收单",lookPanel);
		tabbedPane.add("填写接收单",writePanel);
		tabbedPane.setVisible(true);
		title();
		panel.repaint();
	}
	
	public void initButton(){
		cancleButton = new JButton("取消");
		saveButton = new JButton("保存");
		lookPanel.add(cancleButton);
		lookPanel.add(saveButton);
		cancleButton.setBounds(panelWidth/2+panelWidth/50, panelHeight*27/40, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*13/20+panelWidth/50, panelHeight*27/40, panelWidth/10, panelHeight/20);
		writeCancleButton = new JButton("取消");//取消按钮
		writeSaveButton = new JButton("保存");//保存按钮
		writePanel.add(writeCancleButton);
		writePanel.add(writeSaveButton);
		writeCancleButton.setBounds(panelWidth*2/5, panelHeight*5/8, panelWidth/10, panelHeight/20);
		writeSaveButton.setBounds(panelWidth*6/10,  panelHeight*5/8, panelWidth/10, panelHeight/20);
	}
	//标题
	public void title(){
		title = new JLabel("接收单管理");	
		panel.add(title);
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
	}
	//单据列表
	public void lookTable(){		
		tableTitle = new String[]{"ID","时间","接收单号","类型","状态"};
		tableData = new String[][]{{"20152","2015/03/15","209090","普通","损坏"},{"20152","2015/03/15","209090","普通","损坏"},
				{"20152","2015/03/15","209090","普通","损坏"},{"20152","2015/03/15","209090","普通","损坏"},
				{"20152","2015/03/15","209090","普通","损坏"},{"20152","2015/03/15","209090","普通","损坏"},
				{"20152","2015/03/15","209090","普通","损坏"},{"20152","2015/03/15","209090","普通","损坏"},
				{"20152","2015/03/15","209090","普通","损坏"},{"20152","2015/03/15","209090","普通","损坏"},
				{"20152","2015/03/15","209090","普通","损坏"},{"20152","2015/03/15","209090","普通","损坏"},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
		};
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setDragEnabled(false);
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		lookPanel.add("查看接收单",scrollPane);
		if(tableData.length>9){
			scrollPane.setBounds(panelWidth/50, panelHeight/50, panelWidth*19/25, 10*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/50, panelHeight/50, panelWidth*19/25, (table.getRowCount()+1)*table.getRowHeight());
		}
		scrollPane.setVisible(true);
	}
	//
	public void writeTable(){
		arriveLabel = new JLabel("到达日期");//到达日期
		orderCode = new JLabel("订单号");//订单号
		trainsCode = new JLabel("中转单编号");//中转单编号
		startPlace = new JLabel("出发地");//出发地
		endPlace = new JLabel("到达地");//到达地
		arriveText = new JTextField();//到达日期文本框
		orderCodeText = new JTextField();//订单号文本框
		trainsCodeText = new JTextField();//中转单号文本框
		startText = new JTextField();//出发地文本框
		endText = new JTextField();//到达地文本框
		
		writePanel.add(arriveLabel);
		writePanel.add(orderCode);
		writePanel.add(trainsCode);
		writePanel.add(startPlace);
		writePanel.add(endPlace);
		writePanel.add(arriveText);
		writePanel.add(orderCodeText);
		writePanel.add(trainsCodeText);
		writePanel.add(startText);
		writePanel.add(endText);
		
		arriveLabel.setBounds(panelWidth/10, panelHeight/10, panelWidth/8, panelHeight/20);
		orderCode.setBounds(panelWidth/10, panelHeight/10+arriveLabel.getY(), panelWidth/8, panelHeight/20);
		trainsCode.setBounds(panelWidth/10, panelHeight/10+orderCode.getY(), panelWidth/8, panelHeight/20);
		startPlace.setBounds(panelWidth/10, panelHeight/10+trainsCode.getY(), panelWidth/8, panelHeight/20);
		endPlace.setBounds(panelWidth/10, panelHeight/10+startPlace.getY(), panelWidth/8, panelHeight/20);
		arriveText.setBounds(panelWidth*3/10, panelHeight/10, panelWidth*4/10, panelHeight/20);
		orderCodeText.setBounds(panelWidth*3/10, panelHeight/10+arriveText.getY(), panelWidth*4/10, panelHeight/20);
		trainsCodeText.setBounds(panelWidth*3/10, panelHeight/10+orderCodeText.getY(), panelWidth*4/10, panelHeight/20);
		startText.setBounds(panelWidth*3/10, panelHeight/10+trainsCodeText.getY(), panelWidth*4/10, panelHeight/20);
		endText.setBounds(panelWidth*3/10, panelHeight/10+startText.getY(), panelWidth*4/10, panelHeight/20);
		
	}
		
}
