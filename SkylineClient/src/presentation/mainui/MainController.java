package presentation.mainui;


import presentation.guestui.Guestui;
import presentation.guestui.GuestuiController;
import presentation.loadui.LoaduiController;
import presentation.receiveui.ReceiveController;
import presentation.receiveui.Receiveui;
import presentation.rightui.Rightui;
import presentation.rightui.RightuiController;

public class MainController {
	@SuppressWarnings("unused")
	private static FrameMain frame;
	private static GuestuiController guestui=new GuestuiController();
	private static RightuiController rightui=new RightuiController();
	private static ReceiveController receiveui=new ReceiveController();
	private static LoaduiController loadui=new LoaduiController();
	private static CourierPanel courierpanel;
	private static WritePanel writepanel;
	private static IntermediateStaffPanel intermediateStaffPanel;
	private static RightAdminStaffPanel rightAdminStaffPanel;
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

	public static WritePanel getWritepanel() {
		return writepanel;
	}

}
