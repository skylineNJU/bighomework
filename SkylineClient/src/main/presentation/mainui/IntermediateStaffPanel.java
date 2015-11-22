package main.presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.presentation.financeui.Financeui;
import main.presentation.loadui.Loadui;
import main.presentation.loadui.LoaduiController;
import main.presentation.rightui.Rightui;

@SuppressWarnings("serial")
public class IntermediateStaffPanel extends GuidePanel{
	private static LoaduiController loaduiController;
	private JButton transmitReceive=new JButton("中转接收");
	private JButton loadAdmin=new JButton("装运管理");
	private JButton receiveList=new JButton("接收单列表");
	private JLabel back=new JLabel("注销");
	private JPanel panel;
	public IntermediateStaffPanel(){
		panel=FrameMain.getContentPanel();
		this.setLayout(null);
	}
	
	public void init(){
		this.add(transmitReceive);
		this.add(loadAdmin);
		this.add(receiveList);
		this.add(back);
		
		transmitReceive.setSize(this.getWidth()/4*3,this.getHeight()/15);
		loadAdmin.setSize(this.getWidth()/4*3,this.getHeight()/15);
		receiveList.setSize(this.getWidth()/4*3,this.getHeight()/15);
		back.setSize(this.getWidth()/4*3,this.getHeight()/15);
		
		transmitReceive.setLocation((this.getWidth()-transmitReceive.getWidth())/2
				,this.getHeight()/4*1);
		loadAdmin.setLocation((this.getWidth()-transmitReceive.getWidth())/2
				,transmitReceive.getY()+transmitReceive.getHeight()*3/2);
		receiveList.setLocation((this.getWidth()-transmitReceive.getWidth())/2
				,loadAdmin.getY()+loadAdmin.getHeight()*3/2);
		
		back.setLocation((this.getWidth()-transmitReceive.getWidth())/2
				,receiveList.getY()+receiveList.getHeight()*3/2);
		
		//跳转至中转接收
		 transmitReceive.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToLoadui(Loadui.TRANSMITRECEIVE);
			}
		});
		 //跳转至装运管理
		 loadAdmin.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					removeAllComponent();
					panel.repaint();
					MainController.jumpToLoadui(Loadui.LOADVEHICLE);
				}
			});
		//跳转至接收单列表
		 receiveList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					removeAllComponent();
					panel.repaint();
					MainController.jumpToLoadui(Loadui.RECEIVELIST);
				}
			});
		//跳转至注销
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
		public void removeAllComponent(){
			MainController.getWritepanel().removeAll();
		}
	
}
