package main.presentation.warehouseui;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;

public class AddWarehouseInReceiptPanel {
	private FrameMain frame;
	private JPanel panel;
	private JPanel listPanel;
	private JPanel warningPanel;
	private JButton ok;
	private JButton cancel;
	private JLabel inList;
	private JLabel cargoinfo;
	private JLabel bar;
	private JLabel tip;
	private JLabel inDate;
	private JLabel distination;	
	private JLabel area;
	private JLabel row;
	private JLabel shelf;
	private JLabel position;
	private JLabel line1;
	private JLabel line2;
	private JLabel line3;
	private JComboBox year;
	private JComboBox month;
	private JComboBox day;
	private JTextField bartext;
	private JTextField distext;
	private JTextField areatext;
	private JTextField rowtext;
	private JTextField shelftext;
	private JTextField postext;
	private JScrollPane scrollPane;
	
	public AddWarehouseInReceiptPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	
	}
	
	public void init(){
		//title();
		listPanel= new JPanel();
		listPanel.setLayout(null);
	//	scrollPane = new JScrollPane(listpanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	//	scrollPane.setVisible(true);
	//	scrollPane.setBounds(panel.getWidth()*10/80, panel.getHeight()/20, panel.getWidth()*60/80, panel.getHeight()*18/20);
	//	listpanel.setPreferredSize(new Dimension(1, panel.getHeight()));
	
	//	scrollPane.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, Color.GRAY));//top,left,bottom,right
		
		listPanel.setBounds(panel.getWidth()*10/80, panel.getHeight()/20, panel.getWidth()*57/80, panel.getHeight()*18/20);
		listPanel.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, Color.GRAY));//top,left,bottom,right
		content();

		
		
		
		

		
		
	//	panel.add(scrollPane);
		listPanel.setVisible(true);
		panel.add(listPanel);	
		panel.repaint();
		listPanel.repaint();
	
	//	JOptionPane.showMessageDialog(null, "该区货物过满，请重新填写区号！","消息",JOptionPane. WARNING_MESSAGE);
		
		
	}


	public void content(){
		Font font00 = new Font("宋体", Font.BOLD, 20);
		Font font0 = new Font("宋体", Font.BOLD, 16);
		Font font = new Font("宋体", Font.BOLD, 15);
		line1 = new JLabel("————————————————————————");
		line1.setFont(font0);
		line1.setBounds(listPanel.getX()-panel.getWidth()/15,listPanel.getY(), panel.getWidth()*3/5, panel.getHeight()/10);
		
		line2 = new JLabel("——————————————————————");
		line2.setFont(font0);
		line2.setForeground(Color.GRAY);
		line2.setBounds(listPanel.getX()-panel.getWidth()/30,listPanel.getY()+panel.getHeight()/13, panel.getWidth()*3/5, panel.getHeight()/10);
		
		line3 = new JLabel("——————————————————————");
		line3.setFont(font0);
		line3.setForeground(Color.GRAY);
		line3.setBounds(listPanel.getX()-panel.getWidth()/30,listPanel.getY()+panel.getHeight()/20*11, panel.getWidth()*3/5, panel.getHeight()/10);
		
		
		
		ok=new JButton("提交");
		ok.setFont(font);
		ok.setBounds(listPanel.getX()+panel.getWidth()*2/5,listPanel.getY()+panel.getHeight()*4/6, panel.getWidth()/10, panel.getHeight()/20);
		
		cancel=new JButton("取消");
		cancel.setFont(font);
		cancel.setBounds(ok.getX()-panel.getWidth()/7,ok.getY(), panel.getWidth()/10, panel.getHeight()/20);
		
		inList=new JLabel("入库单");
		inList.setFont(font00);
		inList.setBounds(listPanel.getX()-panel.getWidth()/15,listPanel.getY()-panel.getHeight()/30, panel.getWidth()/10, panel.getHeight()/10);
		
		cargoinfo=new JLabel("货物信息");
		cargoinfo.setFont(font0);
		cargoinfo.setBounds(listPanel.getX()-panel.getWidth()/30,listPanel.getY()+panel.getHeight()/20,panel.getWidth()/10, panel.getHeight()/10);
		
		bar=new JLabel("入库单号:");
		bar.setFont(font);
		bar.setBounds(cargoinfo.getX(),cargoinfo.getY()+panel.getHeight()/12,panel.getWidth()/5, panel.getHeight()/10);
		
		inDate=new JLabel("入库日期:");
		inDate.setFont(font);
		inDate.setBounds(cargoinfo.getX(),bar.getY()+panel.getHeight()/11,panel.getWidth()/5, panel.getHeight()/10);
		
		distination=new JLabel("目的地:");
		distination.setFont(font);
		distination.setBounds(cargoinfo.getX(),inDate.getY()+panel.getHeight()/11,panel.getWidth()/5, panel.getHeight()/10);
		
		area=new JLabel("区号:");
		area.setFont(font);
		area.setBounds(cargoinfo.getX(),distination.getY()+panel.getHeight()/11,panel.getWidth()/5, panel.getHeight()/10);
		
		row=new JLabel("排号:");
		row.setFont(font);
		row.setBounds(area.getX()+panel.getWidth()/3,area.getY(),panel.getWidth()/5, panel.getHeight()/10);
		
		shelf=new JLabel("架号:");
		shelf.setFont(font);
		shelf.setBounds(cargoinfo.getX(),row.getY()+panel.getHeight()/11,panel.getWidth()/5, panel.getHeight()/10);
		
		position=new JLabel("位号:");
		position.setFont(font);
		position.setBounds(shelf.getX()+panel.getWidth()/3,shelf.getY(),panel.getWidth()/5, panel.getHeight()/10);
		
		bartext = new JTextField();
		bartext.setBounds(bar.getX()+panel.getWidth()/8,bar.getY()+panel.getWidth()/50,panel.getWidth()/6, panel.getHeight()/20);
		
		tip = new JLabel("*请输入10位有效入库单号");
		tip.setFont(new Font("宋体", Font.BOLD, 12));
		tip.setForeground(Color.GRAY);
		tip.setBounds(bartext.getX()+bartext.getWidth()+panel.getWidth()/50,bar.getY(),panel.getWidth()/3, panel.getHeight()/10);
		
		
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
		String[] arr1=new String[1000];//数组时个对象,对象在使用前要初始化  
        for(int i=0;i<1000;i++){  
            arr1[i] = i+2000+"年";  
        }         
        
        year = new JComboBox(arr1);  
        year.setBounds(inDate.getX()+panel.getWidth()/8, inDate.getY()+panel.getWidth()/50, panel.getWidth()/11, panel.getHeight()/20);
   
        String [] arr2 = new String[12];  
        for(int i=0;i<12;i++){  
            arr2[i]=i+1+"月";  
        }  
    
        month = new JComboBox(arr2);  
       
        month.setBounds(year.getX()+year.getWidth()+panel.getWidth()/100, inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
        String[] arr30 = new String[31];  
        for(int i=0;i<31;i++){  
             arr30[i]=i+1+"日";  
         }  
     
        day = new JComboBox(arr30);  
        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
       listPanel.add(day);
        
        month.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				listPanel.remove(day);
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
        	        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
        	        listPanel.add(day);	
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
		    	        day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
		    	        listPanel.add(day);
		    	        break;
					case "2月":
						if(isLeap(year.getSelectedItem().toString())){
							String[] arr33 = new String[29];  
							for(int i=0;i<29;i++){  
								arr33[i]=i+1+"日";  
							}  
		        		
							day = new JComboBox(arr33);  
							day.setBounds(month.getX()+month.getWidth()+panel.getWidth()/100,inDate.getY()+panel.getWidth()/50, panel.getWidth()/12, panel.getHeight()/20);
							listPanel.add(day);
						}
						else{
							String[] arr333 = new String[28];  
							for(int i=0;i<28;i++){  
		    				arr333[i]=i+1+"日";  
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
		listPanel.add(tip);
		listPanel.add(inList);
		listPanel.add(ok);
		listPanel.add(cancel);
		listPanel.add(bar);
		listPanel.add(cargoinfo);
		listPanel.add(inDate);
		listPanel.add(distination);
		listPanel.add(area);
		listPanel.add(row);
		listPanel.add(shelf);
		listPanel.add(position);
		listPanel.add(bartext);
		listPanel.add(distext);
		listPanel.add(areatext);
		listPanel.add(rowtext);
		listPanel.add(shelftext);
		listPanel.add(postext);
		
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
