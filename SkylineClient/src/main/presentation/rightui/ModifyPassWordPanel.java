package main.presentation.rightui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class ModifyPassWordPanel {
	
	private int panelWidth;
	private int panelHeight;
	private JLabel label1;//ÇëÊäÈë¾ÉÃÜÂë
	private JLabel label2;//ÇëÊäÈëĞÂÃÜÂë
	private JLabel label3;//ÇëÈ·ÈÏĞÂÃÜÂë
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JPanel panel;
	private JLabel title;
	private JButton saveButton;
	
	public ModifyPassWordPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title = new JLabel("ĞŞ¸ÄÃÜÂë");
		title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
		label1 = new JLabel("ÇëÊäÈë¾ÉÃÜÂë");
		label1.setBounds(panelWidth/10, panelHeight/5, panelWidth/5, panelHeight/20);
		text1 = new JTextField();
		text1.setBounds(panelWidth*3/10, panelHeight/5, panelWidth*2/5, panelHeight/20);
		label2 = new JLabel("ÇëÊäÈë¾ÉÃÜÂë");
		label2.setBounds(panelWidth/10, panelHeight*2/5, panelWidth/5, panelHeight/20);
		text2 = new JTextField();
		text2.setBounds(panelWidth*3/10, panelHeight*2/5, panelWidth*2/5, panelHeight/20);
		label3 = new JLabel("ÇëÊäÈë¾ÉÃÜÂë");
		label3.setBounds(panelWidth/10, panelHeight*3/5, panelWidth/5, panelHeight/20);
		text3 = new JTextField();
		text3.setBounds(panelWidth*3/10, panelHeight*3/5, panelWidth*2/5, panelHeight/20);
		saveButton = new JButton("±£´æ");
		saveButton.setBounds(panelWidth*7/10, panelHeight*4/5, panelWidth/10, panelHeight/20);
		
		panel.add(title);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		panel.add(saveButton);
		panel.repaint();
	}
	public void remove(){
		panel.remove(title);
		panel.remove(label1);
		panel.remove(label2);
		panel.remove(label3);
		panel.remove(text1);
		panel.remove(text2);
		panel.remove(text3);
		panel.remove(saveButton);
	}
	
}
