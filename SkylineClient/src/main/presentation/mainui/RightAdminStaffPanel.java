package main.presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.presentation.rightui.Rightui;

@SuppressWarnings("serial")
public class RightAdminStaffPanel extends GuidePanel{
	private JButton passWordInit=new JButton("密码初始化");
	private JButton rightAdmin=new JButton("权限管理");
	private JLabel back=new JLabel("注销");
	private JPanel panel;

	public RightAdminStaffPanel(){
		panel=FrameMain.getContentPanel();
		this.setLayout(null);
	}
	
	public void init(){
		this.add(passWordInit);
		this.add(rightAdmin);
		this.add(back);
	
		passWordInit.setSize(this.getWidth()/4*3,this.getHeight()/15);
		rightAdmin.setSize(this.getWidth()/4*3,this.getHeight()/15);
		back.setSize(this.getWidth()/4*3,this.getHeight()/15);
	
		passWordInit.setLocation((this.getWidth()-passWordInit.getWidth())/2
				,this.getHeight()/4*1);
		rightAdmin.setLocation((this.getWidth()-passWordInit.getWidth())/2
				,passWordInit.getY()+passWordInit.getHeight()*3/2);
		back.setLocation((this.getWidth()-passWordInit.getWidth())/2
				,rightAdmin.getY()+rightAdmin.getHeight()*3/2);
	
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				panel.repaint();
				MainController.jumpToRightui(Rightui.Login);
			}
		});
		rightAdmin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToRightui(Rightui.RightAdmin);
			}
		});
		passWordInit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToRightui(Rightui.PasswordInit);
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
	
	//跳转到模块其他界面前，移除所有的组件
	public void removeAllComponent(){
		MainController.getWritepanel().removeAll();
	}
}
