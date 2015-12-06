package main.presentation.mainui;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyButton extends JLabel{
	
	/**
	 * @param imgEnter 鼠标进入时的图片
	 * @param imgExit 鼠标移出的图片
	 * @param imgPress 鼠标按下去的图片
	 */
	public void setIMG(ImageIcon imgEnter,ImageIcon imgExit,ImageIcon imgPress){
		imgEnter.setImage(imgEnter.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
		imgExit.setImage(imgExit.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
		imgPress.setImage(imgPress.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
		setIcon(imgExit);
		this.addMouseListener(new MouseAdapter() {
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