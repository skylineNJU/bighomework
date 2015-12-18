package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.FinanceBLService;
import main.businesslogicservice.WarehouseBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.BankAccountVO;
import main.vo.InventoryVO;

public class WarehouseAccountPanel {
	private JPanel panel;
	private JPanel warehouse;
	private JTabbedPane tab;
	private PageTable table;
	private JScrollPane scrollPane;
	private String[] tableTitle;
	private String[][] tableData;
	private JLabel next,previous,add,delete;
	private JLabel label1,label2,title,update,save,back;
	
	public WarehouseAccountPanel (){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		warehouse = new JPanel();
		warehouse.setLayout(null);
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("仓库账目", warehouse);
		tab.setSize(panel.getWidth()*16/18,panel.getHeight()/100*90);
		tab.setLocation(panel.getWidth()/18,panel.getHeight()*2/20);
		panel.add(tab);
		getWarehouseAcountData();
		warehousePanel();
		button();
		Listener();
		tab.repaint();
		panel.repaint();
	}
	
	
	
	public void warehousePanel(){
		tableTitle =  new String[]{"订单号","单据种类","货物所在城市编号","生成时间","区","排号","架号","位号","目的地","损坏情况"};
	//tableData = new String[][]{{"1","","","",""},{"2","","","",""},{"3","","","",""},
	//			{"4","","","",""},{"5","","","",""},{"6","","","",""},{"7","","","",""},
	//			{"8","","","",""},{"9","","","",""},{"10","","","",""},{"11","","","",""}};	
		table = new PageTable(tableTitle,tableData);

		table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panel.getWidth()/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/50,tab.getWidth(), 10*table.getRowHeight());
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane.setVisible(true);		
		warehouse.add(scrollPane);
	}
	
	public void getWarehouseAcountData(){
		WarehouseBLService service = ConstructFactory.WarehouseFactory();
		ArrayList<InventoryVO> Inventory = service.showWarehouseList();
		tableData = new String[Inventory.size()][10];
		System.out.println("++++++WarehouseAccount++++++:::"+Inventory.size());
		if(Inventory.size()==0){
			tableData = new String[10][10];
			for(int x=0;x<10;x++)
				for(int y=0;y<10;y++)
					tableData[x][y]=null;
		}
		int counter = 0;
		for(InventoryVO vo:Inventory){
			tableData[counter][0] = vo.getOrderCode();
			tableData[counter][1] = vo.getReceiptType();
			tableData[counter][2] = vo.getArea().substring(0, 3);//0100 航运区 //得到 "010"
			tableData[counter][3] = vo.getArriveDate();
			tableData[counter][4] = vo.getDestination();
			tableData[counter][5] = vo.getArea().substring(5);//得到  "航运区"
			tableData[counter][6] = vo.getRow()+"";
			tableData[counter][7] = vo.getShelf()+"";
			tableData[counter][8] = vo.getPosition()+"";
			tableData[counter][9] = vo.getDamageCondition();
			counter++;
		}
	}
	
	
	
	
	public void button(){
		  title = new JLabel("仓库账目");
		  title .setBounds(panel.getWidth()*40/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
			
			
	/*	  previous=new JLabel("上一页");
		  previous.setBounds(panel.getWidth()*50/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  next=new JLabel("下一页");
		  next.setBounds(panel.getWidth()*60/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		   delete=new JLabel("删除");
		  delete.setBounds(panel.getWidth()*73/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  add=new JLabel("添加");
		  add.setBounds(panel.getWidth()*80/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  label1=new JLabel("总共"+table.totalRowCount+"记录|当前第"+table.currentPage+"页");
		  label1.setBounds(institution.getWidth()*9/100,panel.getHeight()*71/100, panel.getWidth()/5, panel.getHeight()/20);
		*/  
		  
		  previous=new JLabel("上一页");
		  previous.setBounds(panel.getWidth()*70/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  next=new JLabel("下一页");
		  next.setBounds(panel.getWidth()*80/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		   delete=new JLabel("删除");
		  delete.setBounds(panel.getWidth()*73/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  add=new JLabel("添加");
		  add.setBounds(panel.getWidth()*80/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  label1=new JLabel("总共"+table.totalPage+"页|当前第"+table.currentPage+"页");
		  label1.setBounds(panel.getWidth()*50/100,panel.getHeight()*71/100, panel.getWidth()/4, panel.getHeight()/20); 
		  label2=new JLabel("总共"+table.totalRowCount+"条记录"); 
		  label2.setBounds(panel.getWidth()*2/100,panel.getHeight()*71/100, panel.getWidth()/4, panel.getHeight()/20);
		  update = new JLabel("新建账目");
		  update.setBounds(panel.getWidth()*78/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  save = new JLabel("存档");
		  save.setBounds(panel.getWidth()*70/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  back = new JLabel("返回");
		  back.setBounds(panel.getWidth()*62/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  
		  warehouse.add(previous);
		  warehouse.add(next);
//		  institution.add(add);
//		  institution.add(delete);
		  warehouse.add(label1);
		  warehouse.add(label2);
		  warehouse.add(update);
		  warehouse.add(save);
		  warehouse.add(back);
		//  institution.add(title);
		  
		 }
		 /**
		  * 按钮事件
		  */
		 public void Listener() {
		  previous.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
				System.out.println("previousPage!!!!!");
					int i=table.getPreviousPage();
					DefaultTableModel model=new DefaultTableModel(table.getPageData(),tableTitle);
					table.setModel(model);
					label1.setText("总共"+table.totalPage+"页|当前第"+table.currentPage+"页");
					label2.setText("总共"+table.totalRowCount+"条记录");
					if(i==-1)return;
		  }});
		  
		  next.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					System.out.println("nextPage!!!!!");
					int i=table.getNextPage();
					DefaultTableModel model=new DefaultTableModel(table.getPageData(),tableTitle);
					table.setModel(model);
					label1.setText("总共"+table.totalPage+"页|当前第"+table.currentPage+"页");
					label2.setText("总共"+table.totalRowCount+"条记录");
					if(i==-1)return;
		  }});
		  back.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					panel.removeAll();
					InitialAccountPanel Initial = new InitialAccountPanel();
					Initial.init();
			}});
		/* if(button.equals(delete)){
		   int i=table.getSelectedRow();
		   if(i==-1)return ;
		   Integer id=(Integer) table.getValueAt(i,0);
		   if(id==null)return ;
		   Student s=null;
		   for(Student stu:Student.students){
		    if(stu.getId().equals(id))
		     s=stu;
		   }
		   int index=Student.students.indexOf(s);
		   Student.students.remove(index);
		   table.initTable();
		   label1.setText("总共"+table.totalRowCount+"记录|当前第"+table.currentPage+"页");
		   return;
		  }
		  if(button.equals(add)){
		   Integer id=0;
		   for(Student stu:Student.students){
		    if(stu.getId()>id)id=stu.getId();
		   }
		   Student student=new Student(id+1,"wuming"+(id+1),"男",22);
		   Student.students.add(student);
		   table.initTable();
		   label1.setText("总共"+table.totalRowCount+"记录|当前第"+table.currentPage+"页");
		   return;
		  }
		  */
		
		 }
}
