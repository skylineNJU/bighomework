package main.presentation.financeui;

import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import main.presentation.mainui.MainController;

public class StatisticsListPanel {
	
	private int year;//��ǰ���
	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	private JLabel title;//����
	private JLabel costTitle1;//�ɱ�����ı���
	private JLabel costTitle2;//�ɱ�����ı���
	private JLabel earnTitle1;//�������ı���
	private JLabel earnTitle2;//�������ı���
	private JLabel startTime;
	private JLabel endTime;
	private JLabel startYear;
	private JLabel startMonth;
	private JLabel startDay;
	private JLabel endYear;
	private JLabel endMonth;
	private JLabel endDay;
	private JComboBox<String> startYearBox;
	private JComboBox<String> startMonthBox;
	private JComboBox<String> startDayBox;
	private JComboBox<String> endYearBox;
	private JComboBox<String> endMonthBox;
	private JComboBox<String> endDayBox;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;
	private JTable costListTable;
	private JTable earnListTable;
	private JScrollPane costPane;
	private JScrollPane earnPane;
	private String[] costItem;//��ı���
	private String[] earnItem;//��ı���
	private String[][] costData;
	private String[][] earnData;
	private JButton ensureButton;//ȷ��ʱ��İ�ť
	
	public StatisticsListPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		initStartTime();
		initEndTime();
		ensureButton = new JButton("ȷ��");
		ensureButton.setBounds(endDayBox.getX()+panelWidth/5, panelHeight/8, panelWidth/10, panelHeight/20);
		panel.add(ensureButton);
		initCostTable();
		initEarnTable();
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("ͳ�Ʊ���");
		title.setBounds(panelWidth/3, 5, panelWidth/6, 30);
		panel.add(title);
	}
	//��ʼʱ��
	public void initStartTime(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		startTime = new JLabel("��ʼ����");
		startYear = new JLabel("��");
		startMonth = new JLabel("��");
		startDay = new JLabel("��");
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		startTime.setBounds(panelWidth/20, panelHeight/15, panelWidth/10, panelHeight/20);
		startYearBox = new JComboBox<String>(yearString);
		startYearBox.setBounds(startTime.getX()+panelWidth/10, panelHeight/15, panelWidth/10, panelHeight/20);
		startYear.setBounds(startYearBox.getX()+panelWidth/10+10, panelHeight/15, panelWidth/20, panelHeight/20);
		startMonthBox = new JComboBox<String>(monthString);
		startMonthBox.setBounds(startYear.getX()+panelWidth/10, panelHeight/15, panelWidth/10, panelHeight/20);
		startMonth.setBounds(startMonthBox.getX()+panelWidth/10+10, panelHeight/15, panelWidth/20, panelHeight/20);
		startDayBox = new JComboBox<String>(dayString);
		startDayBox.setBounds(startMonth.getX()+panelWidth/10, panelHeight/15,  panelWidth/10, panelHeight/20);
		startDay.setBounds(startDayBox.getX()+10+panelWidth/10, panelHeight/15, panelWidth/10, panelHeight/20);
		panel.add(startTime);
		panel.add(startYear);
		panel.add(startMonth);
		panel.add(startDay);
		panel.add(startYearBox);
		panel.add(startMonthBox);
		panel.add(startDayBox);
	}
	
	//����ʱ��
	public void initEndTime(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		endTime = new JLabel("��������");
		endYear = new JLabel("��");
		endMonth = new JLabel("��");
		endDay = new JLabel("��");
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		endTime.setBounds(panelWidth/20, panelHeight/8, panelWidth/10, panelHeight/20);
		endYearBox = new JComboBox<String>(yearString);
		endYearBox.setBounds(endTime.getX()+panelWidth/10, panelHeight/8, panelWidth/10, panelHeight/20);
		endYear.setBounds(endYearBox.getX()+panelWidth/10+10, panelHeight/8, panelWidth/20, panelHeight/20);
		endMonthBox = new JComboBox<String>(monthString);
		endMonthBox.setBounds(endYear.getX()+panelWidth/10, panelHeight/8, panelWidth/10, panelHeight/20);
		endMonth.setBounds(endMonthBox.getX()+panelWidth/10+10, panelHeight/8, panelWidth/20, panelHeight/20);
		endDayBox = new JComboBox<String>(dayString);
		endDayBox.setBounds(endMonth.getX()+panelWidth/10, panelHeight/8,  panelWidth/10, panelHeight/20);
		endDay.setBounds(endDayBox.getX()+10+panelWidth/10, panelHeight/8, panelWidth/10, panelHeight/20);
		panel.add(endTime);
		panel.add(endYear);
		panel.add(endMonth);
		panel.add(endDay);
		panel.add(endYearBox);
		panel.add(endMonthBox);
		panel.add(endDayBox);
	}
	
	//�ɱ��б�
	public void initCostTable(){
		costTitle1 = new JLabel("��");
		costTitle1.setBounds(endTime.getX(), endTime.getY()+panelHeight/10, panelWidth/40, panelHeight/20);
		costTitle2 = new JLabel("��");
		costTitle2.setBounds(endTime.getX(), endTime.getY()+panelHeight/10+panelHeight/10, panelWidth/40, panelHeight/20);
		costItem = new String[]{"ID", "����", "���", "�˻�", "����", "��ע"};
		costData = new String[][]{{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "2013167", "��ݷ�", "׷��׿Խ"}};
		costListTable = new JTable(costData,costItem);
		costListTable.setEnabled(false);//���ò��ɱ༭����
		costListTable .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		costListTable.setRowHeight(panelWidth/25);//�����п�
		costListTable.getTableHeader().setPreferredSize(new Dimension(10000, panelWidth/25));//���ñ�ͷ�߶�
		costListTable.setDragEnabled(false);//�����϶�
		costListTable.getTableHeader().setResizingAllowed(false);//�п����ԸĶ�
		costPane = new JScrollPane(costListTable);
		if(costData.length<=6){
			costPane.setBounds(endTime.getX()+panelWidth/30, endTime.getY()+panelHeight/10,
					panelWidth - endTime.getX()*2-panelWidth/15, (costListTable.getRowCount()+1)*costListTable.getRowHeight());
		}else{
			costPane.setBounds(endTime.getX()+panelWidth/30, endTime.getY()+panelHeight/10, 
					panelWidth - endTime.getX()*2-panelWidth/15, 7*costListTable.getRowHeight());
		}
		
		panel.add(costTitle1);
		panel.add(costTitle2);
		panel.add(costPane);
	}
	
	//�����б�
	public void initEarnTable(){
		earnTitle1 = new JLabel("��");
		earnTitle1.setBounds(endTime.getX(), panelHeight*3/5, panelWidth/40, panelHeight/20);
		earnTitle2 = new JLabel("��");
		earnTitle2.setBounds(endTime.getX(), panelHeight*3/5+panelHeight/10, panelWidth/40, panelHeight/20);
		earnItem = new String[]{"ID", "����", "���", "��ע"};
		earnData = new String[][]{{"����", "1ëǮ", "2015", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "׷��׿Խ"},
				{"����", "1ëǮ", "2015", "׷��׿Խ"}};
		earnListTable = new JTable(earnData,earnItem);
		earnListTable.setEnabled(false);//���ò��ɱ༭����
		earnListTable .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		earnListTable.setRowHeight(panelWidth/25);//�����п�
		earnListTable.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/25));//���ñ�ͷ�߶�
		earnListTable.setDragEnabled(false);//�����϶�
		earnListTable.getTableHeader().setResizingAllowed(false);//�п��ɸĶ�
		earnPane = new JScrollPane(earnListTable);
		if(earnData.length<=6){
			earnPane.setBounds(endTime.getX()+panelWidth/30, panelHeight*3/5,
					panelWidth - endTime.getX()*2-panelWidth/15, (costListTable.getRowCount()+1)*costListTable.getRowHeight());
		}else{
			earnPane.setBounds(endTime.getX()+panelWidth/30, panelHeight*3/5, 
					panelWidth - endTime.getX()*2-panelWidth/15, 7*costListTable.getRowHeight());
		}
		panel.add(earnTitle1);
		panel.add(earnTitle2);
		panel.add(earnPane);
	}
}
