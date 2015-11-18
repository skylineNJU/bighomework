package main.presentation.receiptui;

public class ReceiptuiControl {
	AllOrderPanel allOrderPanel;
	
	public void select(Receiptui ui){
		switch(ui){
		case AllOrderui:
			allOrderPanel = new AllOrderPanel();
			allOrderPanel.init();
			break;
		default:
				break;
		}
	}
}
