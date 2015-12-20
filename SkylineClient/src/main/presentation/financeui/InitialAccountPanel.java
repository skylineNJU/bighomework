package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import main.presentation.mainui.MainController;
// �ڳ�����
//��������Ա����������桢 �����˻���Ϣ�����ƣ���
/*
 * �ڳ����ˣ����ϵͳ�ǿ���֧�ֽ������˵ģ�����ϵͳһ��һ����һ���ʣ���ͬ���Ͽ�����ͬһ�ͻ�����
 * ÿ�������½����½��˵�Ƶ��һ��һ��һ�Σ�����2��һ�Σ���ʱ��Ҫ�����ڳ�������һ���ڣ��������Ϊһ���ʵĳ�ʼ��������
 * ��������������Ա����������桢 �����˻���Ϣ�����ƣ�����
 * �ڳ�����Ϣһ��������Ͼͻᵥ���洢������ͬʱ������Ϣ��Ϊϵͳ��������ʼ״̬��֮���һ�в�������ı�ϵͳ�����Ϣ��������ı��ڳ���Ϣ��
 * �ڳ���Ϣ��ʱ�ɲ顣��
 * 
 */
public class InitialAccountPanel {
		private JPanel panel;
		private JButton institution;
		private JButton employee;
		private JButton vehicle;
		private JButton warehouse;
		private JButton bankaccount;
/*		private JPanel institution;
		private JPanel employee;
		private JPanel vehicle;
		private JPanel warehouse;
		private JPanel bankaccount;
		private JTabbedPane tab;
		private JTable table1;
		private JTable table2;
		private JTable table3;
		private JTable table4;
		private JTable table5;
		private JScrollPane scrollPane1;
		private JScrollPane scrollPane2;
		private JScrollPane scrollPane3;
		private JScrollPane scrollPane4;
		private JScrollPane scrollPane5;
		private String[] tableTitle1;
		private String[] tableTitle2;
		private String[] tableTitle3;
		private String[] tableTitle4;
		private String[] tableTitle5;
		private String[][] tableData1;
		private String[][] tableData2;
		private String[][] tableData3;
		private String[][] tableData4;
		private String[][] tableData5;
	*/	
	public InitialAccountPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	
	}
	
	public void init(){
/*		institution = new JPanel();
		employee = new JPanel();
		vehicle = new JPanel();
		warehouse = new JPanel();
		bankaccount = new JPanel();
		
		institution.setLayout(null);
		employee.setLayout(null);
		vehicle.setLayout(null);
		warehouse.setLayout(null);
		bankaccount.setLayout(null);
		
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("������Ŀ", institution);
		tab.addTab("Ա����Ŀ", employee);
		tab.addTab("������Ŀ", vehicle);
		tab.addTab("�ֿ���Ŀ", warehouse);
		tab.addTab("�����˻���Ŀ", bankaccount);
		
		tab.setSize(panel.getWidth()*16/18,panel.getHeight()/100*90);
		tab.setLocation(panel.getWidth()/18,panel.getHeight()*2/20);
		panel.add(tab);
		institutionPanel();
		employeePanel();
		vehiclePanel();
		warehousePanel();
		bankaccountPanel();
		tab.repaint();
*/
		button();
		Listener();
		panel.repaint();
	}

	public void button(){
		institution = new JButton("������Ŀ");
		employee = new JButton("Ա����Ŀ");
		vehicle = new JButton("������Ŀ");
		warehouse = new JButton("�ֿ���Ŀ");
		bankaccount = new JButton("�����˻���Ŀ");
		
		institution.setBounds(panel.getWidth()/3,panel.getHeight()/4, panel.getWidth()/5, panel.getHeight()/10);
		employee.setBounds(institution.getX(),institution.getY()+panel.getHeight()/8, panel.getWidth()/5, panel.getHeight()/10);
		vehicle.setBounds(institution.getX(),employee.getY()+panel.getHeight()/8, panel.getWidth()/5, panel.getHeight()/10);
		warehouse.setBounds(institution.getX(),vehicle.getY()+panel.getHeight()/8, panel.getWidth()/5, panel.getHeight()/10);
		bankaccount.setBounds(institution.getX(),warehouse.getY()+panel.getHeight()/8, panel.getWidth()/5, panel.getHeight()/10);
		
		panel.add(institution);
		panel.add(employee);
		panel.add(vehicle);
		panel.add(warehouse);
		panel.add(bankaccount);
		
	}
	
	public void Listener(){
		institution.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				InstitutionAccountPanel panel  = new InstitutionAccountPanel();
				panel.init();
			}
		});
		employee.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				EmployeeAccountPanel panel  = new EmployeeAccountPanel();
				panel.init();
			}
		});
		vehicle.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				VehicleAccountPanel panel  = new VehicleAccountPanel();
				panel.init();
			}
		});
		warehouse.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				WarehouseAccountPanel panel  = new WarehouseAccountPanel();
				panel.init();
			}
		});
		bankaccount.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				BankAccountPanel panel  = new BankAccountPanel();
				panel.init();
			}
		});
	}
	
	public void remove(){
		panel.remove(institution);
		panel.remove(employee);
		panel.remove(vehicle);
		panel.remove(warehouse);
		panel.remove(bankaccount);
	}
}