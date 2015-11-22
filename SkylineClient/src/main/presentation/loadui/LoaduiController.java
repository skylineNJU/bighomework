package main.presentation.loadui; 
 
  public class LoaduiController { 
  private LoadVehiclePanel loadVehicle; 
  private ReceiveListPanel receiveList; 
  private TransmitReceivePanel transmitReceive; 
  public void select(Loadui ui){ 
 	switch(ui){ 
 	case LOADVEHICLE: 
 		loadVehicle=new LoadVehiclePanel(); 
 		loadVehicle.init(); 
		break; 
 		 
 	case RECEIVELIST: 
 		receiveList=new ReceiveListPanel(); 
 		receiveList.init(); 
 		break; 
 		 
 	case TRANSMITRECEIVE: 
 		transmitReceive=new TransmitReceivePanel(); 
 		transmitReceive.init(); 
 		break; 
 		 
 		default: 
 			break; 
 	} 
	} 
} 
