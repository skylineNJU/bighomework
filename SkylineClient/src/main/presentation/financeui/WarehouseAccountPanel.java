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

import main.businesslogicservice.WarehouseBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
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
		tab.addTab("�ֿ���Ŀ", warehouse);
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
		tableTitle =  new String[]{"������","��������","�������ڲֿ���","����ʱ��","��","�ź�","�ܺ�","λ��","Ŀ�ĵ�","�����"};
//	    tableData = new String[][]{{"1","","","",""},{"2","","","",""},{"3","","","",""},
//				{"4","","","",""},{"5","","","",""},{"6","","","",""},{"7","","","",""},
//				{"8","","","",""},{"9","","","",""},{"10","","","",""},{"11","","","",""}};	
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
		warehouse.add(scrollPane);
	}
	
	public void getWarehouseAcountData(){
		WarehouseBLService service = ConstructFactory.WarehouseFactory();
		ArrayList<InventoryVO> Inventory =service.readCargoList();
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
			String[] eara=vo.getArea().split(" ");
			tableData[counter][0] = vo.getOrderCode();
			tableData[counter][1] = vo.getReceiptType();
			tableData[counter][2] = eara[0];//0100 ������ //�õ� "010"
			tableData[counter][3] = vo.getArriveDate();
			tableData[counter][4] = eara[1];
			tableData[counter][8] = vo.getDestination();//�õ�  "������"
			tableData[counter][5] = vo.getRow()+"";
			tableData[counter][6] = vo.getShelf()+"";
			tableData[counter][7] = vo.getPosition()+"";
			tableData[counter][9] = vo.getDamageCondition();
			counter++;
		}
	}
	
	
	
	
	public void button(){
		  title = new JLabel("�ֿ���Ŀ");
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
		  
		  warehouse.add(previous);
		  warehouse.add(next);
 	//	  institution.add(add);
    // 	  institution.add(delete);
		  warehouse.add(label1);
		  warehouse.add(label2);
		  warehouse.add(update);
		  warehouse.add(save);
		  warehouse.add(back);
	//	  institution.add(title);
		  
		  
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
