package main.presentation.loadui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import main.businesslogicservice.LoadBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.IntermediateMemory;
import main.vo.TrainLoadingVO;

public class TrainLoadingui extends LoadingPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TrainLoadingui(CreatePanel panel, JTabbedPane panel2,WritePanel wpw) {
		super(panel, panel2,wpw);
		// TODO Auto-generated constructor stub
		this.tabbedPane.add(this,"火车装运");
	}
	
	protected void initTable(){
		int panelWidth=this.PANEL_WIDTH-26;
		int panelHeight=this.PANEL_HIGHT-26;
		String[] tableTitle = new String[]{"货运编号", "车次号", "出发地", "到达地", "监装员", "车厢号","托运单号","运费","装运日期"};
		String[][] tableData =this.initTableData();
		lookTable = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(lookTable);
		lookTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		lookTable.setRowHeight(panelWidth/20);//设置列宽
		lookTable.setDragEnabled(false);//设置不可拖动
		lookTable.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		lookTable.getTableHeader().setResizingAllowed(true);//设置列宽不可变
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, (lookTable.getRowCount()+1)*lookTable.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5-15, panelWidth/6*5, 10*lookTable.getRowHeight());
		}
		addButton.setSize(75,35);
     	addButton.setLocation(PANEL_WIDTH*13/20,PANEL_HIGHT*72/85);
		this.add(scrollPane);
     	this.add(addButton);
	}
	
	protected String[][] initTableData(){
		IntermediateMemory memory=(IntermediateMemory)wp.getMemory();
		String codes[]=memory.getRailLoadCode().split(" ");
		int length=codes.length;
		String[][] table;
		if(length>10)
			table=new String[length-1][9];
		else
			table=new String[10][9];
		for(int x=0;x<table.length;x++)
			for(int y=0;y<9;y++)
				table[x][y]=null;
		LoadBLService service=ConstructFactory.LoadFactory();
		ArrayList<TrainLoadingVO> voList=service.inquireLoadTrain(memory.getRailLoadCode());
		int x=0;
		//"货运编号", "车次号", "出发地", "到达地", "监装员", "车厢号","托运区号","运费","装运日期"
		for(TrainLoadingVO vo:voList){
			table[x][0]=vo.getCarTourNum();
			table[x][1]=vo.getCarNum();
			table[x][2]=vo.getDeparture();
			table[x][3]=vo.getDestination();
			table[x][4]=vo.getMonitor();
			table[x][5]=vo.getGuard();
			table[x][6]=vo.getShipment();
			table[x][7]=vo.getFreight()+"";
			table[x][8]=vo.getLoadingDate();
			x++;
		}
		return table;	
		
	}
}
