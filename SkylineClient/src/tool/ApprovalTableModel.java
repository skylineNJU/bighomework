package tool;

import javax.swing.table.AbstractTableModel;

public class ApprovalTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] titleName;   //表格的标题
	private Object[][] content;	//表格的内容

	public ApprovalTableModel(){
		super();
	}
	
	public ApprovalTableModel(Object[][] content,String[] titleName){
		this();
		this.titleName=titleName;
		this.content=content;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titleName.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return content.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return content[arg0][arg1];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 2 || columnIndex == 3) {
				return false;
		}
		return true;
	}



}
