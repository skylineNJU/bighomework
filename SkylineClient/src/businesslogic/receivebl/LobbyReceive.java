package businesslogic.receivebl;

import dataService.ReceiveDataServiceImpl;
import po.LobbyReceivePO;

public class LobbyReceive {
	private LobbyReceivePO po;
	private int[] Date=new int[3];
	private String [] Datee=new String [3];
	private ReceiveDataServiceImpl impl=new ReceiveDataServiceImpl();
	
	public LobbyReceive(String date, String code, String from, int condition,String receiptCode){
		Datee=date.split("/");
		Date[0]=Integer.parseInt(Datee[0]);
		Date[1]=Integer.parseInt(Datee[1]);
		Date[2]=Integer.parseInt(Datee[2]);
		po=new LobbyReceivePO(Date[0],Date[1],Date[2],condition,code,receiptCode);
	}
	
	public void write(){
		
		impl.writeLobbyReceiveOrder(po);
	}
	
	
}
