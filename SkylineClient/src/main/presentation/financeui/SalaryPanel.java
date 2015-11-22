package main.presentation.financeui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class SalaryPanel {
	
	
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private int InterWidth;//ˮƽ���
	private int InterHeight;//��ֱ���
	private JLabel title;
	private JLabel staff;//ְλ
	private JLabel basicSalary;//��������
	private JLabel commission;//���
	private JLabel courier;//���Ա
	private JLabel lobbyer;//Ӫҵ��ҵ��Ա
	private JLabel IntermeStaff;//��ת����ҵ��Ա
	private JLabel wareHouseStaff;//�ֿ������Ա
	private JLabel financeStaff;//������Ա
	private JLabel adminer;//����Ա
	private JLabel manager;//�ܾ���
	private JTextField courierBasic;
	private JTextField lobbyerBasic;
	private JTextField IntermeBasic;
	private JTextField wareHouserBasic;
	private JTextField financerBasic;
	private JTextField adminerBasic;
	private JTextField managerBasic;
	private JTextField courierCommission;
	private JTextField lobbyerCommission;
	private JTextField IntermeCommission;
	private JTextField wareHouserCommission;
	private JTextField financerCommission;
	private JTextField adminerCommission;
	private JTextField managerCommission;
	private JButton saveButton;
	private JButton cancleButton;
	
	public SalaryPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	public void init(){
		initTitle();
		initLabel();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("�ƶ�н�ʲ���");
		panel.add(title);
		title.setBounds(panelWidth*2/5, panelHeight/60, panelWidth/5, panelHeight/30);
	}
	public void initLabel(){
		
		InterWidth = panelWidth/40;
		InterHeight = panelHeight/20;
		staff = new JLabel("ְλ");//ְλ
		basicSalary = new JLabel("��������",(int) JLabel.CENTER_ALIGNMENT);//��������
		commission = new JLabel("���/����");//���
		courier = new JLabel("���Ա");//���Ա
		lobbyer = new JLabel("Ӫҵ��ҵ��Ա");//Ӫҵ��ҵ��Ա
		IntermeStaff = new JLabel("��ת����ҵ��Ա");//��ת����ҵ��Ա
		wareHouseStaff = new JLabel("�ֿ������Ա");//�ֿ������Ա
		financeStaff = new JLabel("������Ա");//������Ա
		adminer = new JLabel("����Ա");//����Ա
		manager = new JLabel("�ܾ���");//�ܾ���
		courierBasic = new JTextField();
		lobbyerBasic = new JTextField();
		IntermeBasic = new JTextField();
		wareHouserBasic = new JTextField();
		financerBasic = new JTextField();
		adminerBasic = new JTextField();
		managerBasic = new JTextField();
		courierCommission = new JTextField();
		lobbyerCommission = new JTextField();
		IntermeCommission = new JTextField();
		wareHouserCommission = new JTextField();
		financerCommission = new JTextField();
		adminerCommission = new JTextField();
		managerCommission = new JTextField();
		saveButton = new JButton("����");
		cancleButton = new JButton("ȡ��");
		
		panel.add(staff);
		panel.add(basicSalary);
		panel.add(commission);
		panel.add(courier);
		panel.add(lobbyer);
		panel.add(IntermeStaff);
		panel.add(wareHouseStaff);
		panel.add(financeStaff);
		panel.add(adminer);
		panel.add(manager);
		panel.add(courierBasic);
		panel.add(lobbyerBasic);
		panel.add(IntermeBasic);
		panel.add(wareHouserBasic);
		panel.add(financerBasic);
		panel.add(adminerBasic);
		panel.add(managerBasic);
		panel.add(courierCommission);
		panel.add(lobbyerCommission);
		panel.add(IntermeCommission);
		panel.add(wareHouserCommission);
		panel.add(financerCommission);
		panel.add(adminerCommission);
		panel.add(managerCommission);
		panel.add(saveButton);
		panel.add(cancleButton);
		
		staff.setBounds(panelWidth/10, panelHeight/10, panelWidth/8, panelHeight/20);
		basicSalary.setBounds(staff.getX()+staff.getWidth()+InterWidth, panelHeight/10, panelWidth*17/40, panelHeight/20);
		commission.setBounds(basicSalary.getX()+basicSalary.getWidth()+InterWidth, panelHeight/10, panelWidth/5, panelHeight/20);
		courier.setBounds(panelWidth/10, staff.getY()+staff.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		lobbyer.setBounds(panelWidth/10, courier.getY()+courier.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		IntermeStaff.setBounds(panelWidth/10, lobbyer.getY()+lobbyer.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		wareHouseStaff.setBounds(panelWidth/10, IntermeStaff.getY()+IntermeStaff.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		financeStaff.setBounds(panelWidth/10,  wareHouseStaff.getY()+wareHouseStaff.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		adminer.setBounds(panelWidth/10, financeStaff.getY()+financeStaff.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		manager.setBounds(panelWidth/10, adminer.getY()+adminer.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		courierBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, courier.getY(), panelWidth*17/40, panelHeight/20);
		lobbyerBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, lobbyer.getY(), panelWidth*17/40, panelHeight/20);
		IntermeBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, IntermeStaff.getY(), panelWidth*17/40, panelHeight/20);
		wareHouserBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, wareHouseStaff.getY(), panelWidth*17/40, panelHeight/20);
		financerBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, financeStaff.getY(), panelWidth*17/40, panelHeight/20);
		adminerBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, adminer.getY(), panelWidth*17/40, panelHeight/20);
		managerBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, manager.getY(), panelWidth*17/40, panelHeight/20);
		courierCommission.setBounds(commission.getX(), courier.getY(), commission.getWidth(), panelHeight/20);
		lobbyerCommission.setBounds(commission.getX(), lobbyer.getY(), commission.getWidth(), panelHeight/20);
		IntermeCommission.setBounds(commission.getX(), IntermeStaff.getY(), commission.getWidth(), panelHeight/20);
		wareHouserCommission.setBounds(commission.getX(), wareHouseStaff.getY(), commission.getWidth(), panelHeight/20);
		financerCommission.setBounds(commission.getX(), financeStaff.getY(), commission.getWidth(), panelHeight/20);
		adminerCommission.setBounds(commission.getX(), adminer.getY(), commission.getWidth(), panelHeight/20);
		managerCommission.setBounds(commission.getX(), manager.getY(), commission.getWidth(), panelHeight/20);
		
		cancleButton.setBounds(managerCommission.getX()-panelWidth/10, managerCommission.getY()+InterHeight*2, panelWidth/10, panelHeight/20);
		saveButton.setBounds(managerCommission.getX()+panelWidth/10, managerCommission.getY()+InterHeight*2, panelWidth/10, panelHeight/20);
	}
}
