package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.FinanceMemory;
import main.vo.BuildAccountVO;
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
		private JPanel initialAccountPanel;
		private JButton institution;
		private JButton employee;
		private JButton vehicle;
		private JButton warehouse;
		private JButton bankaccount;
		private JLabel label;
		private JScrollPane scrollPane;
		private JTable table;
		private String[] tableTitle;
		private String[][] tableData;
		private JLabel buildAccount=new JLabel("����");
		private JLabel loadAccount=new JLabel("������ʷ�汾");
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
		initialAccountPanel=new JPanel();
		initialAccountPanel.setLayout(null);
		initialAccountPanel.setSize(panel.getWidth()*554/689,panel.getHeight()*372/552);
		initialAccountPanel.setLocation(panel.getWidth()*41/689,panel.getHeight()*136/552);
		label=new JLabel("��ʷ��Ŀ");
		label.setSize(panel.getWidth()*110/689,panel.getHeight()*30/552);
		label.setLocation(panel.getWidth()*267/689,panel.getHeight()*138/552);
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
		panel.add(label);
		
		table();
		
		panel.add(initialAccountPanel);
		button();
		Listener();
		initialAccountPanel.repaint();
		panel.repaint();
	}

	public void initTableData(){
		FinanceBLService service=ConstructFactory.FinanceFactory();
		BuildAccountVO vo=service.inquireAccount();
		int size=vo.getName().size();
		System.out.println("size is:"+size);
		ListIterator<String> name=vo.getName().listIterator();
		ListIterator<String> date=vo.getDate().listIterator();
		
		tableData=new String[size][2];
		int x=0;
		while(name.hasNext()){
			tableData[x][0]=name.next();
			tableData[x][1]=date.next();
			x++;
		}
	}
	
    public void table(){
    	tableTitle = new String[]{"������","����ʱ��"};
    	this.initTableData();
    	DefaultTableModel model=new DefaultTableModel(tableData,tableTitle);
    	table =new JTable (model){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row,int column){return false;}
		};
    	table.setSize(panel.getWidth()*514/689,panel.getHeight()*332/552);
    	table.setLocation(panel.getWidth()*180/689,panel.getHeight()*163/552);
   //���ò��ɱ༭����
		table.setRowHeight(panel.getWidth()/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//���ñ�ͷ�߶�
		table.getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setDragEnabled(false);
		table.setVisible(true);

		buildAccount.setSize(panel.getWidth()/8, panel.getHeight()/20);
		loadAccount.setSize(panel.getWidth()/8, panel.getHeight()/20);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(initialAccountPanel.getX()-panel.getWidth()/18+panel.getWidth()*38/689, initialAccountPanel.getY()-panel.getWidth()/50+panel.getWidth()*37/552,initialAccountPanel.getWidth(), 10*table.getRowHeight());
		
		buildAccount.setLocation(scrollPane.getX()+scrollPane.getWidth()/2,scrollPane.getY()+scrollPane.getHeight());
		loadAccount.setLocation(buildAccount.getX()+buildAccount.getWidth()/4*5,buildAccount.getY());
		
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		scrollPane.setVisible(true);		
    	panel.add(scrollPane);
    	panel.add(buildAccount);
    	panel.add(loadAccount);
    }
	
	
	public void button(){
		institution = new JButton("������Ŀ");
		employee = new JButton("Ա����Ŀ");
		vehicle = new JButton("������Ŀ");
		warehouse = new JButton("�ֿ���Ŀ");
		bankaccount = new JButton("�����˻���Ŀ");
		
		institution.setBounds(panel.getWidth()*40/689,panel.getHeight()*60/552,panel.getWidth()/7, panel.getHeight()/10);
		employee.setBounds(institution.getX()+panel.getWidth()/6,institution.getY(), panel.getWidth()/7, panel.getHeight()/10);
		vehicle.setBounds(employee.getX()+panel.getWidth()/6,institution.getY(), panel.getWidth()/7, panel.getHeight()/10);
		warehouse.setBounds(vehicle.getX()+panel.getWidth()/6,institution.getY(),panel.getWidth()/7, panel.getHeight()/10);
		bankaccount.setBounds(warehouse.getX()+panel.getWidth()/6,institution.getY(), panel.getWidth()/7, panel.getHeight()/10);
		
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
		this.buildAccount.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				FinanceBLService service=ConstructFactory.FinanceFactory();
				Date date=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
				String time=format.format(date);
				BuildAccountVO vo=new BuildAccountVO();
				WritePanel wp=(WritePanel) panel;
				FinanceMemory memory=(FinanceMemory) wp.getMemory();
				vo.addAccount(memory.getUserName(),time,table.getRowCount());
				service.buildAccount(vo);
			}
		});
		
		this.loadAccount.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				FinanceBLService service=ConstructFactory.FinanceFactory();
				int x=table.getSelectedRow();
				BuildAccountVO vo=new BuildAccountVO();
				vo.setId(x);
				service.loadAccount(vo);
			}
		});
	}
	
	public void remove(){
		panel.remove(institution);
		panel.remove(employee);
		panel.remove(vehicle);
		panel.remove(warehouse);
		panel.remove(bankaccount);
		panel.remove(initialAccountPanel);
		panel.remove(label);
		panel.remove(table);
	}
}