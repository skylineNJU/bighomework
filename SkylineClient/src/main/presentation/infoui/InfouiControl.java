package main.presentation.infoui;

public class InfouiControl {
	private VehicleMessagePanel vehicleMessagePanel;
	private DriverMessagePanel driverMessagePanel;
	private ManagerStaffPanel managerStaffPanel;
	private InstitutionPanel institutionPanel;
	
	public void select(Infoui ui){
		switch(ui){
		case DriverMessage:
			driverMessagePanel = new DriverMessagePanel();
			driverMessagePanel.init();
			break;
		case VehicleMessage:
			vehicleMessagePanel = new VehicleMessagePanel();
			vehicleMessagePanel.init();
			break;
		case StaffMessage:
			managerStaffPanel = new ManagerStaffPanel();
			managerStaffPanel.init();
			break;
		case Institutionui:
			institutionPanel = new InstitutionPanel();
			institutionPanel.init();
			break;
		default:
			break;
		}
	}
}
