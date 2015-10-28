package presentation.mainui;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 最小化的Label
 * @author 曾攀
 *
 */
public class LabelMin extends LabelFather{
	
	public JFrame frame;
	
	public LabelMin(ImageIcon img, ImageIcon enterImg, int locationX, int locationY, int width, int height, JFrame frame){
		super(img, enterImg, locationX, locationY, width, height);
		this.frame = frame;
	}
	
	public void mouseClicked(MouseEvent e) {
		frame.setExtendedState(JFrame.ICONIFIED);
	}
}
