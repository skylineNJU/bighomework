package main.presentation.receiveui;

public class ReceiveController {
	private OrderInputPanel orderInput;
	private LobbyReceivePanel lobbyReceivePanel;
	public void select(Receiveui ui){
		switch(ui){
		case OrderInput:
			orderInput=new OrderInputPanel();
			orderInput.init();
			break;
		case LobbyReceiveList:
			lobbyReceivePanel = new LobbyReceivePanel();
			lobbyReceivePanel.init();
		default:
			break;
		}
	}
}
