package presentation.mainui;

import javax.swing.*;

import presentation.receiveui.LobbyReceivePanel;

public class MainFrame{
	private JFrame frame;
	private LobbyReceivePanel lobbyreceivepanel;
	public MainFrame(){
		frame=new JFrame();
		frame.setBounds(100, 200,500,500);
		lobbyreceivepanel=new LobbyReceivePanel();
		frame.add(lobbyreceivepanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String args[]){
    	MainFrame frame=new MainFrame();
    }
}
