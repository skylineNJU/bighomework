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
/*	public void institutionPanel(){
		tableTitle1 =  new String[]{"��������","���","���ڳ���","��Ա����","ռ�����/m^2","��������"};
		tableData1 = new String[][]{{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},
				{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},
				{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}};	
		initTable(tableTitle1,tableData1,scrollPane1,table1,institution);
	//	institution.add(scrollPane1);
	}
	
	public void employeePanel(){
		tableTitle1 =  new String[]{"Ա���˺�","Ա������","ְλ","������λ","��ְʱ��","����/��","���"};
		tableData2 = new String[][]{{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
				{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
				{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}};	
		initTable(tableTitle2,tableData2,scrollPane2,table2,employee);
	//	employee.add(scrollPane2);

	}
	
	public void vehiclePanel(){
		tableTitle3 =  new String[]{"���ƺ�","�������","��������","���̺�","����ʱ��","����ʱ��","������/Ԫ"};
		tableData3 = new String[][]{{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
				{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
				{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}};	
		initTable(tableTitle3,tableData2,scrollPane3,table3,vehicle);
	//	vehicle.add(scrollPane3);
	}
	
	public void warehousePanel(){
		tableTitle4 =  new String[]{"������","��������","����ʱ��","����/Ԫ","��ϸ��Ϣ"};
		tableData4 = new String[][]{{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};	
		initTable(tableTitle4,tableData4,scrollPane4,table4,warehouse);
	//	warehouse.add(scrollPane4);
	}
	
	public void bankaccountPanel(){
		tableTitle5 =  new String[]{"�����˻�","���/Ԫ"};
		tableData5 = new String[][]{{"������","","","","100%"},{"��·��","","","","100%"},{"������","","","","100%"},{"������","","","","100%"}};	
		initTable(tableTitle5,tableData5,scrollPane5,table5,bankaccount);
	//	bankaccount.add(scrollPane5);
	}
	public void initTable( String[] tableTitle, String[][] tableData,JScrollPane scrollPane,JTable table,JPanel a){
		table = new JTable(tableData,tableTitle);
		table.setEnabled(false);//���ò��ɱ༭����
		table.setRowHeight(panel.getWidth()/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//���ñ�ͷ�߶�
		table.getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);

		if(tableData.length>=10){
			scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8,tab.getWidth(), 10*table.getRowHeight());
		}else{
			scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8,tab.getWidth(), (table.getRowCount()+1)*table.getRowHeight());
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/5);;
		table.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/6);;
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		scrollPane.setVisible(true);		
		a.add(scrollPane);
	}
}
*/