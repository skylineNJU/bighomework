package main.presentation.rightui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class PasswordInitPanel {
	private JPanel panel;
	private JLabel accountNameLabel;
	private JTextField accountName;
	private JButton submit;
	private JButton cancel;
	private JLabel title;
	private int panelWidth;
	private int panelHeight;
	
	public PasswordInitPanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	public void init(){
		initTitle();
		initLabel();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("银行账户");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	public void initLabel(){
		accountNameLabel = new JLabel("请输入账户名");
		accountName = new JTextField();
		submit = new JButton("确认初始化");
		cancel = new JButton("取消初始化");
		
		panel.add(accountNameLabel);
		panel.add(accountName);
		panel.add(submit);
		panel.add(cancel);
		
		accountNameLabel.setBounds(panelWidth/5, panelHeight*2/5, panelWidth/10, panelHeight/15);
		accountName.setBounds(panelWidth*2/5, panelHeight*2/5, panelWidth/5, panelHeight/15);
		cancel.setBounds(panelWidth*2/5, panelHeight*4/5, panelWidth/10, panelHeight/15);
		submit.setBounds(panelWidth/2, panelHeight*4/5, panelWidth/10, panelHeight/15);
	}
}
