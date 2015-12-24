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

import main.businesslogicservice.InfoBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.vo.CityVO;
import main.vo.VehicleVO;

public class VehicleAccountPanel {
	private JPanel panel;
	private JPanel vehicle;
	private JTabbedPane tab;
	private PageTable table;
	private JScrollPane scrollPane;
	private String[] tableTitle,city;
	private String[][] tableData;
	private JLabel next,previous,add,delete;
	private JLabel label1,label2,title,update,save,back;
	private ArrayList<String> array;
	
	
	public VehicleAccountPanel (){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		vehicle= new JPanel();
		vehicle.setLayout(null);
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("车辆账目", vehicle);
		tab.setSize(panel.getWidth()*16/18,panel.getHeight()/100*90);
		tab.setLocation(panel.getWidth()/18,panel.getHeight()*2/20);
		panel.add(tab);
		getTableData();
		vehiclePanel();
		button();
		Listener();
		tab.repaint();
		panel.repaint();
	}
	
	public void vehiclePanel(){
		tableTitle =  new String[]{"车牌号","所属机构编号","引擎代号","底盘号","购买时间","服役时间"};
	//	tableData = new String[][]{{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
	//			{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
	//			{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}};	
		
		table = new PageTable(tableTitle,tableData);

		table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panel.getWidth()/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);

//		if(tableData.length>=10){
		scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/50,tab.getWidth(), 10*table.getRowHeight());
			//}else{
		//		scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/50,tab.getWidth(), (table.getRowCount()+1)*table.getRowHeight());
		//	}
	//	table.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/5);;
	//	table.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/6);;
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane.setVisible(true);		
		vehicle.add(scrollPane);
	}
	
	
	public void getTableData(){
	
		
	/*	InfoBLService service = ConstructFactory.InfoFactory();		
		CityVO cityVO = service.inquireCity();	
		if(cityVO!=null){
		
			city=cityVO.getCityName().substring(1).split(" ");
			array = cityVO.getInsititutionNum();
			String[][]  InsititutionName=new String[city.length][];
			int x=0;
			for(String s:array){
				 InsititutionName[x]=s.split(" "); 
				 x++;
			}
			
			int counter=0;
			int a=0;
			for(int i=0;i<city.length;i++){
				for(int j=0;j<InsititutionName[i].length;j++){
					ArrayList<VehicleVO> list=service.inquireVehicle(InsititutionName[i][j]);
					a=a+list.size();
				}
			}
				tableData = new String[a][6];	
				for(int i1=0;i1<city.length;i1++){
					for(int j=0;j<InsititutionName[i1].length;j++){
						ArrayList<VehicleVO> list=service.inquireVehicle(InsititutionName[i1][j]);
					for(VehicleVO vo:list){
						tableData[counter][0]=vo.getCarID();
						tableData[counter][1]=vo.getEngineID();
						tableData[counter][2]=vo.getCarNum();
						tableData[counter][3]=vo.getUnderpanID();
						tableData[counter][4]=vo.getBoughtTime();
						tableData[counter][5]=vo.getUsedTime();
						counter++;
					}
					}
			}
		}else{
				tableData = new String[10][6];
				for(int x=0;x<10;x++)
					for(int y=0;y<6;y++)
						tableData[x][y]=null;
			
		}

		*/
		InfoBLService service=ConstructFactory.InfoFactory();
		ArrayList<VehicleVO> list=service.showVehicalList();
		System.out.println("}}}}}::::::"+list.size());
		tableData = new String[list.size()][6];
		if(list.size()==0){
			tableData = new String[10][6];
			for(int x=0;x<10;x++)
				for(int y=0;y<6;y++)
					tableData[x][y]=null;
		}
		int counter=0;
		for(VehicleVO vo:list){
			tableData[counter][0]=vo.getCarID();
			tableData[counter][1]=vo.getEngineID();
			tableData[counter][2]=vo.getCarNum();
			tableData[counter][3]=vo.getUnderpanID();
			tableData[counter][4]=vo.getBoughtTime();
			tableData[counter][5]=vo.getUsedTime();
			counter++;
		}
	}
	
	public void button(){
		  title = new JLabel("车辆账目");
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
		  
		  vehicle.add(previous);
		  vehicle.add(next);
//		  institution.add(add);
//		  institution.add(delete);
		  vehicle.add(label1);
		  vehicle.add(label2);
		  vehicle.add(update);
		  vehicle.add(save);
		  vehicle.add(back);
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
