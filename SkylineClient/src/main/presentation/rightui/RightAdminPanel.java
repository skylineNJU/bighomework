package main.presentation.rightui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class RightAdminPanel {
	private JPanel panel;
	private JLabel title;
	private int panelWidth;
	private int panelHeight;
	private JTable table;
	private JScrollPane scrollPane;
	private String[] tableTitle;
	private String[][] tableData;
	private JLabel inquireLabel;
	private JTextField inquireText;
	private JButton inquireButton;
	private JButton ensureButton;
	private JButton cancleButton;
	private JButton newButton;
	//新建账户信息
	private JLabel name;

	
	public RightAdminPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		initTitle();
		initTable();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("权限管理");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	public void initTable(){
		tableTitle = new String[]{"账号", "姓名", "身份"};
		tableData = new String[][]{{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},
				{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},
				{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},
				{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"},{"260", "刘钦", "快递员"}};
		
		inquireLabel = new JLabel("请输入账户");
		inquireText = new JTextField();
		inquireButton = new JButton("确认");
		ensureButton = new JButton("修改");
		cancleButton = new JButton("取消");
		newButton=new JButton("新建");
		
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(panelWidth/20);//设置列宽
		table.setDragEnabled(false);//设置不可拖动
		table.getTableHeader().setPreferredSize(new Dimension(100, panelWidth/20));//设置表头高度
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/10, panelHeight/5, panelWidth*4/5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/10, panelHeight/5, panelWidth*4/5, 10*table.getRowHeight());
		}		
		panel.add(scrollPane);
		panel.add(inquireLabel);
		panel.add(inquireText);
		panel.add(inquireButton);
		panel.add(ensureButton);
		panel.add(cancleButton);
		panel.add(newButton);
		
		inquireLabel.setBounds(panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		inquireText.setBounds(panelWidth/4, panelHeight/10, panelWidth*9/20, panelHeight/20);
		inquireButton.setBounds(panelWidth*4/5, panelHeight/10, panelWidth/10, panelHeight/20);
		ensureButton.setBounds(panelWidth*4/5, 12*table.getRowHeight()+panelHeight/8+table.getY(), panelWidth/10, panelHeight/20);
		cancleButton.setBounds(panelWidth*3/5, 12*table.getRowHeight()+panelHeight/8+table.getY(), panelWidth/10, panelHeight/20);
		newButton.setBounds(panelWidth*2/5,12*table.getRowHeight()+panelHeight/8+table.getY() , panelWidth/10, panelHeight/20);
	}
	
	
	public void remove(){
		panel.remove(title);
		panel.remove(scrollPane);
		panel.remove(inquireLabel);
		panel.remove(inquireText);
		panel.remove(inquireButton);
		panel.remove(ensureButton);
		panel.remove(cancleButton);
	}
	
	
}
