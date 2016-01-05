package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.InfoBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.CityVO;
import main.vo.IntermediateInfoVO;
import main.vo.LobbyInfoVO;
import main.vo.WarehouseInfoVO;

public class InstitutionAccountPanel {
	private JPanel panel;
	private JPanel institution;
	private JTabbedPane tab;
	private PageTable table;
	private JScrollPane scrollPane;
	private String[] tableTitle;
	private String[][] tableData;
	private JLabel next,previous,add,delete;
	private JLabel label1,label2,title,update,save,back;
	private int x=0,size=0;
	
	public InstitutionAccountPanel (){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		
		institution = new JPanel();
		institution.setLayout(null);
		institution.setVisible(true);
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("������Ŀ", institution);
		tab.setSize(panel.getWidth()*16/18,panel.getHeight()/100*90);
		tab.setLocation(panel.getWidth()/18,panel.getHeight()*2/20);
		panel.add(tab);
		getInsititutionAcountData();
		institutionPanel();
	//	initTableData();
		button();
		Listener();
		tab.repaint();
		panel.repaint();
	}
	
	public void institutionPanel(){
		tableTitle =  new String[]{"��������","���","���ڳ���","��Ա����","ռ�����/m^2"};
//		tableData = new String[][]{{"","1","","","",""},{"","2","","","",""},{"","3","","","",""},{"","4","","","",""},
	//			{"","5","","","",""},{"","6","","","",""},{"","7","","","",""},{"","8","","","",""},
	//			{"","9","","","",""},{"","10","","","",""},{"","11","","","",""},{"","12","","","",""}};	

		table = new PageTable(tableTitle,tableData);
		table.setEnabled(false);//���ò��ɱ༭����
		table.setRowHeight(panel.getWidth()/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//���ñ�ͷ�߶�
		table.getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
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
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		scrollPane.setVisible(true);		
		institution.add(scrollPane);
	}


	public void getInsititutionAcountData(){
		//�ȵõ����г��� �ٴ���������
		InfoBLService service = ConstructFactory.InfoFactory();		
		CityVO cityVO = service.inquireCity();	
		if(cityVO!=null){
		String citys=cityVO.getCityName().substring(1);
		
		System.out.println("==========citys==========="+citys);
		
		String[] city = citys.split(" "); 
		for(int i=0;i<city.length;i++){
			ArrayList<LobbyInfoVO> lobbyList=service.inquireLobby(city[i]);
			size = lobbyList.size()+1+1+size;
		}
		tableData = new String[size][5];
		for(int i=0;i<city.length;i++){
			IntermediateInfoVO vo=service.inquireInterm(city[i]);
			ArrayList<WarehouseInfoVO> voList=vo.getWarehouseInfoList();
			ArrayList<LobbyInfoVO> lobbyList=service.inquireLobby(city[i]);		
			tableData[x][0] = "��ת����";
			tableData[x][1] = vo.getInstitutionCode();
			tableData[x][2] = vo.getCity();
			tableData[x][3] = vo.getStaffNum()+"";
			tableData[x][4] = vo.getArea()+"";
			x++;
			int StaffNum=0;
			double Acreage=0;

			for(WarehouseInfoVO warVO:voList){
				StaffNum = StaffNum + warVO.getStaffNum();
				Acreage = Acreage + warVO.getAcreage();
				tableData[x][2] =warVO.getCity();
				}	
			tableData[x][0] = "�ֿ�";
			tableData[x][1] = vo.getInstitutionCode();
			tableData[x][3] = StaffNum+"";
			tableData[x][4] = Acreage+"";
			x++;
			
			for(LobbyInfoVO lobbyInfo:lobbyList){
				tableData[x][0]="Ӫҵ��";
				tableData[x][1]=lobbyInfo.getLobbyCode();
				tableData[x][2]=lobbyInfo.getCity();
				tableData[x][3]=lobbyInfo.getStaffNum()+"";
				tableData[x][4]=lobbyInfo.getArea()+"";
				x++;
				System.out.println("get a lobbyData");
			}
			System.out.println("========lobbyx========"+x);
		}
		}
		
		else{
				tableData = new String[10][5];
				for(int x=0;x<10;x++)
					for(int y=0;y<5;y++)
						tableData[x][y]=null;
			
		}
}
	
	

	  // TODO Auto-generated method stub
	public void button(){
	  title = new JLabel("������Ŀ");
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
	  
	  institution.add(previous);
	  institution.add(next);
//	  institution.add(add);
//	  institution.add(delete);
	  institution.add(label1);
	  institution.add(label2);
	  institution.add(update);
	  institution.add(save);
	  institution.add(back);
	//  institution.add(title);
	  
	 }
	 /**
	  * �����¼�
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
	   label1.setText("�ܹ�"+table.totalRowCount+"��¼|��ǰ��"+table.currentPage+"ҳ");
	   return;
	  }
	  if(button.equals(add)){
	   Integer id=0;
	   for(Student stu:Student.students){
	    if(stu.getId()>id)id=stu.getId();
	   }
	   Student student=new Student(id+1,"wuming"+(id+1),"��",22);
	   Student.students.add(student);
	   table.initTable();
	   label1.setText("�ܹ�"+table.totalRowCount+"��¼|��ǰ��"+table.currentPage+"ҳ");
	   return;
	  }
	  */
	
	 }
	
	
}
	 
	