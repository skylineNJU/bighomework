

package main.presentation.rightui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class PasswordInitPanel {
	private JPanel panel;
	private JLabel accountNameLabel;
	private JTextField accountName;
	private JButton submit;
	private JButton cancle;
	private JLabel title;
	private int panelWidth;
	private int panelHeight;
	private JTable table;
	private String[] tableTitle;
	private String[][] tableData;
	private JButton inquireButton;
	private JScrollPane scrollPane;
	
	public PasswordInitPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	public void init(){
		initTitle();
		initLabel();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("密码初始化");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	public void initLabel(){
		tableTitle = new String[]{"职位", "编号", "单位", "姓名", "入职时间"};
		tableData = new String[][]{{"2012", "0606", "026", "刘钦", "2015/02/03"}};
		table = new JTable(tableData, tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(panelWidth/20);//设置列宽
		table.setDragEnabled(false);//设置不可拖动
		table.getTableHeader().setPreferredSize(new Dimension(10000, panelHeight/15));//设置表头高度
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.setEnabled(false);
		scrollPane.setVisible(false);
		accountNameLabel = new JLabel("请输入账户");
		accountName = new JTextField();
		submit = new JButton("初始化");
		cancle = new JButton("取消");
		inquireButton =new JButton("查询");
		
		cancle.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				scrollPane.setVisible(false);
			}
		});
		
		submit.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				scrollPane.setVisible(false);
			}
		});
		
		inquireButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				scrollPane.setVisible(true);
				panel.repaint();
			}
		});
		
		panel.add(accountNameLabel);
		panel.add(accountName);
		panel.add(submit);
		panel.add(cancle);
		panel.add(scrollPane);
		panel.add(inquireButton);
		
		accountNameLabel.setBounds(panelWidth/10, panelHeight*3/10, panelWidth/10, panelHeight/15);
		accountName.setBounds(panelWidth*9/40, accountNameLabel.getY(), panelWidth*11/20, panelHeight/15);
		inquireButton.setBounds(panelWidth*4/5, accountNameLabel.getY(), panelWidth/10, panelHeight/15);
		scrollPane.setBounds(accountNameLabel.getX(), panelHeight*13/30, panelWidth*4/5, panelHeight*2/15);
		cancle.setBounds(panelWidth*3/5, panelHeight*19/30, panelWidth/8, panelHeight/15);
		submit.setBounds(panelWidth*31/40, cancle.getY(), panelWidth/8, panelHeight/15);

	}
	
	public void remove(){		
		panel.remove(accountNameLabel);
		panel.remove(accountName);
		panel.remove(submit);
		panel.remove(cancle);
		panel.remove(scrollPane);
		panel.remove(inquireButton);
	}
}