package main.presentation.infoui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.InfoBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.StaffVO;

//��Ա����
public class ManagerStaffPanel {
	
	private JPanel panel;
	private int tabWidth;
	private int tabHeight;
	private JTabbedPane tab;
	private JPanel addPanel;
	//private JPanel inquirePanel;
	private JLabel title;
	
	//����Ա�������
	private JLabel position;//ְλ
	private JLabel staffCode;//���
	private JLabel company;//��λ
	private JLabel name;//Ա������
	private JLabel startWorkTime;//��ְʱ��
	private JTextField positionText;//ְλ
	private JTextField staffCodeText;//���
	private JTextField companyText;//��λ
	private JTextField nameText;//Ա������
	private JTextField startWorkTimeText;//��ְʱ��
	private JButton saveButton;
	private JButton cancleButton;
	
	//�µĲ�ѯԱ������
	private ArrayList<String> delStaffCode = new ArrayList<String>();
	private ArrayList<StaffVO> voList = new ArrayList<StaffVO>();
	private JPanel inquirePane;
	private JTable table;
	private JScrollPane scroll;
	private String[] tableTitle;
	private String[][] tableData;
	private JButton ensureButton;
	private JComboBox<String> unitBox;
	private JLabel unitLable;
	private JButton delButton;
	private JButton sButton;

	public ManagerStaffPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	}
	public void init(){
		initTitle();
		tab = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tab);
		tab.setBounds(panel.getWidth()/10, panel.getHeight()/15, panel.getWidth()*4/5, panel.getHeight()*13/15);
		tabWidth = tab.getWidth();
		tabHeight = tab.getHeight();
		addPanel = new JPanel();
		inquirePane = new JPanel();
		addPanel.setLayout(null);
		inquirePane.setLayout(null);
		tab.addTab("����Ա��", addPanel);
		tab.addTab("��ѯԱ��",inquirePane);
		initAddPanel();
		initTable();
		initButton();
		panel.repaint();
	}
	
	public void initTitle(){
		title = new JLabel("��Ա����");
		panel.add(title);
		title.setBounds(panel.getWidth()*2/5, panel.getHeight()/60, panel.getWidth()/5, panel.getHeight()/30);
	}
	public void initAddPanel(){
		position = new JLabel("ְλ");//ְλ
		staffCode = new JLabel("���");//���
		company = new JLabel("��λ");//��λ
		name = new JLabel("Ա������");//Ա������
		startWorkTime = new JLabel("��ְʱ��");//��ְʱ��
		positionText = new JTextField();//ְλ
		staffCodeText = new JTextField();//���
		companyText = new JTextField();//��λ
		nameText = new JTextField();//Ա������
		startWorkTimeText = new JTextField();//��ְʱ��
		saveButton = new JButton("����");
		cancleButton = new JButton("ȡ��");
		
		addPanel.add(position);//ְλ
		addPanel.add(staffCode);//���
		addPanel.add(company);//��λ
		addPanel.add(name);//Ա������
		addPanel.add(startWorkTime);//��ְʱ��
		addPanel.add(positionText);//ְλ
		addPanel.add(staffCodeText);//���
		addPanel.add(companyText);//��λ
		addPanel.add(nameText);//Ա������
		addPanel.add(startWorkTimeText);//��ְʱ��
		addPanel.add(saveButton);
		addPanel.add(cancleButton);
		
		saveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				InfoBLService service=ConstructFactory.InfoFactory();
				StaffVO staffInfo=new StaffVO(nameText.getText(),
											  positionText.getText(),
											  companyText.getText(),
											  startWorkTimeText.getText(),
											  staffCodeText.getText());
				service.createNewStaff(staffInfo);
			}
		});
		final int INTER = tabHeight*3/35;
		
		position.setBounds(tabWidth/10, INTER, tabWidth/10, tabHeight/15);//ְλ
		staffCode.setBounds(position.getX(), INTER+position.getY()+position.getHeight(), tabWidth/10, tabHeight/15);//���
		company.setBounds(position.getX(), INTER+staffCode.getY()+staffCode.getHeight(), tabWidth/10, tabHeight/15);//��λ
		name.setBounds(position.getX(), INTER+company.getY()+company.getHeight(), tabWidth/10, tabHeight/15);//Ա������
		startWorkTime.setBounds(position.getX(),INTER+name.getY()+name.getHeight(), tabWidth/10, tabHeight/15);//��ְʱ��
		positionText.setBounds(tabWidth/4, INTER, tabWidth*11/20, tabHeight/15);//ְλ
		staffCodeText.setBounds(tabWidth/4, INTER+position.getY()+position.getHeight(), tabWidth*11/20, tabHeight/15);//���
		companyText.setBounds(tabWidth/4, INTER+staffCode.getY()+staffCode.getHeight(), tabWidth*11/20, tabHeight/15);//��λ
		nameText.setBounds(tabWidth/4, INTER+company.getY()+company.getHeight(), tabWidth*11/20, tabHeight/15);//Ա������
		startWorkTimeText.setBounds(tabWidth/4, INTER+name.getY()+name.getHeight(), tabWidth*11/20, tabHeight/15);//��ְʱ��
		cancleButton.setBounds(tabWidth*19/40, INTER+startWorkTimeText.getY()+startWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
		saveButton.setBounds(tabWidth*27/40, INTER+startWorkTimeText.getY()+startWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
	}
	
	//�˴��������Ա������Ϣ
	private void initData(String unit) {
		tableTitle =new String[]{"Ա������","ְλ","������λ","��ְʱ��","Ա���˺�"};
		InfoBLService service = ConstructFactory.InfoFactory();
		ArrayList<StaffVO> staffList = service.readStaff(unit);
		tableData = new String[staffList.size()][tableTitle.length];
		int x=0;
		for(StaffVO staff:staffList){
			tableData[x][0] = staff.getName();
			tableData[x][1] = staff.getJob();
			tableData[x][2] = staff.getUnit();
			tableData[x][3] = staff.getWorkage();
			tableData[x][4] = staff.getCode();
			x++;
		}
	}
	
	private String[] getUnit(){
		InfoBLService service = ConstructFactory.InfoFactory();
		ArrayList<String> unit = service.readUnit();
		String allUnit[] = new String[unit.size()];
		for(int i = 0;i<unit.size();i++){
			allUnit[i] = unit.get(i);
		}
		return allUnit;
	}
	
	public void initButton(){
		delButton = new JButton("ɾ��");
		sButton = new JButton("����");
		ensureButton = new JButton("ȷ��");
		unitLable = new JLabel("��λ��");
		inquirePane.add(ensureButton);
		inquirePane.add(unitLable);
		inquirePane.add(delButton);
		inquirePane.add(sButton);
		unitLable.setBounds(tabWidth/20, tabHeight/20, tabWidth/10, tabHeight/16);
		ensureButton.setBounds(tabWidth*2/5, tabHeight/20, tabWidth/10, tabHeight/16);
		delButton.setBounds(tabWidth*3/5, tabHeight*17/20, tabWidth/10, tabHeight/16);
		sButton.setBounds(tabWidth*4/5, tabHeight*17/20, tabWidth/10, tabHeight/16);
		ensureButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				initData((String) unitBox.getSelectedItem());
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setDataVector(tableData,tableTitle);
			}
		});
		delButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){	
				if(delStaffCode.indexOf(tableData[table.getSelectedRow()][4])!=-1){//��Ҫ���˻���������
					delStaffCode.add(tableData[table.getSelectedRow()][4]);
					((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
				}
			}
		});
		sButton.addMouseListener(new MouseAdapter() {//����ط������г���
			public void mouseClicked(MouseEvent e) {
				for(int i = 0; i<tableData.length; i++){
					for(int j = 0; j<tableTitle.length; j++){
						if(table.getModel().getValueAt(i, j)!=tableData[i][j]
								&&delStaffCode.indexOf(tableData[i][4])==-1){
							voList.add(new StaffVO(String.valueOf(table.getModel().getValueAt(i,0)), 
									String.valueOf(table.getModel().getValueAt(i,1)), 
									String.valueOf(table.getModel().getValueAt(i,2)), 
									String.valueOf(table.getModel().getValueAt(i,3)), 
									String.valueOf(table.getModel().getValueAt(i,4))));
							break;
						}
					}
				}
				InfoBLService service = ConstructFactory.InfoFactory();
				for(int i = 0; i<voList.size(); i++){//�޸�
					service.modifyStaff(voList.get(i));
				}
				for(int i = 0; i<delStaffCode.size(); i++){//ɾ��
					service.deleteStaff(delStaffCode.get(i));
				}
			}
		});
	}
	
	//��ѯԱ��
	private void initTable() {
		unitBox = new JComboBox<String>(getUnit());
		initData(String.valueOf(unitBox.getSelectedItem()));
		table = new JTable(tableData,tableTitle);
		scroll = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setRowHeight(tab.getWidth()/20);//�����п�
		table.setDragEnabled(false);//���ò����϶�
		table.getTableHeader().setPreferredSize(new Dimension(10000, tab.getWidth()/20));//���ñ�ͷ�߶�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�	
		inquirePane.add(scroll);	
		inquirePane.add(unitBox);
		if(tableData.length<=9){
			scroll.setBounds(tabWidth/20, tabHeight*3/20,tabWidth*9/10, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scroll.setBounds(tabWidth/20, tabHeight*3/20, tabWidth*9/10, 10*table.getRowHeight());
		}
		table.setModel(new DefaultTableModel(tableData,tableTitle){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row,int column){
				if(column==4){//�涨�����޸��Ƿ����͵��ţ��涨���ܶ��ѽ���ĵ����޸��κ���Ϣ
					return false;
				}
				return true;
			}
		});
		unitBox.setBounds(tabWidth*3/20, tabHeight/20, tabWidth*3/20, tabHeight/16);
		inquirePane.repaint();
	}
}
