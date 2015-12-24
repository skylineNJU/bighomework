package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
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
		label=new JLabel("历史账目");
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
		panel.add(label);
		
		table();
		
		panel.add(initialAccountPanel);
		button();
		Listener();
		initialAccountPanel.repaint();
		panel.repaint();
	}

	
    public void table(){
    	tableTitle = new String[]{"创建者","创建时间"};
    	tableData=new String[][]{{"null","null"}};
    	table =new JTable (tableData,tableTitle);
    	table.setSize(panel.getWidth()*514/689,panel.getHeight()*332/552);
    	table.setLocation(panel.getWidth()*180/689,panel.getHeight()*163/552);
    	table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panel.getWidth()/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setDragEnabled(false);
		table.setVisible(true);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(initialAccountPanel.getX()-panel.getWidth()/18+panel.getWidth()*38/689, initialAccountPanel.getY()-panel.getWidth()/50+panel.getWidth()*37/552,initialAccountPanel.getWidth(), 10*table.getRowHeight());
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane.setVisible(true);		
    	panel.add(scrollPane);
    }
	
	
	public void button(){
		institution = new JButton("机构账目");
		employee = new JButton("员工账目");
		vehicle = new JButton("车辆账目");
		warehouse = new JButton("仓库账目");
		bankaccount = new JButton("银行账户账目");
		
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