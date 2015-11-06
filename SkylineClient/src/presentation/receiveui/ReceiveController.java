package presentation.receiveui;

public class ReceiveController {
	private OrderInputPanel orderInput;
	public void select(Receiveui ui){
		switch(ui){
		case OrderInput:
			orderInput=new OrderInputPanel();
			orderInput.init();
			break;
		}
	}
}
