package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.FinanceBLService;
import main.businesslogicservice.InfoBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.SalaryVO;
import main.vo.StaffVO;

public class EmployeeAccountPanel {
	private JPanel panel;
	private JPanel employee;
	private JTabbedPane tab;
	private PageTable table;
	private JScrollPane scrollPane;
	private String[] tableTitle;
	private String[][] tableData;
	private JLabel next,previous,add,delete;
	private JLabel label1,label2,title,update,save,back;
	
	public  EmployeeAccountPanel (){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		employee = new JPanel();
		employee.setLayout(null);
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("Ա����Ŀ", employee);
		tab.setSize(panel.getWidth()*16/18,panel.getHeight()/100*90);
		tab.setLocation(panel.getWidth()/18,panel.getHeight()*2/20);
		panel.add(tab);
		getEmployeeAccountData();
		employeePanel();
		button();
		Listener();
		tab.repaint();
		panel.repaint();
	}
	
	public void employeePanel(){
		tableTitle =  new String[]{"Ա���˺�","Ա������","ְλ","������λ","��ְʱ��","����/��","���"};
	//	tableData = new String[][]{{"1","","","","","",""},{"2","","","","","",""},{"3","","","","","",""},
	//			{"4","5","","","","",""},{"6","","","","","",""},{"7","","","","","",""},{"8","","","","","",""},
	//			{"9","","","","","",""},{"10","","","","","",""},{"11","","","","","",""}};	
		table = new PageTable(tableTitle,tableData);
		table.setEnabled(false);//���ò��ɱ༭����
		table.setRowHeight(panel.getWidth()/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//���ñ�ͷ�߶�
		table.getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);

		scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/50,tab.getWidth(), 10*table.getRowHeight());
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		scrollPane.setVisible(true);		
		employee.add(scrollPane);
	}
	
	public void getEmployeeAccountData(){
		InfoBLService service = ConstructFactory.InfoFactory();
		ArrayList<StaffVO> staffList = service.showStaffList();
		
		System.out.println(":::::::::Employee:::::"+staffList.size());
		tableData = new String[staffList.size()][7];
		if(staffList.size()==0){
			tableData = new String[10][7];
			for(int x=0;x<10;x++)
				for(int y=0;y<7;y++)
					tableData[x][y]=null;
		}
		FinanceBLService service1 = ConstructFactory.FinanceFactory();
		SalaryVO salary = service1.readSalary();
		String[] salarys = new String[]{salary.getManagerSalary()+"", salary.getFinanceSalary()+"",
				salary.getCourierSalary()+"",salary.getAdminSalary()+"", salary.getWarehouseSalary()+"",
				salary.getLobbySalary()+"", salary.getIntermediateSalary()+""};
		String[] commissions = new String[]{salary.getManagerCommission()+"",salary.getFinanceCommission()+"",
				salary.getCourierCommission()+"",salary.getAdminCommission()+"",salary.getWareHouseCommission()+"",
				 salary.getLobbyCommission()+"",salary.getIntermediateCommission()+""};
		String[] jobs = new String[]{"MANAGER","FINANCE","COURIER","ACCOUNT","STOREHOUSE","LOBBY","INTERMEDIATE"};
		
		int counter=0;
		for(StaffVO vo: staffList){
			tableData[counter][0] = vo.getCode();
		//	SalaryVO commission = service1.;
			tableData[counter][1] = vo.getName();
			tableData[counter][2] = vo.getJob();
			tableData[counter][3] = vo.getUnit();
			tableData[counter][4] = vo.getWorkage();
			tableData[counter][5] =null;
			tableData[counter][6] = null;
			for(int i=0;i<jobs.length;i++){
				if( vo.getJob().equals(jobs[i])){
					tableData[counter][5] = salarys[i];
					tableData[counter][6] = commissions[i];
					break;
				}
			}
		counter++;
		}
	}
	
	
	
	
	
	public void button(){
		  title = new JLabel("Ա����Ŀ");
		  title .setBounds(panel.getWidth()*40/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
			
			
	/*	  previous=new JLabel("��һҳ");
		  previous.setBounds(panel.getWidth()*50/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  next=new JLabel("��һҳ");
		  next.setBounds(panel.getWidth()*60/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		   delete=new JLabel("ɾ��");
		  delete.setBounds(panel.getWidth()*73/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  add=new JLabel("���");
		  add.setBounds(panel.getWidth()*80/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  label1=new JLabel("�ܹ�"+table.totalRowCount+"��¼|��ǰ��"+table.currentPage+"ҳ");
		  label1.setBounds(institution.getWidth()*9/100,panel.getHeight()*71/100, panel.getWidth()/5, panel.getHeight()/20);
		*/  
		  
		  previous=new JLabel("��һҳ");
		  previous.setBounds(panel.getWidth()*70/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  next=new JLabel("��һҳ");
		  next.setBounds(panel.getWidth()*80/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		   delete=new JLabel("ɾ��");
		  delete.setBounds(panel.getWidth()*73/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  add=new JLabel("���");
		  add.setBounds(panel.getWidth()*80/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  label1=new JLabel("�ܹ�"+table.totalPage+"ҳ|��ǰ��"+table.currentPage+"ҳ");
		  label1.setBounds(panel.getWidth()*50/100,panel.getHeight()*71/100, panel.getWidth()/4, panel.getHeight()/20); 
		  label2=new JLabel("�ܹ�"+table.totalRowCount+"����¼"); 
		  label2.setBounds(panel.getWidth()*2/100,panel.getHeight()*71/100, panel.getWidth()/4, panel.getHeight()/20);
		  update = new JLabel("�½���Ŀ");
		  update.setBounds(panel.getWidth()*78/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  save = new JLabel("�浵");
		  save.setBounds(panel.getWidth()*70/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  back = new JLabel("����");
		  back.setBounds(panel.getWidth()*62/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  
		  employee.add(previous);
		  employee.add(next);
//		  institution.add(add);
//		  institution.add(delete);
		  employee.add(label1);
		  employee.add(label2);
		  employee.add(update);
		  employee.add(save);
		  employee.add(back);
		//  institution.add(title);
		  
		 }
		 /**
		  * ��ť�¼�
		  */
		 public void Listener() {
		  previous.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
				System.out.println("previousPage!!!!!");
					int i=table.getPreviousPage();
					DefaultTableModel model=new DefaultTableModel(table.getPageData(),tableTitle);
					table.setModel(model);
					label1.setText("�ܹ�"+table.totalPage+"ҳ|��ǰ��"+table.currentPage+"ҳ");
					label2.setText("�ܹ�"+table.totalRowCount+"����¼");
					if(i==-1)return;
		  }});
		  
		  next.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					System.out.println("nextPage!!!!!");
					int i=table.getNextPage();
					DefaultTableModel model=new DefaultTableModel(table.getPageData(),tableTitle);
					table.setModel(model);
					label1.setText("�ܹ�"+table.totalPage+"ҳ|��ǰ��"+table.currentPage+"ҳ");
					label2.setText("�ܹ�"+table.totalRowCount+"����¼");
					if(i==-1)return;
		  }});
		  back.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					panel.removeAll();
					InitialAccountPanel Initial = new InitialAccountPanel();
					Initial.init();
			}});
		 }
}
