package main.presentation.infoui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.businesslogicservice.InfoBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.vo.VehicleVO;

public class VehicleMessagePanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	//按钮组件
	private JButton cancleButton;
	private JButton saveButton;
	private JButton lookModifyButton;
	private JButton lookDeleteButton;
	//lookPanel上的组件
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	//writePanel上的组件
	private JLabel vehicleCode;//车辆号
	private JLabel engineCode;//发动机号
	private JLabel chassisCode;//底盘号
	private JLabel buyTime;//购买时间
	private JLabel serviceTime;//服役时间
	private JTextField vehicleCodeText;
	private JTextField engineCodeText;
	private JTextField chassisCodeText;
	private JTextField buyTimeText;
	private JTextField serviceTimeText;
	
	private JLabel title;
	private JPanel lookPanel;//查看接收单
	private JPanel writePanel;//填写接收单
	private JTabbedPane tab;
	private boolean[] selectRow; 
	
	
	public VehicleMessagePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();//初始化标题
		lookPanel = new JPanel();
		lookPanel.setLayout(null);
		writePanel = new JPanel();
		writePanel.setLayout(null);
		
		lookTabel();//初始化查看司机面板
		writeTabel();//初始化填写信息面板
		initButton();//初始化按钮
		
		tab = new JTabbedPane();
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.add("查看车辆信息",lookPanel);
		tab.add("新增车辆信息",writePanel);
		panel.add(tab);
		tab.setBounds(panelWidth/10, panelHeight/10, panelWidth*4/5, panelHeight*4/5);
		tab.setVisible(true);
		tab.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(tab.getSelectedIndex()==0){
					refresh();
				}
			}
			
		});
		panel.repaint();
	}
	
	private void refresh(){
		tableData =getTableData();
		for(int x=0;x<20;x++){
			for(int y=0;y<6;y++)
			table.setValueAt(tableData[x][y],x,y);
		}
	}
	public void title(){
		title = new JLabel("车辆信息管理");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	
	public void initButton(){
		cancleButton = new JButton("取消");
		saveButton = new JButton("保存");
		cancleButton.setBounds(panelWidth*2/5, panelHeight*13/20, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*6/10,  panelHeight*13/20, panelWidth/10, panelHeight/20);
		writePanel.add(cancleButton);
		writePanel.add(saveButton);
		
		saveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				InfoBLService service=ConstructFactory.InfoFactory();
				VehicleVO vehicleInfo=new VehicleVO(vehicleCodeText.getText(),
													engineCodeText.getText(),
													((WritePanel) panel).getBelong(),
													chassisCodeText.getText(),
													buyTimeText.getText(),
													serviceTimeText.getText());
				service.createNewVehicle(vehicleInfo);
			}
		});
		
		cancleButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				vehicleCodeText.setText(null);
				engineCodeText.setText(null);
				chassisCodeText.setText(null);
				buyTimeText.setText(null);
				serviceTimeText.setText(null);
			}
		});
		lookModifyButton = new JButton("修改");
		lookDeleteButton = new JButton("删除");
		lookModifyButton.setBounds(panelWidth*9/20, panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookDeleteButton.setBounds(panelWidth*13/20,  panelHeight*27/40, panelWidth/10, panelHeight/20);
		lookPanel.add(lookModifyButton);
		lookPanel.add(lookDeleteButton);
		
		lookModifyButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				InfoBLService service=ConstructFactory.InfoFactory();
				for(int x=0;x<20;x++){
					if(selectRow[x]){
						//"车辆代号", "发动机号", "底盘号", "购买时间", "服役时间"
						VehicleVO vo=new VehicleVO((String)table.getValueAt(x, 0),
												   (String)table.getValueAt(x, 1),
												   ((WritePanel)panel).getBelong(),
												   (String)table.getValueAt(x, 2),
												   (String)table.getValueAt(x, 3),
												   (String)table.getValueAt(x, 4)
													);
						service.modifyVehicle(vo);
					}
				}
				refresh();
			}
		});
		
		lookDeleteButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println("delete");
				InfoBLService service=ConstructFactory.InfoFactory();
				for(int x=0;x<20;x++){
					if(selectRow[x]){					
						service.deleteVehicle((String)table.getValueAt(x,0));
					}
				}
				refresh();
			}
		});
	}
	
	public void lookTabel(){
		tableTitle = new String[]{"车辆代号", "发动机号", "底盘号", "购买时间", "服役时间","选择"};
		tableData = this.getTableData();
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.getTableHeader().setPreferredSize(new Dimension(1000,panelWidth/20));
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
					table.setValueAt("已选",x,5);
				}else{
					selectRow[x]=false;
					table.setValueAt("",x,5);
				}
			}
		});
	}
	
	public String[][] getTableData(){
		String[][] content=new String[20][6];
		this.selectRow=new boolean[20];
		for(int x=0;x<20;x++){
			this.selectRow[x]=false;
			for(int y=0;y<6;y++){
				content[x][y]=null;
				
			}
		}
		InfoBLService service=ConstructFactory.InfoFactory();
		ArrayList<VehicleVO> list=service.inquireVehicle(((WritePanel) panel).getBelong());
		int counter=0;
		for(VehicleVO vo:list){
			content[counter][0]=vo.getCarID();
			content[counter][1]=vo.getEngineID();
			content[counter][2]=vo.getUnderpanID();
			content[counter][3]=vo.getBoughtTime();
			content[counter][4]=vo.getUsedTime();
			content[counter][5]=null;
			counter++;
		}
		return content;
	}
	public void writeTabel(){
		vehicleCode = new JLabel("车辆号");//车辆号
		engineCode = new JLabel("发动机号");//发动机号
		chassisCode = new JLabel("底盘号");//底盘号
		buyTime = new JLabel("购买时间");//购买时间
		serviceTime = new JLabel("服役时间");//服役时间
		vehicleCodeText = new JTextField();
		engineCodeText = new JTextField();
		chassisCodeText = new JTextField();
		buyTimeText = new JTextField();
		serviceTimeText = new JTextField();
		
		writePanel.add(vehicleCode);
		writePanel.add(engineCode);
		writePanel.add(chassisCode);
		writePanel.add(buyTime);
		writePanel.add(serviceTime);
		writePanel.add(vehicleCodeText);
		writePanel.add(engineCodeText);
		writePanel.add(chassisCodeText);
		writePanel.add(buyTimeText);
		writePanel.add(serviceTimeText);
		
		vehicleCode.setBounds(panelWidth/20, panelHeight/20, panelWidth/10, panelHeight/15);
		engineCode.setBounds(panelWidth/20, panelHeight/8+vehicleCode.getY(), panelWidth/10, panelHeight/15);
		chassisCode.setBounds(panelWidth/20, panelHeight/8+engineCode.getY(), panelWidth/10, panelHeight/15);
		buyTime.setBounds(panelWidth/20, panelHeight/8+chassisCode.getY(), panelWidth/10, panelHeight/15);
		serviceTime.setBounds(panelWidth/20, panelHeight/8+buyTime.getY(), panelWidth/10, panelHeight/15);
		vehicleCodeText.setBounds(panelWidth/5, panelHeight/20, panelWidth/2, panelHeight/15);
		engineCodeText.setBounds(panelWidth/5, panelHeight/8+vehicleCode.getY(), panelWidth/2, panelHeight/15);
		chassisCodeText.setBounds(panelWidth/5, panelHeight/8+engineCode.getY(), panelWidth/2, panelHeight/15);
		buyTimeText.setBounds(panelWidth/5, panelHeight/8+chassisCode.getY(), panelWidth/2, panelHeight/15);
		serviceTimeText.setBounds(panelWidth/5, panelHeight/8+buyTime.getY(), panelWidth/2, panelHeight/15);
	}

}
