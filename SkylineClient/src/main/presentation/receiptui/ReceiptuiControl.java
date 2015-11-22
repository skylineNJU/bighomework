package main.presentation.receiptui;

public class ReceiptuiControl {
	private AllOrderPanel allOrderPanel;
	private ExamAllOrderPanel examAllOrderPanel;
	
	public void select(Receiptui ui){
		switch(ui){
		case AllOrderui:
			allOrderPanel = new AllOrderPanel();
			allOrderPanel.init();
			break;
		case ExamOrder:
			examAllOrderPanel = new ExamAllOrderPanel();
			examAllOrderPanel.init();
			break;
		default:
				break;
		}
	}
}
