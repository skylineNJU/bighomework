package main.serverFrame;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyButton extends JLabel{
	private static final long serialVersionUID = 1L;
	private ImageIcon imgEnter;
	private ImageIcon imgExit;
	private ImageIcon imgPress;

	/**
	 * @param imgEnter ������ʱ��ͼƬ
	 * @param imgExit ����Ƴ���ͼƬ
	 * @param imgPress ��갴��ȥ��ͼƬ
	 */
	public void setIMG(ImageIcon imgEnter,ImageIcon imgExit,ImageIcon imgPress){
		imgEnter.setImage(imgEnter.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
		imgExit.setImage(imgExit.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
		imgPress.setImage(imgPress.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
		this.imgEnter = imgEnter;
		this.imgExit = imgExit;
		this.imgPress = imgPress;
		setIcon(imgExit);
		setAlistener();
	}
	private void setAlistener(){
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setIcon(imgEnter);
			}
			public void mouseExited(MouseEvent e) {
				setIcon(imgExit);
			}
			public void mousePressed(MouseEvent e) {
				setIcon(imgPress);
			}
			public void mouseReleased(MouseEvent e){
				setIcon(imgEnter);
			}
		});
	}
}