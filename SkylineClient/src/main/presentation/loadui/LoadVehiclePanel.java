package main.presentation.loadui;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class LoadVehiclePanel {
	private JPanel panel;
	private JTabbedPane tabbedPane;//选择飞机/火车/汽车
	private JTextField transmitCenterNumber;//中转中心编号输入框
	private JLabel  transmitCenterNumberLabel;
    private JLabel  receiptNumberLabel;
    private JTextField receiptNumber;//订单单号输入框
    private JLabel receiveDateLabel;
    private JTextField receiveDate;//接收时间输入框
	private JPanel carLoadInfo;
	private JPanel planeLoadInfo;
	private JPanel trainLoadInfo;
	public LoadVehiclePanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		tabbedPane=new JTabbedPane(JTabbedPane.TOP);//设置在上方选择
		carLoadInfo=new JPanel();
		planeLoadInfo=new JPanel();
		trainLoadInfo=new JPanel();
		
		carLoadInfo.setBackground(Color.red);
		planeLoadInfo.setBackground(Color.pink);
		trainLoadInfo.setBackground(Color.orange);
		
		carLoadInfo.setLayout(null);
		planeLoadInfo.setLayout(null);
		trainLoadInfo.setLayout(null);
		
		tabbedPane.addTab("飞机装运",planeLoadInfo);
		tabbedPane.addTab("火车装运",trainLoadInfo);
		tabbedPane.addTab("汽车装运",carLoadInfo);
		
		tabbedPane.setSize(panel.getWidth()/4*3,panel.getHeight()/4*3);
		
		tabbedPane.setLocation(panel.getWidth()/8,panel.getHeight()/8);
		panel.add(tabbedPane);
		planeLoadConpo();
		trainLoadConpo();
		carLoadConpo();
		
		
		tabbedPane.repaint();
		panel.repaint();
		
	}
	public void planeLoadConpo(){
		transmitCenterNumberLabel=new JLabel("中转中心编号");
		transmitCenterNumber=new JTextField("请输入中转中心编号");
		transmitCenterNumberLabel.setBounds(100,100,50,50);
		transmitCenterNumber.setBounds(100, 100, 100, 100);
		panel.add( transmitCenterNumber);
		panel.add(transmitCenterNumberLabel);
	}
	
	public void trainLoadConpo(){
		
	}
	
	public void carLoadConpo(){
		
	}
}

