package main.presentation.distributeui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.businesslogicservice.DistributeBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.CourrierMemory;
import main.vo.DistributeVO;

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
		getData();
		panel.repaint();
	}
	
	public void getData(){
		int counter = 0;
		DistributeBLService distributeController = ConstructFactory.DistributeFactory();
		CourrierMemory memory=(CourrierMemory) ((WritePanel)panel).getMemory();
		ArrayList<DistributeVO> voList = distributeController.showDistributeList(memory.getUserName());
		int length=0;
		if(voList.size()<10){
			length=10;
		}else{
			length=voList.size();
		}
		
		tableData = new String[length][4];
		for(int x=0;x<length;x++)
			for(int y=0;y<4;y++)
				tableData[x][y]=null;
		System.out.println("get distributeData---------------");
		
		for(DistributeVO distributeVO:voList){
			tableData[counter][0] = distributeVO.getName();
			tableData[counter][1] = distributeVO.getAdress();
			tableData[counter][2] = distributeVO.getPhoneNumber();
			tableData[counter][3] = distributeVO.getOrderCode();
			counter++;
		}
	}
	//初始化表格
	public void initTable(){
		tableTitle = new String[]{"收件人姓名","收件人地址","收件手机","订单号"};
		getData();
		table = new JTable(tableData,tableTitle);
		table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(true);//表头不可移动
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		if(tableData.length>=10){
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, 11*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, (table.getRowCount()+1)*table.getRowHeight());
		}
		table.getColumnModel().getColumn(3).setPreferredWidth(scrollPane.getWidth()/3);;
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
