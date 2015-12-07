package main.presentation.rightui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.RightBLService;
import main.constructfactory.ConstructFactory;
import main.po.Rights;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.vo.AccountVO;

public class RightAdminPanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	//��ť���
	private JButton cancelButton;
	private JButton saveButton;
	private JButton lookDeleteButton;
	private JButton lookModifyButton;
	//lookPanel�ϵ����
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private String[] identityString;
	DefaultTableModel model ;
	//writePanel�ϵ����
	private JLabel accountLabel;//�˺ű�ǩ
	private JLabel codeLabel;//�����ǩ
	private JLabel identityLabel;//��ݱ�ǩ
	//private JLabel institutionLabel;//������ǩ
	
	private JTextField accountText;
	private JTextField codeText;
	private JComboBox<String> identity;
	//private JTextField institutionText;
	private boolean[] selectRow;
	
	private JLabel title;
	private JPanel lookPanel;//�鿴Ȩ�޹���
	private JPanel writePanel;//��дȨ�޹���
	private JTabbedPane tab;
	private Rights[] right={Rights.COURIER,
										Rights.LOBBY,
										Rights.INTERMEDIATE,
										Rights.MANAGER,
										Rights.STOREHOUSE,
										Rights.FINANCE,
										Rights.ACCOUNT};
	
	public RightAdminPanel(){
		panel=MainController.getWritepanel();
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

		lookTabel();//��ʼ���鿴Ȩ�޹������
		writeTabel();//��ʼ����дȨ�޹������
		initButton();//��ʼ����ť
		tab = new JTabbedPane();
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.add("�鿴�˺�",lookPanel);
		tab.add("�����˺�",writePanel);
		panel.add(tab);	
		tab.setBounds(panelWidth/10, panelHeight/10, panelWidth*4/5, panelHeight*4/5);
		tab.setVisible(true);
		tab.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				switch(tab.getSelectedIndex()){
				case 0:
					refresh();
				}
				
			}
			
		});
		panel.repaint();
	}
	public void refresh(){
		tableData=this.initTableData();
		while(table.getRowCount()<tableData.length){
		((DefaultTableModel)table.getModel()).addRow(new String[4]);
		}
		for(int x=0;x<tableData.length;x++){
			for(int y=0;y<4;y++){
				table.setValueAt(tableData[x][y],x,y);
			}
		}
	}
	
	public void title(){
		title = new JLabel("Ȩ�޹���");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	
	public void initButton(){
		cancelButton = new JButton("ȡ��");
		saveButton = new JButton("����");
		cancelButton.setBounds(panelWidth*2/5, panelHeight*13/20, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*6/10,  panelHeight*13/20, panelWidth/10, panelHeight/20);
		writePanel.add(cancelButton);
		writePanel.add(saveButton);
		cancelButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				accountText.setText(null);
				codeText.setText(null);
				identity.setSelectedIndex(0);
				//institutionText.setText(null);
			}
		});
		//0 ���Ա
		//1 Ӫҵ��ҵ��Ա
		//2 ��ת����ҵ��Ա
		//3 �ܾ���
		//4 �ֿ������Ա
		//5 ������Ա
		//6 ������Ա
		saveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Rights staffIdentity=right[identity.getSelectedIndex()];
				
				AccountVO accountInfo=new AccountVO(staffIdentity
												,accountText.getText()
												,codeText.getText()
												,((WritePanel) panel).getBelong());
				RightBLService service=ConstructFactory.RightFactory();
				service.createNewAccount(accountInfo);
			}
		});
		lookDeleteButton = new JButton("ɾ��");
		lookModifyButton = new JButton("�޸�");
		lookDeleteButton.setBounds(panelWidth*9/20, panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookModifyButton.setBounds(panelWidth*13/20,  panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookPanel.add(lookDeleteButton);
		lookPanel.add(lookModifyButton);
		
		lookModifyButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				for(int x=0;x<selectRow.length;x++){
		//"�˺�"�����롱��Ȩ�ޡ���������
					if(selectRow[x]){
						RightBLService service=ConstructFactory.RightFactory();
						AccountVO vo=new AccountVO(Rights.valueOf((String)table.getValueAt(x,2)),
								(String)table.getValueAt(x,0),
								(String)table.getValueAt(x,1),
								(String) table.getValueAt(x,3)
								);
						System.out.println(vo.getCode());
						RightBLService service1=ConstructFactory.RightFactory();
						service1.modifyAccount(vo);
					}
				}
				refresh();
			}
		});
		lookDeleteButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				for(int x=0;x<selectRow.length;x++){
					if(selectRow[x]){
						RightBLService service=ConstructFactory.RightFactory();
						service.deleteAccount((String) table.getValueAt(x,0));
					}
				}
				
				refresh();
			}
		});
	}
	
	
	public void lookTabel(){
		tableTitle = new String[]{"�˺�", "����", "���", "����","ѡ��"};
		tableData = this.initTableData();
		MyTableModel model=new MyTableModel();
		model.setColumnCount(5);
		model.setColumnIdentifiers(tableTitle);
		for(int x=0;x<tableData.length;x++){
			model.addRow(tableData[x]);
		}
		table = new JTable(model);

		table.setEditingColumn(1);
		table.setEditingColumn(3);
		
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//���ò��ɵ�����С
		for(int i = 0;i<4;i++){
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
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int x=table.getSelectedRow();
				if(!selectRow[x]){
					selectRow[x]=true;
					table.setValueAt("��ѡ",x,4);
				}else{
					selectRow[x]=false;
					table.setValueAt("",x,4);
				}
			}
		});
		
	}
	
	public String[][] initTableData(){
//		for(int x=0;x<table.getRowCount();x++)
//			for(int y=0;y<table.getColumnCount();y++)
//				content[x][y]=null;
		
		ArrayList<AccountVO> volist=null;
		RightBLService service=ConstructFactory.RightFactory();
		volist=service.inquireAccount();
		String[][] content =new String[volist.size()][5];
		for(int x=0;x<volist.size();x++)
			for(int y=0;y<5;y++)
				content[x][y]=null;
		
		if(volist!=null){
		int counter=0;
		
		for(AccountVO vo:volist){
			content[counter][0]=vo.getAccountName();
			content[counter][1]=vo.getCode();
			content[counter][2]=vo.getRight().name();
			content[counter][3]=vo.getBelong();
			content[counter][4]="";
			counter++;
		}
		
		}
		selectRow=new boolean[content.length];
		for(int x=0;x<content.length;x++){
			selectRow[x]=false;
		}
		return content;
	}
	
	public void writeTabel(){
		accountLabel = new JLabel("�˺�");
		codeLabel= new JLabel("����");
		identityLabel = new JLabel("���");
		//institutionLabel = new JLabel("����");
		
		accountText = new JTextField();
		codeText = new JTextField();
		identityString = new String[]{"���Ա","Ӫҵ��ҵ��Ա","��ת����ҵ��Ա","�ܾ���","�ֿ������Ա","������Ա","����Ա"};
		//institutionText = new JTextField();
		identity = new JComboBox<String>(identityString);
		
		
		
		accountLabel.setBounds(panelWidth/10, panelHeight/20, panelWidth*3/20, panelHeight/20);
		codeLabel.setBounds(panelWidth/10, panelHeight*3/40+accountLabel.getY(), panelWidth*3/20, panelHeight/20);
		identityLabel.setBounds(panelWidth/10, panelHeight*3/40+codeLabel.getY(), panelWidth*3/20, panelHeight/20);
		//institutionLabel.setBounds(panelWidth/10, panelHeight*3/40+identityLabel.getY(), panelWidth*3/20, panelHeight/20);
		
		
		accountText.setBounds(panelWidth/4, panelHeight/20, panelWidth*9/20, panelHeight/20);
		codeText.setBounds(panelWidth/4, panelHeight*3/40+accountText.getY(), panelWidth*9/20, panelHeight/20);
		identity.setBounds(panelWidth/4+panelWidth/10, panelHeight*3/40+codeText.getY()-panelHeight/80, panelWidth*3/40, panelHeight*3/40);
		
		//institutionText.setBounds(panelWidth/4, panelHeight*3/40+identity.getY()+panelHeight/80, panelWidth*9/20, panelHeight/20);
		writePanel.add(accountLabel);
		writePanel.add(codeLabel);
		writePanel.add(identityLabel);
		//writePanel.add(institutionLabel);
		writePanel.add(accountText);
		writePanel.add(codeText);
		writePanel.add(identity);
		//writePanel.add(institutionText);
		
		
	}
	
	class MyTableModel extends DefaultTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			if(column%2==0){
				return false;
			}
			return true;
		}
    }
}
