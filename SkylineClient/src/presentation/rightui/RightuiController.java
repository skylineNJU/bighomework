package presentation.rightui;

import presentation.mainui.RightAdminStaffPanel;

public class RightuiController {
	private LoginPanel login;
	private PasswordInitPanel passwordInit;
	private RightAdminPanel rightAdmin;
	public void select(Rightui ui){
		switch(ui){
		case Login:
			login=new LoginPanel();
			login.init();
			break;
		case RightAdmin:
			rightAdmin=new RightAdminPanel();
			rightAdmin.init();
			break;
		case PasswordInit:
			passwordInit=new PasswordInitPanel();
			passwordInit.init();
		}
	}
}
