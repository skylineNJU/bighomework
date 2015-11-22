package main.presentation.distributeui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.presentation.mainui.MainController;

public class DistributePanel {

	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JLabel title;//����
	private JScrollPane scrollPane;
	private JTable table;
	private String[] tableTitle;
	private String[][] tableData;
	
	public DistributePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		initTable();
		panel.repaint();
	}
	//��ʼ������
	public void initTable(){
		tableTitle = new String[]{"����","���͵�ַ","�ռ���","�ֻ���"};
		tableData = new String[][]{{"2015/02/26","�Ͼ���ѧ","����", "132626165"},{"2015/02/26","�Ͼ���ѧ","����", "132626165"},
				{"2015/02/26","�Ͼ���ѧ","����", "132626165"},{"2015/02/26","�Ͼ���ѧ","����", "132626165"},
				{"2015/02/26","�Ͼ���ѧ","����", "132626165"},{"2015/02/26","�Ͼ���ѧ","����", "132626165"},
				{"2015/02/26","�Ͼ���ѧ","����", "132626165"},{"2015/02/26","�Ͼ���ѧ","����", "132626165"},
				{"2015/02/26","�Ͼ���ѧ","����", "132626165"},{"2015/02/26","�Ͼ���ѧ","����", "132626165"},
				{"2015/02/26","�Ͼ���ѧ","����", "132626165"},{"2015/02/26","�Ͼ���ѧ","����", "132626165"},
				{"2015/02/26","�Ͼ���ѧ","����", "132626165"},{"2015/02/26","�Ͼ���ѧ","����", "132626165"},
				{"2015/02/26","�Ͼ���ѧ","����", "132626165"},{"2015/02/26","�Ͼ���ѧ","����", "132626165"},
				{"2015/02/26","�Ͼ���ѧ","����", "132626165"},{"2015/02/26","�Ͼ���ѧ","����", "132626165"}};
		table = new JTable(tableData,tableTitle);
		table.setEnabled(false);//���ò��ɱ༭����
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		if(tableData.length>=10){
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, 11*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, (table.getRowCount()+1)*table.getRowHeight());
		}
		table.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/3);;
		table.getTableHeader().setResizingAllowed(false);//�����п����ɱ�
		scrollPane.setVisible(true);
		panel.add(scrollPane);
	}
	//����
	public void title(){
		title = new JLabel("�鿴����������");
		title.setBounds(panelWidth/3, 20, panelWidth/6, 40);
		panel.add(title);
	}
}