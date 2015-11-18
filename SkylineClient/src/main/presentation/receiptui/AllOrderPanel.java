package main.presentation.receiptui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.presentation.mainui.MainController;

public class AllOrderPanel {
	
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JTable table;
	private JLabel title;
	private JScrollPane scrollPane;
	private String[] tableTitle;
	private String[][] tableData;
	
	
	public AllOrderPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		initTable();
		title();
		panel.repaint();
	}
	public void title(){
		title = new JLabel("�鿴ȫ������");
		title.setBounds(panelWidth/3, 20, panelWidth/6, 40);
		panel.add(title);
	}
	public void initTable(){
		tableTitle = new String[]{"������","�ļ�������","�ļ���סַ","�ļ��˵�λ","�ļ��˵绰",
				"�ռ�������","�ռ���סַ","�ռ��˵�λ","�ռ��˵绰", "�ļ���Ŀ","�ļ�����","�ļ����"};
		tableData = new String[][]{{"2015", "����", "�ϴ�", "�Ͼ� ��ѧ", "20151561",
				"������", "�Ͼ�Сѧ", "�Ͼ�Сѧ", "206156", "20", "205","50"},
				{"2015", "����", "�ϴ�", "�Ͼ� ��ѧ", "20151561",
					"������", "�Ͼ�Сѧ", "�Ͼ�Сѧ", "206156", "20", "205","50"},
					{"2015", "����", "�ϴ�", "�Ͼ� ��ѧ", "20151561",
						"������", "�Ͼ�Сѧ", "�Ͼ�Сѧ", "206156", "20", "205","50"},
						{"2015", "����", "�ϴ�", "�Ͼ� ��ѧ", "20151561",
							"������", "�Ͼ�Сѧ", "�Ͼ�Сѧ", "206156", "20", "205","50"}};
		table = new JTable(tableData,tableTitle);
		table.setEnabled(false);//���ò��ɱ༭����
		table.setRowHeight(panelWidth/20);//�����п�
		//table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
    	table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		table.getTableHeader().setPreferredSize(new Dimension(1000,panelWidth/20));
		table.setVisible(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane = new JScrollPane(table);
		table.setBounds(panelWidth/20, panelHeight/6, panelWidth*2, tableData.length*table.getRowHeight());
		if(tableData.length>=10){
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, 11*table.getRowHeight());		
		}else{
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, (table.getRowCount()+1)*table.getRowHeight());
		}
		panel.add(scrollPane);
	}
}
