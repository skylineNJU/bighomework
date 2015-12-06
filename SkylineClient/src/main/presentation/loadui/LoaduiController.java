package main.presentation.loadui;
 
  public class LoaduiController { 
  private LoadVehiclePanel loadVehicle; 
  private ReceiveListPanel receiveList; 
  private TransmitReceivePanel transmitReceive; 
  private LobbyLoadPanel lobbyLoadPanel;
  private IntermLoadingui interml;
  public void select(Loadui ui){ 
 	switch(ui){ 
 	case LOADVEHICLE: 
// 		loadVehicle=new LoadVehiclePanel(); 
// 		loadVehicle.init(); 
 		interml=new IntermLoadingui();
		break; 
 		 
 	case RECEIVELIST: 
 		receiveList=new ReceiveListPanel(); 
 		receiveList.init(); 
 		break; 
 		 
 	case TRANSMITRECEIVE: 
 		transmitReceive=new TransmitReceivePanel(); 
 		transmitReceive.init(); 
 		break; 
 	case LobbyLoading:
 		lobbyLoadPanel = new LobbyLoadPanel();
 		lobbyLoadPanel.init();
 		break;
 		default: 
 			break; 
 	} 
	} 
} 
