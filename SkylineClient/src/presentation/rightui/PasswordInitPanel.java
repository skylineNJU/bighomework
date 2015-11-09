package presentation.rightui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.mainui.FrameMain;
import presentation.mainui.MainController;

public class PasswordInitPanel {
	private JPanel panel;
	private JLabel accountNameLabel;
	private JLabel newPasswordLabel;
	private JLabel newPasswordConfirmLabel;
	private JTextField accountName;
	private JTextField newPassword;
	private JTextField newPasswordConfirm;
	private JButton submit;
	private JButton cancel;
	
	public PasswordInitPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	public void init(){
		
	}
}
