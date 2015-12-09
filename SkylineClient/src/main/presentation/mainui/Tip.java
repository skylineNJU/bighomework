package main.presentation.mainui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 使用方法：new对象，先setBounds(或者setSize)后setIMG,在需要显示的时候调用startThread方法;
 * 图片显示一段时间后会自动消失.
 */
public class Tip extends JLabel implements Runnable {
	private static final long serialVersionUID = 1L;
	private ImageIcon[] img;
	/**
	 * 设置要显示的图片,调用此方法之前必须先为此对象设置大小
	 */
	public void setIMG(ImageIcon[] img){
		this.img = img;
		for(int i = 0; i<img.length; i++){
			img[i].setImage(img[i].getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
		}
	}
	/**
	 * 启动动画的方法，借鉴了线程池的思想,但没有线程锁
	 */
	public void startThread(){
		Thread thread = new Thread(this);
		thread.start();
	}
	public void run() {
		this.setVisible(true);
		for(int i = 0; i<img.length; i++){//通过for循环不停的换图片，形成视频的效果
			this.setIcon(img[i]);
			this.repaint();
			try {Thread.sleep(50);} 
			catch (InterruptedException e) {e.printStackTrace();}
		}
		this.setIcon(null);
		this.setVisible(false);
	}
}
