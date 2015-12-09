package main.presentation.loadui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.presentation.mainui.WritePanel;



public class LoadingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected JComboBox<String> yearBox;
	protected JComboBox<String> monthBox;
	protected JComboBox<String> dayBox;
	protected JLabel yearLabel=new JLabel("年");
	protected JLabel monthLabel=new JLabel("月");
	protected JLabel dayLabel=new JLabel("日");
	protected JLabel timeLabel=new JLabel("装运时间");
	
	protected JTable lookTable;
	protected CreatePanel newPanel;
	protected JButton inquireButton=new JButton("查询");
	protected JButton addButton=new JButton("新增");
	protected final int PANEL_WIDTH;
	protected final int PANEL_HIGHT;
	protected JScrollPane scrollPane;
	protected JTabbedPane tabbedPane; 
	protected WritePanel wp;
	
	public LoadingPanel(CreatePanel panel,JTabbedPane panel2,WritePanel pwp){
		this.PANEL_HIGHT=panel2.getHeight();
		this.PANEL_WIDTH=panel2.getWidth();
		this.newPanel=panel;
		this.tabbedPane=panel2;
		wp=pwp;
		this.setBounds(0,0,this.PANEL_WIDTH,this.PANEL_HIGHT);
		this.setLayout(null);
		this.initAll();
	}
	private void initCombo(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		String years[]={""+(year-1),""+year,""+(year+1)};
		yearBox=new JComboBox<String>(years);
		String months[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
		monthBox=new JComboBox<String>(months);
		String days[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		dayBox=new JComboBox<String>(days);
		timeLabel.setBounds(this.PANEL_WIDTH/20,this.PANEL_HIGHT/10-15,this.PANEL_WIDTH/10,this.PANEL_HIGHT/20);
		yearBox.setBounds(timeLabel.getX()+this.PANEL_WIDTH/10, this.PANEL_HIGHT/10-15,this.PANEL_WIDTH/10,this.PANEL_HIGHT/20);
		yearLabel.setBounds(yearBox.getX()+this.PANEL_WIDTH/10+10, this.PANEL_HIGHT/10-15,this.PANEL_WIDTH/20,this.PANEL_HIGHT/20);
		monthBox.setBounds(yearLabel.getX()+this.PANEL_WIDTH/10, this.PANEL_HIGHT/10-15,this.PANEL_WIDTH/10,this.PANEL_HIGHT/20);
		monthLabel.setBounds(monthBox.getX()+this.PANEL_WIDTH/10+10, this.PANEL_HIGHT/10-15,this.PANEL_WIDTH/20,this.PANEL_HIGHT/20);
		dayBox.setBounds(monthLabel.getX()+this.PANEL_WIDTH/10, this.PANEL_HIGHT/10-15,this.PANEL_WIDTH/10,this.PANEL_HIGHT/20);
		dayLabel.setBounds(dayBox.getX()+10+this.PANEL_WIDTH/10, this.PANEL_HIGHT/10-15,this.PANEL_WIDTH/10,this.PANEL_HIGHT/20);
		inquireButton=new JButton("查询");
		inquireButton.setBounds(dayLabel.getX()+this.PANEL_WIDTH/10+10,this.PANEL_HIGHT/10-15,this.PANEL_WIDTH/10,this.PANEL_HIGHT/20);
		this.add(dayBox);
		this.add(dayLabel);
		this.add(timeLabel);
		this.add(yearBox);
		this.add(yearLabel);
		this.add(monthBox);
		this.add(monthLabel);
		this.add(dayBox);
		this.add(dayLabel);	
		this.add(inquireButton);
	}
	
	protected void initTable(){
		
	}
	
	protected void initAll(){
		this.initCombo();
		this.initTable();
		this.initListener();
	}
	
	public void refresh(){
		String data[][]=this.initTableData();
		while(data.length>lookTable.getRowCount()){
			((DefaultTableModel)lookTable.getModel()). addRow(new String[9]);
		}
		for(int x=0;x<data.length;x++)
			for(int y=0;y<data[0].length;y++)
				this.lookTable.setValueAt(data[x][y],x,y);
	}
	
	protected String[][] initTableData(){return null;};
	
	protected void initListener(){
		addButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				newPanel.setVisible(true);
				tabbedPane.setVisible(false);
			}
		});
		
		this.inquireButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				refresh();
			}
		});
	}
}
