package main.socketservice;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.po.Message;

public class Client {
	private Socket socket;
	private ObjectOutputStream writer;
	private ClientThread clth;
	private ArrayList<Thread> threadList=new ArrayList<Thread>();
	private int callCounter=0;
	public Client(){
		this.buildNet();
	}
	
	public void buildNet(){
		try{
			socket=new Socket("127.0.0.1",12345);
			System.out.println("get connection success");
			Thread thread=new Thread(clth=new ClientThread(socket));
			threadList.add(thread);
			System.out.println("thread create success");
			thread.start();
			System.out.println("net start success");
			writer=new ObjectOutputStream(socket.getOutputStream());
			callCounter=0;
		}catch(Exception ex){
			if(callCounter>5){
				JOptionPane.showMessageDialog(null, "请检查你的网络设置", "重连失败", JOptionPane.ERROR_MESSAGE); 
			}
			callCounter++;
			System.out.println("net start failed");
			int result=JOptionPane.showConfirmDialog(null, "网络出现异常，是否重新连接？","提示:", JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.OK_OPTION){
				buildNet();
			}else{
				System.exit(0);
			}
		}
	}
	
	public boolean writeReceipt(Message receipt){
		try {
			writer.writeObject(receipt);
			System.out.println("send successfully,and key is:"+receipt.getKey());
			writer.flush();
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Message getResponse(){
		return clth.getResponseMessage();
	}
}
