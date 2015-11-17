package main.presentation.financeui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.presentation.mainui.MainController;

public class StatisticsListPanel {
	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	private JLabel title;
	
	public StatisticsListPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		JButton button = new JButton("统计报表界面");
		button.setBounds(100, 100, 200, 80);
		panel.add(button);
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("统计报表");
		title.setBounds(panelWidth/3, 20, panelWidth/6, 40);
		panel.add(title);
	}
}
