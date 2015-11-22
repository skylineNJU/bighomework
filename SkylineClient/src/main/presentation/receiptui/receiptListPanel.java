package main.presentation.receiptui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.presentation.mainui.MainController;

//���յ�
public class ReceiptListPanel {
	
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JLabel title;
	
	public ReceiptListPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		panel.repaint();
	}
	
	//����
	public void title(){
		title = new JLabel("���յ�");
		title.setBounds(panelWidth/3, panelHeight/20, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	
}
