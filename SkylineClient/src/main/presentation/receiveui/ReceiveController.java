package main.presentation.receiveui;

public class ReceiveController {
	private OrderInputPanel orderInput;
	private ModifyPassWordPanel modifyPanel;
	public void select(Receiveui ui){
		switch(ui){
		case OrderInput:
			orderInput=new OrderInputPanel();
			orderInput.init();
			break;
		case ModifyPassWord:
			modifyPanel = new ModifyPassWordPanel();
			modifyPanel.init();
			break;
		default:
			break;
		}
	}
}
