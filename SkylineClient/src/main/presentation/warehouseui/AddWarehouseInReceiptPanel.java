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

import main.businesslogicservice.WarehouseBLService;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.businesslogicservice.receiptblService.WarehouseReceipt;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.AllImage;
import main.presentation.mainui.MainController;
import main.presentation.mainui.TipFrame;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.WarehouseMemory;
import main.vo.WarehouseInVO;

public class AddWarehouseInReceiptPanel {
	private JPanel panel;
	private JPanel listPanel;
	private JPanel tipPanel;
//	private JButton ok;
	private JButton cancel;
	private JLabel tip;
	private JLabel ok;
	private JLabel cL;
	private JLabel inList;
	private JLabel cargoinfo;
	private JLabel bar;
	private JLabel inDate;
	private JLabel distination;	
	private JLabel area;
	private JLabel row;
	private JLabel shelf;
	private JLabel position;
	private JLabel line1;
	private JLabel line2;
	private JLabel line3;
	private JLabel damageCondition;
	private JLabel search;
	private JCheckBox good;
	private JCheckBox damage;
	private JComboBox year;
	private JComboBox month;
	private JComboBox day;
	private JTextField bartext;
	private JTextField codetext;
	private JTextField distext;
	private JTextField areatext;
	private JTextField rowtext;
	private JTextField shelftext;
	private JTextField postext;
	private JScrollPane scrollPane;
	private TipFrame a ;
	
	public AddWarehouseInReceiptPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	
	}
	
	public void init(){
		//title();
		listPanel= new JPanel();
		listPanel.setLayout(null);
		listPanel.setBounds(panel.getWidth()*10/80, panel.getHeight()/13, panel.getWidth()*57/80, panel.getHeight()*18/20);
		listPanel.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, Color.GRAY));//top,left,bottom,right
		tip();
		content();
		listPanel.setVisible(true);
		panel.add(listPanel);	
		panel.repaint();
		listPanel.repaint();
		//tipPanel.repaint();
	//	a.repaint();
	
	}


	public void content(){

		Font font00 = new Font("����", Font.BOLD, 20);
		Font font0 = new Font("����", Font.BOLD, 16);
		Font font = new Font("����", Font.BOLD, 15);
		line1 = new JLabel("������������������������������������������������");
		line1.setFont(font0);
		line1.setBounds(listPanel.getX()-panel.getWidth()/15,listPanel.getY()-panel.getHeight()/20, panel.getWidth()*3/5, panel.getHeight()/10);
		
		line2 = new JLabel("��������������������������������������������");
		line2.setFont(font0);
		line2.setForeground(Color.GRAY);
		line2.setBounds(listPanel.getX()-panel.getWidth()/30,listPanel.getY()+panel.getHeight()/36, panel.getWidth()*3/5, panel.getHeight()/10);
		
		line3 = new JLabel("��������������������������������������������");
		line3.setFont(font0);
		line3.setForeground(Color.GRAY);
		line3.setBounds(listPanel.getX()-panel.getWidth()/30,listPanel.getY()+panel.getHeight()/100*75, panel.getWidth()*3/5, panel.getHeight()/10);

		
	/*	ok=new JButton("�ύ");
		ok.setFont(font);
		ok.setBounds(listPanel.getX()+panel.getWidth()*2/5,listPanel.getY()+panel.getHeight()*30/40, panel.getWidth()/10, panel.getHeight()/20);
	*/
		ok=new JLabel();
		ok.setIcon(AllImage.submit);
		ok.setBounds(listPanel.getX()+panel.getWidth()*2/5,listPanel.getY()+panel.getHeight()*30/40, panel.getWidth()/10, panel.getHeight()/20);
		

		
		cancel=new JButton("ȡ��");
		cancel.setFont(font);
		cancel.setBounds(ok.getX()-panel.getWidth()/7,ok.getY(), panel.getWidth()/10, panel.getHeight()/20);
			
		inList=new JLabel("��ⵥ");
		inList.setFont(font00);
		inList.setBounds(listPanel.getX()-panel.getWidth()/15,listPanel.getY()-panel.getHeight()/13, panel.getWidth()/10, panel.getHeight()/10);
		
		cargoinfo=new JLabel("������Ϣ");
		cargoinfo.setFont(font0);
		cargoinfo.setBounds(listPanel.getX()-panel.getWidth()/30,listPanel.getY(),panel.getWidth()/10, panel.getHeight()/10);
		
		bar = new JLabel("������:");
		bar.setFont(font);
		bar.setBounds(cargoinfo.getX(),cargoinfo.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
/*		
		code=new JLabel("��ⵥ��:");
		code.setFont(font);
		code.setBounds(cargoinfo.getX(),bar.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
	*/	
		inDate=new JLabel("�������:");
		inDate.setFont(font);
		inDate.setBounds(cargoinfo.getX(),bar.getY()+panel.getHeight()/14,panel.getWidth()/5, panel.getHeight()/10);
		
		distination=new JLabel("Ŀ�ĵ�:");
		distination.setFont(font);
		distination.setBounds(cargoinfo.getX(),inDate.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
		
		damageCondition = new JLabel("�����");
		damageCondition.setFont(font);
		damageCondition.setBounds(cargoinfo.getX(),distination.getY()+panel.getHeight()/13,panel.getWidth()/10, panel.getHeight()/10);
		
		good = new JCheckBox("���");
		good.setFont(font);
		good.setBounds(damageCondition.getX()+panel.getWidth()/8,damageCondition.getY()+panel.getHeight()/45,panel.getWidth()/12, panel.getHeight()/20);
		
		damage = new JCheckBox("��");
		damage.setFont(font);
		damage.setBounds(good.getX()+panel.getWidth()/8,damageCondition.getY()+panel.getHeight()/45,panel.getWidth()/12, panel.getHeight()/20);
		
		
		area=new JLabel("����:");
		area.setFont(font);
		area.setBounds(cargoinfo.getX(),damageCondition.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
		
		row=new JLabel("�ź�:");
		row.setFont(font);
		row.setBounds(area.getX()+panel.getWidth()/3,area.getY(),panel.getWidth()/5, panel.getHeight()/10);
		
		shelf=new JLabel("�ܺ�:");
		shelf.setFont(font);
		shelf.setBounds(cargoinfo.getX(),row.getY()+panel.getHeight()/13,panel.getWidth()/5, panel.getHeight()/10);
		
		position=new JLabel("λ��:");
		position.setFont(font);
		position.setBounds(shelf.getX()+panel.getWidth()/3,shelf.getY(),panel.getWidth()/5, panel.getHeight()/10);
		
		bartext = new JTextField();
		bartext.setBounds(bar.getX()+panel.getWidth()/8,bar.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
	//	codetext = new JTextField();
	//	codetext.setBounds(code.getX()+panel.getWidth()/8,code.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
	/*	tip = new JLabel("*������10λ��Ч��ⵥ��");
		tip.setFont(new Font("����", Font.BOLD, 12));
		tip.setForeground(Color.GRAY);
		tip.setBounds(codetext.getX()+codetext.getWidth()+panel.getWidth()/50,code.getY(),panel.getWidth()/3, panel.getHeight()/10);
	*/	
		distext = new JTextField();
		distext.setBounds(distination.getX()+panel.getWidth()/8,distination.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
		areatext = new JTextField();
		areatext.setBounds(area.getX()+panel.getWidth()/8,area.getY()+panel.getWidth()/50,panel.getWidth()/15, panel.getHeight()/20);
		rowtext = new JTextField();
		rowtext.setBounds(row.getX()+panel.getWidth()/8,row.getY()+panel.getWidth()/50,panel.getWidth()/15, panel.getHeight()/20);
		shelftext = new JTextField();
		shelftext.setBounds(shelf.getX()+panel.getWidth()/8,shelf.getY()+panel.getWidth()/50,panel.getWidth()/15, panel.getHeight()/20);
		postext = new JTextField();	
		postext.setBounds(position.getX()+panel.getWidth()/8,position.getY()+panel.getWidth()/50,panel.getWidth()/15, panel.getHeight()/20);
		

		year= new JComboBox();
		month= new JComboBox();
		day= new JComboBox();
		String[] arr1=new String[1000];//����ʱ������,������ʹ��ǰҪ��ʼ��  
        for(int i=0;i<1000;i++){  
            arr1[i] = i+2000+"��";  
        }         
        
        year = new JComboBox(arr1);  
    	Calendar calendar = Calendar.getInstance();
    
    	String	y = String.valueOf(calendar.get(Calendar.YEAR))+"��";
    	for(String  y1: arr1){
    		if(y1.equals(y)){
    			year.setSelectedItem(y);
    		}
    	}
    	
        year.setBounds(inDate.getX()+panel.getWidth()/8, inDate.getY()+panel.getWidth()/50, panel.getWidth()/11, panel.getHeight()/20);
   
        String [] arr2 = new String[12];  
        for(int i=0;i<12;i++){  
            arr2[i]=i+1+"��";  
        }  
    
        month = new JComboBox(arr2);  
       
    	String	m = String.valueOf(calendar.get(Calendar.MONTH)+1)+"��";
    	for(String  m1: arr2){
    		if(m1.equals(m)){
    			month.setSelectedItem(m1);
    		}
    	}
        
        
        month.setBounds(year.getX()+year.getWidth()+panel.getWidth()/100, inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
        String[] arr30 = new String[31];  
        for(int i=0;i<31;i++){  
             arr30[i]=i+1+"��";  
         }  
     
        day = new JComboBox(arr30);  
        
    	String	d = String.valueOf(calendar.get(Calendar.DATE))+"��";
    	for(String  d1: arr30){
    		if(d1.equals(d)){
    			day.setSelectedItem(d1);
    		}
    	}
    	
        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
       listPanel.add(day);
        
        month.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				listPanel.remove(day);
				switch(month.getSelectedItem().toString()){
					case "1��":
					case "3��":
					case "5��":
					case "7��":
					case "8��":
					case "10��":
					case "12��": 
						String[] arr31 = new String[31];  
        			for(int i=0;i<31;i++){  
        				arr31[i]=i+1+"��";  
        				
        			}  
        		
        			day = new JComboBox(arr31);  

        	        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
        	        listPanel.add(day);	
        	        break;
					case "4��":
					case "6��":
					case "9��":
					case "11��":
						String[] arr3 = new String[30];  
		    			for(int i=0;i<30;i++){  
		    				arr3[i]=i+1+"��";  
		    			}  
		        		
		    			 day = new JComboBox(arr3);  
		    		
		    		    
		    	        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
		    	        listPanel.add(day);
		    	        break;
					case "2��":
						if(isLeap(year.getSelectedItem().toString())){
							String[] arr33 = new String[29];  
							for(int i=0;i<29;i++){  
								arr33[i]=i+1+"��";  
							}  
		        		
							day = new JComboBox(arr33);  
						
							day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
							listPanel.add(day);
						}
						else{
							String[] arr333 = new String[28];  
							for(int i=0;i<28;i++){  
		    				arr333[i]=i+1+"��";  
							}  
		        		
							day = new JComboBox(arr333);  
					    	
							day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
							listPanel.add(day);
							
						}
							break;
					default: 
							break;
	        		
	        	}
			}
        	
        });
		

		listPanel.add(year);
		listPanel.add(month);
		listPanel.add(day);
		listPanel.add(line1);
		listPanel.add(line2);
		listPanel.add(line3);
	//	listPanel.add(tip);
		listPanel.add(inList);
	//	listPanel.add(ok);
		listPanel.add(cancel);
		listPanel.add(ok);
	//	listPanel.add(code);
		listPanel.add(bar);
		listPanel.add(bartext);
		listPanel.add(cargoinfo);
		listPanel.add(inDate);
		listPanel.add(distination);
		listPanel.add(damageCondition);
		listPanel.add(good);
		listPanel.add(damage);
		listPanel.add(area);
		listPanel.add(row);
		listPanel.add(shelf);
		listPanel.add(position);
	//	listPanel.add(codetext);
		listPanel.add(distext);
		listPanel.add(areatext);
		listPanel.add(rowtext);
		listPanel.add(shelftext);
		listPanel.add(postext);
		
		
		
		ok.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				String date=((year.getSelectedIndex()+2000)+"/")+((month.getSelectedIndex()+1)+"/")+((day.getSelectedIndex()+1+""));
				
				String damageCondition = null;
				if(good.isSelected()){
					damageCondition="���";
				}
				if(damage.isSelected()){
					damageCondition="��";
				}	
				
				
				WarehouseMemory memory=(WarehouseMemory) ((WritePanel)panel).getMemory();
				String code=memory.getWarehouseInCode();
				ReceiptCode cal=ConstructFactory.calculateCode();
				code=cal.calculCode(code,memory.getUserName());
				System.out.println(code);
				
				//code��ⵥ�š�barΪ������,key�ж��Ƿ�������ͬ��ⵥ��
				WarehouseInVO warehouseInVO = new WarehouseInVO(bartext.getText(),code,
						distext.getText(),date,((WritePanel) panel).getBelong()+" "+areatext.getText(),
						Integer.parseInt(rowtext.getText()),
						Integer.parseInt(shelftext.getText()),
						Integer.parseInt(postext.getText()),
						damageCondition);
				
				WarehouseBLService service=ConstructFactory.WarehouseFactory();
				boolean key=service.WarehouseIn(warehouseInVO);
			//��汨�� �������������Inventory���Ѵﵽ�ֿ�洢����90%����˵��ݲ������κεط�����ʾ������������
				System.out.println("?::::::::::::::::::::::::::??"+key);
				try{
				if(key){
					System.out.println("??????????????????????????");
					WarehouseReceipt wr = ConstructFactory.WarehouseReceiptFactory();
					wr.saveWarehouseInCode(code, memory.getUserName());
					memory.setWarehouseInCode(memory.getWarehouseInCode()+" "+code);
					memory.setWarehouseInDate(memory.getWarehouseInDate()+" "+date);
				}
				}catch(Exception ex){
					ex.printStackTrace();
					System.err.println("�����ظ������ţ���");
					a = new TipFrame("��������ȷ�Ķ�����");
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

	public void tip(){
		tipPanel = new JPanel();
		tipPanel.setLayout(null);
		tipPanel.setVisible(true);
		tipPanel.setBackground(Color.LIGHT_GRAY);
		tipPanel.setBounds(panel.getX()-panel.getWidth()/4,panel.getY()+panel.getHeight()*91/100, panel.getWidth()/5, panel.getHeight()/20);
		
		
		tip = new JLabel("�õ����л���");
		tip.setBounds(panel.getX()-panel.getWidth()/4,panel.getY()+panel.getHeight()*91/100, panel.getWidth()/5, panel.getHeight()/20);
		tipPanel.add(tip);
		panel.add(tipPanel);
		
	}
	
	public void remove(){
		panel.remove(listPanel);
		listPanel.remove(year);
		listPanel.remove(month);
		listPanel.remove(day);
		listPanel.remove(line1);
		listPanel.remove(line2);
		listPanel.remove(line3);
	//	listPanel.remove(tip);
		listPanel.remove(inList);
	//	listPanel.add(ok);
		listPanel.remove(cancel);
		listPanel.remove(ok);
	//	listPanel.remove(code);
		listPanel.remove(bar);
		listPanel.remove(bartext);
		listPanel.remove(cargoinfo);
		listPanel.remove(inDate);
		listPanel.remove(distination);
		listPanel.remove(damageCondition);
		listPanel.remove(good);
		listPanel.remove(damage);
		listPanel.remove(area);
		listPanel.remove(row);
		listPanel.remove(shelf);
		listPanel.remove(position);
	//	listPanel.remove(codetext);
		listPanel.remove(distext);
		listPanel.remove(areatext);
		listPanel.remove(rowtext);
		listPanel.remove(shelftext);
		listPanel.remove(postext);
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
