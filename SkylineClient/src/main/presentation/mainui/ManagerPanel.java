package main.presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.presentation.financeui.Financeui;
import main.presentation.infoui.Infoui;
import main.presentation.receiptui.Receiptui;
import main.presentation.rightui.Rightui;

//�ܾ���
public class ManagerPanel extends GuidePanel{
	
	private JPanel panel;
	private JButton modifyPassWord = new JButton("�޸�����");//�޸�����
	private JButton managerStaff = new JButton("��Ա����");//��Ա����
	private JButton examineOrder = new JButton("��������");//��������
	private JButton managerInstitution = new JButton("��������");//��������
	private JButton feeStrategy = new JButton("�շѲ���");//�շѲ���
	private JButton lookBankAccount = new JButton("�����˻�");//�鿴�˻�
	private JButton salaryStrategy = new JButton("н�ʲ���");//н�ʲ���
	private JButton statistic = new JButton("ͳ�Ʊ���");//�鿴ͳ�Ʊ���
	private JButton back = new JButton("ע��");
	
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
		
		//�޸�����
		modifyPassWord.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToRightui(Rightui.ModifyPassWord);
			}
		});
		//Ա������
		managerStaff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToInfoui(Infoui.StaffMessage);
			}
		});
		//��������
		examineOrder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToReceiptui(Receiptui.ExamOrder);
			}
		});
		//��������
		managerInstitution.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToInfoui(Infoui.Institutionui);
			}
		});
		//�շѲ���
		feeStrategy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToFinanceui(Financeui.FeeStrategyui);
			}
		});
		//�鿴�����˻�
		lookBankAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToFinanceui(Financeui.Balanceui);
			}
		});
		//�ƶ�нˮ����
		salaryStrategy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToFinanceui(Financeui.SalaryStrategyui);
			}
		});
		//�鿴ͳ������
		statistic.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToFinanceui(Financeui.StatisticsListui);
			}
		});
		//ע��
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
	
	//��ת��ģ����������ǰ���Ƴ����е����
	public void removeAllComponent(){
		MainController.getWritepanel().removeAll();
	}
}
