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
	private JTabbedPane tabbedPane;//ѡ��ɻ�/��/����
	private JTextField transmitCenterNumber;//��ת���ı�������
	private JLabel  transmitCenterNumberLabel;
    private JLabel  receiptNumberLabel;
    private JTextField receiptNumber;//�������������
    private JLabel receiveDateLabel;
    private JTextField receiveDate;//����ʱ�������
	private JPanel carLoadInfo;
	private JPanel planeLoadInfo;
	private JPanel trainLoadInfo;
	private JLabel loadDateLabel;
	private JTextField loadDate;
	private JButton searchFromDate;//�������ڲ�ѯ
	public LoadVehiclePanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		tabbedPane=new JTabbedPane(JTabbedPane.TOP);//�������Ϸ�ѡ��
		carLoadInfo=new JPanel();
		planeLoadInfo=new JPanel();
		trainLoadInfo=new JPanel();
		
		carLoadInfo.setBackground(Color.red);
		planeLoadInfo.setBackground(Color.pink);
		trainLoadInfo.setBackground(Color.orange);
		
		carLoadInfo.setLayout(null);
		planeLoadInfo.setLayout(null);
		trainLoadInfo.setLayout(null);
		
		tabbedPane.addTab("�ɻ�װ��",planeLoadInfo);
		tabbedPane.addTab("��װ��",trainLoadInfo);
		tabbedPane.addTab("����װ��",carLoadInfo);
		
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
		loadDateLabel=new JLabel("װ������");
		loadDate=new JTextField("������װ������");
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

