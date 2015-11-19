package main.presentation.loadui;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.JButton;
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
	private JLabel loadDateLabel;
	private JTextField loadDate;
	private JButton searchFromDate;//根据日期查询
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
		
		tabbedPane.setSize(panel.getWidth()/6*5+43,panel.getHeight()/6*5);
		tabbedPane.setLocation(panel.getWidth()/18,panel.getHeight()/12);
		panel.add(tabbedPane);
		planeLoadConpo();
		trainLoadConpo();
		carLoadConpo();
		
		
		tabbedPane.repaint();
		panel.repaint();
		
	}
	public void planeLoadConpo(){
		loadDateLabel=new JLabel("装运日期");
		loadDate=new JTextField("请输入装运日期");
		loadDateLabel.setBounds(panel.getWidth()/20,panel.getHeight()/2,panel.getWidth()/20+66,panel.getHeight()/3+20);
		//loadDate.setBounds(panel.getHeight()/20, panel.getWidth()/3+20, panel.getHeight()/20+66, panel.getWidth()/2);
		//panel.add( loadDate);
		panel.add(loadDateLabel);
	}
	
	public void trainLoadConpo(){
		
	}
	
	public void carLoadConpo(){
		
	}
}

