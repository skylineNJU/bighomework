package presentation.mainui;

import javax.swing.*;

import presentation.receiveui.LobbyReceivePanel;
import socketservice.Client;

public class MainFrame{
	private JFrame frame;
	private LobbyReceivePanel lobbyreceivepanel;
	private static Client client;
	public MainFrame(){
		frame=new JFrame();
		frame.setBounds(100, 200,500,500);
		lobbyreceivepanel=new LobbyReceivePanel();
		frame.add(lobbyreceivepanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client=new Client();
	}

	
    public static void main(String args[]){
    	MainFrame frame=new MainFrame();
    	
    }


	public static Client getClient() {
		return client;
	}

}
