package main.presentation.warehouseui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;

//���鿴
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
	private String  title1;//��ⵥ��
	private String  title2;//���ⵥ��
	private String  title3;//�洢λ��
	
	private String  othertitle;//���ż�λ
	private String  titlelist;
	
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
		tab.addTab("�����Ϣ", inInfo);
		tab.addTab("������Ϣ", outInfo);
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
		startdate = new JLabel("��ʼ����:");
		enddate = new JLabel("��ֹ����:");
		Font font = new Font("����", Font.BOLD, 15);
		enddate.setFont(font);
		startdate.setFont(font);
		startdate.setBounds(panel.getWidth()/18, panel.getHeight()/15, panel.getWidth()/6, panel.getHeight()/20);
		enddate.setBounds(panel.getWidth()*8/18, panel.getHeight()/15, panel.getWidth()/6, panel.getHeight()/20);
		startdate.setVisible(true);
		enddate.setVisible(true);
		
		
		year1= new JComboBox();
		month1= new JComboBox();
		day1= new JComboBox();
		year2= new JComboBox();
		month2= new JComboBox();
		day2= new JComboBox();

          
        //�ֱ�����3��combobox�ڵ�ֵ  
        String[] arr1=new String[1000];//����ʱ������,������ʹ��ǰҪ��ʼ��  
        for(int i=0;i<1000;i++){  
            arr1[i] = i+2000+"��";  
        }         
        
        year1 = new JComboBox(arr1);  
        year1.setBounds(panel.getWidth()*3/18, panel.getHeight()/15, panel.getWidth()/11, panel.getHeight()/20);
   
        String [] arr2 = new String[12];  
        for(int i=0;i<12;i++){  
            arr2[i]=i+1+"��";  
        }  
    
        month1 = new JComboBox(arr2);  
       
        month1.setBounds(year1.getX()+year1.getWidth()+panel.getWidth()/100, panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
        String[] arr30 = new String[31];  
        for(int i=0;i<31;i++){  
             arr30[i]=i+1+"��";  
         }  
     
        day1 = new JComboBox(arr30);  
        day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
        panel.add(day1);
        
        month1.addItemListener(new ItemListener(){
			@Override
			
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				panel.remove(day1);
				switch(month1.getSelectedItem().toString()){
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
        		
        			day1 = new JComboBox(arr31);  
        	        day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
        	        panel.add(day1);	
        	        break;
					case "4��":
					case "6��":
					case "9��":
					case "11��":
						String[] arr3 = new String[30];  
		    			for(int i=0;i<30;i++){  
		    				arr3[i]=i+1+"��";  
		    			}  
		        		
		    			 day1 = new JComboBox(arr3);  
		    	        day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
		    	        panel.add(day1);
		    	        break;
					case "2��":
						if(isLeap(year1.getSelectedItem().toString())){
							String[] arr33 = new String[29];  
							for(int i=0;i<29;i++){  
								arr33[i]=i+1+"��";  
							}  
		        		
							day1 = new JComboBox(arr33);  
							day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
							panel.add(day1);
						}
						else{
							String[] arr333 = new String[28];  
							for(int i=0;i<28;i++){  
		    				arr333[i]=i+1+"��";  
							}  
		        		
							day1 = new JComboBox(arr333);  
							day1.setBounds(month1.getX()+month1.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
							panel.add(day1);
							
						}
							break;
					default: 
							break;
	        		
	        	}
			}
        	
        });
       
        year2 = new JComboBox(arr1);  
        year2.setBounds(panel.getWidth()*10/18, panel.getHeight()/15, panel.getWidth()/11, panel.getHeight()/20);
      
        month2 = new JComboBox(arr2);  
        month2.setBounds(year2.getX()+year2.getWidth()+panel.getWidth()/100, panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
 
        for(int i=0;i<31;i++){  
             arr30[i]=i+1+"��";  
         }  
     
        day2 = new JComboBox(arr30);  
        day2.setBounds(month2.getX()+month2.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
        panel.add(day2);
        month2.addItemListener(new ItemListener(){
     			@Override
     			
     			public void itemStateChanged(ItemEvent arg0) {
     				// TODO Auto-generated method stub
     				panel.remove(day2);
     				switch(month2.getSelectedItem().toString()){
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
             		
             			day2 = new JComboBox(arr31);  
             	        day2.setBounds(month2.getX()+month2.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
             	        panel.add(day2);	
             	        break;
     					case "4��":
     					case "6��":
     					case "9��":
     					case "11��":
     						String[] arr3 = new String[30];  
     		    			for(int i=0;i<30;i++){  
     		    				arr3[i]=i+1+"��";  
     		    			}  
     		        		
     		    			 day2 = new JComboBox(arr3);  
     		    	        day2.setBounds(month2.getX()+month1.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
     		    	        panel.add(day2);
     		    	        break;
     					case "2��":
     						if(isLeap(year2.getSelectedItem().toString())){
     							String[] arr33 = new String[29];  
     							for(int i=0;i<29;i++){  
     								arr33[i]=i+1+"��";  
     							}  
     		        		
     							day2 = new JComboBox(arr33);  
     							day2.setBounds(month2.getX()+month2.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
     							panel.add(day2);
     						}
     						else{
     							String[] arr333 = new String[28];  
     							for(int i=0;i<28;i++){  
     		    				arr333[i]=i+1+"��";  
     							}  
     		        		
     							day2 = new JComboBox(arr333);  
     							day2.setBounds(month2.getX()+month2.getWidth()+panel.getWidth()/100,panel.getHeight()/15, panel.getWidth()/12, panel.getHeight()/20);
     							panel.add(day2);
     							
     						}
     							break;
     					default: 
     							break;
     	        		
     	        	}
     			}
             	
             });
       
        ok=new JButton("ȷ��");
		ok.setBounds(day2.getX()+month2.getWidth()+panel.getWidth()/90,panel.getHeight()/15, panel.getWidth()/11, panel.getHeight()/20);
		ok.setVisible(true);
		
        
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
		
		title1="��ⵥ��";
		title2 ="���ⵥ��";
		title3="�洢λ��";
		String[] t1 = new String[]{title1,title3};
		String[] t2 = new String[]{title2,title3};

		
		String[] ot = new String[]{"��ⵥ��","����","�ź�","�ܺ�","λ��"};
		String[][] tl = new String[][]{{"111010000000","A","1","2","1"},{"111010000000","A","1","3","1"},{"111010000000","A","1","4","1"},
				{"111010000200","B","2","2","1"},{"111010000050","K","1","2","1"},{"111010000090","F","1","2","1"},{"111010000000","A","1","9","1"},
				{"111010000004","A","9","3","1"},{"111010000000","D","1","2","1"},{"111230000230","A","1","2","1"},{"111010000000","C","1","2","1"},
				{"112020033000","H","11","2","7"},{"112040000003","D","1","2","1"},{"112310000010","B","2","3","1"},{"111010000000","C","2","1","1"}};
		table1 = new JTable(tl,ot);
		String[] ot1 = new String[]{"���ⵥ��","����","�ź�","�ܺ�","λ��"};
		table2 = new JTable(tl,ot1);
	//in
		table1.setEnabled(false);//���ò��ɱ༭����
		table1.setRowHeight(panel.getWidth()/20);//�����п�
		table1.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//���ñ�ͷ�߶�
		table1.getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table1.setDragEnabled(false);
		table1.setVisible(true);
		scrollPane = new JScrollPane(table1);

		if(tl.length>=10){
			scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8,tab.getWidth(), 10*table1.getRowHeight());
		}else{
			scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8,tab.getWidth(), (table1.getRowCount()+1)*table1.getRowHeight());
		}
		table1.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/5);;
		table1.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/6);;
		table1.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		scrollPane.setVisible(true);
		inInfo.add(scrollPane);
	//out
		table2.setEnabled(false);//���ò��ɱ༭����
		table2.setRowHeight(panel.getWidth()/20);//�����п�
		table2.getTableHeader().setPreferredSize(new Dimension(tab.getWidth(), panel.getWidth()/20));//���ñ�ͷ�߶�
		table2.getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table2.setDragEnabled(false);
		table2.setVisible(true);
		scrollPane2 = new JScrollPane(table2);

		if(tl.length>=10){
			scrollPane2.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8, tab.getWidth(), 10*table1.getRowHeight());
		}else{
			scrollPane2.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/8,tab.getWidth(), (table1.getRowCount()+1)*table1.getRowHeight());
		}
		table2.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/5);;
		table2.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/6);;
		table2.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		table2.setVisible(true);
		scrollPane2.setVisible(true);
		outInfo.add(scrollPane2);
		
		
		//tab.add(table1);
	}
	
	public void Num(){
		Font font = new Font("����", Font.BOLD, 13);//BOLD PLAIN
		
		inNum = new JLabel("�������:");
		inNum.setFont(font);
		inNum.setBounds(panel.getWidth()*3/4,panel.getHeight()*81/100, panel.getWidth()*2/5, panel.getHeight()/15);
		inNum.setVisible(true);
		
		outNum = new JLabel("��������");
		outNum.setFont(font);
		outNum.setBounds(panel.getWidth()*3/4,panel.getHeight()*81/100, panel.getWidth()*2/5, panel.getHeight()/15);
		outNum.setVisible(true);
	
		allNum = new JLabel("�洢�����ϼ�:");
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
