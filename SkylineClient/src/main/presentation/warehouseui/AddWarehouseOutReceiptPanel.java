package main.presentation.warehouseui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import main.State.TransType;
import main.businesslogicservice.WarehouseBLService;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.businesslogicservice.receiptblService.WarehouseReceipt;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.WarehouseMemory;
import main.vo.WarehouseOutVO;

public class AddWarehouseOutReceiptPanel {
	private FrameMain frame;
	private JPanel panel;
	private JPanel listpanel;
	private JButton ok;
	private JButton cancel;
	private JLabel outList;
	private JLabel cargoinfo;
	private JLabel bar;
	private JLabel code;
	private JLabel tip1;
	private JLabel tip2;
	private JLabel outDate;
	private JLabel distination;	
	private JLabel loadingtype;
	private JLabel transfercode;
	//汽运编号
	private JLabel vehicleCode;
	private JLabel damageCondition;
	private JCheckBox tB;
	private JCheckBox pB;
	private JCheckBox bB;
	private JCheckBox good;
	private JCheckBox damage;
	private JLabel line1;
	private JLabel line2;
	private JLabel line3;
	private JComboBox year;
	private JComboBox month;
	private JComboBox day;
	private JTextField bartext;
	private JTextField codetext;
	private JTextField distext;
	private JTextField vehtext;
	private JTextField transtext;
	private JScrollPane scrollPane;
	
	public AddWarehouseOutReceiptPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	
	}
	
	public void init(){
		//title();
		listpanel= new JPanel();
		listpanel.setLayout(null);
		listpanel.setBounds(panel.getWidth()*10/80, panel.getHeight()/13, panel.getWidth()*57/80, panel.getHeight()*18/20);
		listpanel.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, Color.GRAY));//top,left,bottom,right
	
		content();
		listpanel.setVisible(true);
		panel.add(listpanel);
		panel.repaint();
		listpanel.repaint();
	}


	public void content(){
		Font font00 = new Font("宋体", Font.BOLD, 20);
		Font font0 = new Font("宋体", Font.BOLD, 16);
		Font font = new Font("宋体", Font.BOLD, 15);
		line1 = new JLabel("————————————————————————");
		line1.setFont(font0);
		line1.setBounds(listpanel.getX()-panel.getWidth()/15,listpanel.getY()-panel.getHeight()/20,panel.getWidth()*3/5, panel.getHeight()/10);
		
		line2 = new JLabel("——————————————————————");
		line2.setFont(font0);
		line2.setForeground(Color.GRAY);
		line2.setBounds(listpanel.getX()-panel.getWidth()/30,listpanel.getY()+panel.getHeight()/36,panel.getWidth()*3/5, panel.getHeight()/10);
		
		line3 = new JLabel("——————————————————————");
		line3.setFont(font0);
		line3.setForeground(Color.GRAY);
		line3.setBounds(listpanel.getX()-panel.getWidth()/30,listpanel.getY()+panel.getHeight()/100*75, panel.getWidth()*3/5, panel.getHeight()/10);
		
		
		
		ok=new JButton("提交");
		ok.setFont(font);
		ok.setBounds(listpanel.getX()+panel.getWidth()*2/5,listpanel.getY()+panel.getHeight()*30/40,  panel.getWidth()/10, panel.getHeight()/20);
		
		cancel=new JButton("取消");
		cancel.setFont(font);
		cancel.setBounds(ok.getX()-panel.getWidth()/7,ok.getY(), panel.getWidth()/10, panel.getHeight()/20);
		
		outList=new JLabel("出库单");
		outList.setFont(font00);
		outList.setBounds(listpanel.getX()-panel.getWidth()/15,listpanel.getY()-panel.getHeight()/13, panel.getWidth()/10, panel.getHeight()/10);
		
		cargoinfo=new JLabel("货物信息");
		cargoinfo.setFont(font0);
		cargoinfo.setBounds(listpanel.getX()-panel.getWidth()/30,listpanel.getY(),panel.getWidth()/10, panel.getHeight()/10);
		
		bar = new JLabel("订单号");
		bar.setFont(font);
		bar.setBounds(cargoinfo.getX(),cargoinfo.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
		
/*		code=new JLabel("出库单号:");
		code.setFont(font);
		code.setBounds(cargoinfo.getX(),bar.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
	*/	
		outDate=new JLabel("出库日期:");
		outDate.setFont(font);
		outDate.setBounds(cargoinfo.getX(),bar.getY()+panel.getHeight()/14,panel.getWidth()/5, panel.getHeight()/10);
		
		distination=new JLabel("目的地:");
		distination.setFont(font);
		distination.setBounds(cargoinfo.getX(),outDate.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
		
		damageCondition = new JLabel("损坏情况");
		damageCondition.setFont(font);
		damageCondition.setBounds(cargoinfo.getX(),distination.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
		
		good = new JCheckBox("完好");
		good.setFont(font);
		good.setBounds(damageCondition.getX()+panel.getWidth()/8,damageCondition.getY()+panel.getHeight()/45,panel.getWidth()/12, panel.getHeight()/20);
		
		damage = new JCheckBox("损坏");
		damage.setFont(font);
		damage.setBounds(good.getX()+panel.getWidth()/8,damageCondition.getY()+panel.getHeight()/45,panel.getWidth()/12, panel.getHeight()/20);
		
		loadingtype=new JLabel("装运形式:");
		loadingtype.setFont(font);
		loadingtype.setBounds(damageCondition.getX(),damageCondition.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
		
		tB = new JCheckBox("火车");
		tB.setFont(font);
		tB.setBounds(loadingtype.getX()+panel.getWidth()/8,loadingtype.getY()+panel.getHeight()/45,panel.getWidth()/12, panel.getHeight()/20);
		pB = new JCheckBox("飞机");
		pB.setFont(font);
		pB.setBounds(tB.getX()+panel.getWidth()/8,loadingtype.getY()+panel.getHeight()/45,panel.getWidth()/12, panel.getHeight()/20);
		bB = new JCheckBox("汽车");
		bB.setFont(font);
		bB.setBounds(pB.getX()+panel.getWidth()/8,loadingtype.getY()+panel.getHeight()/45,panel.getWidth()/12, panel.getHeight()/20);
		
//		transfercode=new JLabel("中转单编号:");
//		transfercode.setFont(font);
//		transfercode.setBounds(cargoinfo.getX(),bB.getY()+panel.getHeight()/14,panel.getWidth()/5, panel.getHeight()/10);
		
	//	codetext = new JTextField();
	//	codetext.setBounds(code.getX()+panel.getWidth()/8,code.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
	/*	tip1 = new JLabel("*请输入10位有效出库单号");
		tip1.setFont(new Font("宋体", Font.BOLD, 12));
		tip1.setForeground(Color.GRAY);
		tip1.setBounds(codetext.getX()+codetext.getWidth()+panel.getWidth()/50,code.getY(),panel.getWidth()/3, panel.getHeight()/10);
		*/
		vehicleCode=new JLabel("汽运编号:");
		vehicleCode.setFont(font);
		vehicleCode.setBounds(cargoinfo.getX(),bB.getY()+panel.getHeight()/14,panel.getWidth()/5, panel.getHeight()/10);
		
		
		bartext = new JTextField();
		bartext.setBounds(bar.getX()+panel.getWidth()/8,bar.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
		distext = new JTextField();
		distext.setBounds(distination.getX()+panel.getWidth()/8,distination.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
	//	transtext = new JTextField();
	//	transtext.setBounds(transfercode.getX()+panel.getWidth()/7,transfercode.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
		vehtext = new JTextField();
		vehtext.setBounds(distination.getX()+panel.getWidth()/7,vehicleCode.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
/*		tip2 = new JLabel("*请输入14位有效中转单编号");
		tip2.setFont(new Font("宋体", Font.BOLD, 12));
		tip2.setForeground(Color.GRAY);
		tip2.setBounds(transtext.getX()+transtext.getWidth()+panel.getWidth()/50,transfercode.getY(),panel.getWidth()/3, panel.getHeight()/10);
	*/	
		
		

		year= new JComboBox();
		month= new JComboBox();
		day= new JComboBox();
		String[] arr1=new String[1000];//数组时个对象,对象在使用前要初始化  
        for(int i=0;i<1000;i++){  
            arr1[i] = i+2000+"年";  
        }         
        
        year = new JComboBox(arr1);  
        Calendar calendar = Calendar.getInstance();
        
    	String	y = String.valueOf(calendar.get(Calendar.YEAR))+"年";
    	for(String  y1: arr1){
    		if(y1.equals(y)){
    			year.setSelectedItem(y);
    		}
    	}
        year.setBounds(outDate.getX()+panel.getWidth()/8, outDate.getY()+panel.getWidth()/50, panel.getWidth()/11, panel.getHeight()/20);
   
        String [] arr2 = new String[12];  
        for(int i=0;i<12;i++){  
            arr2[i]=i+1+"月";  
        }  
    
        month = new JComboBox(arr2);  
        String	m = String.valueOf(calendar.get(Calendar.MONTH)+1)+"月";
    	for(String  m1: arr2){
    		if(m1.equals(m)){
    			month.setSelectedItem(m1);
    		}
    	}
       
        month.setBounds(year.getX()+year.getWidth()+panel.getWidth()/100, outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
        String[] arr30 = new String[31];  
        for(int i=0;i<31;i++){  
             arr30[i]=i+1+"日";  
         }  
     
        day = new JComboBox(arr30);  
        
    	String	d = String.valueOf(calendar.get(Calendar.DATE))+"日";
    	for(String  d1: arr30){
    		if(d1.equals(d)){
    			day.setSelectedItem(d1);
    		}
    	}
        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
       listpanel.add(day);
        
        month.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				listpanel.remove(day);
				switch(month.getSelectedItem().toString()){
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
        		
        			day = new JComboBox(arr31);  
        	        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
        	        listpanel.add(day);	
        	        break;
					case "4月":
					case "6月":
					case "9月":
					case "11月":
						String[] arr3 = new String[30];  
		    			for(int i=0;i<30;i++){  
		    				arr3[i]=i+1+"日";  
		    			}  
		        		
		    			 day = new JComboBox(arr3);  
		    	        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
		    	        listpanel.add(day);
		    	        break;
					case "2月":
						if(isLeap(year.getSelectedItem().toString())){
							String[] arr33 = new String[29];  
							for(int i=0;i<29;i++){  
								arr33[i]=i+1+"日";  
							}  
		        		
							day = new JComboBox(arr33);  
							day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
							listpanel.add(day);
						}
						else{
							String[] arr333 = new String[28];  
							for(int i=0;i<28;i++){  
		    				arr333[i]=i+1+"日";  
							}  
		        		
							day = new JComboBox(arr333);  
							day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
							listpanel.add(day);
							
						}
							break;
					default: 
							break;
	        		
	        	}
			}
        	
        });
		

		
		listpanel.add(year);
		listpanel.add(month);
		listpanel.add(day);
		listpanel.add(line1);
		listpanel.add(line2);
		listpanel.add(line3);
	//	listpanel.add(tip1);
	//	listpanel.add(tip2);
		listpanel.add(outList);
		listpanel.add(ok);
		listpanel.add(cancel);
		listpanel.add(bar);
	//	listpanel.add(code);
		listpanel.add(cargoinfo);
		listpanel.add(outDate);
		listpanel.add(distination);
		listpanel.add(loadingtype);
		listpanel.add(damageCondition);
		listpanel.add(good);
		listpanel.add(damage);
		listpanel.add(pB);
		listpanel.add(bB);
		listpanel.add(tB);
	//	listpanel.add(transfercode);
		listpanel.add(vehicleCode);
		listpanel.add(vehtext);
		listpanel.add(bartext);
	//	listpanel.add(codetext);
		listpanel.add(distext);
	//	listpanel.add(transtext);
		
		
		ok.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				String date=((year.getSelectedIndex()+2000)+"/")+((month.getSelectedIndex()+1)+"/")+((day.getSelectedIndex()+1+""));
				
				String damageCondition = null;
				if(good.isSelected()){
					damageCondition="完好";
				}
				if(damage.isSelected()){
					damageCondition="损坏";
				}	

				
				TransType transtype= TransType.BUS;
				if(tB.isSelected()){
					 transtype= TransType.TRAIN;
				}
				if(bB.isSelected()){
					transtype= TransType.BUS;
				}	
				if(pB.isSelected()){
					 transtype= TransType.PLANE;	 
				}	
				
				
				WarehouseMemory memory=(WarehouseMemory) ((WritePanel)panel).getMemory();
				String code=memory.getWarehouseOutCode();
				ReceiptCode cal=ConstructFactory.calculateCode();
				code=cal.calculCode(code,memory.getUserName());
				System.out.println(code);
				
				//code出库单号、bar为订单号
	
				WarehouseOutVO warehouseOutVO = new WarehouseOutVO(bartext.getText(),code,
						distext.getText(),date,
						transtype,((WritePanel) panel).getBelong(),vehtext.getText(),damageCondition);

				WarehouseBLService service=ConstructFactory.WarehouseFactory();
				boolean key = service.WarehouseOut(warehouseOutVO);
				if(key){
					WarehouseReceipt wr = ConstructFactory.WarehouseReceiptFactory();
					wr.saveWarehouseOutCode(code, memory.getUserName());
					memory.setWarehouseOutCode(memory.getWarehouseOutCode()+" "+code);
					memory.setWarehouseOutDate(memory.getWarehouseOutDate()+" "+date);
				}
			}
		});
	
		cancel.addMouseListener( new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				panel.repaint();
			}		
		});
		
		
	}
	public void remove(){
		panel.remove(listpanel);
		listpanel.remove(year);
		listpanel.remove(month);
		listpanel.remove(day);
		listpanel.remove(line1);
		listpanel.remove(line2);
		listpanel.remove(line3);
	//	listpanel.remove(tip1);
	//	listpanel.remove(tip2);
		listpanel.remove(outList);
		listpanel.remove(ok);
		listpanel.remove(cancel);
		listpanel.remove(bar);
	//	listpanel.remove(code);
		listpanel.remove(cargoinfo);
		listpanel.remove(outDate);
		listpanel.remove(distination);
		listpanel.remove(loadingtype);
		listpanel.remove(damageCondition);
		listpanel.remove(good);
		listpanel.remove(damage);
		listpanel.remove(pB);
		listpanel.remove(bB);
		listpanel.remove(tB);
	//	listpanel.remove(transfercode);
		listpanel.remove(vehicleCode);
		listpanel.remove(vehtext);
		listpanel.remove(bartext);
	//	listpanel.remove(codetext);
		listpanel.remove(distext);
	//	listpanel.remove(transtext);
		
		
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


