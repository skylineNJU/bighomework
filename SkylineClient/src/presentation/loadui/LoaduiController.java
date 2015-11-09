package presentation.loadui;

public class LoaduiController {
private LoadVehiclePanel loadVehicle;
public void select(Loadui ui){
	switch(ui){
	case LOADVEHICLE:
		loadVehicle=new LoadVehiclePanel();
		loadVehicle.init();
		break;
		
		default:
			break;
	}
}
}
