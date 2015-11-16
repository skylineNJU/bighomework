package main.presentation.rightui;

import javax.swing.JPanel;

import main.presentation.mainui.MainController;

public class RightAdminPanel {
	private JPanel panel;
	
	public RightAdminPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		
	}
}
