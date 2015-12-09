package main.timetask;

public class TimerTask extends java.util.TimerTask {
	ClearCourrierReceipt ccr=new ClearCourrierReceipt();
	ClearLobbyReceipt clr=new ClearLobbyReceipt();
	ClearIntermediateReceipt cir=new ClearIntermediateReceipt();
	ClearWarehouseReceipt cwr=new ClearWarehouseReceipt();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ccr.excute();
		
	}

}
