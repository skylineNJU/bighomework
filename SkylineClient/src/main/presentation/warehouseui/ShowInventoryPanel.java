package main.presentation.warehouseui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import main.businesslogicservice.LoadBLService;
import main.businesslogicservice.WarehouseBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.WarehouseMemory;
import main.vo.InventoryVO;
import main.vo.PlaneLoadingVO;
import main.vo.WarehouseInVO;
import main.vo.WarehouseOutVO;

//库存查看
public class ShowInventoryPanel {

	private JPanel panel;
	private JPanel inInfo;
	private JPanel outInfo;
	private JTabbedPane tab;
	private JTextField all;
	private JTextField inOfNum;
	private JTextField outOfNum;
	private JLabel startdate;
	private JLabel enddate;
	private JLabel allNum;
	private JLabel inNum;
	private JLabel outNum;
	private JButton ok;
	private JComboBox year1;
	private JComboBox month1;
	private JComboBox day1;
	private JComboBox year2;
	private JComboBox month2;
	private JComboBox day2;
	private JTable table1;
	private JTable table2;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private String  othertitle;//区排架位
	private String  titlelist;
	private int y1;
	private int m1;
	private int d1;
	private int y2;
	private int m2;
	private int d2;
	private String[] tableTitle1;
	private String[][] tableData;
	public ShowInventoryPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		
		inInfo = new JPanel();
		outInfo = new JPanel();
		inInfo.setLayout(null);
		outInfo.setLayout(null);
		
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("入库信息", inInfo);
		tab.addTab("出库信息", outInfo);
		tab.setSize(panel.getWidth()*7/8,panel.getHeight()/100*80);
		tab.setLocation(panel.getWidth()/18,panel.getHeight()*3/20);
	
		panel.add(tab);
		
		datePanel();
		tablePanel();
		Num();
		
		inInfo.setVisible(true);
		outInfo.setVisible(true);
		
		
		tab.repaint();
		panel.repaint();
	
	}
	
	
	public void datePanel(){
		startdate = new JLabel("开始日期:");
		enddate = new JLabel("截止日期:");
		Font font = new Font("宋体", Font.BOLD, 15);
		enddate.setFont(font);
		startdate.setFont(font);
		startdate.setBounds(panel.getWidth()/18, panel.getHeight()/12, panel.getWidth()/6, panel.getHeight()/20);
		enddate.setBounds(panel.getWidth()*8/18, panel.getHeight()/12, panel.getWidth()/6, panel.getHeight()/20);
		startdate.setVisible(true);
		enddate.setVisible(true);
		
		
		year1= new JComboBox();
		month1= new JComboBox();
		day1= new JComboBox();
		year2= new JComboBox();
		month2= new JComboBox();
		day2= new JComboBox();

          
        //分别设置3个combobox内的值  
        String[] arr1=new String[50];//数组时个对象,对象在使用前要初始化  
        for(int i=0;i<50;i++){  
            arr1[i] = i+2000+"年";  
        }         
        
        year1 = new JComboBox(arr1);  
        year1.setBounds(panel.getWidth()*3/18, startdate.getY(), panel.getWidth()/11, panel.getHeight()/20);
   
        String [] arr2 = new String[12];  
        for(int i=0;i<12;i++){  
            arr2[i]=i+1+"月";  
        }  
    
        month1 = new JComboBox(arr2);  
       
        month1.setBounds(year1.getX()+year1.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
        String[] arr30 = new String[31];  
        for(int i=0;i<31;i++){  
             arr30[i]=i+1+"日";  
         }  
     
        day1 = new JComboBox(arr30);  
        day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
        panel.add(day1);
        
        month1.addItemListener(new ItemListener(){
			@Override
			
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				panel.remove(day1);
				switch(month1.getSelectedItem().toString()){
					case "1月":
					case "3月":
					case "5月":
					case "7月":
					case "8月":
					case "10月":
					case "12月": 
						String[] arr31 = new String[31];  
        			for(int i=0;i<31;i++){  
        				arr31[i]=i+1+"日";  
        				
        			}  
        		
        			day1 = new JComboBox(arr31);  
        	        day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
        	        panel.add(day1);	
        	        break;
					case "4月":
					case "6月":
					case "9月":
					case "11月":
						String[] arr3 = new String[30];  
		    			for(int i=0;i<30;i++){  
		    				arr3[i]=i+1+"日";  
		    			}  
		        		
		    			 day1 = new JComboBox(arr3);  
		    	        day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
		    	        panel.add(day1);
		    	        break;
					case "2月":
						if(isLeap(year1.getSelectedItem().toString())){
							String[] arr33 = new String[29];  
							for(int i=0;i<29;i++){  
								arr33[i]=i+1+"日";  
							}  
		        		
							day1 = new JComboBox(arr33);  
							day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
							panel.add(day1);
						}
						else{
							String[] arr333 = new String[28];  
							for(int i=0;i<28;i++){  
		    				arr333[i]=i+1+"日";  
							}  
		        		
							day1 = new JComboBox(arr333);  
							day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
							panel.add(day1);
							
						}
							break;
					default: 
							break;
	        		
	        	}
			}
        	
        });
       
        year2 = new JComboBox(arr1);  
        year2.setBounds(panel.getWidth()*10/18,  startdate.getY(), panel.getWidth()/11, panel.getHeight()/20);
      
        month2 = new JComboBox(arr2);  
        month2.setBounds(year2.getX()+year2.getWidth()+panel.getWidth()/100,startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
 
        for(int i=0;i<31;i++){  
             arr30[i]=i+1+"日";  
         }  
     
        day2 = new JComboBox(arr30);  
        day2.setBounds(month2.getX()+month2.getWidth()+panel.getWidth()/100,startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
        panel.add(day2);
        month2.addItemListener(new ItemListener(){
     			@Override
     			
     			public void itemStateChanged(ItemEvent arg0) {
     				// TODO Auto-generated method stub
     				panel.remove(day2);
     				switch(month2.getSelectedItem().toString()){
     					case "1月":
     					case "3月":
     					case "5月":
     					case "7月":
     					case "8月":
     					case "10月":
     					case "12月": 
     						String[] arr31 = new String[31];  
             			for(int i=0;i<31;i++){  
             				arr31[i]=i+1+"日";  
             				
             			}  
             		
             			day2 = new JComboBox(arr31);  
             	        day2.setBounds(month2.getX()+month2.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
             	        panel.add(day2);	
             	        break;
     					case "4月":
     					case "6月":
     					case "9月":
     					case "11月":
     						String[] arr3 = new String[30];  
     		    			for(int i=0;i<30;i++){  
     		    				arr3[i]=i+1+"日";  
     		    			}  
     		        		
     		    			 day2 = new JComboBox(arr3);  
     		    	        day2.setBounds(month2.getX()+month1.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
     		    	        panel.add(day2);
     		    	        break;
     					case "2月":
     						if(isLeap(year2.getSelectedItem().toString())){
     							String[] arr33 = new String[29];  
     							for(int i=0;i<29;i++){  
     								arr33[i]=i+1+"日";  
     							}  
     		        		
     							day2 = new JComboBox(arr33);  
     							day2.setBounds(month2.getX()+month2.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
     							panel.add(day2);
     						}
     						else{
     							String[] arr333 = new String[28];  
     							for(int i=0;i<28;i++){  
     		    				arr333[i]=i+1+"日";  
     							}  
     		        		
     							day2 = new JComboBox(arr333);  
     							day2.setBounds(month2.getX()+month2.getWidth()+panel.getWidth()/100, startdate.getY(), panel.getWidth()/12, panel.getHeight()/20);
     							panel.add(day2);
     							
     						}
     							break;
     					default: 
     							break;
     	        		
     	        	}
     			}
             	
             });
       
        ok=new JButton("确定");
		ok.setBounds(day2.getX()+month2.getWidth()+panel.getWidth()/90,startdate.getY(), panel.getWidth()/11, panel.getHeight()/20);
		ok.setVisible(true);
		
		ok.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				tableData=initInTableData();
				 for(int i=0;i<tableData.length;i++){
						for(int j=0;j<tableData[0].length;j++){
							table1.setValueAt(tableData[i][j], i, j);
						}
					}
			}});
		
        panel.add(ok);
		panel.add(year1);
		panel.add(month1);
		panel.add(day1);
		panel.add(year2);
		panel.add(month2);
		panel.add(day2);
		panel.add(startdate);
		panel.add(enddate);
	}
	
	public void tablePanel(){
		tableTitle1= new String[]{"入库单号","区号","排号","架号","位号"};
		tableData=initInTableData();	
		table1 = new JTable(tableData,tableTitle1);
		
		String[] ot1 = new String[]{"出库单号","区号","排号","架号","位号"};
		table2 = new JTable(tableData,ot1);
	//in
		table1.setEnabled(false);//设置不可编辑内容
		table1.setRowHeight(panel.getWidth()/20);//设置列宽
		table1.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table1.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table1.setDragEnabled(false);
		table1.setVisible(true);
		scrollPane = new JScrollPane(table1);

		if(tableData.length>=10){
			scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8,tab.getWidth(), 10*table1.getRowHeight());
		}else{
			scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8,tab.getWidth(), (table1.getRowCount()+1)*table1.getRowHeight());
		}
		table1.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/5);;
		table1.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/6);;
		table1.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane.setVisible(true);
		inInfo.add(scrollPane);
	//out
		table2.setEnabled(false);//设置不可编辑内容
		table2.setRowHeight(panel.getWidth()/20);//设置列宽
		table2.getTableHeader().setPreferredSize(new Dimension(tab.getWidth(), panel.getWidth()/20));//设置表头高度
		table2.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table2.setDragEnabled(false);
		table2.setVisible(true);
		scrollPane2 = new JScrollPane(table2);

		if(tableData.length>=10){
			scrollPane2.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8, tab.getWidth(), 10*table1.getRowHeight());
		}else{
			scrollPane2.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8,tab.getWidth(), (table1.getRowCount()+1)*table1.getRowHeight());
		}
		table2.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/5);;
		table2.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/6);;
		table2.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table2.setVisible(true);
		scrollPane2.setVisible(true);
		outInfo.add(scrollPane2);
		
		//tab.add(table1);
	}
	
	public String[][] initInTableData(){
		y1=year1.getSelectedIndex()+2000;
		m1=month1.getSelectedIndex()+1;
		d1=day1.getSelectedIndex()+1;
		y2=year2.getSelectedIndex()+2000;
		m2=month2.getSelectedIndex()+1;
		d2=day2.getSelectedIndex()+1;
		
		System.out.println("/////////////////////////:::"+y1+" "+m1+" "+d1+" "+y2+" "+m2+" "+d2);
		
		WarehouseMemory memory=(WarehouseMemory) ((WritePanel)panel).getMemory();
		
		//得到date1,date2,判断memory中d是否在这之前，如果在，则取得相对应的入库单号号再从db入库单里提出区排架位
		String date=memory.getWarehouseInDate().substring(2);
		String[] dates =date.split(" ");
		String code = memory.getWarehouseInCode().substring(2);
		String[] codes =code.split(" ");
		System.out.println("::::::::::1:::::::::"+date);
		System.out.println("::::::::::2:::::::::"+code);
		Date date1 = new Date(y1-1900,m1-1,d1);
        Date date2 = new Date(y2-1900,m2-1,d2);
        assert(date2.after(date1));
       
        int counter=0;
        for(int i=0;i<dates.length;i++){
        	System.out.println(":::::::::3::::::::::"+dates[0]);
        	String[] yAmAd=dates[i].split("年|月|日");
        	int year = Integer.parseInt(yAmAd[0]);
        	int month = Integer.parseInt(yAmAd[1]);
        	int day = Integer.parseInt(yAmAd[2]);
        	
        	Date d = new Date(year-1900,month-1,day);
        	if(d.after(date1)&&d.before(date2)){
        		String c = codes[i];
        		
        		String[][] content =new String[20][5];
        		for(int x=0;x<20;x++)
        			for(int y=0;y<5;y++)
        				content[x][y]=null;
        		if(c!=null){
    				WarehouseBLService service = ConstructFactory.WarehouseFactory();
    				ArrayList<WarehouseInVO> in = service.showWarehouseInInfo(c);
					for(WarehouseInVO vo: in){
						content[counter][0]=c;
						content[counter][1]=vo.getArea();
						content[counter][2]=vo.getRow()+"";
						content[counter][3]=vo.getShelf()+"";
						content[counter][4]=vo.getPosition()+"";
					}
        		}
        			counter++;
        			return content;
        	}else return null;
        }
        	/*	ArrayList<WarehouseInVO> in=null;
        		WarehouseBLService service=ConstructFactory.WarehouseFactory();
        		in=service.showWarehouseInInfo(((WritePanel)panel).getBelong());
        		if(in!=null){
        			int counter=0;
        			for(WarehouseInVO vo:in){
        				content[counter][0]=vo.getCode();
						content[counter][1]=vo.getArea();
						content[counter][2]=vo.getRow()+"";
						content[counter][3]=vo.getShelf()+"";
						content[counter][4]=vo.getPosition()+"";
						counter++;
        			}
        		}
        		
        		return content;
        	}else return null;
        }*/
        return null;
}
	
/*	public String[][] initOutTableData(){
		String[][] content =new String[20][5];
		for(int x=0;x<20;x++)
			for(int y=0;y<5;y++)
				content[x][y]=null;
		ArrayList<InventoryVO> out=null;
		WarehouseBLService service=ConstructFactory.WarehouseFactory();
	//	assert(areanumber.getText()!=null);
	//	System.out.println("+++++++++++++++::::"+areanumber.getText());
		out=service.checkInventory(((WritePanel)panel).getBelong()+" "+areanumber.getText());
		if(out!=null){
		int counter=0;
		for(InventoryVO vo:out){
			content[counter][0]=vo.getOrderCode();
			content[counter][1]=vo.getArriveDate();
			content[counter][2]=vo.getDestination();
			content[counter][3]=vo.getArea();
			content[counter][4]=vo.getRow()+"";
			counter++;
		}
		}
		return content;
	}
	*/
	
	public void Num(){
		Font font = new Font("宋体", Font.BOLD, 13);//BOLD PLAIN
		
		inNum = new JLabel("入库数量:");
		inNum.setFont(font);
		inNum.setBounds(panel.getWidth()*3/4,panel.getHeight()*81/100, panel.getWidth()*2/5, panel.getHeight()/15);
		inNum.setVisible(true);
		
		outNum = new JLabel("出库数量");
		outNum.setFont(font);
		outNum.setBounds(panel.getWidth()*3/4,panel.getHeight()*81/100, panel.getWidth()*2/5, panel.getHeight()/15);
		outNum.setVisible(true);
	
		allNum = new JLabel("存储数量合计:");
		allNum.setFont(font);
		allNum.setBounds(panel.getWidth()*71/100,panel.getHeight()*53/60, panel.getWidth()*2/5, panel.getHeight()/15);
		allNum.setVisible(true);
		
		inOfNum = new JTextField();
		inOfNum.setBounds(panel.getWidth()*34/40,panel.getHeight()*82/100, panel.getWidth()/18, panel.getHeight()/20);
		inOfNum.setVisible(true);
		
		outOfNum = new JTextField();
		outOfNum.setBounds(panel.getWidth()*34/40,panel.getHeight()*82/100, panel.getWidth()/18, panel.getHeight()/20);
		outOfNum.setVisible(true);
	
		all = new JTextField();
		all.setBounds(panel.getWidth()*34/40,panel.getHeight()*89/100, panel.getWidth()/18, panel.getHeight()/20);
		all.setVisible(true);
	    
		
		inInfo.add(inNum);
		outInfo.add(outNum);
		inInfo.add(inOfNum);
		outInfo.add(outOfNum);
		panel.add(allNum);
		panel.add(all);
		
	}

	
	public void remove(){
		panel.remove(tab);
		inInfo.remove(scrollPane);
		outInfo.remove(scrollPane2);
		inInfo.remove(inNum);
		outInfo.remove(outNum);
		inInfo.remove(inOfNum);
		outInfo.remove(outOfNum);
		panel.remove(allNum);
		panel.remove(all);	 
        panel.remove(ok);
		panel.remove(year1);
		panel.remove(month1);
		panel.remove(day1);
		panel.remove(year2);
		panel.remove(month2);
		panel.remove(day2);
		panel.remove(startdate);
		panel.remove(enddate);
	}
	
	
	static public boolean isLeap(String a){
		a=a.substring(0,4);
		int year = Integer.parseInt(a);
		if( year % 400 == 0 || ( year % 100 != 0 && year % 4 == 0)){
		  return true;
		}
		else
			return false;
		
	} 
}
