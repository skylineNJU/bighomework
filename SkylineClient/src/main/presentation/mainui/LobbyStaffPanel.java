package main.presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.presentation.financeui.Financeui;
import main.presentation.infoui.Infoui;
import main.presentation.loadui.Loadui;
import main.presentation.receiveui.Receiveui;
import main.presentation.rightui.Rightui;

public class LobbyStaffPanel extends GuidePanel{
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton modifyPassWord = new JButton("�޸�����");
	private JButton receiveList = new JButton("���յ�");//���յ�
	private JButton earnList = new JButton("�տ");//�տ
	private JButton carLoad = new JButton("����װ������");//����װ������
	private JButton carMessage = new JButton("������Ϣ����");//������Ϣ����
	private JButton driverMessage = new JButton("˾����Ϣ����");//˾����Ϣ����
	private JButton back = new JButton("ע��");//ע��
	
	public LobbyStaffPanel(){
		panel = FrameMain.getContentPanel();
		this.setLayout(null);
	}
	
	public void init(){
		
		this.add(modifyPassWord);
		this.add(receiveList);
		this.add(earnList);
		this.add(carLoad);
		this.add(carMessage);
		this.add(driverMessage);
		this.add(back);
		modifyPassWord.setSize(this.getWidth()/4*3,this.getHeight()/15);
		receiveList.setSize(this.getWidth()/4*3,this.getHeight()/15);
		earnList.setSize(this.getWidth()/4*3,this.getHeight()/15);
		carLoad.setSize(this.getWidth()/4*3,this.getHeight()/15);
		carMessage.setSize(this.getWidth()/4*3,this.getHeight()/15);
		driverMessage.setSize(this.getWidth()/4*3,this.getHeight()/15);
		back.setSize(this.getWidth()/4*3,this.getHeight()/15);
		
		modifyPassWord.setLocation(this.getWidth()/8, this.getHeight()/4);
		receiveList.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()/10);
		earnList.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()*2/10);
		carLoad.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()*3/10);
		carMessage.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()*4/10);
		driverMessage.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()*5/10);
		back.setLocation(this.getWidth()/8, this.getHeight()/4 + this.getHeight()*6/10);
		
		panel.add(this);	
		panel.repaint();
		this.repaint();
		this.setVisible(true);
		
		//�޸��������
		modifyPassWord.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToRightui(Rightui.ModifyPassWord);
			}
		});
		
		//���յ�����
		receiveList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToReceiveui(Receiveui.LobbyReceiveList);
			}
		});
		
		//�տ����
		earnList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				MainController.jumpToFinanceui(Financeui.LobbyEarnui);
				
			}
		});
		
		//����װ������
		carLoad.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToLoadui(Loadui.LobbyLoading);
			}
		});
		
		//������Ϣ����
		carMessage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToInfoui(Infoui.VehicleMessage);
			}
		});
		
		//˾����Ϣ����
		driverMessage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				removeAllComponent();
				panel.repaint();
				MainController.jumpToInfoui(Infoui.DriverMessage);
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
