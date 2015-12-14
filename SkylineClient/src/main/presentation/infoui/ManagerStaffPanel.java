package main.presentation.infoui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.InfoBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.StaffVO;

//人员管理
public class ManagerStaffPanel {
	
	private JPanel panel;
	private int tabWidth;
	private int tabHeight;
	private JTabbedPane tab;
	private JPanel addPanel;
	//private JPanel inquirePanel;
	private JLabel title;
	
	//新增员工的组件
	private JLabel position;//职位
	private JLabel staffCode;//编号
	private JLabel company;//单位
	private JLabel name;//员工姓名
	private JLabel startWorkTime;//入职时间
	private JTextField positionText;//职位
	private JTextField staffCodeText;//编号
	private JTextField companyText;//单位
	private JTextField nameText;//员工姓名
	private JTextField startWorkTimeText;//入职时间
	private JButton saveButton;
	private JButton cancleButton;
	
	//新的查询员工界面
	private ArrayList<String> delStaffCode = new ArrayList<String>();
	private ArrayList<StaffVO> voList = new ArrayList<StaffVO>();
	private JPanel inquirePane;
	private JTable table;
	private JScrollPane scroll;
	private String[] tableTitle;
	private String[][] tableData;
	private JButton ensureButton;
	private JComboBox<String> unitBox;
	private String[] allUnit;
	private JLabel unitLable;
	private JButton delButton;
	private JButton sButton;
	private JPopupMenu popMenu;
	private String[] allJob = {"快递员","营业厅业务员","司机","中转中西业务员","仓库管理人员","财务人员",
			"总经理","账户管理人员"};
	private JMenuItem[] menuItem;
//	//查询员工组件
//	private JLabel dataLabel;
//	private JLabel inquirePosition;//职位
//	private JLabel inquireStaffCode;//编号
//	private JLabel inquireCompany;//单位
//	private JLabel inquireName;//员工姓名
//	private JLabel inquireStartWorkTime;//入职时间
//	private JTextField inquirePositionText;//职位
//	private JTextField inquireStaffCodeText;//编号
//	private JTextField inquireCompanyText;//单位
//	private JTextField inquireNameText;//员工姓名
//	private JTextField inquireStartWorkTimeText;//入职时间
//	private JButton inquireSaveButton;
//	private JButton inquireCancleButton;
//	private JButton backButton;
//	
//	private JLabel label;
//	private JLabel inquire;
//	private JTextField inquireText;
//	private JButton inquireButton;
	

	
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
//		inquirePanel = new JPanel();
		inquirePane = new JPanel();
		addPanel.setLayout(null);
	//	inquirePanel.setLayout(null);
		inquirePane.setLayout(null);
		tab.addTab("新增员工", addPanel);
//		tab.addTab("查询员工", inquirePanel);
		tab.addTab("查询员工",inquirePane);
		initAddPanel();
		//initInquirePanel();
		initTable();
		initButton();
		panel.repaint();
	}
	
	public void initTitle(){
		title = new JLabel("人员管理");
		panel.add(title);
		title.setBounds(panel.getWidth()*2/5, panel.getHeight()/60, panel.getWidth()/5, panel.getHeight()/30);
	}
	public void initAddPanel(){
		position = new JLabel("职位");//职位
		staffCode = new JLabel("编号");//编号
		company = new JLabel("单位");//单位
		name = new JLabel("员工姓名");//员工姓名
		startWorkTime = new JLabel("入职时间");//入职时间
		positionText = new JTextField();//职位
		staffCodeText = new JTextField();//编号
		companyText = new JTextField();//单位
		nameText = new JTextField();//员工姓名
		startWorkTimeText = new JTextField();//入职时间
		saveButton = new JButton("保存");
		cancleButton = new JButton("取消");
		
		addPanel.add(position);//职位
		addPanel.add(staffCode);//编号
		addPanel.add(company);//单位
		addPanel.add(name);//员工姓名
		addPanel.add(startWorkTime);//入职时间
		addPanel.add(positionText);//职位
		addPanel.add(staffCodeText);//编号
		addPanel.add(companyText);//单位
		addPanel.add(nameText);//员工姓名
		addPanel.add(startWorkTimeText);//入职时间
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
		
		position.setBounds(tabWidth/10, INTER, tabWidth/10, tabHeight/15);//职位
		staffCode.setBounds(position.getX(), INTER+position.getY()+position.getHeight(), tabWidth/10, tabHeight/15);//编号
		company.setBounds(position.getX(), INTER+staffCode.getY()+staffCode.getHeight(), tabWidth/10, tabHeight/15);//单位
		name.setBounds(position.getX(), INTER+company.getY()+company.getHeight(), tabWidth/10, tabHeight/15);//员工姓名
		startWorkTime.setBounds(position.getX(),INTER+name.getY()+name.getHeight(), tabWidth/10, tabHeight/15);//入职时间
		positionText.setBounds(tabWidth/4, INTER, tabWidth*11/20, tabHeight/15);//职位
		staffCodeText.setBounds(tabWidth/4, INTER+position.getY()+position.getHeight(), tabWidth*11/20, tabHeight/15);//编号
		companyText.setBounds(tabWidth/4, INTER+staffCode.getY()+staffCode.getHeight(), tabWidth*11/20, tabHeight/15);//单位
		nameText.setBounds(tabWidth/4, INTER+company.getY()+company.getHeight(), tabWidth*11/20, tabHeight/15);//员工姓名
		startWorkTimeText.setBounds(tabWidth/4, INTER+name.getY()+name.getHeight(), tabWidth*11/20, tabHeight/15);//入职时间
		cancleButton.setBounds(tabWidth*19/40, INTER+startWorkTimeText.getY()+startWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
		saveButton.setBounds(tabWidth*27/40, INTER+startWorkTimeText.getY()+startWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
	}
	
	//此处获得所有员工的信息
	private void initData() {
		tableTitle =new String[]{"员工姓名","职位","所属单位","入职时间","员工账号"};
		tableData = new String[1][tableTitle.length];
		InfoBLService service = ConstructFactory.InfoFactory();
		ArrayList<StaffVO> staffList = service.readStaff(String.valueOf(unitBox.getSelectedItem()));
		tableData = new String[staffList.size()+1][tableTitle.length];
		for(int i =0;i<tableTitle.length;i++){
			tableData[i][0] = staffList.get(i).getName();
			tableData[i][1] = staffList.get(i).getJob();
			tableData[i][2] = staffList.get(i).getUnit();
			tableData[i][3] = staffList.get(i).getWorkage();
			tableData[i][4] = staffList.get(i).getCode();
		}
		for(int i = 0;i<tableTitle.length;i++){
			tableData[tableTitle.length][i] = " ";
		}
	}
	
	private void getUnit(){
		InfoBLService service = ConstructFactory.InfoFactory();
	}
	
	public void initButton(){
		delButton = new JButton("删除");
		sButton = new JButton("保存");
		ensureButton = new JButton("确认");
		unitLable = new JLabel("单位：");
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
				inquirePane.remove(scroll);
				inquirePane.remove(table);
				inquirePane.remove(unitBox);
				initTable();
				inquirePane.repaint();
			}
		});
		delButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){	
				if(delStaffCode.indexOf(tableData[table.getSelectedRow()][4])!=-1){//需要加人机交互部分
					delStaffCode.add(tableData[table.getSelectedRow()][4]);
				}
			}
		});
		sButton.addMouseListener(new MouseAdapter() {//这个地方可能有出错
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
				for(int i = 0; i<voList.size(); i++){//修改
					service.modifyStaff(voList.get(i));
				}
				for(int i = 0; i<delStaffCode.size(); i++){//删除
					service.deleteStaff(delStaffCode.get(i));
				}
				if(isRight()) {
					StaffVO vo = new StaffVO(String.valueOf(table.getModel().getValueAt(tableData.length,0)), 
							String.valueOf(table.getModel().getValueAt(tableData.length,1)), 
							String.valueOf(table.getModel().getValueAt(tableData.length,2)), 
							String.valueOf(table.getModel().getValueAt(tableData.length,3)), 
							String.valueOf(table.getModel().getValueAt(tableData.length,4)));
					service.createNewStaff(vo);
				}else{//输入不正确时的人机交互
					
				}
			}
		});
	}
	
	private boolean isRight() {//判断输入是否准确
//		if(table.getModel().getValueAt(tableData.length,0)!=null
//				&&){
//			
//		}
		return true;
	}
	//查询员工
	private void initTable() {
//		initData();
//		getUnit();
		popMenu = new JPopupMenu();
		menuItem = new JMenuItem[allJob.length];
		for(int i = 0;i<allJob.length;i++){
			menuItem[i] = new JMenuItem(allJob[i]);
			popMenu.add(menuItem[i]);
		}
		tableTitle =new String[]{"员工姓名","职位","所属单位","入职时间","员工账号"};
		tableData = new String[][]{{"员工姓名","职位","所属单位","入职时间","员工账号"},{"员工姓名","职位","所属单位","入职时间","员工账号"},
				{"员工姓名","职位","所属单位","入职时间","员工账号"},{"员工姓名","职位","所属单位","入职时间","员工账号"}};
		allUnit = new String[]{"员工姓名","职位","所属单位","入职时间","员工账号"};
		unitBox = new JComboBox<String>(allUnit);
		table = new JTable(tableData,tableTitle);
		scroll = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setRowHeight(tab.getWidth()/20);//设置列宽
		table.setDragEnabled(false);//设置不可拖动
		table.getTableHeader().setPreferredSize(new Dimension(10000, tab.getWidth()/20));//设置表头高度
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变	
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
				if(column==4){//规定不能修改是否结算和单号，规定不能对已结算的单据修改任何信息
					return false;
				}
				return true;
			}
		});
		unitBox.setBounds(tabWidth*3/20, tabHeight/20, tabWidth*3/20, tabHeight/16);
		inquirePane.repaint();
	}
	
//	public void initInquirePanel(){
//		
//		label  = new JLabel();
//		dataLabel = new JLabel();
//		inquirePosition = new JLabel("职位");//职位
//		inquireStaffCode = new JLabel("编号");//编号
//		inquireCompany = new JLabel("单位");//单位
//		inquireName = new JLabel("员工姓名");//员工姓名
//		inquireStartWorkTime = new JLabel("入职时间");//入职时间
//		inquirePositionText = new JTextField();//职位
//		inquireStaffCodeText = new JTextField();//编号
//		inquireCompanyText = new JTextField();//单位
//		inquireNameText = new JTextField();//员工姓名
//		inquireStartWorkTimeText = new JTextField();//入职时间
//		inquireSaveButton = new JButton("保存");
//		inquireCancleButton = new JButton("取消");
//		backButton = new JButton("返回");
//		backButton.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e){
//				label.setVisible(true);
//				dataLabel.setVisible(false);
//			}
//		});
//		
//		inquire = new JLabel("查询");
//		inquireText = new JTextField();
//		inquireButton = new JButton("查询");
//		inquireButton.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e){
//				InfoBLService service=ConstructFactory.InfoFactory();
//				System.out.println(inquireText.getText());
//				StaffVO vo=service.inquireStaff(inquireText.getText());
//				inquirePositionText.setText(vo.getJob());
//				inquireStaffCodeText.setText(vo.getCode());
//				inquireCompanyText.setText(vo.getUnit());
//				inquireNameText.setText(vo.getName());
//				inquireStartWorkTimeText.setText(vo.getWorkage());
//				dataLabel.setVisible(true);
//				label.setVisible(false);
//			}
//		});
//		
//		inquirePanel.add(label);
//		inquirePanel.add(dataLabel);
//		label.setBounds(0, 0, tabWidth, tabHeight);
//		dataLabel.setBounds(0, 0, tabWidth, tabHeight);
//		label.setVisible(true);
//		dataLabel.setVisible(false);
//		
//		dataLabel.add(inquirePosition);//职位
//		dataLabel.add(inquireStaffCode);//编号
//		dataLabel.add(inquireCompany);//单位
//		dataLabel.add(inquireName);//员工姓名
//		dataLabel.add(inquireStartWorkTime);//入职时间
//		dataLabel.add(inquirePositionText);//职位
//		dataLabel.add(inquireStaffCodeText);//编号
//		dataLabel.add(inquireCompanyText);//单位
//		dataLabel.add(inquireNameText);//员工姓名
//		dataLabel.add(inquireStartWorkTimeText);//入职时间
//		dataLabel.add(inquireSaveButton);
//		dataLabel.add(inquireCancleButton);
//		dataLabel.add(backButton);
//		
//		label.add(inquire);
//		label.add(inquireText);
//		label.add(inquireButton);
//		
//		final int INTER = tabHeight*3/35;
//		
//		inquirePosition.setBounds(tabWidth/10, INTER, tabWidth/10, tabHeight/15);//职位
//		inquireStaffCode.setBounds(tabWidth/10, INTER+inquirePosition.getY()+inquirePosition.getHeight(), tabWidth/10, tabHeight/15);//编号
//		inquireCompany.setBounds(inquirePosition.getX(), INTER+inquireStaffCode.getY()+inquireStaffCode.getHeight(), tabWidth/10, tabHeight/15);//单位
//		inquireName.setBounds(inquirePosition.getX(), INTER+inquireCompany.getY()+inquireCompany.getHeight(), tabWidth/10, tabHeight/15);//员工姓名
//		inquireStartWorkTime.setBounds(inquirePosition.getX(),INTER+inquireName.getY()+inquireName.getHeight(), tabWidth/10, tabHeight/15);//入职时间
//		inquirePositionText.setBounds(tabWidth/4, INTER, tabWidth*11/20, tabHeight/15);//职位
//		inquireStaffCodeText.setBounds(tabWidth/4, INTER+inquirePosition.getY()+inquirePosition.getHeight(), tabWidth*11/20, tabHeight/15);//编号
//		inquireCompanyText.setBounds(tabWidth/4, INTER+inquireStaffCode.getY()+inquireStaffCode.getHeight(), tabWidth*11/20, tabHeight/15);//单位
//		inquireNameText.setBounds(tabWidth/4, INTER+inquireCompany.getY()+inquireCompany.getHeight(), tabWidth*11/20, tabHeight/15);//员工姓名
//		inquireStartWorkTimeText.setBounds(tabWidth/4, INTER+inquireName.getY()+inquireName.getHeight(), tabWidth*11/20, tabHeight/15);//入职时间
//		inquireCancleButton.setBounds(tabWidth*19/40, INTER+inquireStartWorkTimeText.getY()+inquireStartWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
//		inquireSaveButton.setBounds(tabWidth*27/40, INTER+inquireStartWorkTimeText.getY()+inquireStartWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
//		backButton.setBounds(2*inquireCancleButton.getX()-inquireSaveButton.getX(), inquireSaveButton.getY(), tabWidth/8, tabHeight/15);
//		
//		inquire.setBounds(tabWidth/10-tabWidth/40,tabHeight*2/5,tabWidth/10, tabHeight/15);
//		inquireText.setBounds(tabWidth*3/20, tabHeight*2/5, tabWidth*3/5, tabHeight/15);
//		inquireButton.setBounds(tabWidth*4/5, tabHeight*2/5, tabWidth/8, tabHeight/15);
//	}
}
