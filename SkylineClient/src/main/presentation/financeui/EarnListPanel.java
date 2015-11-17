package main.presentation.financeui;

import javax.swing.JPanel;

import main.presentation.mainui.MainController;

public class EarnListPanel {
	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	
	public EarnListPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		panel.repaint();
	}
}
