package main.socketservice;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

import main.po.Message;

public class Client {
	private Socket socket;
	private ObjectOutputStream writer;
	private ClientThread clth;
	private Thread thread;
	private int callCounter=0;
	public Client(){
		this.buildNet();
	}
	
	public void buildNet(){
		try{
			socket=new Socket("127.0.0.1",12345);
			System.out.println("get connection success");
			thread=new Thread(clth=new ClientThread(socket));

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
	
	@SuppressWarnings("deprecation")
	public boolean writeReceipt(Message receipt){
		try {
			writer.writeObject(receipt);
			System.out.println("send successfully,and key is:"+receipt.getKey());
			if(!(receipt.getKey().equals("Save")||receipt.getKey().equals("Load"))){
				thread.resume();
			}
			writer.flush();
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.buildNet();
			this.writeReceipt(receipt);
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public Message getResponse(){
		Message message= clth.getResponseMessage();
		thread.suspend();
		return message;
	}
}
