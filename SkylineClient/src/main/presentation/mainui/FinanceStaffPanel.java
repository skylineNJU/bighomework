package main.presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.presentation.financeui.Financeui;
import main.presentation.rightui.Rightui;

public class FinanceStaffPanel extends GuidePanel{
	@SuppressWarnings("serial")
	
	private static final long serialVersionUID = 1L;
	
	private JButton modifyKeyWord = new JButton("修改密码");
	private JButton costManager = new JButton("成本管理");
	private JButton earnManager = new JButton("结算管理");
	private JButton bankAccountManager = new JButton("账户管理");
	private JButton StatisticsManager = new JButton("查看统计报表");
	private JButton back = new JButton("注销");
	private JPanel panel;
	
	public FinanceStaffPanel(){
		panel = FrameMain.getContentPanel();
		this.setLayout(null);
	}
	
	public void init(){
		this.add(modifyKeyWord);
		this.add(costManager);
		this.add(earnManager);
		this.add(bankAccountManager);
		this.add(StatisticsManager);
		this.add(back);
		
		//设置按钮组件大小
		modifyKeyWord.setSize(this.getWidth()/4*3,this.getHeight()/15);
		costManager.setSize(this.getWidth()/4*3,this.getHeight()/15);
		earnManager.setSize(this.getWidth()/4*3,this.getHeight()/15);
		bankAccountManager.setSize(this.getWidth()/4*3,this.getHeight()/15);
		StatisticsManager.setSize(this.getWidth()/4*3,this.getHeight()/15);
		back.setSize(this.getWidth()/4*3,this.getHeight()/15);
		
		//设置按钮组件位置
		modifyKeyWord.setLocation(this.getWidth()/8, this.getHeight()/4);
		costManager.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10);
		earnManager.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10*2);
		bankAccountManager.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10*3);
		StatisticsManager.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10*4);
		back.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10*5);
		
		//------设置按钮组件的监听--------
		//修改密码
		modifyKeyWord.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToRightui(Rightui.ModifyPassWord);
			}
		});
		//------跳至成本管理界面-------
		costManager.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToFinanceui(Financeui.CostListui);
			}
		});
		//-------跳至收益管理界面-------
		earnManager.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToFinanceui(Financeui.EarnListui);
			}
		});
		//-------跳至银行账户界面-------
		bankAccountManager.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToFinanceui(Financeui.Balanceui);
			}
		});
		//-------跳至统计报表界面-------
		StatisticsManager.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToFinanceui(Financeui.StatisticsListui);
			}
		});
		
		//-------返回登陆界面---------
		back.addMouseListener(new MouseAdapter() {
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
	
	//跳转到模块其他界面前，移除所有的组件
	public void removeAllComponent(){
		MainController.getWritepanel().removeAll();
	}
}
