package main.presentation.rightui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class RightAdminPanel {
	private JPanel panel;
	private JLabel title;
	private int panelWidth;
	private int panelHeight;
	private JTable table;
	private JScrollPane scrollPane;
	private String[] tableTitle;
	private String[][] tableData;
	private JLabel inquireLabel;
	private JTextField inquireText;
	private JButton inquireButton;
	private JButton ensureButton;
	private JButton cancleButton;
	private JButton newButton;
	//�½��˻���Ϣ
	private JLabel name;

	
	public RightAdminPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		initTitle();
		initTable();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("Ȩ�޹���");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	public void initTable(){
		tableTitle = new String[]{"�˺�", "����", "���"};
		tableData = new String[][]{{"260", "����", "���Ա"},{"260", "����", "���Ա"},{"260", "����", "���Ա"},{"260", "����", "���Ա"},
				{"260", "����", "���Ա"},{"260", "����", "���Ա"},{"260", "����", "���Ա"},{"260", "����", "���Ա"},
				{"260", "����", "���Ա"},{"260", "����", "���Ա"},{"260", "����", "���Ա"},{"260", "����", "���Ա"},
				{"260", "����", "���Ա"},{"260", "����", "���Ա"},{"260", "����", "���Ա"},{"260", "����", "���Ա"}};
		
		inquireLabel = new JLabel("�������˻�");
		inquireText = new JTextField();
		inquireButton = new JButton("ȷ��");
		ensureButton = new JButton("�޸�");
		cancleButton = new JButton("ȡ��");
		newButton=new JButton("�½�");
		
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setRowHeight(panelWidth/20);//�����п�
		table.setDragEnabled(false);//���ò����϶�
		table.getTableHeader().setPreferredSize(new Dimension(100, panelWidth/20));//���ñ�ͷ�߶�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/10, panelHeight/5, panelWidth*4/5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/10, panelHeight/5, panelWidth*4/5, 10*table.getRowHeight());
		}		
		panel.add(scrollPane);
		panel.add(inquireLabel);
		panel.add(inquireText);
		panel.add(inquireButton);
		panel.add(ensureButton);
		panel.add(cancleButton);
		panel.add(newButton);
		
		inquireLabel.setBounds(panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		inquireText.setBounds(panelWidth/4, panelHeight/10, panelWidth*9/20, panelHeight/20);
		inquireButton.setBounds(panelWidth*4/5, panelHeight/10, panelWidth/10, panelHeight/20);
		ensureButton.setBounds(panelWidth*4/5, 12*table.getRowHeight()+panelHeight/8+table.getY(), panelWidth/10, panelHeight/20);
		cancleButton.setBounds(panelWidth*3/5, 12*table.getRowHeight()+panelHeight/8+table.getY(), panelWidth/10, panelHeight/20);
		newButton.setBounds(panelWidth*2/5,12*table.getRowHeight()+panelHeight/8+table.getY() , panelWidth/10, panelHeight/20);
	}
	
	
	public void remove(){
		panel.remove(title);
		panel.remove(scrollPane);
		panel.remove(inquireLabel);
		panel.remove(inquireText);
		panel.remove(inquireButton);
		panel.remove(ensureButton);
		panel.remove(cancleButton);
	}
	
	
}
