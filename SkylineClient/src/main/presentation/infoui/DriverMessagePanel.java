package main.presentation.infoui;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class DriverMessagePanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	//��ť���
	private JButton cancleButton;
	private JButton saveButton;
	private JButton lookCancleButton;
	private JButton lookSaveButton;
	//lookPanel�ϵ����
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	//writePanel�ϵ����
	private JLabel driverCodeLabel;//˾�����
	private JLabel driverNameLabel;//˾������
	private JLabel driverSexLabel;//˾���Ա�
	private JLabel driverBirthLabel;//˾������
	private JLabel idCodeLabel;//����֤��
	private JLabel driverPhoneLabel;//˾���ֻ���
	private JLabel carUnitLabel;//������λ
	private JLabel licenseDataLabel;//��ʻ֤��ֹ����
	private JTextField driverCodeText;
	private JTextField driverNameText;
	private JCheckBox driverSex1;
	private JCheckBox driverSex2;
	private JTextField driverBirthText;
	private JTextField idCodeText;
	private JTextField driverPhoneText;
	private JTextField carUnitText;
	private JTextField licenseDataText;
	private ButtonGroup buttonGroup;
	
	private JLabel title;
	private JPanel lookPanel;//�鿴���յ�
	private JPanel writePanel;//��д���յ�
	private JTabbedPane tab;
	public DriverMessagePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();//��ʼ������
		lookPanel = new JPanel();
		lookPanel.setLayout(null);
		writePanel = new JPanel();
		writePanel.setLayout(null);
		initButton();//��ʼ����ť
		lookTabel();//��ʼ���鿴˾�����
		writeTabel();//��ʼ����д��Ϣ���
		tab = new JTabbedPane();
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.add("�鿴˾����Ϣ",lookPanel);
		tab.add("����˾����Ϣ",writePanel);
		panel.add(tab);
		tab.setBounds(panelWidth/10, panelHeight/10, panelWidth*4/5, panelHeight*4/5);
		tab.setVisible(true);
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("˾����Ϣ����");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	
	public void initButton(){
		cancleButton = new JButton("ȡ��");
		saveButton = new JButton("����");
		cancleButton.setBounds(panelWidth*2/5, panelHeight*13/20, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*6/10,  panelHeight*13/20, panelWidth/10, panelHeight/20);
		writePanel.add(cancleButton);
		writePanel.add(saveButton);
		lookCancleButton = new JButton("ȡ��");
		lookSaveButton = new JButton("����");
		lookCancleButton.setBounds(panelWidth*9/20, panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookSaveButton.setBounds(panelWidth*13/20,  panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookPanel.add(lookCancleButton);
		lookPanel.add(lookSaveButton);
	}
	
	public void lookTabel(){
		tableTitle = new String[]{"˾�����", "˾������", "˾���Ա�", "˾������", "����֤��", "��ϵ��ʽ", "������λ", "��ʻ֤��ֹ����"};
		tableData = new String[][]{{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"},
				{"02152", "����", "Ů", "2019/06/19", "0259584864", "05510161", "025", "2013/06/26"}
		};
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.getTableHeader().setResizingAllowed(false);//�����п����ɱ�
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//���ò��ɵ�����С
		for(int i = 0;i<8;i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(panelWidth/5);
		}
		
		table.getTableHeader().setPreferredSize(new Dimension(10000,panelWidth/20));
		scrollPane = new JScrollPane(table);
		if(tableData.length>9){
			scrollPane.setBounds(panelWidth/40, panelHeight/40, panelWidth*3/4, 10*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/40, panelHeight/40, panelWidth*3/4, (table.getRowCount()+1)*table.getRowHeight());
		}
		scrollPane.setVisible(true);
		lookPanel.add(scrollPane);
	}
	
	public void writeTabel(){
		driverCodeLabel = new JLabel("˾�����");//˾�����
		driverNameLabel = new JLabel("˾������");//˾������
		driverSexLabel = new JLabel("˾���Ա�");//˾���Ա�
		driverBirthLabel = new JLabel("˾������");//˾������
		idCodeLabel = new JLabel("����֤��");//����֤��
		driverPhoneLabel = new JLabel("��ϵ��ʽ");//˾���ֻ���
		carUnitLabel = new JLabel("������λ");//������λ
		licenseDataLabel = new JLabel("��ʻ֤��ֹ����");//��ʻ֤��ֹ����
		driverCodeText = new JTextField();
		driverNameText = new JTextField();
		driverSex1 = new JCheckBox("��");
		driverSex2 = new JCheckBox("Ů");
		driverBirthText = new JTextField();
		idCodeText = new JTextField();
		driverPhoneText = new JTextField();
		carUnitText = new JTextField();
		licenseDataText = new JTextField();
		buttonGroup = new ButtonGroup();
		buttonGroup.add(driverSex1);
		buttonGroup.add(driverSex2);
		
		writePanel.add(driverCodeLabel);
		writePanel.add(driverNameLabel);
		writePanel.add(driverSexLabel);
		writePanel.add(driverBirthLabel);
		writePanel.add(idCodeLabel);
		writePanel.add(driverPhoneLabel);
		writePanel.add(carUnitLabel);
		writePanel.add(licenseDataLabel);
		writePanel.add(driverCodeText);
		writePanel.add(driverNameText);
		writePanel.add(driverSex1);
		writePanel.add(driverSex2);
		writePanel.add(driverBirthText);
		writePanel.add(idCodeText);
		writePanel.add(driverPhoneText);
		writePanel.add(carUnitText);
		writePanel.add(licenseDataText);
		
		driverCodeLabel.setBounds(panelWidth/10, panelHeight/20, panelWidth*3/20, panelHeight/20);
		driverNameLabel.setBounds(panelWidth/10, panelHeight*3/40+driverCodeLabel.getY(), panelWidth*3/20, panelHeight/20);
		driverSexLabel.setBounds(panelWidth/10, panelHeight*3/40+driverNameLabel.getY(), panelWidth*3/20, panelHeight/20);
		driverBirthLabel.setBounds(panelWidth/10, panelHeight*3/40+driverSexLabel.getY(), panelWidth*3/20, panelHeight/20);
		idCodeLabel.setBounds(panelWidth/10, panelHeight*3/40+driverBirthLabel.getY(), panelWidth*3/20, panelHeight/20);
		driverPhoneLabel.setBounds(panelWidth/10, panelHeight*3/40+idCodeLabel.getY(), panelWidth*3/20, panelHeight/20);
		carUnitLabel.setBounds(panelWidth/10, panelHeight*3/40+driverPhoneLabel.getY(), panelWidth*3/20, panelHeight/20);
		licenseDataLabel.setBounds(panelWidth/10, panelHeight*3/40+carUnitLabel.getY(), panelWidth*3/20, panelHeight/20);
		
		driverCodeText.setBounds(panelWidth/4, panelHeight/20, panelWidth*9/20, panelHeight/20);
		driverNameText.setBounds(panelWidth/4, panelHeight*3/40+driverCodeText.getY(), panelWidth*9/20, panelHeight/20);
		
		driverSex1.setBounds(panelWidth/4+panelWidth/10, panelHeight*3/40+driverNameText.getY()-panelHeight/80, panelWidth*3/40, panelHeight*3/40);
		driverSex2.setBounds(panelWidth/4+panelWidth*13/40, panelHeight*3/40+driverNameText.getY()-panelHeight/80, panelWidth*3/40, panelHeight*3/40);
		
		driverBirthText.setBounds(panelWidth/4, panelHeight*3/40+driverSex1.getY()+panelHeight/80, panelWidth*9/20, panelHeight/20);
		idCodeText.setBounds(panelWidth/4, panelHeight*3/40+driverBirthText.getY(), panelWidth*9/20, panelHeight/20);
		driverPhoneText.setBounds(panelWidth/4, panelHeight*3/40+idCodeText.getY(), panelWidth*9/20, panelHeight/20);
		carUnitText.setBounds(panelWidth/4, panelHeight*3/40+driverPhoneText.getY(), panelWidth*9/20, panelHeight/20);
		licenseDataText.setBounds(panelWidth/4, panelHeight*3/40+carUnitText.getY(), panelWidth*9/20, panelHeight/20);
		
	}
}