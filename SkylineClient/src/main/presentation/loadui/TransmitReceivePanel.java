package main.presentation.loadui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.businesslogic.receiptbl.IntermediateReceiptCode;
import main.businesslogicservice.InfoBLService;
import main.businesslogicservice.ReceiveBLService;
import main.businesslogicservice.receiptblService.IntermediateReceipt;
import main.businesslogicservice.receiptblService.LobbyReceipt;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.IntermediateMemory;
import main.presentation.mainui.memory.LobbyMemory;
import main.vo.DriverVO;
import main.vo.TransitReceptionVO;

public class TransmitReceivePanel {
private JPanel panel;//大的
private JPanel innerPanel;//小的
private JLabel title;
private JButton saveButton;
private JButton delButton;
private JLabel transmitCenterNumLabel;//中转中心编号标签
private JLabel orderNumLabel;
private JLabel receiveTimeLabel;
private JTextField transmitCenterNum;
private JTextField orderNum;
private JLabel yearLabel;
private JLabel monthLabel;
private JLabel dayLabel;//年月日标签
private JComboBox<String> yearBox;//表示年份的组合框
private JComboBox<String> monthBox;//表示月份的组合框
private JComboBox<String> dayBox;//表示天的组合框
int year;
private String[] yearString;
private String[] monthString;
private String[] dayString;//31天


int panelWidth=0;
int panelHeight=0;
	public TransmitReceivePanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth=panel.getWidth();
		panelHeight=panel.getHeight();
	}
	public void init(){
		
		innerPanel=new JPanel();
		
		innerPanel.setBackground(Color.gray);
		innerPanel.setSize(panel.getWidth()/5*4+20,panel.getHeight()/5*4);
		
		innerPanel.setLocation(panel.getWidth()/8-25,panel.getHeight()/8-16);
		panel.add(innerPanel);
		innerPanel.setLayout(null);
		addTitle();
		addElements();
		setTime();
		panel.repaint();
		
	}
	public void addTitle(){
		title=new JLabel("中转接收");
		title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
		innerPanel.add(title);
	}
	public void addElements(){
		transmitCenterNumLabel=new JLabel("中转中心编号");
		orderNumLabel=new JLabel("订单单号");
		receiveTimeLabel=new JLabel("接收时间");
		transmitCenterNum=new JTextField("请输入中转中心编号");
		receiveTimeLabel.setSize(panelWidth*20/69,panelWidth*10/69);
		receiveTimeLabel.setLocation(panelWidth*3/69,panelHeight*185/550);
		orderNumLabel.setSize(panelWidth*20/69,panelWidth*10/69);
		orderNumLabel.setLocation(panelWidth*3/69,panelHeight*185/550+panelHeight*185/550-panelHeight/2-panelHeight/7+panelHeight*105/550);
		orderNum=new JTextField("请输入订单单号");
		orderNum.setSize(panelWidth*20/69,panelHeight*35/550);
		orderNum.setLocation(panelWidth/2-panelWidth*24/69,panelHeight*2/5+panelHeight*185/550-panelHeight/2-panelHeight/7+panelHeight*105/550);
		transmitCenterNumLabel.setSize(panelWidth*20/69,panelWidth*10/69);
		transmitCenterNumLabel.setLocation(panelWidth*3/69,panelHeight*185/550+(panelHeight*185/550-panelHeight/2-panelHeight/7+panelHeight*105/550)*2);
		transmitCenterNum.setSize(panelWidth*20/69,panelHeight*35/550);
		transmitCenterNum.setLocation(panelWidth/2-panelWidth*24/69,panelHeight*2/5+2*(panelHeight*185/550-panelHeight/2-panelHeight/7+panelHeight*105/550));
		
		delButton = new JButton("删除");
		saveButton = new JButton("保存");
		delButton.setBounds(panelWidth*3/5, panelHeight*9/10, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*3/5+delButton.getWidth()*2, panelHeight*9/10, panelWidth/10, panelHeight/20);
		
		panel.add(delButton);
		panel.add(saveButton);
		innerPanel.add(transmitCenterNumLabel);
		innerPanel.add(transmitCenterNum);
		innerPanel.add(orderNum);
		innerPanel.add(receiveTimeLabel);
		innerPanel.add(orderNumLabel);
		
		delButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				transmitCenterNum.setText(null);
				orderNum.setText(null);
				yearBox.setSelectedItem(null);
				monthBox.setSelectedItem(null);
				dayBox.setSelectedItem(null);
			}
		});
		
		saveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				ReceiveBLService service=ConstructFactory.ReceiveFactory();
				String code=null;
				IntermediateMemory memory=(IntermediateMemory) ((WritePanel)panel).getMemory();
				String codeList=memory.getIntermReceiptCode();
				String userName=memory.getUserName();
				ReceiptCode service2=ConstructFactory.calculateCode();
				code=service2.calculCode(codeList, userName);
				memory.setIntermReceiptCode(memory.getIntermReceiptCode()+" "+code);
				System.out.println("-------"+code);
				TransitReceptionVO transitReceptionInfo=new TransitReceptionVO(Integer.parseInt((String)yearBox.getSelectedItem())
												,Integer.parseInt((String)monthBox.getSelectedItem())
												,Integer.parseInt((String)dayBox.getSelectedItem())
												,transmitCenterNum.getText()
												,orderNum.getText()											
												,code);
				service.createNewTransitReception(transitReceptionInfo);
				IntermediateReceipt receiptService=ConstructFactory.IntermediateFactory();
				receiptService.saveIntermReceiptCode(userName, code);
			}
		});
		
		
	}
	public void remove(){
		
		
		
	}
	
	
	public void setTime(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		yearLabel = new JLabel("年");
		monthLabel = new JLabel("月");
		dayLabel = new JLabel("日");
		
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		yearBox = new JComboBox<String>(yearString);
		yearBox.setSize(panelWidth*20/69,panelHeight*35/550);
		yearBox.setLocation(panelWidth*7/46,panelHeight*2/5);
		yearLabel.setSize(panelWidth*20/69,panelWidth*10/69);
		yearLabel.setLocation(panelWidth*45/690+panelWidth*29/69,panelHeight*185/550);
		monthBox = new JComboBox<String>(monthString);
		monthBox.setSize(panelWidth*20/69,panelHeight*35/550);
		monthBox.setLocation(panelWidth*105/690,panelHeight*567/1100);
		monthLabel.setSize(panelWidth*20/69,panelWidth*10/69);
		monthLabel.setLocation(panelWidth*45/690+panelWidth*29/69,panelHeight/2+panelHeight/7-panelHeight*105/550);
		dayBox = new JComboBox<String>(dayString);
		dayBox.setSize(panelWidth*20/69,panelHeight*35/550);
		dayBox.setLocation(panelWidth/2-panelWidth*24/69,panelHeight/2+panelHeight/7+panelHeight/7-panelHeight*85/550);
		dayLabel.setSize(panelWidth*20/69,panelWidth*10/69);
		dayLabel.setLocation(panelWidth/2-panelWidth*10/23+panelWidth*29/69,panelHeight/2+panelHeight/7+panelHeight/7-panelHeight*12/55);
		
	
		innerPanel.add(yearLabel);
		innerPanel.add(monthLabel);
		innerPanel.add(dayLabel);
		innerPanel.add(yearBox);
		innerPanel.add(monthBox);
		innerPanel.add(dayBox);
	}
}
