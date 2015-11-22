package main.presentation.warehouseui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;

public class AddWarehouseOutReceiptPanel {
	private FrameMain frame;
	private JPanel panel;
	private JPanel listpanel;
	private JButton ok;
	private JButton cancel;
	private JLabel outList;
	private JLabel cargoinfo;
	private JLabel bar;
	private JLabel tip1;
	private JLabel tip2;
	private JLabel outDate;
	private JLabel distination;	
	private JLabel loadingtype;
	private JLabel transfercode;
	private JLabel train;	
	private JLabel bus;
	private JLabel plane;
	private JLabel trainB;	
	private JLabel busB;
	private JLabel planeB;
	private JLabel line1;
	private JLabel line2;
	private JLabel line3;
	private JComboBox year;
	private JComboBox month;
	private JComboBox day;
	private JTextField bartext;
	private JTextField distext;
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
	//	scrollPane = new JScrollPane(listpanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	//	scrollPane.setVisible(true);
	//	scrollPane.setBounds(panel.getWidth()*10/80, panel.getHeight()/20, panel.getWidth()*60/80, panel.getHeight()*18/20);
	//	listpanel.setPreferredSize(new Dimension(1, panel.getHeight()));
	
	//	scrollPane.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, Color.GRAY));//top,left,bottom,right
		
		listpanel.setBounds(panel.getWidth()*10/80, panel.getHeight()/20, panel.getWidth()*57/80, panel.getHeight()*18/20);
		listpanel.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, Color.GRAY));//top,left,bottom,right
	
		content();
	
	//	panel.add(scrollPane);
		listpanel.setVisible(true);
		panel.add(listpanel);
		panel.repaint();
		listpanel.repaint();
	}


	public void content(){
		Font font00 = new Font("����", Font.BOLD, 20);
		Font font0 = new Font("����", Font.BOLD, 16);
		Font font = new Font("����", Font.BOLD, 15);
		line1 = new JLabel("������������������������������������������������");
		line1.setFont(font0);
		line1.setBounds(listpanel.getX()-panel.getWidth()/15,listpanel.getY(), panel.getWidth()*3/5, panel.getHeight()/10);
		
		line2 = new JLabel("��������������������������������������������");
		line2.setFont(font0);
		line2.setForeground(Color.GRAY);
		line2.setBounds(listpanel.getX()-panel.getWidth()/30,listpanel.getY()+panel.getHeight()/13, panel.getWidth()*3/5, panel.getHeight()/10);
		
		line3 = new JLabel("��������������������������������������������");
		line3.setFont(font0);
		line3.setForeground(Color.GRAY);
		line3.setBounds(listpanel.getX()-panel.getWidth()/30,listpanel.getY()+panel.getHeight()/20*13, panel.getWidth()*3/5, panel.getHeight()/10);
		
		
		
		ok=new JButton("�ύ");
		ok.setFont(font);
		ok.setBounds(listpanel.getX()+panel.getWidth()*2/5,listpanel.getY()+panel.getHeight()*5/7, panel.getWidth()/10, panel.getHeight()/20);
		
		cancel=new JButton("ȡ��");
		cancel.setFont(font);
		cancel.setBounds(ok.getX()-panel.getWidth()/7,ok.getY(), panel.getWidth()/10, panel.getHeight()/20);
		
		outList=new JLabel("���ⵥ");
		outList.setFont(font00);
		outList.setBounds(listpanel.getX()-panel.getWidth()/15,listpanel.getY()-panel.getHeight()/30, panel.getWidth()/10, panel.getHeight()/10);
		
		cargoinfo=new JLabel("������Ϣ");
		cargoinfo.setFont(font0);
		cargoinfo.setBounds(listpanel.getX()-panel.getWidth()/30,listpanel.getY()+panel.getHeight()/20,panel.getWidth()/10, panel.getHeight()/10);
		
		bar=new JLabel("���ⵥ��:");
		bar.setFont(font);
		bar.setBounds(cargoinfo.getX(),cargoinfo.getY()+panel.getHeight()/12,panel.getWidth()/5, panel.getHeight()/10);
		
		outDate=new JLabel("��������:");
		outDate.setFont(font);
		outDate.setBounds(cargoinfo.getX(),bar.getY()+panel.getHeight()/11,panel.getWidth()/5, panel.getHeight()/10);
		
		distination=new JLabel("Ŀ�ĵ�:");
		distination.setFont(font);
		distination.setBounds(cargoinfo.getX(),outDate.getY()+panel.getHeight()/11,panel.getWidth()/5, panel.getHeight()/10);
		
		loadingtype=new JLabel("װ����ʽ:");
		loadingtype.setFont(font);
		loadingtype.setBounds(cargoinfo.getX(),distination.getY()+panel.getHeight()/11,panel.getWidth()/5, panel.getHeight()/10);
		
		trainB = new JLabel("Icon"); 
		trainB.setFont(font);
		trainB.setBounds(loadingtype.getX()+panel.getWidth()/8,loadingtype.getY()+panel.getHeight()/45,panel.getWidth()/5, panel.getHeight()/20);
		planeB = new JLabel("Icon");
		planeB.setFont(font);
		planeB.setBounds(loadingtype.getX()+panel.getWidth()/8,trainB.getY()+panel.getHeight()/20,panel.getWidth()/5, panel.getHeight()/20);
		busB = new JLabel("Icon");
		busB.setFont(font);
		busB.setBounds(loadingtype.getX()+panel.getWidth()/8,planeB.getY()+panel.getHeight()/20,panel.getWidth()/5, panel.getHeight()/20);
		
		train = new JLabel("��"); 
		train.setFont(font);
		train.setBounds(trainB.getX()+panel.getWidth()/15,trainB.getY(),panel.getWidth()/5, panel.getHeight()/20);
		plane = new JLabel("�ɻ�");
		plane.setFont(font);
		plane.setBounds(planeB.getX()+panel.getWidth()/15,planeB.getY(),panel.getWidth()/5, panel.getHeight()/20);
		bus = new JLabel("����");
		bus.setFont(font);
		bus.setBounds(busB.getX()+panel.getWidth()/15,busB.getY(),panel.getWidth()/5, panel.getHeight()/20);
		

		transfercode=new JLabel("��ת�����:");
		transfercode.setFont(font);
		transfercode.setBounds(cargoinfo.getX(),bus.getY()+panel.getHeight()/17,panel.getWidth()/5, panel.getHeight()/10);
		
		bartext = new JTextField();
		bartext.setBounds(bar.getX()+panel.getWidth()/8,bar.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
		tip1 = new JLabel("*������10λ��Ч���ⵥ��");
		tip1.setFont(new Font("����", Font.BOLD, 12));
		tip1.setForeground(Color.GRAY);
		tip1.setBounds(bartext.getX()+bartext.getWidth()+panel.getWidth()/50,bar.getY(),panel.getWidth()/3, panel.getHeight()/10);
		
		
		distext = new JTextField();
		distext.setBounds(distination.getX()+panel.getWidth()/8,distination.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
		transtext = new JTextField();
		transtext.setBounds(transfercode.getX()+panel.getWidth()/7,transfercode.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
		tip2 = new JLabel("*������14λ��Ч��ת�����");
		tip2.setFont(new Font("����", Font.BOLD, 12));
		tip2.setForeground(Color.GRAY);
		tip2.setBounds(transtext.getX()+transtext.getWidth()+panel.getWidth()/50,transfercode.getY(),panel.getWidth()/3, panel.getHeight()/10);
		
		
		

		year= new JComboBox();
		month= new JComboBox();
		day= new JComboBox();
		String[] arr1=new String[1000];//����ʱ������,������ʹ��ǰҪ��ʼ��  
        for(int i=0;i<1000;i++){  
            arr1[i] = i+2000+"��";  
        }         
        
        year = new JComboBox(arr1);  
        year.setBounds(outDate.getX()+panel.getWidth()/8, outDate.getY()+panel.getWidth()/50, panel.getWidth()/11, panel.getHeight()/20);
   
        String [] arr2 = new String[12];  
        for(int i=0;i<12;i++){  
            arr2[i]=i+1+"��";  
        }  
    
        month = new JComboBox(arr2);  
       
        month.setBounds(year.getX()+year.getWidth()+panel.getWidth()/100, outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
        String[] arr30 = new String[31];  
        for(int i=0;i<31;i++){  
             arr30[i]=i+1+"��";  
         }  
     
        day = new JComboBox(arr30);  
        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
       listpanel.add(day);
        
        month.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				listpanel.remove(day);
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
        	        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
        	        listpanel.add(day);	
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
		    	        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
		    	        listpanel.add(day);
		    	        break;
					case "2��":
						if(isLeap(year.getSelectedItem().toString())){
							String[] arr33 = new String[29];  
							for(int i=0;i<29;i++){  
								arr33[i]=i+1+"��";  
							}  
		        		
							day = new JComboBox(arr33);  
							day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,outDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
							listpanel.add(day);
						}
						else{
							String[] arr333 = new String[28];  
							for(int i=0;i<28;i++){  
		    				arr333[i]=i+1+"��";  
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
		listpanel.add(tip1);
		listpanel.add(tip2);
		listpanel.add(outList);
		listpanel.add(ok);
		listpanel.add(cancel);
		listpanel.add(bar);
		listpanel.add(cargoinfo);
		listpanel.add(outDate);
		listpanel.add(distination);
		listpanel.add(loadingtype);
		listpanel.add(plane);
		listpanel.add(bus);
		listpanel.add(train);
		listpanel.add(planeB);
		listpanel.add(busB);
		listpanel.add(trainB);
		listpanel.add(transfercode);
		listpanel.add(bartext);
		listpanel.add(distext);
		listpanel.add(transtext);
		
		
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


