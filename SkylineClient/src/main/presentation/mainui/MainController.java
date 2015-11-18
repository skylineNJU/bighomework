package main.presentation.mainui;

import main.presentation.guestui.Guestui;
import main.presentation.guestui.GuestuiController;
import main.presentation.loadui.LoaduiController;
import main.presentation.receiveui.ReceiveController;
import main.presentation.receiveui.Receiveui;
import main.presentation.rightui.Rightui;
import main.presentation.rightui.RightuiController;
import main.presentation.warehouseui.Warehouseui;
import main.presentation.warehouseui.WarehouseuiController;

public class MainController {
	@SuppressWarnings("unused")
	private static FrameMain frame;
	private static GuestuiController guestui=new GuestuiController();
	private static RightuiController rightui=new RightuiController();
	private static ReceiveController receiveui=new ReceiveController();
	private static WarehouseuiController warehouseui=new WarehouseuiController();
	private static CourierPanel courierpanel;
	private static WritePanel writepanel;
	private static IntermediateStaffPanel intermediateStaffPanel;
	private static RightAdminStaffPanel rightAdminStaffPanel;
	private static WarehousePanel warehousepanel;
	public static void start(){
		frame=FrameMain.createFrame();
		FrameMain.init();
		writepanel=new WritePanel();
		jumpToGuestui(Guestui.Search);
	}
	
	public static void jumpToGuestui(Guestui ui){
		guestui.select(ui);
	}
	
	public static void jumpToRightui(Rightui ui){
		rightui.select(ui);
	}
	
	public static void jumpToReceiveui(Receiveui ui){
		receiveui.select(ui);
	}
	
	public static void jumpToWarehouseui(Warehouseui ui){
		warehouseui.select(ui);
	}
	
	public static void goToCourierui(){
		courierpanel=new CourierPanel();
		courierpanel.init();
		FrameMain.getContentPanel().add(writepanel);
		jumpToReceiveui(Receiveui.OrderInput);
	}
	
	public static void goToRightAdminStaffui(){
		rightAdminStaffPanel=new RightAdminStaffPanel();
		rightAdminStaffPanel.init();
		FrameMain.getContentPanel().add(writepanel);
		jumpToRightui(Rightui.RightAdmin);
	}
	public static void goToIntermediateStaffui(){
		intermediateStaffPanel=new IntermediateStaffPanel();
		intermediateStaffPanel.init();
		FrameMain.getContentPanel().add(writepanel);
		
	
	}
	public static void goToWarehouseui(){
		warehousepanel=new WarehousePanel();
		warehousepanel.init();
		FrameMain.getContentPanel().add(writepanel);
		jumpToWarehouseui(Warehouseui.AddWarehouseInReceipt);
		jumpToWarehouseui(Warehouseui.AddWarehouseOutReceipt);
		jumpToWarehouseui(Warehouseui.ShowInventory);
		jumpToWarehouseui(Warehouseui.CheckInventory);
	}

	public static WritePanel getWritepanel() {
		return writepanel;
	}

}
