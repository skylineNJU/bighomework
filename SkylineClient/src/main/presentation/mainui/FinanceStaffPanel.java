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
	
	private JButton modifyKeyWord = new JButton("�޸�����");
	private JButton costManager = new JButton("�ɱ�����");
	private JButton earnManager = new JButton("�������");
	private JButton bankAccountManager = new JButton("�˻�����");
	private JButton StatisticsManager = new JButton("�鿴ͳ�Ʊ���");
	private JButton back = new JButton("ע��");
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
		
		//���ð�ť�����С
		modifyKeyWord.setSize(this.getWidth()/4*3,this.getHeight()/15);
		costManager.setSize(this.getWidth()/4*3,this.getHeight()/15);
		earnManager.setSize(this.getWidth()/4*3,this.getHeight()/15);
		bankAccountManager.setSize(this.getWidth()/4*3,this.getHeight()/15);
		StatisticsManager.setSize(this.getWidth()/4*3,this.getHeight()/15);
		back.setSize(this.getWidth()/4*3,this.getHeight()/15);
		
		//���ð�ť���λ��
		modifyKeyWord.setLocation(this.getWidth()/8, this.getHeight()/4);
		costManager.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10);
		earnManager.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10*2);
		bankAccountManager.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10*3);
		StatisticsManager.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10*4);
		back.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10*5);
		
		//------���ð�ť����ļ���--------
		//�޸�����
		modifyKeyWord.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToRightui(Rightui.ModifyPassWord);
			}
		});
		//------�����ɱ��������-------
		costManager.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToFinanceui(Financeui.CostListui);
			}
		});
		//-------��������������-------
		earnManager.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToFinanceui(Financeui.EarnListui);
			}
		});
		//-------���������˻�����-------
		bankAccountManager.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToFinanceui(Financeui.Balanceui);
			}
		});
		//-------����ͳ�Ʊ������-------
		StatisticsManager.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToFinanceui(Financeui.StatisticsListui);
			}
		});
		
		//-------���ص�½����---------
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
