package main.presentation.mainui;

import main.presentation.distributeui.Distributeui;
import main.presentation.distributeui.DistributeuiControl;
import main.presentation.financeui.Financeui;
import main.presentation.financeui.FinanceuiControl;
import main.presentation.guestui.Guestui;
import main.presentation.guestui.GuestuiController;
import main.presentation.receiveui.ReceiveController;
import main.presentation.receiveui.Receiveui;
import main.presentation.rightui.Rightui;
import main.presentation.rightui.RightuiController;
import main.presentation.warehouseui.Warehouseui;
import main.presentation.warehouseui.WarehouseuiController;

public class MainController {
	@SuppressWarnings("unused")
	private static FrameMain frame;

	private static WarehouseuiController warehouseuiControl=new WarehouseuiController();
	private static DistributeuiControl distributeuiControl = new DistributeuiControl();
	private static GuestuiController guestuiControl=new GuestuiController();
	private static RightuiController rightuiControl=new RightuiController();
	private static ReceiveController receiveuiControl=new ReceiveController();
	private static FinanceuiControl financeuiControl = new FinanceuiControl();

	private static CourierPanel courierpanel;
	private static FinanceStaffPanel financeStaffPanel;
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
	
	public static void jumpToDistributeui(Distributeui ui){
		distributeuiControl.select(ui);
	}
	
	public static void jumpToGuestui(Guestui ui){
		guestuiControl.select(ui);
	}
	
	public static void jumpToFinanceui(Financeui ui){
		financeuiControl.select(ui);
	}
	public static void jumpToRightui(Rightui ui){
		rightuiControl.select(ui);
	}
	
	public static void jumpToReceiveui(Receiveui ui){
		receiveuiControl.select(ui);
	}
	
	public static void jumpToWarehouseui(Warehouseui ui){
		 warehouseuiControl.select(ui);
	}

	public static void goToCourierui(){
		courierpanel=new CourierPanel();
		courierpanel.init();
		FrameMain.getContentPanel().add(writepanel);
		jumpToReceiveui(Receiveui.OrderInput);
	}
	
	public static void gotoFinanceui(){
		financeStaffPanel = new FinanceStaffPanel();
		financeStaffPanel.init();
		FrameMain.getContentPanel().add(writepanel);
		jumpToFinanceui(Financeui.Balanceui);
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
