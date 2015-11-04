package presentation.mainui;

import presentation.guestui.Guestui;
import presentation.guestui.GuestuiController;
import presentation.rightui.Rightui;
import presentation.rightui.RightuiController;

public class MainController {
	@SuppressWarnings("unused")
	private static FrameMain frame;
	private static GuestuiController guestui=new GuestuiController();
	private static RightuiController rightui=new RightuiController();
	public static void start(){
		frame=FrameMain.createFrame();
		FrameMain.init();
		jumpToGuestui(Guestui.Search);
	}
	
	public static void jumpToGuestui(Guestui ui){
		guestui.select(ui);
	}
	
	public static void jumpToRightui(Rightui ui){
		rightui.select(ui);
	}
}
