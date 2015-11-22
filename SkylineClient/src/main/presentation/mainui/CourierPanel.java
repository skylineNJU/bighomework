package main.presentation.mainui;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.presentation.distributeui.Distributeui;
import main.presentation.receiptui.Receiptui;
import main.presentation.receiveui.ReceiveController;
import main.presentation.receiveui.Receiveui;
import main.presentation.rightui.Rightui;
import main.presentation.rightui.RightuiController;

@SuppressWarnings("serial")

public class CourierPanel extends GuidePanel {

	private JButton modifyPassWordButton = new JButton("�޸�����");
	private JButton orderInput=new JButton("��������");
	private JButton receiveInput=new JButton("�ռ���Ϣ����");
	private JButton showOrder=new JButton("�����鿴");
	private JButton showTask=new JButton("����鿴");
	private JButton back=new JButton("ע��");
	private JPanel panel;
	
	public CourierPanel(){
		panel = FrameMain.getContentPanel();
		this.setLayout(null);
	}
	
	public void init(){
		
		this.add(modifyPassWordButton);
		this.add(orderInput);
		this.add(receiveInput);
		this.add(showOrder);
		this.add(showTask);//�鿴����
		this.add(back);
		
		modifyPassWordButton.setSize(this.getWidth()/4*3,this.getHeight()/15);
		orderInput.setSize(this.getWidth()/4*3,this.getHeight()/15);
		receiveInput.setSize(this.getWidth()/4*3,this.getHeight()/15);
		showOrder.setSize(this.getWidth()/4*3,this.getHeight()/15);
		showTask.setSize(this.getWidth()/4*3,this.getHeight()/15);
		back.setSize(this.getWidth()/4*3,this.getHeight()/15);
		
		modifyPassWordButton.setLocation((this.getWidth()-orderInput.getWidth())/2
				,this.getHeight()/4*1);
		orderInput.setLocation((this.getWidth()-orderInput.getWidth())/2
				,modifyPassWordButton.getY()+modifyPassWordButton.getHeight()*3/2);
		receiveInput.setLocation((this.getWidth()-orderInput.getWidth())/2
				,orderInput.getY()+orderInput.getHeight()*3/2);
		showOrder.setLocation((this.getWidth()-orderInput.getWidth())/2
				,receiveInput.getY()+receiveInput.getHeight()*3/2);
		showTask.setLocation((this.getWidth()-orderInput.getWidth())/2
				,showOrder.getY()+showOrder.getHeight()*3/2);
		back.setLocation((this.getWidth()-orderInput.getWidth())/2
				,showTask.getY()+showTask.getHeight()*3/2);
		
		//�޸��������
		modifyPassWordButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToRightui(Rightui.ModifyPassWord);
			}
		});
		//������������Ľ���
		orderInput.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToReceiveui(Receiveui.OrderInput);
			}
		});
		//�ռ���Ϣ����
		receiveInput.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToDistributeui(Distributeui.ReceiveMessageui);
			}
		});
		//��ʾ����
		showOrder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToReceiptui(Receiptui.AllOrderui);
			}
		});
		//�鿴����������
		showTask.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToDistributeui(Distributeui.DistributeListui);
			}
		});
		
		//���ص�½����
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				panel.repaint();
				MainController.jumpToRightui(Rightui.Login);
			}
		});
		
		panel.add(this);	
		panel.repaint();
		this.repaint();
		this.setVisible(true);
	}

	public void remove(){
		this.removeAll();
		panel.remove(this);
		MainController.getWritepanel().removeAll();
		panel.remove(MainController.getWritepanel());
	}
	
	//��ת��ģ����������ǰ���Ƴ����е����
	public void removeAllComponent(){
		MainController.getWritepanel().removeAll();
	}
}
