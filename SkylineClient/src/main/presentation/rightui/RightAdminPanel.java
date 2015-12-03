package main.presentation.rightui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.businesslogicservice.InfoBLService;
import main.businesslogicservice.RightBLService;
import main.constructfactory.ConstructFactory;
import main.po.Rights;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.vo.AccountVO;
import main.vo.DriverVO;

public class RightAdminPanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	//��ť���
	private JButton cancelButton;
	private JButton saveButton;
	private JButton lookCancleButton;
	private JButton lookSaveButton;
	//lookPanel�ϵ����
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	//writePanel�ϵ����
	private JLabel nameLabel;//������ǩ
	private JLabel accountLabel;//�˺ű�ǩ
	private JLabel identityLabel;//��ݱ�ǩ
	private JLabel institutionLabel;//������ǩ
	
	private JTextField nameText;
	private JTextField accountText;
	private JComboBox<String> identity;
	private JTextField institutionText;
	
	
	private JLabel title;
	private JPanel lookPanel;//�鿴Ȩ�޹���
	private JPanel writePanel;//��дȨ�޹���
	private JTabbedPane tab;

	
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
				if(tab.getSelectedIndex()==0){
					tableData =initTableData();
					for(int x=0;x<20;x++){
						for(int y=0;y<8;y++)
						table.setValueAt(tableData[x][y],x,y);
					}
				}
			}
			
		});
		panel.repaint();
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
				nameText.setText(null);
				accountText.setText(null);
				identity.setSelectedIndex(0);
				institutionText.setText(null);
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
				Rights staffIdentity=null;
				switch(identity.getSelectedIndex()){
				case 0:
					staffIdentity=Rights.COURIER;
					break;
				case 1:
					staffIdentity=Rights.LOBBY;
					break;
				case 2:
					staffIdentity=Rights.INTERMEDIATE;
					break;
				case 3:
					staffIdentity=Rights.MANAGER;
					break;
				case 4:
					staffIdentity=Rights.STOREHOUSE;
					break;
				case 5:
					staffIdentity=Rights.FINANCE;
					break;					
				case 6:
					staffIdentity=Rights.ACCOUNT;
					break;
				default:
					break;
				}
				
				AccountVO accountInfo=new AccountVO(staffIdentity
												,nameText.getText()
												,accountText.getText()
												,((WritePanel) panel).getBelong());
				RightBLService service=ConstructFactory.RightFactory();
				service.createNewAccount(accountInfo);
			}
		});
		lookCancleButton = new JButton("ȡ��");
		lookSaveButton = new JButton("����");
		lookCancleButton.setBounds(panelWidth*9/20, panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookSaveButton.setBounds(panelWidth*13/20,  panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookPanel.add(lookCancleButton);
		lookPanel.add(lookSaveButton);
		
	}
	
	public void lookTabel(){
		tableTitle = new String[]{"�˺�", "����", "���", "����"};
		tableData = this.initTableData();
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
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
	
	public String[][] initTableData(){
		String[][] content =new String[20][8];
		for(int x=0;x<20;x++)
			for(int y=0;y<8;y++)
				content[x][y]=null;
	
		ArrayList<AccountVO> volist=null;
		RightBLService service=ConstructFactory.RightFactory();
		volist=service.inquireAccount(((WritePanel)panel).getBelong());
		if(volist!=null){
		int counter=0;
		for(AccountVO vo:volist){
			content[counter][0]=vo.getCode();
			content[counter][1]=vo.getAccountName();
			content[counter][2]=vo.getRight().toString();
			content[counter][3]=vo.getBelong();
		
			counter++;
		}
		}
		return content;
	}
	
	public void writeTabel(){
		nameLabel = new JLabel("����");
		accountLabel= new JLabel("�˺�");
		identityLabel = new JLabel("���");
		institutionLabel = new JLabel("����");
		
		nameText = new JTextField();
		accountText = new JTextField();
		
		institutionText = new JTextField();
		
		
		writePanel.add(nameLabel);
		writePanel.add(accountLabel);
		writePanel.add(identityLabel);
		writePanel.add(institutionLabel);
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
