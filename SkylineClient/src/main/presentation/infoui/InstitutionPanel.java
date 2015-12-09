package main.presentation.infoui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.InfoBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.LobbyInfoVO;

public class InstitutionPanel {

	
	private JPanel panel;
	private JPanel IntermPanel;
	private JPanel LobbyPanel;
	private JTabbedPane tab;
	private JTable table1;
	private JTable table11;
	private JTable table2;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane11;
	private JScrollPane scrollPane2;
	private String[] tableTitle1;
	private String[] tableTitle11;
	private String[] tableTitle2;
	private String[][] tableData1;
	private String[][] tableData11;
	private String[][] tableData2;
	private JLabel citys;
	private JLabel newWarehouse;
	private JLabel newInterm;
	private JLabel modifty;
	private JLabel save;
	private JLabel newLobby;
	private JLabel ok;
	private JTextField city;
	private JLabel message;
	private	DefaultTableModel   defaultModel11 ;
	private	DefaultTableModel   defaultModel1 ;
	private	DefaultTableModel   defaultModel2 ;
	private Vector<String> columnNameV; // declare the table column name vector  
	private Vector<Vector<Object>> tableValueV; // declare the table value     // vector  
	private int fixedColumn = 1; // the fixed column number                                
	private int oldLobbyNum=0;
	private int oldInstitutionNum=0;
	private JTextField stuffNumText=new JTextField();
	private JTextField earaText=new JTextField();
	private JLabel stuffNumLabel=new JLabel("员工数目");
	private JLabel earaLabel=new JLabel("占地面积");
	
	public InstitutionPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		IntermPanel = new JPanel();
		IntermPanel.setLayout(null);
		IntermPanel.setVisible(true);
		LobbyPanel = new JPanel();
		LobbyPanel.setLayout(null);
		LobbyPanel.setVisible(true);
		
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("中转中心", IntermPanel);
		tab.addTab("营业厅", LobbyPanel);
		tab.setSize(panel.getWidth()*7/8,panel.getHeight()/100*75);
		tab.setLocation(panel.getWidth()/16,panel.getHeight()/6);
	
		
		initIntermTable();
		initLobbyTable();
		Button();
		Listener();
		panel.add(tab);	
		tab.repaint();
		panel.repaint();
		
	}
	
	public void initIntermTable(){
	
		tableTitle11 = new String[]{"所属城市","中转中心编号","机构员工数","占地面积/m^2"};
		tableData11=new String[][]{{"上海","0210","400","1000"}};
		defaultModel11   =  new   DefaultTableModel(tableData11,tableTitle11);;
		table11 = new JTable(defaultModel11);
		table11.setEnabled(false);//设置不可编辑内容
		table11.setRowHeight(panel.getWidth()/20);//设置列宽
		table11.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table11.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table11.setDragEnabled(false);
		table11.setVisible(true);
		table11.setBorder(BorderFactory.createEtchedBorder());
		scrollPane11 = new JScrollPane(table11);
		scrollPane11.setBounds(tab.getX()-panel.getWidth()/16, tab.getY()-panel.getWidth()/7,tab.getWidth()+panel.getWidth()/30, (table11.getRowCount()+1)*table11.getRowHeight());
		table11.getColumnModel().getColumn(0).setPreferredWidth(scrollPane11.getWidth()/5);
		table11.getColumnModel().getColumn(1).setPreferredWidth(scrollPane11.getWidth()/6);
	
		table11.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane11.setVisible(true);
	
		
		tableTitle1 = new String[]{"仓库区","总员工数","占地面积/m^2","仓库警戒值"};
		tableData1=new String[][]{{"航运区","50","500","90%"},{"铁路区","50","600","90%"},{"汽运区","50","500","90%"},{"机动区","50","508","90%"}};	
		defaultModel1   =  new   DefaultTableModel(tableData1,tableTitle1){	public boolean isCellEditable(int row, int column) {  
	        return true;  
	     } } ;
		table1 = new JTable(defaultModel1);
		table1.setEnabled(false);//设置不可编辑内容
		table1.setRowHeight(panel.getWidth()/20);//设置列宽
		table1.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table1.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table1.setDragEnabled(false);
		table1.setVisible(true);
		scrollPane1 = new JScrollPane(table1);
		if(tableData1.length>=7){
			scrollPane1.setBounds(tab.getX()+panel.getWidth()/25, tab.getY(),tab.getWidth()*4/5, 7*table1.getRowHeight());
		}else{
			scrollPane1.setBounds(tab.getX()+panel.getWidth()/25, tab.getY(),tab.getWidth()*4/5, (table1.getRowCount()+1)*table1.getRowHeight());
		}
		table1.getColumnModel().getColumn(0).setPreferredWidth(scrollPane1.getWidth()/5);;
		table1.getColumnModel().getColumn(1).setPreferredWidth(scrollPane1.getWidth()/6);;
		table1.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane1.setVisible(true);
		scrollPane1.setEnabled(false);
		IntermPanel.add(scrollPane1);
		IntermPanel.add(scrollPane11);
	}
	
	public void initLobbyTable(){
	//	现有北京、上海、广州、南京设有中转中心。每个中转中心下设各设20、20、15、20、10个营业厅。未来会扩展城市的中转中心和营业厅数量。
	//   每营业厅业务员大约5人。司机20人。
	//营业厅编号是三位数000
		tableTitle2 = new String[]{"营业厅编号","机构员工数","占地面积/m^2"};
		tableData2=new String[][]{};	
		defaultModel2   =  new   DefaultTableModel(tableData2,tableTitle2);;
		table2 = new JTable(defaultModel2);
		table2.setEnabled(false);//设置不可编辑内容
		table2.setRowHeight(panel.getWidth()/20);//设置列宽
		table2.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table2.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table2.setDragEnabled(false);
		table2.setVisible(true);
		scrollPane2 = new JScrollPane(table2);
		//if(tableData2.length>=10){
			scrollPane2.setBounds(tab.getX()-panel.getWidth()/16, tab.getY()-panel.getWidth()/7,tab.getWidth(), 8*table2.getRowHeight());
		//}else{
		//	scrollPane2.setBounds(tab.getX()-panel.getWidth()/16, tab.getY()-panel.getWidth()/7,tab.getWidth(), (table2.getRowCount()+1)*table2.getRowHeight());
		//}
		this.stuffNumLabel.setBounds(scrollPane2.getWidth()/10,scrollPane2.getHeight()/28*32+scrollPane2.getY(),scrollPane2.getWidth()/10,table2.getRowHeight());
		this.stuffNumText.setBounds(stuffNumLabel.getX()+stuffNumLabel.getWidth()+scrollPane2.getWidth()/15,stuffNumLabel.getY(),scrollPane2.getWidth()/5,table2.getRowHeight());
		this.earaLabel.setBounds(stuffNumText.getX()+stuffNumText.getWidth()+scrollPane2.getWidth()/15,stuffNumLabel.getY(),scrollPane2.getWidth()/10,table2.getRowHeight());
		this.earaText.setBounds(earaLabel.getX()+earaLabel.getWidth()+scrollPane2.getWidth()/15,stuffNumLabel.getY(),scrollPane2.getWidth()/5,table2.getRowHeight());
		table2.getColumnModel().getColumn(0).setPreferredWidth(scrollPane2.getWidth()/5);;
		table2.getColumnModel().getColumn(1).setPreferredWidth(scrollPane2.getWidth()/6);;
		table2.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane2.setVisible(true);
		scrollPane2.setEnabled(false);
		LobbyPanel.add(scrollPane2);
		LobbyPanel.add(this.stuffNumLabel);
		LobbyPanel.add(this.stuffNumText);
		LobbyPanel.add(this.earaLabel);
		LobbyPanel.add(this.earaText);
		this.stuffNumLabel.setVisible(false);
		this.stuffNumText.setVisible(false);
		this.earaLabel.setVisible(false);
		this.earaText.setVisible(false);
	}
	
	public String[][] getInterm(){
		String[][] content =new String[1][4];
		for(int x=0;x<1;x++)
			for(int y=0;y<4;y++)
				content[x][y]=null;
		return content;
	}
	
	public String[][] getWarehouse(){
		String[][] content =new String[4][4];
		for(int x=0;x<4;x++)
			for(int y=0;y<4;y++)
				content[x][y]=null;
		return content;
	}
	
	public String[][]  getLobby(){
		String[][] content =new String[20][4];
		for(int x=0;x<20;x++)
			for(int y=0;y<4;y++)
				content[x][y]=null;
		return content;
	} 
	
	
	public void Button(){
		//可用符号代替
		newWarehouse = new JLabel("新增仓库");
		newInterm = new JLabel("新增中转中心");
		save = new JLabel("保存");
		newLobby = new JLabel("新增营业厅");
		modifty = new JLabel("修改");
	//	newWarehouse.setBounds(panel.getWidth()*60/100,panel.getHeight()*53/60, panel.getWidth()/10, panel.getHeight()/15);
		newInterm.setBounds(panel.getWidth()*60/100,panel.getHeight()*53/60, panel.getWidth()/5, panel.getHeight()/15);
		newLobby.setBounds(panel.getWidth()*60/100,panel.getHeight()*53/60, panel.getWidth()/5, panel.getHeight()/15);
		modifty.setBounds(panel.getWidth()*75/100,panel.getHeight()*53/60, panel.getWidth()/10, panel.getHeight()/15);
		save.setBounds(panel.getWidth()*85/100,panel.getHeight()*53/60, panel.getWidth()/10, panel.getHeight()/15);
		
		
		message = new JLabel("请输入要查看的机构所在城市：");
		message.setBounds(panel.getWidth()*8/100,panel.getHeight()*2/60, panel.getWidth()/3, panel.getHeight()/15);
		city=new JTextField();
		city.setBounds(panel.getWidth()*9/100,panel.getHeight()*6/60, panel.getWidth()/12, panel.getHeight()/20);
		ok = new JLabel("确认");
		ok.setBounds(panel.getWidth()*25/100,panel.getHeight()*7/80, panel.getWidth()/10, panel.getHeight()/15);
		
		
		newLobby.setVisible(false);
	//	newWarehouse.setVisible(true);
		newInterm.setVisible(true);
		ok.setVisible(true);
		city.setVisible(true);
		message.setVisible(true);
		
	//	panel.add(newWarehouse);
		panel.add(newInterm);
		panel.add(newLobby);
		panel.add(modifty);
		panel.add(save);
		panel.add(ok);
		panel.add(city);
		panel.add(message);
	}
	
	public void Listener(){
		save.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				switch(tab.getSelectedIndex()){
				case 0:
					break;
				case 1:
					int row=table2.getRowCount();
					//"所属城市","营业厅编号","机构员工数","占地面积/m^2"
					LobbyInfoVO vo=new LobbyInfoVO(
							city.getText(),
							String.format("%3d",row),
							Integer.parseInt(stuffNumText.getText()),
							Double.parseDouble(earaText.getText()));
					InfoBLService service=ConstructFactory.InfoFactory();
					service.addNewLobby(vo);
				    stuffNumLabel.setVisible(false);
					stuffNumText.setVisible(false);
					earaLabel.setVisible(false);
					earaText.setVisible(false);
					defaultModel2.addRow(new String[]{String.format("%3d",row),stuffNumText.getText(),earaText.getText()});
				}
			}
		});
		tab.addChangeListener( new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		    	  if(tab.getTitleAt(tab.getSelectedIndex()).equals("中转中心") ){
		    		  newLobby.setVisible(false);
		    		  table1.setEnabled(false);
					  table11.setEnabled(false);
		  //  		  newWarehouse.setVisible(true);
		    		  newInterm.setVisible(true);
		    	  }
		
		    	  else if(tab.getTitleAt(tab.getSelectedIndex()).equals("营业厅")){
		   // 		  newWarehouse.setVisible(false);
		    		  newInterm.setVisible(false);
		    		  newLobby.setVisible(true);
		    		  table2.setEnabled(false);
		    	
		    	  }
		      }});
		
		
		modifty.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				  if(tab.getTitleAt(tab.getSelectedIndex()).equals("中转中心") ){
					  table1.setEnabled(true);
					  table11.setEnabled(true);
		    		  table2.setEnabled(false);
				  }
		
		    	  else if(tab.getTitleAt(tab.getSelectedIndex()).equals("营业厅")){
					  table1.setEnabled(false);
					  table11.setEnabled(false);
		    		  table2.setEnabled(true);
			}
			}
		});
		
		newInterm.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
			
				tableData1 = getInterm();
				for(int i=0;i<tableData1.length;i++){
					for(int j=0;j<tableData1[0].length;j++){
						table1.setValueAt(tableData1[i][j], i, j);
					}
				}
				tableData11 = getWarehouse();
				for(int i=0;i<tableData11.length;i++){
					for(int j=0;j<tableData11[0].length;j++){
						table11.setValueAt(tableData11[i][j], i,j);
					}
				}	
				
				table1.setEnabled(true);
				table11.setEnabled(true);
			}
		});
		newLobby.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				stuffNumLabel.setText(null);
				stuffNumText.setText(null);
				earaLabel.setText(null);
				earaText.setText(null);
				stuffNumLabel.setVisible(true);
				stuffNumText.setVisible(true);
				earaLabel.setVisible(true);
				earaText.setVisible(true);
			}
		});
		save.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				table1.setEnabled(false);
				table11.setEnabled(false);
				table2.setEnabled(false);
			}
		});
		
		
		table1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				 int row = table1.rowAtPoint(e.getPoint());
				 int column=table1.columnAtPoint(e.getPoint());  
				 System.out.println("?????"+row+" "+column+"");
				
			}
		});
			
		
	}

	 private class FloatingColumnTableModel extends AbstractTableModel {  
	  
	        private static final long serialVersionUID = -2481466672947191281L;  
	          
	        @Override  
	        public boolean isCellEditable(int row, int column) {  
	            return true;  
	        }  
	  
	        @Override  
	        public int getRowCount() {  
	            return tableValueV.size();  
	        }  
	  
	        @Override  
	        public int getColumnCount() {  
	            return columnNameV.size() - fixedColumn;  
	        }  
	  
	        @Override  
	        public Object getValueAt(int rowIndex, int columnIndex) {  
	            return tableValueV.get(rowIndex).get(columnIndex + fixedColumn);  
	        }  
	  
	        @Override  
	        public String getColumnName(int columnIndex) {  
	            return columnNameV.get(columnIndex + fixedColumn);  
	        }  
	    }
	 
}
