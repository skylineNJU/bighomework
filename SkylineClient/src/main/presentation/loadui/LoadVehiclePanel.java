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
		transmitCenterNumberLabel=new JLabel("��ת���ı��");
		transmitCenterNumber=new JTextField("��������ת���ı��");
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

