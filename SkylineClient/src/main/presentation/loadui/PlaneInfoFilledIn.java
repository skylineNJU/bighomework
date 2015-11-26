package main.presentation.loadui;

import java.awt.Color;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class PlaneInfoFilledIn {
	private JPanel panel;//大的
	private JPanel innerPanel;//小的
	private JLabel title;
	private JButton saveButton;
	private JButton delButton;
	private JLabel setOutPlaceLabel;
	private JLabel arrivalPlaceLabel;
	private JLabel monitorLabel;
	private JLabel guardLabel;
	private JLabel storeNumLabel;
	private JLabel loadAreaNumLabel;
	private JLabel freightLabel;
	private JTextField flightNum;
	private JTextField setOutPlace;
	private JTextField arrivalPlace;
	private JTextField monitor;
	private JTextField guard;
	private JTextField storeNum;
	private JTextField loadAreaNum;
	private JTextField freight;
	private JLabel planeNumLabel;//航运编号标签
	private JLabel flightNumLabel;//航班号标签
	private JLabel loadTimeLabel;
	private JTextField planeNum;
	private JTextField orderNum;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;//年月日标签
	private JComboBox<String> yearBox;//表示年份的组合框
	private JComboBox<String> monthBox;//表示月份的组合框
	private JComboBox<String> dayBox;//表示天的组合框
	int year;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;//31天


	int panelWidth=0;
	int panelHeight=0;
		public PlaneInfoFilledIn(){
			panel=MainController.getWritepanel();
			panel.setLayout(null);
			panelWidth=panel.getWidth();
			panelHeight=panel.getHeight();
		}
		public void init(){
			
			innerPanel=new JPanel();
			
			innerPanel.setBackground(Color.gray);
			innerPanel.setSize(panel.getWidth()/5*4+20,panel.getHeight()/5*4);
			
			innerPanel.setLocation(panel.getWidth()/8-25,panel.getHeight()/8-16);
			panel.add(innerPanel);
			innerPanel.setLayout(null);
			addTitle();
			addElements();
			setTime();
			panel.repaint();
			
		}
		public void addTitle(){
			title=new JLabel("飞机装运单");
			title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
			innerPanel.add(title);
		}
		public void addElements(){
			planeNumLabel=new JLabel("航运编号");
			flightNumLabel=new JLabel("航班号");
			loadTimeLabel=new JLabel("装运时间");
			setOutPlaceLabel=new JLabel("出发地");
			arrivalPlaceLabel=new JLabel("到达地");
			monitorLabel=new JLabel("监装员");
			guardLabel=new JLabel("押运员");
			storeNumLabel=new JLabel("货柜号");
			loadAreaNumLabel=new JLabel("托运区号");
			freightLabel=new JLabel("运费");
			
			planeNum=new JTextField("请输入航运编号");
            flightNum=new JTextField("请输入航班号");
			setOutPlace=new JTextField("请输入出发地");
			arrivalPlace=new JTextField("请输入到达地");
			monitor=new JTextField("请输入监装员");
			guard=new JTextField("请输入押运员");
			storeNum=new JTextField("请输入货柜号");
			loadAreaNum=new JTextField("请输入托运区号");
			freight=new JTextField("请输入运费");
			
			
			planeNumLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			loadTimeLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			flightNumLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			setOutPlaceLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			arrivalPlaceLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			monitorLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			guardLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			storeNumLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			loadAreaNumLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			freightLabel.setSize(panelWidth*20/69,panelHeight*35/550);
			
			planeNumLabel.setLocation(panelWidth/3,panelHeight/4);
			loadTimeLabel.setLocation(planeNumLabel.getX(),planeNumLabel.getY()-panelHeight/8);
			flightNumLabel.setLocation(planeNumLabel.getX(),planeNumLabel.getY()+panelHeight/8);
			setOutPlaceLabel.setLocation(planeNumLabel.getX(),flightNumLabel.getY()+panelHeight/8);
			arrivalPlaceLabel.setLocation(planeNumLabel.getX(),setOutPlaceLabel.getY()+panelHeight/8);
			monitorLabel.setLocation(planeNumLabel.getX(),arrivalPlaceLabel.getY()+panelHeight/8);
			guardLabel.setLocation(planeNumLabel.getX()+panelWidth/3,planeNumLabel.getY());
			storeNumLabel.setLocation(guardLabel.getX(),flightNumLabel.getY());
			loadAreaNumLabel.setLocation(storeNumLabel.getX(),setOutPlace.getY());
			freightLabel.setLocation(loadAreaNumLabel.getX(),arrivalPlaceLabel.getY());
			
			planeNum.setLocation(planeNumLabel.getX()+panelWidth/12,planeNumLabel.getY());
			flightNum.setLocation(planeNum.getX(),flightNumLabel.getY());
			setOutPlace.setLocation(flightNum.getX(),setOutPlaceLabel.getY());
			arrivalPlace.setLocation(setOutPlace.getX(),arrivalPlaceLabel.getY());
			monitor.setLocation(arrivalPlace.getX(),monitorLabel.getY());
			guard.setLocation(guardLabel.getX()+panelWidth/12,guardLabel.getY());
			storeNum.setLocation(guard.getX(),storeNumLabel.getY());
			loadAreaNum.setLocation(storeNum.getX(),loadAreaNumLabel.getY());
			freight.setLocation(loadAreaNum.getX(),freightLabel.getY());
			
			planeNum.setSize(panelWidth*20/69,panelWidth*10/69);
			flightNum.setSize(panelWidth*20/69,panelWidth*10/69);
			setOutPlace.setSize(panelWidth*20/69,panelWidth*10/69);
			arrivalPlace.setSize(panelWidth*20/69,panelWidth*10/69);
			monitor.setSize(panelWidth*20/69,panelWidth*10/69);
			guard.setSize(panelWidth*20/69,panelWidth*10/69);
			storeNum.setSize(panelWidth*20/69,panelWidth*10/69);
			loadAreaNum.setSize(panelWidth*20/69,panelWidth*10/69);
			freight.setSize(panelWidth*20/69,panelWidth*10/69);
			
			
			
			
			delButton = new JButton("删除");
			saveButton = new JButton("保存");
			delButton.setBounds(panelWidth*3/5, panelHeight*9/10, panelWidth/10, panelHeight/20);
			saveButton.setBounds(panelWidth*3/5+delButton.getWidth()*2, panelHeight*9/10, panelWidth/10, panelHeight/20);
			
			panel.add(delButton);
			panel.add(saveButton);
			innerPanel.add(loadTimeLabel);
			innerPanel.add(planeNumLabel);
			innerPanel.add(planeNum);
			innerPanel.add(flightNumLabel);
			innerPanel.add(flightNum);
			innerPanel.add(setOutPlaceLabel);
			innerPanel.add(setOutPlace);
			innerPanel.add(arrivalPlaceLabel);
			innerPanel.add(arrivalPlace);
			innerPanel.add(monitorLabel);
			innerPanel.add(monitor);
			innerPanel.add(guard);
			innerPanel.add(guardLabel);
			innerPanel.add(storeNumLabel);
			innerPanel.add(storeNum);
			innerPanel.add(loadAreaNum);
			innerPanel.add(loadAreaNumLabel);
			innerPanel.add(freightLabel);
			innerPanel.add(freight);
			setTime();
			
			
		}
		public void setTime(){
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
			yearLabel = new JLabel("年");
			monthLabel = new JLabel("月");
			dayLabel = new JLabel("日");
			
			yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
			monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
			dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
					"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
			yearBox = new JComboBox<String>(yearString);
			yearBox.setSize(panelWidth*20/69,panelHeight*35/550);
			yearBox.setLocation(panelWidth*7/46,panelHeight*2/5);
			yearLabel.setSize(panelWidth*20/69,panelWidth*10/69);
			yearLabel.setLocation(panelWidth*45/690+panelWidth*29/69,panelHeight*185/550);
			monthBox = new JComboBox<String>(monthString);
			monthBox.setSize(panelWidth*20/69,panelHeight*35/550);
			monthBox.setLocation(panelWidth*105/690,panelHeight*567/1100);
			monthLabel.setSize(panelWidth*20/69,panelWidth*10/69);
			monthLabel.setLocation(panelWidth*45/690+panelWidth*29/69,panelHeight/2+panelHeight/7-panelHeight*105/550);
			dayBox = new JComboBox<String>(dayString);
			dayBox.setSize(panelWidth*20/69,panelHeight*35/550);
			dayBox.setLocation(panelWidth/2-panelWidth*24/69,panelHeight/2+panelHeight/7+panelHeight/7-panelHeight*85/550);
			dayLabel.setSize(panelWidth*20/69,panelWidth*10/69);
			dayLabel.setLocation(panelWidth/2-panelWidth*10/23+panelWidth*29/69,panelHeight/2+panelHeight/7+panelHeight/7-panelHeight*12/55);
			
		
			innerPanel.add(yearLabel);
			innerPanel.add(monthLabel);
			innerPanel.add(dayLabel);
			innerPanel.add(yearBox);
			innerPanel.add(monthBox);
			innerPanel.add(dayBox);
		}
}
