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
// 期初建账
//机构、人员、车辆、库存、 银行账户信息（名称，余额）
/*
 * 期初建账（这个系统是可以支持建多套账的（整个系统一般一年算一套帐，不同账上可以有同一客户），
 * 每套帐在新建（新建账的频率一般一年一次，或者2年一次）的时候都要经过期初建账这一环节，可以理解为一套帐的初始化操作。
 * 包括：机构、人员、车辆、库存、 银行账户信息（名称，余额）。
 * 期初的信息一旦建立完毕就会单独存储起来，同时将此信息作为系统的启动初始状态，之后的一切操作将会改变系统里的信息，但不会改变期初信息。
 * 期初信息随时可查。）
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
		tab.addTab("机构账目", institution);
		tab.addTab("员工账目", employee);
		tab.addTab("车辆账目", vehicle);
		tab.addTab("仓库账目", warehouse);
		tab.addTab("银行账户账目", bankaccount);
		
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
		institution = new JButton("机构账目");
		employee = new JButton("员工账目");
		vehicle = new JButton("车辆账目");
		warehouse = new JButton("仓库账目");
		bankaccount = new JButton("银行账户账目");
		
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
		tableTitle1 =  new String[]{"机构类型","编号","所在城市","总员工数","占地面积/m^2","建立日期"};
		tableData1 = new String[][]{{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},
				{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},
				{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}};	
		initTable(tableTitle1,tableData1,scrollPane1,table1,institution);
	//	institution.add(scrollPane1);
	}
	
	public void employeePanel(){
		tableTitle1 =  new String[]{"员工账号","员工姓名","职位","所属单位","入职时间","工资/月","提成"};
		tableData2 = new String[][]{{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
				{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
				{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}};	
		initTable(tableTitle2,tableData2,scrollPane2,table2,employee);
	//	employee.add(scrollPane2);

	}
	
	public void vehiclePanel(){
		tableTitle3 =  new String[]{"车牌号","引擎代号","车辆代号","底盘号","购买时间","服役时间","购买金额/元"};
		tableData3 = new String[][]{{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
				{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
				{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}};	
		initTable(tableTitle3,tableData2,scrollPane3,table3,vehicle);
	//	vehicle.add(scrollPane3);
	}
	
	public void warehousePanel(){
		tableTitle4 =  new String[]{"订单号","单据种类","生成时间","费用/元","详细信息"};
		tableData4 = new String[][]{{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};	
		initTable(tableTitle4,tableData4,scrollPane4,table4,warehouse);
	//	warehouse.add(scrollPane4);
	}
	
	public void bankaccountPanel(){
		tableTitle5 =  new String[]{"银行账户","金额/元"};
		tableData5 = new String[][]{{"航运区","","","","100%"},{"铁路区","","","","100%"},{"汽运区","","","","100%"},{"机动区","","","","100%"}};	
		initTable(tableTitle5,tableData5,scrollPane5,table5,bankaccount);
	//	bankaccount.add(scrollPane5);
	}
	public void initTable( String[] tableTitle, String[][] tableData,JScrollPane scrollPane,JTable table,JPanel a){
		table = new JTable(tableData,tableTitle);
		table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panel.getWidth()/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table.getTableHeader().setReorderingAllowed(false);//表头不可移动
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
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane.setVisible(true);		
		a.add(scrollPane);
	}
}
*/