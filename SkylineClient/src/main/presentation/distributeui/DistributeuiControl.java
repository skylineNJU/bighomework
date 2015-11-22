package main.presentation.distributeui;

public class DistributeuiControl {
	private DistributePanel distributePanel;
	private ReceiveMessagePanel receivePanel;
	
	public void select(Distributeui ui){
		switch(ui){
		case DistributeListui:
			distributePanel = new DistributePanel();
			distributePanel.init();
			break;
		case ReceiveMessageui:
			receivePanel = new ReceiveMessagePanel();
			receivePanel.init();
			break;
		
		default:
			break;
		}
	}
}
