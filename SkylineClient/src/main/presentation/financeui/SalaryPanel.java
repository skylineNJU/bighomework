package main.presentation.financeui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.SalaryVO;

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
	private JLabel driver;
	private JLabel IntermeStaff;//��ת����ҵ��Ա
	private JLabel wareHouseStaff;//�ֿ������Ա
	private JLabel financeStaff;//������Ա
	private JLabel adminer;//����Ա
	private JLabel manager;//�ܾ���
	private JTextField courierBasic;
	private JTextField lobbyerBasic;
	private JTextField driverBasic;
	private JTextField IntermeBasic;
	private JTextField wareHouserBasic;
	private JTextField financerBasic;
	private JTextField adminerBasic;
	private JTextField managerBasic;
	private JTextField courierCommission;
	private JTextField lobbyerCommission;
	private JTextField driverCommission;
	private JTextField IntermeCommission;
	private JTextField wareHouserCommission;
	private JTextField financerCommission;
	private JTextField adminerCommission;
	private JTextField managerCommission;
	private JButton saveButton;
	
	public SalaryPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	public void init(){
		initTitle();
		initLabel();
		setSalary();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("�ƶ�н�ʲ���");
		panel.add(title);
		title.setBounds(panelWidth*2/5, panelHeight/60, panelWidth/5, panelHeight/30);
	}
	
	//����ֵ
	public void setSalary(){
		FinanceBLService finance = ConstructFactory.FinanceFactory();
		SalaryVO salaryVO = finance.readSalary();
		courierBasic.setText(String.valueOf(salaryVO.getCourierSalary()));
		lobbyerBasic.setText(String.valueOf(salaryVO.getLobbySalary()));
		driverBasic.setText(String.valueOf(salaryVO.getDriverSalary()));
		IntermeBasic.setText(String.valueOf(salaryVO.getIntermediateSalary()));
		wareHouserBasic.setText(String.valueOf(salaryVO.getWarehouseSalary()));
		financerBasic.setText(String.valueOf(salaryVO.getFinanceSalary()));
		adminerBasic.setText(String.valueOf(salaryVO.getAdminSalary()));
		managerBasic.setText(String.valueOf(salaryVO.getManagerSalary()));
		courierCommission.setText(String.valueOf(salaryVO.getCourierCommission()));
		lobbyerCommission.setText(String.valueOf(salaryVO.getLobbyCommission()));
		driverCommission.setText(String.valueOf(salaryVO.getDriverCommission()));
		IntermeCommission.setText(String.valueOf(salaryVO.getIntermediateCommission()));
		wareHouserCommission.setText(String.valueOf(salaryVO.getWareHouseCommission()));
		financerCommission.setText(String.valueOf(salaryVO.getFinanceCommission()));
		adminerCommission.setText(String.valueOf(salaryVO.getAdminCommission()));
		managerCommission.setText(String.valueOf(salaryVO.getManagerCommission()));
	}
	
	public void initLabel(){
		
		InterWidth = panelWidth/40;
		InterHeight = panelHeight/25;
		staff = new JLabel("ְλ");//ְλ
		basicSalary = new JLabel("��������",(int) JLabel.CENTER_ALIGNMENT);//��������
		commission = new JLabel("���/����");//���
		courier = new JLabel("���Ա");//���Ա
		driver = new JLabel("˾��");
		lobbyer = new JLabel("Ӫҵ��ҵ��Ա");//Ӫҵ��ҵ��Ա
		IntermeStaff = new JLabel("��ת����ҵ��Ա");//��ת����ҵ��Ա
		wareHouseStaff = new JLabel("�ֿ������Ա");//�ֿ������Ա
		financeStaff = new JLabel("������Ա");//������Ա
		adminer = new JLabel("����Ա");//����Ա
		manager = new JLabel("�ܾ���");//�ܾ���
		courierBasic = new JTextField();
		driverBasic = new JTextField();
		lobbyerBasic = new JTextField();
		IntermeBasic = new JTextField();
		wareHouserBasic = new JTextField();
		financerBasic = new JTextField();
		adminerBasic = new JTextField();
		managerBasic = new JTextField();
		courierCommission = new JTextField();
		lobbyerCommission = new JTextField();
		driverCommission = new JTextField();
		IntermeCommission = new JTextField();
		wareHouserCommission = new JTextField();
		financerCommission = new JTextField();
		adminerCommission = new JTextField();
		managerCommission = new JTextField();
		saveButton = new JButton("����");
		
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				FinanceBLService finance = ConstructFactory.FinanceFactory();
				SalaryVO salaryVO = new SalaryVO();
				salaryVO.setAdminSalary(Double.valueOf(adminerBasic.getText()));
				salaryVO.setAdminCommission(Double.valueOf(adminerCommission.getText()));
				salaryVO.setCourierSalary(Double.valueOf(courierBasic.getText()));
				salaryVO.setCourierCommission(Double.valueOf(courierCommission.getText()));
				salaryVO.setDriverSalary(Double.valueOf(driverBasic.getText()));
				salaryVO.setDriverCommission(Double.valueOf(driverCommission.getText()));
				salaryVO.setFinanceSalary(Double.valueOf(financerBasic.getText()));
				salaryVO.setFinanceCommission(Double.valueOf(financerCommission.getText()));
				salaryVO.setIntermediateSalary(Double.valueOf(IntermeBasic.getText()));
				salaryVO.setIntermediateCommission(Double.valueOf(IntermeCommission.getText()));
				salaryVO.setLobbySalary(Double.valueOf(lobbyerBasic.getText()));
				salaryVO.setLobbyCommission(Double.valueOf(lobbyerCommission.getText()));
				salaryVO.setManagerSalary(Double.valueOf(managerBasic.getText()));
				salaryVO.setManagerCommission(Double.valueOf(managerCommission.getText()));
				salaryVO.setWarehouseSalary(Double.valueOf(wareHouserBasic.getText()));
				salaryVO.setWareHouseCommission(Double.valueOf(wareHouserCommission.getText()));
				if(finance.modifySalary(salaryVO)){//����ɹ����˻���������
					
				}else{//����ʧ��
					
				}
			}
		});
		
		panel.add(staff);
		panel.add(basicSalary);
		panel.add(commission);
		panel.add(courier);
		panel.add(lobbyer);
		panel.add(driver);
		panel.add(IntermeStaff);
		panel.add(wareHouseStaff);
		panel.add(financeStaff);
		panel.add(adminer);
		panel.add(manager);
		panel.add(courierBasic);
		panel.add(lobbyerBasic);
		panel.add(driverBasic);
		panel.add(IntermeBasic);
		panel.add(wareHouserBasic);
		panel.add(financerBasic);
		panel.add(adminerBasic);
		panel.add(managerBasic);
		panel.add(courierCommission);
		panel.add(lobbyerCommission);
		panel.add(driverCommission);
		panel.add(IntermeCommission);
		panel.add(wareHouserCommission);
		panel.add(financerCommission);
		panel.add(adminerCommission);
		panel.add(managerCommission);
		panel.add(saveButton);
		
		staff.setBounds(panelWidth/10, panelHeight/10, panelWidth/8, panelHeight/20);
		basicSalary.setBounds(staff.getX()+staff.getWidth()+InterWidth, panelHeight/10, panelWidth*12/40, panelHeight/20);
		commission.setBounds(basicSalary.getX()+basicSalary.getWidth()+InterWidth*4, panelHeight/10, panelWidth/4, panelHeight/20);
		courier.setBounds(panelWidth/10, staff.getY()+staff.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		lobbyer.setBounds(panelWidth/10, courier.getY()+courier.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		driver.setBounds(panelWidth/10, lobbyer.getY()+lobbyer.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		IntermeStaff.setBounds(panelWidth/10, driver.getY()+driver.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		wareHouseStaff.setBounds(panelWidth/10, IntermeStaff.getY()+IntermeStaff.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		financeStaff.setBounds(panelWidth/10,  wareHouseStaff.getY()+wareHouseStaff.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		adminer.setBounds(panelWidth/10, financeStaff.getY()+financeStaff.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		manager.setBounds(panelWidth/10, adminer.getY()+adminer.getHeight()+InterHeight, panelWidth/5, panelHeight/20);
		courierBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, courier.getY(), panelWidth*12/40, panelHeight/20);
		lobbyerBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, lobbyer.getY(), panelWidth*12/40, panelHeight/20);
		driverBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, driver.getY(), panelWidth*12/40, panelHeight/20);
		IntermeBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, IntermeStaff.getY(), panelWidth*12/40, panelHeight/20);
		wareHouserBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, wareHouseStaff.getY(), panelWidth*12/40, panelHeight/20);
		financerBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, financeStaff.getY(), panelWidth*12/40, panelHeight/20);
		adminerBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, adminer.getY(), panelWidth*12/40, panelHeight/20);
		managerBasic.setBounds(staff.getX()+staff.getWidth()+InterWidth, manager.getY(), panelWidth*12/40, panelHeight/20);
		courierCommission.setBounds(commission.getX()-InterWidth*3, courier.getY(), commission.getWidth(), panelHeight/20);
		lobbyerCommission.setBounds(commission.getX()-InterWidth*3, lobbyer.getY(), commission.getWidth(), panelHeight/20);
		driverCommission.setBounds(commission.getX()-InterWidth*3, driver.getY(), commission.getWidth(), panelHeight/20);
		IntermeCommission.setBounds(commission.getX()-InterWidth*3, IntermeStaff.getY(), commission.getWidth(), panelHeight/20);
		wareHouserCommission.setBounds(commission.getX()-InterWidth*3, wareHouseStaff.getY(), commission.getWidth(), panelHeight/20);
		financerCommission.setBounds(commission.getX()-InterWidth*3, financeStaff.getY(), commission.getWidth(), panelHeight/20);
		adminerCommission.setBounds(commission.getX()-InterWidth*3, adminer.getY(), commission.getWidth(), panelHeight/20);
		managerCommission.setBounds(commission.getX()-InterWidth*3, manager.getY(), commission.getWidth(), panelHeight/20);
		
		saveButton.setBounds(managerCommission.getX()+panelWidth/10, managerCommission.getY()+InterHeight*5/2, panelWidth/10, panelHeight/20);
	}
}
