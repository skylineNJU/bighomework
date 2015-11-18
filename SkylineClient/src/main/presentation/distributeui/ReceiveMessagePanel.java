package main.presentation.distributeui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class ReceiveMessagePanel {
	
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JLabel title;
	private JLabel codeLabel;
	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JTextField receiveCode;
	private JTextField receiverName;
	private JTextField phone;
	private JButton cancleButton;//取消
	private JButton saveButton;//保存
	
	public ReceiveMessagePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		allTextFiled();
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("收件信息输入");
		title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
		panel.add(title);
	}
	
	public void allTextFiled(){
		codeLabel = new JLabel("收件编号");
		nameLabel = new JLabel("收件人姓名");
		phoneLabel = new JLabel("联系方式");
		receiveCode = new JTextField();
		receiverName = new JTextField();
		phone = new JTextField();
		codeLabel.setBounds(panelWidth/8, panelHeight/4, panelWidth/10, panelHeight/20);
		nameLabel.setBounds(panelWidth/8, codeLabel.getY()+panelHeight/6, panelWidth/10, panelHeight/20);
		phoneLabel.setBounds(panelWidth/8, nameLabel.getY()+panelHeight/6, panelWidth/10, panelHeight/20);
		receiveCode.setBounds(codeLabel.getX()+panelWidth/8, panelHeight/4, panelWidth/2, panelHeight/20);
		receiverName.setBounds(nameLabel.getX()+panelWidth/8, codeLabel.getY()+panelHeight/6, panelWidth/2, panelHeight/20);
		phone.setBounds(phoneLabel.getX()+panelWidth/8, nameLabel.getY()+panelHeight/6, panelWidth/2, panelHeight/20);
		
		cancleButton = new JButton("取消");
		saveButton = new JButton("保存");
		cancleButton.setBounds(panelWidth*3/8, phone.getY()+panelHeight/6, panelWidth/8, panelHeight/20);
		saveButton.setBounds(panelWidth*5/8,phone.getY()+panelHeight/6, panelWidth/8, panelHeight/20);
		
		panel.add(codeLabel);
		panel.add(nameLabel);
		panel.add(phoneLabel);
		panel.add(receiveCode);
		panel.add(receiverName);
		panel.add(phone);
		panel.add(cancleButton);
		panel.add(saveButton);
	}
}
