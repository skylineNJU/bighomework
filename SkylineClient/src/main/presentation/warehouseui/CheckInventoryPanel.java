package main.presentation.warehouseui;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.*;
import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;

//����̵�
public class CheckInventoryPanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JButton ok;
	private JButton export;
	private JLabel title;//����
	private JLabel ddl;
	private JTextField areanumber;
	private JScrollPane scrollPane;
	private JTable table;
	private String[] tableTitle;
	private String[][] tableData;
	
	public CheckInventoryPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		//title();
		area();
		initTable();
		panel.repaint();
	}
	private void area() {
		areanumber = new JTextField();
		areanumber.setBounds(panel.getWidth()/8, panel.getHeight()/11, panel.getWidth()/18, panel.getHeight()/20 );
		areanumber.setVisible(true);
		panel.add(areanumber);
		
		title = new JLabel("����: ");
		Font font = new Font("����", Font.PLAIN, 20);
		title.setFont(font);
		title.setBounds(panel.getWidth()/18, panel.getHeight()/11, panel.getWidth()/6, panel.getHeight()/20 );
		panel.add(title);
	}
	//��ʼ�����
	public void initTable(){
		tableTitle = new String[]{"��ⵥ��","�������","Ŀ�ĵ�","����","�ź�","�ܺ�","λ��"};
		tableData = new String[][]{{"112010000000","2015/01/01","�Ϻ�","A","1","1","1"},{"112010000001","2015/01/01","�Ͼ�","A","1","1","2"},
				{"112010000003","2015/01/01","�Ϻ�","A","1","1","1"},{"112010000004","2015/01/01","�Ͼ�","A","1","2","10"},
				{"112010000005","2015/01/01","�Ͼ�","B","3","21","1"},{"112010000006","2015/01/01","�Ͼ�","B","2","1","11"},
				{"112010000007","2015/01/01","����","C","5","1","1"},{"112010000008","2015/01/01","����","C","3","4","1"},
				{"112010000009","2015/01/01","����","D","1","1","3"},{"112010000010","2015/01/01","�Ͼ�","D","1","1","1"},
				{"112010000011","2015/01/01","�Ͼ�","D","1","1","3"},{"112010000012","2015/01/01","����","D","1","1","3"},
				{"112010000013","2015/01/01","�Ͼ�","D","1","1","3"},{"112010000014","2015/01/01","�Ͼ�","D","1","1","3"},
				{"112010000015","2015/01/01","�Ϻ�","D","1","1","3"},{"112010000016","2015/01/01","�Ͼ�","D","1","1","3"},
				{"112010000016","2015/01/01","�Ͼ�","D","1","1","3"},{"112010000017","2015/01/01","����","D","1","1","3"}};
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
		table.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/5);;
		table.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/6);;
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		scrollPane.setVisible(true);
		panel.add(scrollPane);
		
		
		ok=new JButton("ȷ��");
		ok.setBounds(panel.getWidth()*17/20,panel.getHeight()*7/8, panel.getWidth()/11, panel.getHeight()/15);
		ok.setVisible(true);
		panel.add(ok);
		
		export=new JButton("����");
		export.setBounds(panel.getWidth()*15/20,panel.getHeight()*7/8, panel.getWidth()/11, panel.getHeight()/15);
		export.setVisible(true);
		panel.add(export);
		
		String data="2015��09��11��";
		ddl= new JLabel("��һ��������: "+data);
		ddl.setBounds(panel.getWidth()/16,panel.getHeight()*7/8, panel.getWidth()*2/5, panel.getHeight()/15);
		ddl.setVisible(true);
		panel.add(ddl);
	}
/*//����
	public void title(){
		title = new JLabel("");
		title.setBounds(panelWidth/3, 20, panelWidth/6, 40);
		panel.add(title);
	}
	*/
	
	public void remove(){
		panel.remove(ddl);
		panel.remove(scrollPane);
		panel.remove(export);
		panel.remove(ok);
		panel.remove(title);
		panel.remove(areanumber);
	}	
}


