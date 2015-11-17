package main.presentation.financeui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.presentation.mainui.MainController;

public class BalancePanel {
	
	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	private JLabel title;
	
	public BalancePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		JButton button = new JButton("成功了吗？！");
		button.setBounds(100, 100, 100, 100);
		panel.add(button);
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("账户管理");
		title.setBounds(panelWidth/3, 20, panelWidth/6, 40);
		panel.add(title);
	}
}
