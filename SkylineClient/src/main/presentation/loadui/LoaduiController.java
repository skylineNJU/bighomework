package main.presentation.loadui;

public class LoaduiController {
	
private LoadVehiclePanel loadVehicle;
private LobbyLoadPanel lobbyLoadPanel;

public void select(Loadui ui){
	switch(ui){
	case LOADVEHICLE:
		loadVehicle=new LoadVehiclePanel();
		loadVehicle.init();
		break;
	case LobbyLoading:
		lobbyLoadPanel = new LobbyLoadPanel();
		lobbyLoadPanel.init();
		default:
			break;
	}
}
}
