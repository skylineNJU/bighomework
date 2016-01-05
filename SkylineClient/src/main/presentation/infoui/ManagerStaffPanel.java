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
		tab.addTab("新增员工", addPanel);
		tab.addTab("查询员工",inquirePane);
		initAddPanel();
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
	private void initData(String unit) {
		tableTitle =new String[]{"员工姓名","职位","所属单位","入职时间","员工账号"};
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
				initData((String) unitBox.getSelectedItem());
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setDataVector(tableData,tableTitle);
			}
		});
		delButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){	
				if(delStaffCode.indexOf(tableData[table.getSelectedRow()][4])!=-1){//需要加人机交互部分
					delStaffCode.add(tableData[table.getSelectedRow()][4]);
					((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
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
			}
		});
	}
	
	//查询员工
	private void initTable() {
		unitBox = new JComboBox<String>(getUnit());
		initData(String.valueOf(unitBox.getSelectedItem()));
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
}
