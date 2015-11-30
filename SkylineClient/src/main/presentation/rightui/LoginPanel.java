package main.presentation.rightui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import main.businesslogicservice.RightBLService;
import main.businesslogicservice.receiptblService.CourrierReceipt;
import main.businesslogicservice.receiptblService.FinanceReceipt;
import main.businesslogicservice.receiptblService.IntermediateReceipt;
import main.businesslogicservice.receiptblService.LobbyReceipt;
import main.businesslogicservice.receiptblService.SubmitReceipt;
import main.businesslogicservice.receiptblService.WarehouseReceipt;
import main.constructfactory.ConstructFactory;
import main.presentation.guestui.Guestui;
import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;
import main.presentation.mainui.memory.CourrierMemory;
import main.presentation.mainui.memory.FinanceMemory;
import main.presentation.mainui.memory.IntermediateMemory;
import main.presentation.mainui.memory.LobbyMemory;
import main.presentation.mainui.memory.ManagerMemory;
import main.presentation.mainui.memory.WarehouseMemory;
import main.vo.AccountVO;
import main.vo.ApprovalVO;
import main.vo.CorrierReceiptVO;
import main.vo.FinanceReceiptVO;
import main.vo.IntermediateReciptVO;
import main.vo.LobbyReceiptVO;
import main.vo.WarhouseReceiptVO;

public class LoginPanel {
	private JTextField userName=new JTextField("000890004");
	private JTextField passWord=new JTextField("12345678");
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
				System.out.println();
				System.out.println("username: "+username);
				AccountVO account=	new AccountVO(username, password);
				RightBLService  service  = ConstructFactory.RightFactory();
				service.login(account);
				System.out.println("get login message");
				switch(account.getRight()){
					case ACCOUNT:
						remove();
						panel.repaint();
						MainController.goToRightAdminStaffui(account.getBelong());
						break;
					case COURIER:
						CourrierReceipt Receiptservice=ConstructFactory.CourrierReceiptFactory();
						CorrierReceiptVO Courrier=Receiptservice.getAllReceipt(username);
						MainController.getWritepanel().setMemory(new CourrierMemory(username,password,Courrier.getOrderCode()
								,Courrier.getBuildDate(),Courrier.getReceiveCode(),Courrier.getReceiveDate(),
						Courrier.getDistributeCode()));
						remove();
						panel.repaint();
						MainController.goToCourierui(account.getBelong());
						break;
					case FINANCE:
						FinanceReceipt financeService=ConstructFactory.FinanceReceiptFactory();
						FinanceReceiptVO financeVO=financeService.getFinanceCode(username);
						MainController.getWritepanel().setMemory(new FinanceMemory(username,password,financeVO.getCostCode()
						,financeVO.getEarnCode()));
						remove();
						panel.repaint();
						MainController.gotoFinanceui(account.getBelong());	
						break;
					case INTERMEDIATE:
						IntermediateReceipt intermediate=ConstructFactory.IntermediateFactory();
						IntermediateReciptVO intermediateVO=intermediate.getIntermediateReceiptCode(username);
						MainController.getWritepanel().setMemory(new IntermediateMemory(username,password,
								intermediateVO.getIntermReceiptCode(),intermediateVO.getAirLoadCode(),intermediateVO.getRailLoadCode(),intermediateVO.getRoadLoadCode()
								,intermediateVO.getAirLoadDate(),intermediateVO.getRailLoadDate(),intermediateVO.getRoadLoadDate(),intermediateVO.getIntermDate()));
						remove();
						panel.repaint();
						MainController.goToIntermediateStaffui(account.getBelong());
						break;
					case LOBBY:
						LobbyReceipt lobbyService=ConstructFactory.LobbyReceiptFactory();
						LobbyReceiptVO lobbyVO=lobbyService.getLobbyReceiptCode(username);
						System.out.println(lobbyVO.getReceiveCode());
						MainController.getWritepanel().setMemory(new LobbyMemory(username,password,lobbyVO.getReceiveCode(),
								lobbyVO.getEarnCode(),lobbyVO.getReceiveDate(),lobbyVO.getEarnDate(),lobbyVO.getLobbyLoading()));
						remove();
						panel.repaint();
						MainController.goToLobbyStaffui(account.getBelong());
						break;
					case MANAGER:
						SubmitReceipt manager=ConstructFactory.SubMitFactory();
						ApprovalVO manvo=manager.getApproval();
						MainController.getWritepanel().setMemory(new ManagerMemory(username,password,manvo.getKinds(),manvo.getCode()));
						remove();
						panel.repaint();
						MainController.goToManagerui(account.getBelong());
						break;
					case STOREHOUSE:
						remove();
						panel.repaint();
						WarehouseReceipt receipt=ConstructFactory.WarehouseReceiptFactory();
						WarhouseReceiptVO Warehouse=new WarhouseReceiptVO(null,null,null,username);
						Warehouse=receipt.inquireWarehouseReceipt(Warehouse);
						System.out.println("---------"+Warehouse.getWarehouseInCode());
						MainController.getWritepanel().setMemory(new WarehouseMemory(username,password,Warehouse.getWarehouseInCode()
								,Warehouse.getWarehouseOutCode()));
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
