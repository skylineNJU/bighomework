package tool;

import java.awt.Component;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyButtonRender extends JButton implements TableCellRenderer {

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 public MyButtonRender() {  
		    setOpaque(true);  
	 }  
	 
	@Override
	 public Component getTableCellRendererComponent(JTable table, Object value,  
             boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		 if (isSelected) {  
		      setForeground(table.getSelectionForeground());  
		      setBackground(table.getSelectionBackground());  
		    } else{  
		      setForeground(table.getForeground());  
		      setBackground(UIManager.getColor("UIManager"));  
		    }  
		    setText( (value ==null) ? "" : value.toString() );  
		    return this;  
	 }  

	
	


}
