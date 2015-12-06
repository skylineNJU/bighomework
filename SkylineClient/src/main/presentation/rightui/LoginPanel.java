package main.presentation.rightui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

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
import main.presentation.mainui.AllImage;
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



public class LoginPanel{
	private JTextField userName=new JTextField("011900017");
	private JTextField passWord=new JTextField("00000000");

	private JLabel confirm=new JLabel("");//log in��ť
	private JLabel back=new JLabel("");
	private FrameMain frame;
	private JPanel panel;
	private JLabel login;
	private JLabel show=new JLabel("");//��ʾ������
	private JLabel forget=new JLabel("");//��������
      
	
	public LoginPanel(){
		frame=FrameMain.getFrame();
		panel=FrameMain.getContentPanel();
	}
	public void init(){
		int w=frame.getWidth();
		int h=frame.getHeight();
		
		AllImage.login_username.setImage(AllImage.login_username.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.login.setImage(AllImage.login.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.login_back.setImage(AllImage.login_back.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.login_login.setImage(AllImage.login_login.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.login_password.setImage(AllImage.login_password.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.login_show.setImage(AllImage.login_show.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.login_forget.setImage(AllImage.login_forget.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
	
		userName.setOpaque(false);
		userName.setBorder(null);
		userName.setFont(new Font("����",Font.PLAIN,18));
		userName.setForeground(Color.WHITE);
		userName.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				login.setIcon(AllImage.login_username);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				login.setIcon(AllImage.login);
				panel.repaint();
			}
		});
		passWord.setOpaque(false);
		passWord.setBorder(null);
		passWord.setFont(new Font("����",Font.PLAIN,18));
		passWord.setForeground(Color.WHITE);
		passWord.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				login.setIcon(AllImage.login_password);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				login.setIcon(AllImage.login);
				panel.repaint();
			}
		});
		show.setOpaque(false);
		show.setSize(w*38/851,h*12/576);
		show.setLocation(w*506/851,h*300/576);
		show.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				login.setIcon(AllImage.login_show);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				login.setIcon(AllImage.login);
				panel.repaint();
			}
		});
		
		forget.setOpaque(false);
		forget.setSize(w*113/851,h*15/576);
		forget.setLocation(w*354/851,h*470/576);
		forget.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				login.setIcon(AllImage.login_forget);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				login.setIcon(AllImage.login);
				panel.repaint();
			}
		});
//����
		login=new JLabel(AllImage.login);
		login.setSize(panel.getWidth(),panel.getHeight());
		login.setLocation(0,0);
		userName.setSize(w*152/851,h*38/576);
		userName.setLocation(w*293/851,h*234/576);
		passWord.setSize(w*152/851,h*38/576);
		passWord.setLocation(w*293/851,h*317/576);
		
		back.setOpaque(false);
		back.setSize(w*32/851,h*29/576);
		back.setLocation(w*275/851,h*105/576);
		
		confirm.setOpaque(false);
		confirm.setSize(w*230/851,h*46/576);
		confirm.setLocation(w*298/851,h*406/576);
		System.out.println("Frame��"+frame.getWidth()+"   "+frame.getHeight());
		panel.add(userName);
		panel.add(passWord);
		panel.add(back);
		panel.add(confirm);
		panel.add(forget);
		panel.add(show);
		panel.add(login);
		panel.repaint();
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				panel.removeAll();
				panel.repaint();
				MainController.jumpToGuestui(Guestui.Search);
			}
			public void mouseEntered(MouseEvent e){
				login.setIcon(AllImage.login_back);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				login.setIcon(AllImage.login);
				panel.repaint();
			}
		});
		
		confirm.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				login.setIcon(AllImage.login_login);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				login.setIcon(AllImage.login);
				panel.repaint();
			}
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
						panel.removeAll();
						panel.repaint();
						MainController.goToRightAdminStaffui(account.getBelong());
						break;
					case COURIER:
						CourrierReceipt Receiptservice=ConstructFactory.CourrierReceiptFactory();
						CorrierReceiptVO Courrier=Receiptservice.getAllReceipt(username);
						MainController.getWritepanel().setMemory(new CourrierMemory(username,password,Courrier.getOrderCode()
								,Courrier.getBuildDate(),Courrier.getReceiveCode(),Courrier.getReceiveDate(),
						Courrier.getDistributeCode()));
						panel.removeAll();
						panel.repaint();
						MainController.goToCourierui(account.getBelong());
						break;
					case FINANCE:
						FinanceReceipt financeService=ConstructFactory.FinanceReceiptFactory();
						FinanceReceiptVO financeVO=financeService.getFinanceCode(username);
						MainController.getWritepanel().setMemory(new FinanceMemory(username,password,financeVO.getCostCode()
						,financeVO.getEarnCode()));
						panel.removeAll();
						panel.repaint();
						MainController.gotoFinanceui(account.getBelong());	
						break;
					case INTERMEDIATE:
						IntermediateReceipt intermediate=ConstructFactory.IntermediateFactory();
						IntermediateReciptVO intermediateVO=intermediate.getIntermediateReceiptCode(username);
						MainController.getWritepanel().setMemory(new IntermediateMemory(username,password,
								intermediateVO.getIntermReceiptCode(),intermediateVO.getAirLoadCode(),intermediateVO.getRailLoadCode(),intermediateVO.getRoadLoadCode()
								,intermediateVO.getAirLoadDate(),intermediateVO.getRailLoadDate(),intermediateVO.getRoadLoadDate(),intermediateVO.getIntermDate()));
						panel.removeAll();
						panel.repaint();
						MainController.goToIntermediateStaffui(account.getBelong());
						break;
					case LOBBY:
						LobbyReceipt lobbyService=ConstructFactory.LobbyReceiptFactory();
						LobbyReceiptVO lobbyVO=lobbyService.getLobbyReceiptCode(username);
						System.out.println(lobbyVO.getReceiveCode());
						MainController.getWritepanel().setMemory(new LobbyMemory(username,password,lobbyVO.getReceiveCode(),
								lobbyVO.getEarnCode(),lobbyVO.getReceiveDate(),lobbyVO.getEarnDate(),lobbyVO.getLobbyLoading()));
						panel.removeAll();
						panel.repaint();
						MainController.goToLobbyStaffui(account.getBelong());
						break;
					case MANAGER:
						SubmitReceipt manager=ConstructFactory.SubMitFactory();
						ApprovalVO manvo=manager.getApproval();
						MainController.getWritepanel().setMemory(new ManagerMemory(username,password,manvo.getKinds(),manvo.getCode()));
						panel.removeAll();
						panel.repaint();
						MainController.goToManagerui(account.getBelong());
						break;
					case STOREHOUSE:
						panel.removeAll();
						panel.repaint();
						WarehouseReceipt receipt=ConstructFactory.WarehouseReceiptFactory();
						WarhouseReceiptVO Warehouse=new WarhouseReceiptVO(null,null,null,null,null,username);
						Warehouse=receipt.inquireWarehouseReceipt(Warehouse);
						System.out.println("---------"+Warehouse.getWarehouseInCode());
						MainController.getWritepanel().setMemory(new WarehouseMemory(username,password,Warehouse.getWarehouseInCode()
								,Warehouse.getWarehouseInDate(),Warehouse.getWarehouseOutCode(),Warehouse.getWarehouseOutDate()));
						MainController.goToWarehouseui(account.getBelong());
						break;
					default:
						System.err.println("������û�������");
						break;
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		/*		switch(username){
				case "141250029":    //���Ա�˺�
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.goToCourierui();
					}
					break;
					
				case "141250028":    //Ӫҵ��ҵ��Ա�˺�
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.goToLobbyStaffui();
					}
					break;
					
				case "141250027":    //��ת����ҵ��Ա�˺� 
					if(password.equals(username)){
						remove();
						panel.repaint();
						//panel.add(FrameMain.getContentPanel());
						MainController.goToIntermediateStaffui();
					}
					break;
					
				case "141250026":    //��ת�ֿ������Ա�˺�
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.goToWarehouseui();
					}
					break;
					
				case "141250025":    //���������Ա�˺�
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.gotoFinanceui();	
					}
					break;
					
				case "141250024":    //�ܾ����˺�
					if(password.equals(username)){
						remove();
						panel.repaint();
						MainController.goToManagerui();
					}
					break;
					
				case "141250023":    //�˻�������Ա�˺�
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
	
		panel.remove(back);
		panel.remove(passWord);
		panel.remove(confirm);
		panel.remove(userName);
	}
}

