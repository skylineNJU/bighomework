package main.presentation.rightui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import main.State.Rights;
import main.businesslogicservice.RightBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.guestui.Guestui;
import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;
import main.vo.AccountVO;
import main. State.Rights;

public class LoginPanel {
	private JTextField userName=new JTextField("141250024");
	private JTextField passWord=new JTextField("141250024");
	private JLabel confirm=new JLabel("确定");
	private JLabel back=new JLabel("返回");
	private FrameMain frame;
	private JPanel panel;
	private JLabel uIcon;
	private JLabel pIcon;
	
	public LoginPanel(){
		frame=FrameMain.getFrame();
		panel=FrameMain.getContentPanel();
	}
	
	public void init(){
		uIcon = new JLabel("Icon");
		uIcon.setBounds(frame.getWidth()/20*12,frame.getHeight()/20*7,frame.getWidth()/10,frame.getHeight()/10);
		uIcon.setVisible(true);
		pIcon = new JLabel("Icon");		
		pIcon.setBounds(frame.getWidth()/20*12,frame.getHeight()/20*10,frame.getWidth()/10,frame.getHeight()/10);
		pIcon.setVisible(true);
		userName.setBounds(frame.getWidth()/20*13,frame.getHeight()/20*7,frame.getWidth()/10*3,frame.getHeight()/10);
		passWord.setBounds(frame.getWidth()/20*13,frame.getHeight()/20*10,frame.getWidth()/10*3,frame.getHeight()/10);
		panel.add(uIcon);
		panel.add(pIcon);
		panel.add(userName);
		panel.add(passWord);

		confirm.setBounds(frame.getWidth()/40*28,frame.getHeight()/40*25,frame.getWidth()/10,frame.getHeight()/10);
		back.setBounds(frame.getWidth()/40*34,frame.getHeight()/40*25,frame.getWidth()/10,frame.getHeight()/10);
	
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
				AccountVO account=	new AccountVO(username, password);
				RightBLService  service  = ConstructFactory.RightFactory();
				service.login(account);
				
				switch(account.getRight()){
					case ACCOUNT:
						remove();
						panel.repaint();
						MainController.goToRightAdminStaffui(account.getBelong());
						break;
					case COURIER:
						remove();
						panel.repaint();
						MainController.goToCourierui(account.getBelong());
						break;
					case FINANCE:
						remove();
						panel.repaint();
						MainController.gotoFinanceui(account.getBelong());	
						break;
					case INTERMEDIATE:
						remove();
						panel.repaint();
						MainController.goToIntermediateStaffui(account.getBelong());
						break;
					case LOBBY:
						remove();
						panel.repaint();
						MainController.goToLobbyStaffui(account.getBelong());
						break;
					case MANAGER:
						remove();
						panel.repaint();
						MainController.goToManagerui(account.getBelong());
						break;
					case STOREHOUSE:
						remove();
						panel.repaint();
						MainController.goToWarehouseui(account.getBelong());
						break;
					default:
						System.err.println("密码或用户名错误！");
						break;
						
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		/*		switch(username){
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
			*/
			}
		});
		panel.repaint();
	}
	
	public void remove(){
		panel.remove(uIcon);
		panel.remove(pIcon);
		panel.remove(back);
		panel.remove(passWord);
		panel.remove(confirm);
		panel.remove(userName);
	}
}
