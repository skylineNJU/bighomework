package main.presentation.warehouseui;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.businesslogicservice.WarehouseBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.vo.InventoryVO;

//库存盘点
public class CheckInventoryPanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JButton ok;
	private JButton export;
	private JLabel title;//标题
	private JLabel ddl;
	private JTextField areanumber;
	private JScrollPane scrollPane;
	private JTable table;
	private String[] tableTitle;
	private String[][] tableData;
	
	public CheckInventoryPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		//title();
		other();
		initTable();
		
		
		
		
		
		panel.repaint();
	}
	private void other() {
		title = new JLabel("区号: ");
		Font font = new Font("宋体", Font.PLAIN, 20);
		title.setFont(font);
		title.setBounds(panel.getWidth()/18, panel.getHeight()/11, panel.getWidth()/6, panel.getHeight()/20 );
		panel.add(title);
		
		areanumber = new JTextField();
		areanumber.setBounds(panel.getWidth()/8, panel.getHeight()/11, panel.getWidth()/18, panel.getHeight()/20 );
		areanumber.setVisible(true);
		panel.add(areanumber);
		
		areanumber.addKeyListener(new KeyListener() {	
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// 监听到回车事件	
					tableData = initTableData();
					for(int i=0;i<tableData.length;i++){
						for(int j=0;j<tableData[0].length;j++){
							table.setValueAt(tableData[i][j], i, j);
						}
					}
					
				}
			}		
			@Override
			public void keyReleased(KeyEvent arg0){
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub		
				}			
		});
		
		ok=new JButton("确定");
		ok.setBounds(panel.getWidth()*17/20,panel.getHeight()*7/8, panel.getWidth()/11, panel.getHeight()/15);
		ok.setVisible(true);
		
		ddl= new JLabel("上一个截至点: 2015年11月28日");
		ok.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Calendar calendar = Calendar.getInstance();
		    	String	year = String.valueOf(calendar.get(Calendar.YEAR))+"年";
		    	String	month = String.valueOf(calendar.get(Calendar.MONTH)+1)+"月";
		    	String	day = String.valueOf(calendar.get(Calendar.DATE))+"日";
		    	String data=year+month+day;
		    	ddl.setText("上一个截至点: "+data);
			}
		});
		
		
		ddl.setBounds(panel.getWidth()/16,panel.getHeight()*7/8, panel.getWidth()*2/5, panel.getHeight()/15);
		ddl.setVisible(true);
		
		export=new JButton("导出");
		export.setBounds(panel.getWidth()*15/20,panel.getHeight()*7/8, panel.getWidth()/11, panel.getHeight()/15);
		export.setVisible(true);

		panel.add(ok);
		panel.add(export);
		panel.add(ddl);		
	}
	//初始化表格
	public void initTable(){
		tableTitle = new String[]{"订单号","入库日期","目的地","区号","排号","架号","位号"};
		tableData = initTableData();
		table = new JTable(tableData,tableTitle);
		table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		if(tableData.length>=10){
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, 11*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, (table.getRowCount()+1)*table.getRowHeight());
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/5);;
		table.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/6);;
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane.setVisible(true);	
		panel.add(scrollPane);
	}

	public String[][] initTableData(){
		String[][] content =new String[20][7];
		for(int x=0;x<20;x++)
			for(int y=0;y<7;y++)
				content[x][y]=null;
	
		ArrayList<InventoryVO> inventory=null;
		WarehouseBLService service=ConstructFactory.WarehouseFactory();
		assert(areanumber.getText()!=null);
		System.out.println("+++++++++++++++::::"+areanumber.getText());
		inventory=service.checkInventory(((WritePanel)panel).getBelong()+" "+areanumber.getText());
		if(inventory!=null){
		int counter=0;
		for(InventoryVO vo:inventory){
			content[counter][0]=vo.getOrderCode();
			content[counter][1]=vo.getArriveDate();
			content[counter][2]=vo.getDestination();
			content[counter][3]=vo.getArea();
			content[counter][4]=vo.getRow()+"";
			content[counter][5]=vo.getShelf()+"";
			content[counter][6]=vo.getPosition()+"";
			counter++;
		}
		}
		return content;
	}
		
	public void remove(){
		panel.remove(ddl);
		panel.remove(scrollPane);
		panel.remove(export);
		panel.remove(ok);
		panel.remove(title);
		panel.remove(areanumber);
	}	
}


