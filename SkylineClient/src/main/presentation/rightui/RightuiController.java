package main.presentation.rightui;

import main.presentation.mainui.RightAdminStaffPanel;

@SuppressWarnings("unused")
public class RightuiController {
	private LoginPanel login;
	private ModifyPassWordPanel passwordInit;
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
			passwordInit=new ModifyPassWordPanel();
			passwordInit.init();
		}
	}
}
