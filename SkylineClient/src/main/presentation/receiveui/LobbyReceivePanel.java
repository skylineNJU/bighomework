package main.presentation.receiveui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.ReceiveBLService;
import main.businesslogicservice.receiptblService.LobbyReceipt;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.LobbyMemory;
import main.vo.LobbyReceptionVO;

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
	private JLabel yearLabel;//到达日期
	private JLabel monthLabel;//订单号
	private JLabel dayLabel;//中转单编号
	private JLabel conditionLabel;//出发地
	private JLabel barLabel;//到达地
	private JTextField yearText;//到达日期文本框
	private JTextField monthText;//订单号文本框
	private JTextField dayText;//中转单号文本框
	private JTextField conditionText;//出发地文本框
	private JTextField barText;//到达地文本框
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
		tabbedPane.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(tabbedPane.getSelectedIndex()==0){
					initTableData();
					while(tableData.length>table.getRowCount()){
						((DefaultTableModel)table.getModel()). addRow(new String[9]);
					}
					for(int x=0;x<tableData.length;x++)
						for(int y=0;y<3;y++){
							table.setValueAt(tableData[x][y],x,y);
						}
				}
			}
			
		});
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
		
		writeSaveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
			WritePanel wp=(WritePanel)panel;
			LobbyMemory memory=(LobbyMemory) wp.getMemory();
			String code=null;
			
			ReceiptCode service2=ConstructFactory.calculateCode();
			code=service2.calculCode(memory.getReceiveCode(),memory.getUserName());
			
			
			LobbyReceptionVO vo=new LobbyReceptionVO(
					code,
					yearText.getText(),
					monthText.getText(),
					dayText.getText(),
					conditionText.getText(),
					barText.getText()
					);
			vo.setBelong(wp.getBelong());
			ReceiveBLService service=ConstructFactory.ReceiveFactory();
			service.createNewLobbyReception(vo);
			
			memory.setReceiveCode(memory.getReceiveCode()+" "+code);
			System.out.println("receiveCode:"+memory.getReceiveCode());
			memory.setReceiveDate(memory.getReceiveDate()+" "+yearText.getText()+"/"+monthText.getText()+"/"+dayText.getText());
			
			LobbyReceipt service3=ConstructFactory.LobbyReceiptFactory();
			service3.SaveReceiveCode(memory.getUserName(), code);
			}
		});
	}
	//标题
	public void title(){
		title = new JLabel("接收单管理");	
		panel.add(title);
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
	}
	//单据列表
	public void initTableData(){
		WritePanel wp=(WritePanel)panel;
		LobbyMemory memory=(LobbyMemory) wp.getMemory();
		String code=memory.getReceiveCode();
		String codes[]=code.split(" ");
		if(codes.length<11){
			tableData=new String[10][3];
			for(int x=0;x<10;x++)
				for(int y=0;y<3;y++)
					tableData[x][y]=null;
		}else{
			tableData=new String[codes.length-1][3];
			for(int x=0;x<codes.length-1;x++)
				for(int y=0;y<3;y++)
					tableData[x][y]=null;
		}
		
		ReceiveBLService service=ConstructFactory.ReceiveFactory();
		ArrayList<LobbyReceptionVO> voList=service.inquireLobbyReceive(code);
		int x=0;
		for(LobbyReceptionVO vo:voList){
			tableData[x][0]=vo.getReceiveYear()+"/"+vo.getReceiveMonth()+"/"+vo.getReceiveDay();
			tableData[x][1]=vo.getExpressBar();
			tableData[x][2]=vo.getCondition();
			x++;
		}
	}
	
	public void lookTable(){		
		initTableData();
		tableTitle = new String[]{"时间","订单号","状态"};
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
		yearLabel = new JLabel("年份");//到达日期
		monthLabel = new JLabel("月份");//订单号
		dayLabel = new JLabel("日期");//中转单编号
		conditionLabel = new JLabel("损坏情况");//出发地
		barLabel = new JLabel("订单号");//到达地
		yearText = new JTextField();//到达日期文本框
		monthText = new JTextField();//订单号文本框
		dayText = new JTextField();//中转单号文本框
		conditionText = new JTextField();//出发地文本框
		barText = new JTextField();//到达地文本框
		
		
		writePanel.add(yearLabel);
		writePanel.add(monthLabel);
		writePanel.add(dayLabel);
		writePanel.add(conditionLabel);
		writePanel.add(barLabel);
		writePanel.add(yearText);
		writePanel.add(monthText);
		writePanel.add(dayText);
		writePanel.add(conditionText);
		writePanel.add(barText);
		
		yearLabel.setBounds(panelWidth/10, panelHeight/10, panelWidth/8, panelHeight/20);
		monthLabel.setBounds(panelWidth/10, panelHeight/10+yearLabel.getY(), panelWidth/8, panelHeight/20);
		dayLabel.setBounds(panelWidth/10, panelHeight/10+monthLabel.getY(), panelWidth/8, panelHeight/20);
		conditionLabel.setBounds(panelWidth/10, panelHeight/10+dayLabel.getY(), panelWidth/8, panelHeight/20);
		barLabel.setBounds(panelWidth/10, panelHeight/10+conditionLabel.getY(), panelWidth/8, panelHeight/20);
		yearText.setBounds(panelWidth*3/10, panelHeight/10, panelWidth*4/10, panelHeight/20);
		monthText.setBounds(panelWidth*3/10, panelHeight/10+yearText.getY(), panelWidth*4/10, panelHeight/20);
		dayText.setBounds(panelWidth*3/10, panelHeight/10+monthText.getY(), panelWidth*4/10, panelHeight/20);
		conditionText.setBounds(panelWidth*3/10, panelHeight/10+dayText.getY(), panelWidth*4/10, panelHeight/20);
		barText.setBounds(panelWidth*3/10, panelHeight/10+conditionText.getY(), panelWidth*4/10, panelHeight/20);
		
	}
		
}
