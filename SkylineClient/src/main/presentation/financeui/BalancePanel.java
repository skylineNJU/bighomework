package main.presentation.financeui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.presentation.mainui.MainController;

public class BalancePanel {
	
	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	private JLabel title;
	private JScrollPane scrollPane;
	private JTable table;
	//�����˻�����Ϣ,��Ҫ�����ݿ��ж�ȡ
	private String[][] bankAccountMessage;
	//�б��еı���
	private String[] tableTitle;
	
	public BalancePanel(){
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
	
	public void initTable(){
		tableTitle = new String[]{"�����˻�","���"};
		bankAccountMessage = new String[][]{{"���˷�������˻�","3"},{"��С��������˻�","60000000"},
				{"��С��������˻�","30000000"},{"���ʵ������˻�","9000000000"}
		};
		table = new JTable(bankAccountMessage,tableTitle);
		table.setEnabled(false);//���ò��ɱ༭����
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		if(bankAccountMessage.length>4){
			scrollPane.setBounds(panelWidth/6, panelHeight/3, panelWidth*2/3, 5*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/6, panelHeight/3, panelWidth*2/3, (table.getRowCount()+1)*table.getRowHeight());
		}
		scrollPane.setVisible(true);
		panel.add(scrollPane);
	}
	
	public void title(){
		title = new JLabel("�����˻�");
		title.setBounds(panelWidth/3, 20, panelWidth/6, 40);
		panel.add(title);
	}

}
