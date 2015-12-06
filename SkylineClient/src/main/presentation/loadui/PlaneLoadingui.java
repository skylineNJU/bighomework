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
import main.vo.PlaneLoadingVO;

public class PlaneLoadingui extends LoadingPanel{
	
	public PlaneLoadingui(CreatePanel panel, JTabbedPane panel2,WritePanel pwp) {
		super(panel, panel2,pwp);
		// TODO Auto-generated constructor stub
		this.tabbedPane.add(this,"飞机装运");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	protected void initTable(){
		String[] tableTitle = new String[]{"航运编号", "航班号", "出发地", "到达地", "监装员", "货柜号","托运区号","运费","装运日期"};
		String[][] tableData=this.initTableData();
		this.lookTable=new JTable(tableData,tableTitle);
		addButton.setSize(75,35);
     	addButton.setLocation(PANEL_WIDTH*13/20,PANEL_HIGHT*72/85);
     	scrollPane = new JScrollPane(lookTable);
		lookTable .getTableHeader().setReorderingAllowed(false);//表头不可移动
		lookTable.setRowHeight(PANEL_WIDTH/20);//设置列宽
		lookTable.setDragEnabled(false);//设置不可拖动
		lookTable.getTableHeader().setPreferredSize(new Dimension(1, PANEL_WIDTH/20));//设置表头高度
		lookTable.getTableHeader().setResizingAllowed(true);//设置列宽不可变
		if(tableData.length<=9){
			scrollPane.setBounds(PANEL_WIDTH/12, PANEL_HIGHT/5-15, PANEL_WIDTH/6*5, (lookTable.getRowCount()+1)*lookTable.getRowHeight());
		}else{
			scrollPane.setBounds(PANEL_WIDTH/12, PANEL_HIGHT/5-15, PANEL_WIDTH/6*5, 10*lookTable.getRowHeight());
		}
		this.add(scrollPane);
     	this.add(addButton);
	}
	
	protected String[][] initTableData(){
		IntermediateMemory memory=(IntermediateMemory)wp.getMemory();
		String[] codes=memory.getAirLoadCode().split(" ");
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
		ArrayList<PlaneLoadingVO> volist=service.inquireLoadPlane(memory.getAirLoadCode());
		int x=0;
		for(PlaneLoadingVO vo:volist){
			table[x][0]=vo.getCarTourNum();
			table[x][1]=vo.getCarNum();
			table[x][2]=vo.getDeparture();
			table[x][3]=vo.getDestination();
			table[x][4]=vo.getMonitor();
			table[x][5]=vo.getStore();
			table[x][6]=vo.getShipment();
			table[x][7]=vo.getFreight()+"";
			table[x][8]=vo.getLoadingDate();
			x++;
		}
		return table;
	
	}
	
	
}
