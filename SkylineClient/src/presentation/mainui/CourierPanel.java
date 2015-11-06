package presentation.mainui;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import presentation.rightui.Rightui;

@SuppressWarnings("serial")
public class CourierPanel extends GuidePanel {
	private JButton orderInput=new JButton("订单输入");
	private JButton receiveInput=new JButton("收件信息输入");
	private JButton showOrder=new JButton("订单查看");
	private JButton showMission=new JButton("任务查看");
	private JLabel back=new JLabel("注销");
	private JPanel panel;
	public CourierPanel(){
		panel=FrameMain.getContentPanel();
		this.setLayout(null);
	}
	
	public void init(){
		

		this.add(orderInput);
		this.add(receiveInput);
		this.add(showOrder);
		this.add(showMission);
		this.add(back);
		
		orderInput.setSize(this.getWidth()/4*3,this.getHeight()/15);
		receiveInput.setSize(this.getWidth()/4*3,this.getHeight()/15);
		showOrder.setSize(this.getWidth()/4*3,this.getHeight()/15);
		showMission.setSize(this.getWidth()/4*3,this.getHeight()/15);
		back.setSize(this.getWidth()/4*3,this.getHeight()/15);
		
		orderInput.setLocation((this.getWidth()-orderInput.getWidth())/2
				,this.getHeight()/4*1);
		receiveInput.setLocation((this.getWidth()-orderInput.getWidth())/2
				,orderInput.getY()+orderInput.getHeight()*3/2);
		showOrder.setLocation((this.getWidth()-orderInput.getWidth())/2
				,receiveInput.getY()+receiveInput.getHeight()*3/2);
		showMission.setLocation((this.getWidth()-orderInput.getWidth())/2
				,showOrder.getY()+showOrder.getHeight()*3/2);
		back.setLocation((this.getWidth()-orderInput.getWidth())/2
				,showMission.getY()+showMission.getHeight()*3/2);
		
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
}
