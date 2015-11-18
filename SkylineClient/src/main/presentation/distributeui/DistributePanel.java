package main.presentation.distributeui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.presentation.mainui.MainController;

public class DistributePanel {

	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JLabel title;//标题
	private JScrollPane scrollPane;
	private JTable table;
	private String[] tableTitle;
	private String[][] tableData;
	
	public DistributePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		initTable();
		panel.repaint();
	}
	//初始化表格
	public void initTable(){
		tableTitle = new String[]{"日期","派送地址","收件人","手机号"};
		tableData = new String[][]{{"2015/02/26","南京大学","刘钦", "132626165"},{"2015/02/26","南京大学","刘钦", "132626165"},
				{"2015/02/26","南京大学","刘钦", "132626165"},{"2015/02/26","南京大学","刘钦", "132626165"},
				{"2015/02/26","南京大学","刘钦", "132626165"},{"2015/02/26","南京大学","刘钦", "132626165"},
				{"2015/02/26","南京大学","刘钦", "132626165"},{"2015/02/26","南京大学","刘钦", "132626165"},
				{"2015/02/26","南京大学","刘钦", "132626165"},{"2015/02/26","南京大学","刘钦", "132626165"},
				{"2015/02/26","南京大学","刘钦", "132626165"},{"2015/02/26","南京大学","刘钦", "132626165"},
				{"2015/02/26","南京大学","刘钦", "132626165"},{"2015/02/26","南京大学","刘钦", "132626165"},
				{"2015/02/26","南京大学","刘钦", "132626165"},{"2015/02/26","南京大学","刘钦", "132626165"},
				{"2015/02/26","南京大学","刘钦", "132626165"},{"2015/02/26","南京大学","刘钦", "132626165"}};
		table = new JTable(tableData,tableTitle);
		table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		if(tableData.length>=10){
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, 11*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, (table.getRowCount()+1)*table.getRowHeight());
		}
		table.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/3);;
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane.setVisible(true);
		panel.add(scrollPane);
	}
	//标题
	public void title(){
		title = new JLabel("查看被分配任务");
		title.setBounds(panelWidth/3, 20, panelWidth/6, 40);
		panel.add(title);
	}
}
