package main.presentation.financeui;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class PageTableModel extends AbstractTableModel implements TableModel,TableModelListener{
	private TableModel baseModel;
	
	/**当前页，从0开始编号.
	　　*/
	private int currentPage;
	/**每页最多数据行数.
	　　*/
	private int pageSize=20;

	/**获取总页数。
	　　*
	　　* @return
	　　*/
	public PageTableModel(TableModel baseModel){
		this.baseModel=baseModel;
		baseModel.addTableModelListener(this);
	}
	public int getPageCount(){
	int mod=baseModel.getRowCount()%pageSize;
	int hasMode=mod>0?1:0;
			return baseModel.getRowCount()/pageSize+hasMode;
	}

	public int getPageSize() {
	return pageSize;
	}

	public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
	}

	public int getCurrentPage() {
	return currentPage;
	}

	public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
	}
	@Override
	public int getRowCount() {
	if(getCurrentPage()<getPageCount()-1)return pageSize;
		return baseModel.getRowCount()%pageSize;
	}

	@Override
	public int getColumnCount() {
		return baseModel.getColumnCount();
	}

	public String getColumnName(int columnIndex) {
	return baseModel.getColumnName(columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return baseModel.getColumnClass(columnIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return baseModel.isCellEditable(getBaseModelRow(rowIndex), columnIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return baseModel.getValueAt(getBaseModelRow(rowIndex), columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		baseModel.setValueAt(aValue, getBaseModelRow(rowIndex), columnIndex);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int firstRow,lastRow;
		int minFirstRow=getBaseModelRow(0);
		int maxFirstRow=getBaseModelRow(pageSize-1);
		if(e.getFirstRow()>maxFirstRow)return;
		if(e.getLastRow()<minFirstRow)return;
		firstRow=getThisModelRow(e.getFirstRow());
		if(firstRow<0)firstRow=0;
		lastRow=getThisModelRow(e.getLastRow());
		if(lastRow<0)lastRow=this.pageSize-1;
		fireTableChanged(new TableModelEvent(this, firstRow, lastRow, e.getColumn(), e.getType()));
	}

	/**获取指定的行在底层Model中的行号.
	　　*
	　　* @param row
	　　* @return
	　　*/
	private int getBaseModelRow(int row){
		return getCurrentPage()*pageSize+row;
	}
	/**获取指定的底层Model中的行号对应的当前Model的行号.
	　　* 如果底层Model中指定的行号不在当前Model的显示范围内，应该返回-1。
	　　*
	　　* @param row
	　　* @return
	　　*/
	private int getThisModelRow(int row){
		if(row/pageSize !=getCurrentPage())return -1;
		return row%pageSize;
	}
	}