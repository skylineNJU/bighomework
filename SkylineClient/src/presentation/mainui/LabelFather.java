package presentation.mainui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * �̳к� ֻ��Ҫ��дmouseClicked��������
 * ���� ����ʵ��Label�Ļ��ƺ�ע�����
 * @author ����
 *
 */
public class LabelFather extends JLabel implements MouseListener{
	
/**
 * @param img ��ʼ��ʱ���ص�ͼƬ
 * @param locationX λ�ã�x����
 * @param locationY λ�ã�y����
 * @param width ���
 * @param height ����
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
	
	//��������
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
