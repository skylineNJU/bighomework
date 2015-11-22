package main.presentation.loadui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.presentation.mainui.MainController;

public class TransmitReceivePanel {
private JPanel panel;//大的
private JPanel innerPanel;//小的
private JLabel title;
	public TransmitReceivePanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	public void init(){
		
		innerPanel=new JPanel();
		
		innerPanel.setBackground(Color.gray);
		innerPanel.setSize(panel.getWidth()/5*4+20,panel.getHeight()/5*4);
		
		innerPanel.setLocation(panel.getWidth()/8-25,panel.getHeight()/8-16);
		panel.add(innerPanel);
		innerPanel.setLayout(null);
		
		
		panel.repaint();
		
	}
}
