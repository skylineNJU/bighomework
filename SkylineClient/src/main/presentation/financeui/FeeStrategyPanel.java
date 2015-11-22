package main.presentation.financeui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class FeeStrategyPanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JLabel title;
	private JLabel carLabel;
	private JLabel trainLabel;
	private JLabel planeLabel;
	private JLabel label1;//Ԫÿ����
	private JLabel label2;//Ԫÿ����
	private JLabel label3;//Ԫÿ����
	private JTextField carText;
	private JTextField trainText;
	private JTextField planeText;
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel cityDistance;
	private JButton saveButton;
	private JButton refleshButton;
	private JButton cancleButton;
	
	public FeeStrategyPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	public void init(){
		initTitle();
		initText();
		initTable();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("�ƶ��շѲ���");
		panel.add(title);
		title.setBounds(panelWidth*2/5, panelHeight/60, panelWidth/5, panelHeight/30);
	}
	public void initText(){
		carLabel = new JLabel("����:");
		trainLabel = new JLabel("��:");
		planeLabel = new JLabel("�ɻ�:");
		label1 = new JLabel("Ԫ/��ǧ��*���");
		label2 = new JLabel("Ԫ/��ǧ��*���");
		label3 = new JLabel("Ԫ/��ǧ��*���");
		carText = new JTextField();
		trainText = new JTextField();
		planeText = new JTextField();	
		
		panel.add(carLabel);
		panel.add(trainLabel);
		panel.add(planeLabel);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(carText);
		panel.add(trainText);
		panel.add(planeText);
		
		carLabel.setBounds(panelWidth/5, panelHeight/10, panelWidth/20, panelHeight/20);
		trainLabel.setBounds(panelWidth/5, panelHeight/10+carLabel.getY(),  panelWidth/20, panelHeight/20);
		planeLabel.setBounds(panelWidth/5, panelHeight/10+trainLabel.getY(),  panelWidth/20, panelHeight/20);
		carText.setBounds(panelWidth*3/10, carLabel.getY(), panelWidth/5, panelHeight/20);
		trainText.setBounds(panelWidth*3/10, panelHeight/10+carLabel.getY(), panelWidth/5, panelHeight/20);
		planeText.setBounds(panelWidth*3/10, panelHeight/10+trainLabel.getY(), panelWidth/5, panelHeight/20);
		label1.setBounds(panelWidth*11/20, carLabel.getY(), panelWidth*7/20, panelHeight/20);
		label2.setBounds(panelWidth*11/20, panelHeight/10+carLabel.getY(), panelWidth*7/20, panelHeight/20);
		label3.setBounds(panelWidth*11/20, panelHeight/10+trainLabel.getY(), panelWidth*7/20, panelHeight/20);
		
	}
	public void initTable(){
		tableTitle = new String[]{" ","����", "�Ͼ�", "�Ϻ�", "����"};
		tableData = new String[][]{{"����", "20", "100", "200", "300"},{"�Ͼ�", "100", "20", "50", "250"},
				{"�Ϻ�", "200", "50", "20", "300"},{"����", "300", "250", "300", "20"}};
		
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		cityDistance = new JLabel("���о���:");
		saveButton = new JButton("����");
		refleshButton = new JButton("ˢ��");
		cancleButton = new JButton("ȡ��");
		
		
		panel.add(scrollPane);
		panel.add(saveButton);
		panel.add(refleshButton);
		panel.add(cancleButton);
		panel.add(cityDistance);
		
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setRowHeight(panelWidth/20);//�����п�
		table.setDragEnabled(false);//���ò����϶�
		table.getTableHeader().setPreferredSize(new Dimension(10000, panelWidth/20));//���ñ�ͷ�߶�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		
		cityDistance.setBounds(panelWidth/10, panelHeight*23/60, panelWidth/4, panelHeight/20);
		scrollPane.setBounds(panelWidth/10, panelHeight*9/20, panelWidth*4/5, panelHeight*31/100);
		cancleButton.setBounds(panelWidth*2/5, panelHeight*17/20, panelWidth/10, panelHeight/20);
		refleshButton.setBounds(panelWidth*3/5, panelHeight*17/20, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*4/5, panelHeight*17/20, panelWidth/10, panelHeight/20);
	}
	

}