package main.presentation.receiptui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.presentation.mainui.MainController;

public class AllOrderPanel {
	
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JTable table;
	private JLabel title;
	private JScrollPane scrollPane;
	private String[] tableTitle;
	private String[][] tableData;
	
	
	public AllOrderPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		initTable();
		title();
		panel.repaint();
	}
	public void title(){
		title = new JLabel("查看全部订单");
		title.setBounds(panelWidth/3, 20, panelWidth/6, 40);
		panel.add(title);
	}
	public void initTable(){
		tableTitle = new String[]{"订单号","寄件人姓名","寄件人住址","寄件人单位","寄件人电话",
				"收件人姓名","收件人住址","收件人单位","收件人电话", "寄件数目","寄件总重","寄件体积"};
		tableData = new String[][]{{"2015", "刘钦", "南大", "南京 大学", "20151561",
				"张田田", "南京小学", "南京小学", "206156", "20", "205","50"},
				{"2015", "刘钦", "南大", "南京 大学", "20151561",
					"张田田", "南京小学", "南京小学", "206156", "20", "205","50"},
					{"2015", "刘钦", "南大", "南京 大学", "20151561",
						"张田田", "南京小学", "南京小学", "206156", "20", "205","50"},
						{"2015", "刘钦", "南大", "南京 大学", "20151561",
							"张田田", "南京小学", "南京小学", "206156", "20", "205","50"}};
		table = new JTable(tableData,tableTitle);
		table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panelWidth/20);//设置列宽
		//table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
    	table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.getTableHeader().setPreferredSize(new Dimension(1000,panelWidth/20));
		table.setVisible(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane = new JScrollPane(table);
		table.setBounds(panelWidth/20, panelHeight/6, panelWidth*2, tableData.length*table.getRowHeight());
		if(tableData.length>=10){
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, 11*table.getRowHeight());		
		}else{
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, (table.getRowCount()+1)*table.getRowHeight());
		}
		panel.add(scrollPane);
	}
}
