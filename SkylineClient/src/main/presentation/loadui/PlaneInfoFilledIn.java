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
	private JPanel panel;//���
	private JPanel innerPanel;//С��
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
	private JLabel planeNumLabel;//���˱�ű�ǩ
	private JLabel flightNumLabel;//����ű�ǩ
	private JLabel loadTimeLabel;
	private JTextField planeNum;
	private JTextField orderNum;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;//�����ձ�ǩ
	private JComboBox<String> yearBox;//��ʾ��ݵ���Ͽ�
	private JComboBox<String> monthBox;//��ʾ�·ݵ���Ͽ�
	private JComboBox<String> dayBox;//��ʾ�����Ͽ�
	int year;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;//31��


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
			title=new JLabel("�ɻ�װ�˵�");
			title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
			innerPanel.add(title);
		}
		public void addElements(){
			planeNumLabel=new JLabel("���˱��");
			flightNumLabel=new JLabel("�����");
			loadTimeLabel=new JLabel("װ��ʱ��");
			setOutPlaceLabel=new JLabel("������");
			arrivalPlaceLabel=new JLabel("�����");
			monitorLabel=new JLabel("��װԱ");
			guardLabel=new JLabel("Ѻ��Ա");
			storeNumLabel=new JLabel("�����");
			loadAreaNumLabel=new JLabel("��������");
			freightLabel=new JLabel("�˷�");
			
			planeNum=new JTextField("�����뺽�˱��");
            flightNum=new JTextField("�����뺽���");
			setOutPlace=new JTextField("�����������");
			arrivalPlace=new JTextField("�����뵽���");
			monitor=new JTextField("�������װԱ");
			guard=new JTextField("������Ѻ��Ա");
			storeNum=new JTextField("����������");
			loadAreaNum=new JTextField("��������������");
			freight=new JTextField("�������˷�");
			
			
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
			
			
			
			
			delButton = new JButton("ɾ��");
			saveButton = new JButton("����");
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
			yearLabel = new JLabel("��");
			monthLabel = new JLabel("��");
			dayLabel = new JLabel("��");
			
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
