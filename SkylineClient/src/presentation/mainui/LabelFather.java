package presentation.mainui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 继承后 只需要重写mouseClicked方法即可
 * 父类 用来实现Label的绘制和注册监听
 * @author 曾攀
 *
 */
public class LabelFather extends JLabel implements MouseListener{
	
/**
 * @param img 初始化时加载的图片
 * @param locationX 位置：x坐标
 * @param locationY 位置：y坐标
 * @param width 宽度
 * @param height 长度
 */
	protected ImageIcon img;
	protected ImageIcon enterImg;
	
	public LabelFather(ImageIcon img, ImageIcon enterImg, int locationX, int locationY, int width, int height){
		this.img = img;
		this.enterImg = enterImg;
		this.setIcon(img);
		this.setBounds(locationX, locationY, width, height);
		this.addMouseListener(this);
	}
	
	//更新坐标
	public void updateLocation(int locationX, int locationY, int width, int height){
		this.setBounds(locationX, locationY, width, height);
		Graphics g = getGraphics();
		update(g);
	}
	
	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {
		this.setIcon(enterImg);
	}

	public void mouseExited(MouseEvent e) {
		this.setIcon(img);
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}
}
