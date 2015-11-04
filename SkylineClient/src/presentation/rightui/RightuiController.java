package presentation.rightui;

public class RightuiController {
	private LoginPanel login;
	public void select(Rightui ui){
		switch(ui){
		case Login:
			login=new LoginPanel();
			login.init();
			break;
		}
	}
}
