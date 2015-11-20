package main.presentation.loadui;

import java.awt.Color;
import java.awt.TextField;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class LoadVehiclePanel {
	int year;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;//31��
	private JPanel panel;
	private JTabbedPane tabbedPane;//ѡ��ɻ�/��/����
	private JTextField transmitCenterNumber;//��ת���ı�������
	private JLabel  transmitCenterNumberLabel;
    private JLabel  receiptNumberLabel;
    private JTextField receiptNumber;//�������������
    private JLabel receiveDateLabel;
    private JTextField receiveDate;//����ʱ�������
	private JPanel carLoadInfo;
	private JPanel planeLoadInfo;
	private JPanel trainLoadInfo;
	private JLabel timeLabel;//װ������
	private JComboBox<String> yearBox;//��ʾ��ݵ���Ͽ�
	private JComboBox<String> monthBox;//��ʾ�·ݵ���Ͽ�
	private JComboBox<String> dayBox;//��ʾ�����Ͽ�
	private JButton searchFromDate;//�������ڲ�ѯ
	private JTable planeTable;//�ɻ����
	private JTable trainTable;
	private JTable carTable;
	private JButton ensureButton;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private String[] tableTitle;
	private String[][] tableData;
	private JButton delButton;
	private JButton saveButton;
	int panelWidth=0;
	int panelHeight=0;
	public LoadVehiclePanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		tabbedPane=new JTabbedPane(JTabbedPane.TOP);//�������Ϸ�ѡ��
		carLoadInfo=new JPanel();
		planeLoadInfo=new JPanel();
		trainLoadInfo=new JPanel();
		
		carLoadInfo.setBackground(Color.red);
		planeLoadInfo.setBackground(Color.pink);
		trainLoadInfo.setBackground(Color.orange);
		
		carLoadInfo.setLayout(null);
		planeLoadInfo.setLayout(null);
		trainLoadInfo.setLayout(null);
		
		tabbedPane.addTab("�ɻ�װ��",planeLoadInfo);
		tabbedPane.addTab("��װ��",trainLoadInfo);
		tabbedPane.addTab("����װ��",carLoadInfo);
		
		tabbedPane.setSize(panel.getWidth()/6*5+43,panel.getHeight()/6*5);
		tabbedPane.setLocation(panel.getWidth()/18,panel.getHeight()/12);
		panel.add(tabbedPane);
		planeLoadConpo();
		trainLoadConpo();
		carLoadConpo();
		
		
		tabbedPane.repaint();
		panel.repaint();
		
	}
	public void planeLoadConpo(){
		panelWidth=tabbedPane.getWidth();
    	panelHeight=tabbedPane.getHeight();
		
		delButton=new JButton("ɾ��");
		saveButton=new JButton("����");
		timeLabel=new JLabel("װ������");
		
	
     	
     	setTime(tabbedPane,planeLoadInfo);
     	
     	delButton.setSize(75,35);//ɾ���뱣�水ť�ĳ�ʼ��
     	delButton.setLocation(panelWidth*13/20, panelHeight*72/85);
     	saveButton.setSize(75,35);
		saveButton.setLocation(panelWidth*13/20+100,panelHeight*72/85);
     	
		
		
		planeLoadInfo.add(timeLabel);
     	planeLoadInfo.add(delButton);
        planeLoadInfo.add(saveButton);
	}
	
	public void trainLoadConpo(){
		panelWidth=tabbedPane.getWidth();
    	panelHeight=tabbedPane.getHeight();
		
		delButton=new JButton("ɾ��");
		saveButton=new JButton("����");
		timeLabel=new JLabel("װ������");
		
	
     	setTime(tabbedPane ,trainLoadInfo);
     	delButton.setSize(75,35);//ɾ���뱣�水ť�ĳ�ʼ��
     	delButton.setLocation(panelWidth*13/20, panelHeight*72/85);
     	saveButton.setSize(75,35);
		saveButton.setLocation(panelWidth*13/20+100,panelHeight*72/85);
		
		
		trainLoadInfo.add(timeLabel);
     	trainLoadInfo.add(delButton);
        trainLoadInfo.add(saveButton);
	}
	
	public void carLoadConpo(){
		panelWidth=tabbedPane.getWidth();
    	panelHeight=tabbedPane.getHeight();
		
		delButton=new JButton("ɾ��");
		saveButton=new JButton("����");
		timeLabel=new JLabel("װ������");
		
     	
     	setTime(tabbedPane ,carLoadInfo);
     	delButton.setSize(75,35);//ɾ���뱣�水ť�ĳ�ʼ��
     	delButton.setLocation(panelWidth*13/20, panelHeight*72/85);
     	saveButton.setSize(75,35);
		saveButton.setLocation(panelWidth*13/20+100,panelHeight*72/85);
		
		
		carLoadInfo.add(timeLabel);
     	carLoadInfo.add(delButton);
        carLoadInfo.add(saveButton);
	}
	
	
	public void setTime(JTabbedPane panel,JPanel panel2){
		int panelWidth=panel.getWidth();
		int panelHeight=panel.getHeight();
		
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		timeLabel = new JLabel("װ������");
		yearLabel = new JLabel("��");
		monthLabel = new JLabel("��");
		dayLabel = new JLabel("��");
		ensureButton = new JButton("ȷ��");
		
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		timeLabel.setBounds(panelWidth/20, panelHeight/10, panelWidth/10, panelHeight/20);
		yearBox = new JComboBox<String>(yearString);
		yearBox.setBounds(timeLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		yearLabel.setBounds(yearBox.getX()+panelWidth/10+10, panelHeight/10, panelWidth/20, panelHeight/20);
		monthBox = new JComboBox<String>(monthString);
		monthBox.setBounds(yearLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		monthLabel.setBounds(monthBox.getX()+panelWidth/10+10, panelHeight/10, panelWidth/20, panelHeight/20);
		dayBox = new JComboBox<String>(dayString);
		dayBox.setBounds(monthLabel.getX()+panelWidth/10, panelHeight/10,  panelWidth/10, panelHeight/20);
		dayLabel.setBounds(dayBox.getX()+10+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		ensureButton.setBounds(dayLabel.getX()+panelWidth/10+10, panelHeight/10, panelWidth/10, panelHeight/20);
		
		panel2.add(ensureButton);
		panel2.add(timeLabel);
		panel2.add(yearLabel);
		panel2.add(monthLabel);
		panel2.add(dayLabel);
		panel2.add(yearBox);
		panel2.add(monthBox);
		panel2.add(dayBox);
	}
}

