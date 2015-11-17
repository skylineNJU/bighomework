package main.presentation.financeui;

import javax.swing.JPanel;

import main.presentation.mainui.MainController;

public class StatisticsListPanel {
	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	
	public StatisticsListPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		panel.repaint();
	}
}
