package main.presentation.rightui;

import main.presentation.mainui.RightAdminStaffPanel;

@SuppressWarnings("unused")
public class RightuiController {
	private LoginPanel login;
	private PasswordInitPanel passwordInit;
	private ModifyPassWordPanel modifyPassWordPanel;
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
			passwordInit = new PasswordInitPanel();
			passwordInit.init();
			break;
		case ModifyPassWord:
			modifyPassWordPanel = new ModifyPassWordPanel();
			modifyPassWordPanel.init();
			break;
		default:
			break;
		}
	}
}
