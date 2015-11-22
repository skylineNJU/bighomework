package main.presentation.rightui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import main.presentation.guestui.Guestui;
import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;

public class LoginPanel {
	private JTextField userName=new JTextField("141250024");
	private JTextField passWord=new JTextField("141250024");
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
		passWord.setSize(frame.getWidth()/2,frame.getHeight()/10);
		userName.setLocation(frame.getWidth()/4,frame.getHeight()/5*2);
		passWord.setLocation(frame.getWidth()/4, frame.getHeight()/5*3);
		panel.add(userName);
		panel.add(passWord);
		confirm.setSize(frame.getWidth()/10, frame.getHeight()/10);
		confirm.setLocation(frame.getWidth()/10*3,
				passWord.getY()+passWord.getHeight()+confirm.getHeight()/3);
		back.setSize(frame.getWidth()/10, frame.getHeight()/10);
		back.setLocation(frame.getWidth()/10*6,
				passWord.getY()+passWord.getHeight()+confirm.getHeight()/3);
		panel.add(back);
		panel.add(confirm);
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				panel.repaint();
				MainController.jumpToGuestui(Guestui.Search);
			}
		});
		confirm.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String username=userName.getText();
				String password=passWord.getText();
				switch(username){
				case "141250029":    //快递员账号
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.goToCourierui();
					}
					break;
					
				case "141250028":    //营业厅业务员账号
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.goToLobbyStaffui();
					}
					break;
					
				case "141250027":    //中转中心业务员账号 
					if(password.equals(username)){
						remove();
						panel.repaint();
						//panel.add(FrameMain.getContentPanel());
						MainController.goToIntermediateStaffui();
					}
					break;
					
				case "141250026":    //中转仓库管理人员账号
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.goToWarehouseui();
					}
					break;
					
				case "141250025":    //财务管理人员账号
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.gotoFinanceui();	
					}
					break;
					
				case "141250024":    //总经理账号
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.goToManagerui();
					}
					break;
					
				case "141250023":    //账户管理人员账号
					if(password.equals(username)){
					remove();
					panel.repaint();
					MainController.goToRightAdminStaffui();

					}
					break;
				}
			}
		});
		panel.repaint();
	}
	
	public void remove(){
		panel.remove(back);
		panel.remove(passWord);
		panel.remove(confirm);
		panel.remove(userName);
	}
}
