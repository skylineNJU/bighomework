package main.socketservice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;

import main.serverFrame.MyFrame;

public class Server extends Thread {
	private ServerSocket ss;
	private static boolean startServer = false;
	public void startServer(){
		try {
//			Timer timer=new Timer();
//			timer.schedule(new TimerTask(),new Date());
//			System.out.println("timer start success");
			ss=new ServerSocket(12345);
			System.out.println("server start");
			while(true){
			Socket socket=ss.accept();
			Thread clientThread=new Thread(new ClientHander(socket));
			clientThread.start();
			System.out.println("got a connection");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		MyFrame frame = new MyFrame(400,200);
		frame.setLocation(200,300);
		frame.init();
		frame.setVisible(true);
		JButton button = new JButton();
		frame.add(button);
		button.setBounds(frame.getWidth()/4, frame.getHeight()/4, frame.getWidth()/2, frame.getHeight()/2);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startServer = !startServer;
				if(startServer) {
					Server server = new Server();
					server.start();
				}else{
					System.exit(0);
				}
			}
		});
		frame.repaint();
	}

	@Override
	public void run() {
		startServer();
	}
}