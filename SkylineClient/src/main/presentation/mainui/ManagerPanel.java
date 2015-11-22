package main.presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.presentation.financeui.Financeui;
import main.presentation.infoui.Infoui;
import main.presentation.receiptui.Receiptui;
import main.presentation.rightui.Rightui;

//总经理
public class ManagerPanel extends GuidePanel{
	
	private JPanel panel;
	private JButton modifyPassWord = new JButton("修改密码");//修改密码
	private JButton managerStaff = new JButton("人员管理");//人员管理
	private JButton examineOrder = new JButton("审批单据");//审批单据
	private JButton managerInstitution = new JButton("机构管理");//机构管理
	private JButton feeStrategy = new JButton("收费策略");//收费策略
	private JButton lookBankAccount = new JButton("银行账户");//查看账户
	private JButton salaryStrategy = new JButton("薪资策略");//薪资策略
	private JButton statistic = new JButton("统计报表");//查看统计报表
	private JButton back = new JButton("注销");
	
	public ManagerPanel(){
		panel = FrameMain.getContentPanel();
		this.setLayout(null);
	}
	
	public void init(){
		this.add(modifyPassWord);
		this.add(managerStaff);
		this.add(examineOrder);
		this.add(managerInstitution);
		this.add(feeStrategy);
		this.add(lookBankAccount);
		this.add(salaryStrategy);
		this.add(statistic);
		this.add(back);
		
		modifyPassWord.setBounds(this.getWidth()/8, this.getHeight()*6/25, this.getWidth()/4*3,this.getHeight()/15);
		managerStaff.setBounds(this.getWidth()/8, modifyPassWord.getY()+this.getHeight()*6/75, this.getWidth()/4*3,this.getHeight()/15);
		examineOrder.setBounds(this.getWidth()/8, managerStaff.getY()+this.getHeight()*6/75, this.getWidth()/4*3,this.getHeight()/15);
		managerInstitution.setBounds(this.getWidth()/8, examineOrder.getY()+this.getHeight()*6/75, this.getWidth()/4*3,this.getHeight()/15);
		feeStrategy.setBounds(this.getWidth()/8, managerInstitution.getY()+this.getHeight()*6/75, this.getWidth()/4*3,this.getHeight()/15);
		lookBankAccount.setBounds(this.getWidth()/8, feeStrategy.getY()+this.getHeight()*6/75, this.getWidth()/4*3,this.getHeight()/15);
		salaryStrategy.setBounds(this.getWidth()/8, lookBankAccount.getY()+this.getHeight()*6/75, this.getWidth()/4*3,this.getHeight()/15);
		statistic.setBounds(this.getWidth()/8, salaryStrategy.getY()+this.getHeight()*6/75, this.getWidth()/4*3,this.getHeight()/15);
		back.setBounds(this.getWidth()/8, statistic.getY()+this.getHeight()*6/75, this.getWidth()/4*3,this.getHeight()/15);
		
		//修改密码
		modifyPassWord.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToRightui(Rightui.ModifyPassWord);
			}
		});
		//员工管理
		managerStaff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToInfoui(Infoui.StaffMessage);
			}
		});
		//单据审批
		examineOrder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToReceiptui(Receiptui.ExamOrder);
			}
		});
		//机构管理
		managerInstitution.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToInfoui(Infoui.Institutionui);
			}
		});
		//收费策略
		feeStrategy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToFinanceui(Financeui.FeeStrategyui);
			}
		});
		//查看银行账户
		lookBankAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToFinanceui(Financeui.Balanceui);
			}
		});
		//制定薪水策略
		salaryStrategy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToFinanceui(Financeui.SalaryStrategyui);
			}
		});
		//查看统计数据
		statistic.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToFinanceui(Financeui.StatisticsListui);
			}
		});
		//注销
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
