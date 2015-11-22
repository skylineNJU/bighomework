package main.presentation.infoui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class VehicleMessagePanel {
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
	private JLabel vehicleCode;//������
	private JLabel engineCode;//��������
	private JLabel chassisCode;//���̺�
	private JLabel buyTime;//����ʱ��
	private JLabel serviceTime;//����ʱ��
	private JTextField vehicleCodeText;
	private JTextField engineCodeText;
	private JTextField chassisCodeText;
	private JTextField buyTimeText;
	private JTextField serviceTimeText;
	
	private JLabel title;
	private JPanel lookPanel;//�鿴���յ�
	private JPanel writePanel;//��д���յ�
	private JTabbedPane tab;
	public VehicleMessagePanel(){
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
		tab.add("�鿴������Ϣ",lookPanel);
		tab.add("����������Ϣ",writePanel);
		panel.add(tab);
		tab.setBounds(panelWidth/10, panelHeight/10, panelWidth*4/5, panelHeight*4/5);
		tab.setVisible(true);
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("������Ϣ����");
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
		tableTitle = new String[]{"��������", "��������", "���̺�", "����ʱ��", "����ʱ��"};
		tableData = new String[][]{{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"},
				{"20126", "0625", "290", "2013/06/15", "2013/07/02"},{"20126", "0625", "290", "2013/06/15", "2013/07/02"}
		};
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		table.getTableHeader().setPreferredSize(new Dimension(1000,panelWidth/20));
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
		vehicleCode = new JLabel("������");//������
		engineCode = new JLabel("��������");//��������
		chassisCode = new JLabel("���̺�");//���̺�
		buyTime = new JLabel("����ʱ��");//����ʱ��
		serviceTime = new JLabel("����ʱ��");//����ʱ��
		vehicleCodeText = new JTextField();
		engineCodeText = new JTextField();
		chassisCodeText = new JTextField();
		buyTimeText = new JTextField();
		serviceTimeText = new JTextField();
		
		writePanel.add(vehicleCode);
		writePanel.add(engineCode);
		writePanel.add(chassisCode);
		writePanel.add(buyTime);
		writePanel.add(serviceTime);
		writePanel.add(vehicleCodeText);
		writePanel.add(engineCodeText);
		writePanel.add(chassisCodeText);
		writePanel.add(buyTimeText);
		writePanel.add(serviceTimeText);
		
		vehicleCode.setBounds(panelWidth/20, panelHeight/20, panelWidth/10, panelHeight/15);
		engineCode.setBounds(panelWidth/20, panelHeight/8+vehicleCode.getY(), panelWidth/10, panelHeight/15);
		chassisCode.setBounds(panelWidth/20, panelHeight/8+engineCode.getY(), panelWidth/10, panelHeight/15);
		buyTime.setBounds(panelWidth/20, panelHeight/8+chassisCode.getY(), panelWidth/10, panelHeight/15);
		serviceTime.setBounds(panelWidth/20, panelHeight/8+buyTime.getY(), panelWidth/10, panelHeight/15);
		vehicleCodeText.setBounds(panelWidth/5, panelHeight/20, panelWidth/2, panelHeight/15);
		engineCodeText.setBounds(panelWidth/5, panelHeight/8+vehicleCode.getY(), panelWidth/2, panelHeight/15);
		chassisCodeText.setBounds(panelWidth/5, panelHeight/8+engineCode.getY(), panelWidth/2, panelHeight/15);
		buyTimeText.setBounds(panelWidth/5, panelHeight/8+chassisCode.getY(), panelWidth/2, panelHeight/15);
		serviceTimeText.setBounds(panelWidth/5, panelHeight/8+buyTime.getY(), panelWidth/2, panelHeight/15);
	}

}
