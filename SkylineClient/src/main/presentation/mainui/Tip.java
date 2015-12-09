package main.presentation.mainui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * ʹ�÷�����new������setBounds(����setSize)��setIMG,����Ҫ��ʾ��ʱ�����startThread����;
 * ͼƬ��ʾһ��ʱ�����Զ���ʧ.
 */
public class Tip extends JLabel implements Runnable {
	private static final long serialVersionUID = 1L;
	private ImageIcon[] img;
	/**
	 * ����Ҫ��ʾ��ͼƬ,���ô˷���֮ǰ������Ϊ�˶������ô�С
	 */
	public void setIMG(ImageIcon[] img){
		this.img = img;
		for(int i = 0; i<img.length; i++){
			img[i].setImage(img[i].getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
		}
	}
	/**
	 * ���������ķ�����������̳߳ص�˼��,��û���߳���
	 */
	public void startThread(){
		Thread thread = new Thread(this);
		thread.start();
	}
	public void run() {
		this.setVisible(true);
		for(int i = 0; i<img.length; i++){//ͨ��forѭ����ͣ�Ļ�ͼƬ���γ���Ƶ��Ч��
			this.setIcon(img[i]);
			this.repaint();
			try {Thread.sleep(50);} 
			catch (InterruptedException e) {e.printStackTrace();}
		}
		this.setIcon(null);
		this.setVisible(false);
	}
}
