package presentation.rightui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import presentation.guestui.Guestui;
import presentation.mainui.FrameMain;
import presentation.mainui.MainController;

public class LoginPanel {
	private JTextField userName=new JTextField("请输入账户名");
	private JTextField code=new JTextField("请输入密码");
	private JLabel confirm=new JLabel("确定");
	private JLabel back=new JLabel("返回");
	private FrameMain frame;
	private JPanel panel;
	
	public LoginPanel(){
		frame=FrameMain.getFrame();
		panel=FrameMain.getContentPanel();
	}
	
	public void init(){
		userName.setSize(frame.getWidth()/2,frame.getHeight()/10);
		code.setSize(frame.getWidth()/2,frame.getHeight()/10);
		userName.setLocation(frame.getWidth()/4,frame.getHeight()/5*2);
		code.setLocation(frame.getWidth()/4, frame.getHeight()/5*3);
		panel.add(userName);
		panel.add(code);
		confirm.setSize(frame.getWidth()/10, frame.getHeight()/10);
		confirm.setLocation(frame.getWidth()/10*3,
				code.getY()+code.getHeight()+confirm.getHeight()/3);
		back.setSize(frame.getWidth()/10, frame.getHeight()/10);
		back.setLocation(frame.getWidth()/10*6,
				code.getY()+code.getHeight()+confirm.getHeight()/3);
		panel.add(back);
		panel.add(confirm);
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				panel.repaint();
				MainController.jumpToGuestui(Guestui.Search);
			}
		});
		panel.repaint();
	}
	
	public void remove(){
		panel.remove(back);
		panel.remove(code);
		panel.remove(confirm);
		panel.remove(userName);
	}
}
